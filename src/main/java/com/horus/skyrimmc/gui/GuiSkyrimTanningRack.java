// 
// Decompiled by Procyon v0.5.36
// 
package com.horus.skyrimmc.gui;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import com.horus.skyrimmc.util.RecipeUtil;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import org.lwjgl.input.Keyboard;
public class GuiSkyrimTanningRack extends GuiScreen {
private static final int PADDING = 7;
private Multimap<String, Recipe> items;
private ArrayList<Recipe> itemList;
private Object[] categories;
private boolean categoryChosen;
private int currentCategory;
private int currentItem;
private float spin = 0.0F;
private Recipe currentRecipeObject = null;
private EntityPlayer player;
public GuiSkyrimTanningRack(EntityPlayer player) {
this.player = player;
this.items = ArrayListMultimap.create();
this.addItems();
this.categories = this.items.keySet().toArray();
this.currentCategory = 0;
this.currentItem = 0;
this.itemList = new ArrayList();
this.itemList.addAll(this.items.get((String)this.categories[this.currentCategory]));
}
public boolean doesGuiPauseGame() {
return false;
}
public void updateScreen() {
super.updateScreen();
if (this.spin > 360.0F) {
this.spin -= 360.0F;
} else {
++this.spin;
}
}
protected void keyTyped(char par1, int par2) {
if (!this.mc.inGameHasFocus && par2 == 1) {
this.mc.displayGuiScreen((GuiScreen)null);
this.mc.setIngameFocus();
}
if (Keyboard.isKeyDown(208)) {
if (!this.categoryChosen) {
if (this.currentCategory < this.categories.length - 1) {
++this.currentCategory;
} else {
this.currentCategory = this.categories.length - 1;
}
this.itemList.clear();
this.itemList.addAll(this.items.get((String)this.categories[this.currentCategory]));
} else if (this.currentItem < this.itemList.size() - 1) {
++this.currentItem;
} else {
this.currentItem = this.itemList.size() - 1;
}
}
if (Keyboard.isKeyDown(200)) {
if (!this.categoryChosen) {
if (this.currentCategory > 0) {
--this.currentCategory;
} else {
this.currentCategory = 0;
}
this.itemList.clear();
this.itemList.addAll(this.items.get((String)this.categories[this.currentCategory]));
} else if (this.currentItem > 0) {
--this.currentItem;
} else {
this.currentItem = 0;
}
}
if (Keyboard.isKeyDown(205) && !this.categoryChosen) {
this.categoryChosen = true;
}
if (Keyboard.isKeyDown(203) && this.categoryChosen) {
this.categoryChosen = false;
this.currentItem = 0;
}
if (Keyboard.isKeyDown(28)) {
if (!this.categoryChosen) {
return;
}
ItemStack[] recipe = this.currentRecipeObject.getRecipeItems();
ItemStack[] var4 = recipe;
int var5 = recipe.length;
int var6;
ItemStack is;
for(var6 = 0; var6 < var5; ++var6) {
is = var4[var6];
if (!RecipeUtil.hasItem(this.player, is, is.getCount())) {
this.player.sendMessage(new TextComponentString("[Skyrimmc] - You don't have the required items!"));
return;
}
}
var4 = recipe;
var5 = recipe.length;
for(var6 = 0; var6 < var5; ++var6) {
is = var4[var6];
ItemStack copy = is.copy();
RecipeUtil.removeItem(this.player, copy, copy.getCount());
}
this.player.inventory.addItemStackToInventory(this.currentRecipeObject.getItemStack().copy());
this.player.addExperience(2);
}
}
public void drawScreen(int par1, int par2, float par3) {
super.drawScreen(par1, par2, par3);
this.drawGradientRect(0, 0, this.width, this.height, 1156377062, 1155390941);
if (!this.categoryChosen) {
this.drawGradientRect(10, 0, 80, this.height, -1442840576, -1437248171);
drawRect(12, 2, 13, this.height - 2, -1);
drawRect(77, 2, 78, this.height - 2, -1);
drawRect(90, 0, 200, this.height, -1442840576);
drawRect(197, 2, 198, this.height - 2, -1426063361);
drawRect(92, 2, 93, this.height - 2, -1426063361);
} else {
drawRect(10, 0, 80, this.height, -1442840576);
drawRect(12, 2, 13, this.height - 2, -1);
drawRect(77, 2, 78, this.height - 2, -1);
this.drawGradientRect(90, 0, 200, this.height, -1442840576, -1437248171);
drawRect(197, 2, 198, this.height - 2, -1);
drawRect(92, 2, 93, this.height - 2, -1);
}
if (!this.items.isEmpty()) {
Object[] categories = this.getCategories(this.items);
int i;
for(i = this.currentCategory - 6 >= 0 ? this.currentCategory - 6 : 0; i < (this.currentCategory + 6 < categories.length ? this.currentCategory + 6 : categories.length); ++i) {
if (i == this.currentCategory) {
this.drawString(this.fontRenderer, (String)categories[i], 18, this.height / 2 + 14 * i - this.currentCategory * 7, 16777215);
} else {
this.drawString(this.fontRenderer, (String)categories[i], 18, this.height / 2 + 14 * i - this.currentCategory * 7, 12632256);
}
}
if (!this.itemList.isEmpty() || this.itemList != null) {
for(i = this.currentItem - 6 >= 0 ? this.currentItem - 6 : 0; i < (this.currentItem + 6 < this.itemList.size() ? this.currentItem + 6 : this.itemList.size()); ++i) {
Recipe recipe = (Recipe)this.itemList.get(i);
String displayName = recipe.getItemStack().getDisplayName();
if (displayName.length() >= 18) {
displayName = displayName.substring(0, 16) + "..";
}
if (i == this.currentItem) {
this.currentRecipeObject = recipe;
this.drawString(this.fontRenderer, displayName, 98, this.height / 2 + 14 * i - this.currentItem * 7, 16777215);
this.drawItemImage(recipe.getItemStack(), this.width - 110, this.height / 2 - 40, this.spin);
if (recipe.getRecipeItems() == null) {
this.drawItemInformation(recipe, true);
} else {
this.drawItemInformation(recipe, false);
}
} else {
this.drawString(this.fontRenderer, displayName, 98, this.height / 2 + 14 * i - this.currentItem * 7, 12632256);
}
}
}
}
}
private Object[] getCategories(Multimap<String, Recipe> items) {
return items.keySet().toArray();
}
private void drawItemImage(ItemStack is, int xPos, int yPos, float spin) {
GlStateManager.pushMatrix();
GlStateManager.translate((float)xPos, (float)yPos, 300.0F);
GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
GlStateManager.rotate(15.0F, 0.0F, 0.0F, 1.0F);
GlStateManager.rotate(195.0F, 1.0F, 0.0F, 0.0F);
GlStateManager.rotate(spin++ % 360.0F, 0.0F, 1.0F, 0.0F);
GlStateManager.scale(100.0F, 100.0F, 100.0F);
RenderHelper.enableGUIStandardItemLighting();
GlStateManager.depthMask(false);
this.mc.getRenderItem().renderItem(is, TransformType.GROUND);
GlStateManager.popMatrix();
}
private void drawItemInformation(Recipe recipe, boolean isInventory) {
drawRect(this.width - 180, (this.height + 50) / 2, this.width - 20, (this.height + 50) / 2 + 80, -1442840576);
this.drawHorizontalLine(this.width - 178, this.width - 22, (this.height + 50) / 2 + 2, -1);
this.drawHorizontalLine(this.width - 178, this.width - 22, (this.height + 50) / 2 + 77, -1);
this.drawVerticalLine(this.width - 178, (this.height + 50) / 2 + 77, (this.height + 50) / 2 + 2, -1);
this.drawVerticalLine(this.width - 22, (this.height + 50) / 2 + 77, (this.height + 50) / 2 + 2, -1);
this.drawCenteredString(this.fontRenderer, recipe.getItemStack().getDisplayName(), this.width - 100, (this.height + 50) / 2 + 8, -1);
this.drawHorizontalLine(this.width - 170, this.width - 30, (this.height + 50) / 2 + 20, -1);
//int fontColor = true;
if (isInventory) {
this.drawCenteredString(this.fontRenderer, "Item in inventory", this.width - 100, (this.height + 50) / 2 + 30, -1);
} else {
this.drawCenteredString(this.fontRenderer, "Required Items: ", this.width - 100, (this.height + 50) / 2 + 24, -1);
int i = 0;
ItemStack[] var5 = recipe.getRecipeItems();
int var6 = var5.length;
for(int var7 = 0; var7 < var6; ++var7) {
ItemStack is = var5[var7];
boolean hasItem = RecipeUtil.hasItem(this.player, is, is.getCount());
int fontColor;
if (!hasItem) {
fontColor = -65536;
} else {
fontColor = -16751616;
}
this.drawCenteredString(this.fontRenderer, is.getDisplayName() + " (" + is.getCount() + ")", this.width - 100, (this.height + 50) / 2 + 34 + 10 * i++, fontColor);
}
}
}
private void addItems() {
ItemStack[] inventory = this.player.inventory.mainInventory.toArray(new ItemStack[0]);
for(int i = 0; i < inventory.length; ++i) {
if (inventory[i] != null) {
this.items.put("Inventory", new Recipe(inventory[i], (ItemStack[])null));
}
}
RecipeUtil.addTanningRackRecipes(this.items);
}
}
