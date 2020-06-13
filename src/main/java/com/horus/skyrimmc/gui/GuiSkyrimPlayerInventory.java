package com.horus.skyrimmc.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.input.Keyboard;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// TODO: Fix inventory...
public class GuiSkyrimPlayerInventory extends GuiScreen
{
    private List<ItemStack> allItems;
    private LinkedHashMap<String, List<ItemStack>> inventory;
    private EntityPlayer player;

    private boolean categorySelected;
    private int categoryIndex, itemIndex;

    private static final int INACTIVE_PANEL_COLOR = 0xAA000000;

    private List<ItemStack> currentItemStacks;

    private float spin = 0.0F;

    public GuiSkyrimPlayerInventory(EntityPlayer player) {
        this.player = player;

        categorySelected = false;
        categoryIndex = 0;
        itemIndex = 0;

        inventory = new LinkedHashMap<>();
        currentItemStacks = new ArrayList<>();
        updateInventory();

        System.out.println(allItems);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);

        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.disableLighting();

        //drawGradientRect(0, 0, this.width, this.height, 1156377062, 1155390941);
        drawDefaultBackground();

        // Draw Categories "panel"
        drawGradientRect(10, 0, 110, height, !categorySelected ? -1442840576 : INACTIVE_PANEL_COLOR, !categorySelected ? -1437248171 : INACTIVE_PANEL_COLOR); // Panel background
        drawRect(12, 0, 13, height, 0xAAFFFFFF); // Panel right border
        drawRect(107, 0, 108, height, 0xAAFFFFFF); // Panel left border

        // Draw Items "panel"
        drawGradientRect(130, 0, 230, height, categorySelected ? -1442840576 : INACTIVE_PANEL_COLOR, categorySelected ? -1437248171 : INACTIVE_PANEL_COLOR); // Panel background
        drawRect(132, 0, 133, height, 0xAAFFFFFF); // Panel right border
        drawRect(227, 0, 228, height, 0xAAFFFFFF); // Panel left border

        // Write categories
        int y = 0;
        for(String key : inventory.keySet()) {
            if (key.length() >= 14) {
                key = key.substring(0, 12) + "..";
            }

            if(y/20 == categoryIndex)
                drawString(fontRenderer, TextFormatting.BOLD + key + TextFormatting.RESET, 20, height / 2 + y - (categoryIndex * 20), 0xAAFFFFFF);
            else
                drawString(fontRenderer, key, 20, height / 2 + y - (categoryIndex * 20), 0xAAAAAAAA);

            y += 20;
        }

