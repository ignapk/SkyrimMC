// 
// Decompiled by Procyon v0.5.36
// 

package com.horus.skyrimmc.gui;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiMenuSelect extends GuiScreen
{
    public static boolean drawLeft;
    public static boolean drawRight;
    public static boolean drawUp;
    public static boolean drawDown;
    
    public GuiMenuSelect() {
        this.allowUserInput = true;
    }
    
    public boolean doesGuiPauseGame() {
        return true;
    }
    
    public void onGuiClosed() {
    }
    
    protected void actionPerformed(final GuiButton guibutton) {
    }
    
    public void initGui() {
        this.buttonList.clear();
    }
    
    protected void keyTyped(final char par1, final int par2) {
        if (!this.mc.inGameHasFocus && (par2 == 1 || par2 == 50)) {
            this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
        }
        if (par2 == 203) {
            GuiMenuSelect.drawLeft = true;
            GuiMenuSelect.drawRight = false;
            GuiMenuSelect.drawUp = false;
            GuiMenuSelect.drawDown = false;
        }
        if (par2 == 205) {
            GuiMenuSelect.drawRight = true;
            GuiMenuSelect.drawLeft = false;
            GuiMenuSelect.drawUp = false;
            GuiMenuSelect.drawDown = false;
        }
        if (par2 == 200) {
            GuiMenuSelect.drawUp = true;
            GuiMenuSelect.drawRight = false;
            GuiMenuSelect.drawLeft = false;
            GuiMenuSelect.drawDown = false;
        }
        if (par2 == 208) {
            GuiMenuSelect.drawDown = true;
            GuiMenuSelect.drawRight = false;
            GuiMenuSelect.drawUp = false;
            GuiMenuSelect.drawLeft = false;
        }
        if (GuiMenuSelect.drawUp && par2 == 28) {
            final EntityPlayer p = (EntityPlayer)this.mc.player;
            p.sendMessage((ITextComponent)new TextComponentString("[Skyrimmc] - Skills currently unavailable"));
            this.mc.setIngameFocus();
        }
        if (GuiMenuSelect.drawDown && par2 == 28) {
            final EntityPlayer p = (EntityPlayer)this.mc.player;
            p.sendMessage((ITextComponent)new TextComponentString("[Skyrimmc] - Map currently unavailable"));
            this.mc.setIngameFocus();
        }
        if (GuiMenuSelect.drawRight && par2 == 28) {
            final EntityPlayer p = (EntityPlayer)this.mc.player;
            this.mc.setIngameFocus();
            this.mc.displayGuiScreen((GuiScreen)new GuiInventory(p));
        }
        if (GuiMenuSelect.drawLeft && par2 == 28) {
            final EntityPlayer p = (EntityPlayer)this.mc.player;
            this.mc.setIngameFocus();
        }
    }
    
    public void drawScreen(final int par1, final int par2, final float par3) {
        this.drawDefaultBackground();
        final ResourceLocation cross = new ResourceLocation("skyrimmc", "textures/gui/cross.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().renderEngine.bindTexture(cross);
        this.drawTexturedModalRect(this.width / 2 - 120, this.height / 2 - 50, 0, 81, 230, 101);
        final GuiMethods m = new GuiMethods();
        if (GuiMenuSelect.drawLeft) {
            this.drawTexturedModalRect(this.width / 2 - 170, this.height / 2 - 10, 53, 0, 17, 18);
            this.drawString(this.fontRenderer, "Skills", this.width / 2 - 4, this.height / 2 - 65, 16777215);
            this.drawString(this.fontRenderer, "Map", this.width / 2 - 1, this.height / 2 + 55, 16777215);
            this.drawString(this.fontRenderer, "Items", this.width / 2 + 118, this.height / 2 - 4, 16777215);
            m.drawSizedText(this.fontRenderer, "Magic", this.width / 2 - 144, this.height / 2 - 4, 1);
        }
        else if (GuiMenuSelect.drawRight) {
            this.drawTexturedModalRect(this.width / 2 + 165, this.height / 2 - 10, 36, 0, 17, 18);
            this.drawString(this.fontRenderer, "Skills", this.width / 2 - 4, this.height / 2 - 65, 16777215);
            this.drawString(this.fontRenderer, "Map", this.width / 2 - 1, this.height / 2 + 55, 16777215);
            m.drawSizedText(this.fontRenderer, "Items", this.width / 2 + 115, this.height / 2 - 4, 1);
            this.drawString(this.fontRenderer, "Magic", this.width / 2 - 135, this.height / 2 - 4, 16777215);
        }
        else if (GuiMenuSelect.drawUp) {
            this.drawTexturedModalRect(this.width / 2 - 2, this.height / 2 - 90, 0, 0, 17, 18);
            m.drawSizedText(this.fontRenderer, "Skills", this.width / 2 - 11, this.height / 2 - 65, 1);
            this.drawString(this.fontRenderer, "Map", this.width / 2 - 1, this.height / 2 + 55, 16777215);
            this.drawString(this.fontRenderer, "Items", this.width / 2 + 118, this.height / 2 - 4, 16777215);
            this.drawString(this.fontRenderer, "Magic", this.width / 2 - 135, this.height / 2 - 4, 16777215);
        }
        else if (GuiMenuSelect.drawDown) {
            this.drawTexturedModalRect(this.width / 2 - 3, this.height / 2 + 70, 18, 0, 17, 18);
            this.drawString(this.fontRenderer, "Skills", this.width / 2 - 4, this.height / 2 - 65, 16777215);
            m.drawSizedText(this.fontRenderer, "Map", this.width / 2 - 6, this.height / 2 + 55, 1);
            this.drawString(this.fontRenderer, "Items", this.width / 2 + 118, this.height / 2 - 4, 16777215);
            this.drawString(this.fontRenderer, "Magic", this.width / 2 - 135, this.height / 2 - 4, 16777215);
        }
        else {
            this.drawString(this.fontRenderer, "Skills", this.width / 2 - 4, this.height / 2 - 65, 16777215);
            this.drawString(this.fontRenderer, "Map", this.width / 2 - 1, this.height / 2 + 55, 16777215);
            this.drawString(this.fontRenderer, "Items", this.width / 2 + 118, this.height / 2 - 4, 16777215);
            this.drawString(this.fontRenderer, "Magic", this.width / 2 - 135, this.height / 2 - 4, 16777215);
        }
        super.drawScreen(par1, par2, par3);
    }
    
    static {
        GuiMenuSelect.drawLeft = false;
        GuiMenuSelect.drawRight = false;
        GuiMenuSelect.drawUp = false;
        GuiMenuSelect.drawDown = false;
    }
}