        // Show items
        currentItemStacks = (List<ItemStack>) getElementByIndex(inventory, categoryIndex);
        for(int i = 0; i < currentItemStacks.size(); i++) {
            ItemStack is = currentItemStacks.get(i);
            String displayName = is.getDisplayName();

            if (displayName.length() >= 14) {
                displayName = displayName.substring(0, 12) + "..";
            }

            if(i == itemIndex) {
                drawString(fontRenderer, TextFormatting.BOLD + displayName + TextFormatting.RESET, 140, height / 2 + (i * 20) - (itemIndex * 20), 0xAAFFFFFF);
                GlStateManager.scale(1.0f, 1.0f, -1.0f);
                drawItemImage(is, width - 100, height / 2 - 40, spin);
                //GlStateManager.scale(-120.0f, -120.0f, -120.0f);
                GlStateManager.scale(1.0f, 1.0f, 1.0f);
                drawItemInformation("", is);
            } else
                drawString(fontRenderer, displayName, 140, height / 2 + (i * 20) - (itemIndex * 20), 0xAAAAAAAA);
        }
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);

        // If press ESC or E, exit inventory
        if (keyCode == 1 || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))
            this.mc.player.closeScreen();

        if (keyCode == Keyboard.KEY_UP) {
            if(categorySelected) {
                if (itemIndex <= 0)
                    itemIndex = 0;
                else
                    itemIndex--;
            } else {
                if(categoryIndex <= 0)
                    categoryIndex = 0;
                else
                    categoryIndex--;
            }
        }
        if (keyCode == Keyboard.KEY_DOWN) {
            if (categorySelected) {
                if (itemIndex >= currentItemStacks.size() - 1)
                    itemIndex = currentItemStacks.size() - 1;
                else
                    itemIndex++;
            } else {
                if (categoryIndex >= inventory.keySet().size() - 1)
                    categoryIndex = inventory.keySet().size() - 1;
                else
                    categoryIndex++;
            }
        }

        if(keyCode == Keyboard.KEY_LEFT) {
            if (categorySelected)
                categorySelected = false;

            itemIndex = 0;
        }
        if (keyCode == Keyboard.KEY_RIGHT) {
            if (!categorySelected)
                categorySelected = true;

            itemIndex = 0;
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        updateInventory(); // Update the inventory to check new items etc. coming into or leaving the inventory

        if (this.spin > 360.0F)
            this.spin -= 360.0F;
        else
            ++this.spin;
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    private List<String> getTabsFromItem(ItemStack stack) {
        List<String> tabs = new ArrayList<>();
        for(CreativeTabs tab : stack.getItem().getCreativeTabs())
            if(tab != null)
                tabs.add(I18n.format(tab.getTranslationKey()));

        return tabs;
    }

private void updateInventory() {
    allItems = Stream.of(player.inventory.mainInventory, player.inventory.offHandInventory, player.inventory.armorInventory).flatMap(Collection::stream).filter(s -> !s.isEmpty()).collect(toList());
    inventory = new LinkedHashMap<>();

    // TODO: If inventory is empty, show that it is empty!

    inventory.put("All Items", allItems);
    for (ItemStack stack : allItems) {
        List<String> tabs = getTabsFromItem(stack);
        for(String tab : tabs) {
            inventory.computeIfAbsent(tab, k -> new ArrayList<>()).add(stack);
        }
    }
}

    public Object getElementByIndex(LinkedHashMap map,int index){
        return map.get( (map.keySet().toArray())[ index ] );
    }

    private void drawItemImage(ItemStack is, int xPos, int yPos, float spin) {
        GlStateManager.pushMatrix();
        //GlStateManager.enableDepth();
        GlStateManager.translate((float)xPos, (float)yPos, 300.0f);
        GlStateManager.rotate(45.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(15.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(195.0f, 1.0f, 0.0f, 0.0f);
        final float n = spin;
        spin = n + 1.0f;
        GlStateManager.rotate(n % 360.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.scale(100.0f, 100.0f, 100.0f);
        //GlStateManager.scale(120.0F, 120.0F, 120.0F);
        RenderHelper.enableGUIStandardItemLighting();
        this.mc.getRenderItem().renderItem(is, ItemCameraTransforms.TransformType.GROUND);
        GlStateManager.popMatrix();
    }

    private void drawItemInformation(String category, ItemStack is) {
        drawRect(this.width - 180, (this.height + 50) / 2, this.width - 20, (this.height + 50) / 2 + 80, -1442840576);
        this.drawHorizontalLine(this.width - 178, this.width - 22, (this.height + 50) / 2 + 2, -1);
        this.drawHorizontalLine(this.width - 178, this.width - 22, (this.height + 50) / 2 + 77, -1);
        this.drawVerticalLine(this.width - 178, (this.height + 50) / 2 + 77, (this.height + 50) / 2 + 2, -1);
        this.drawVerticalLine(this.width - 22, (this.height + 50) / 2 + 77, (this.height + 50) / 2 + 2, -1);
        this.drawCenteredString(fontRenderer, is.getDisplayName(), this.width - 100, (this.height + 50) / 2 + 8, -1);
        this.drawHorizontalLine(this.width - 170, this.width - 30, (this.height + 50) / 2 + 20, -1);
    }
}
