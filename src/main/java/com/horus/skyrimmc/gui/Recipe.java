// 
// Decompiled by Procyon v0.5.36
// 

package com.horus.skyrimmc.gui;

import net.minecraft.item.ItemStack;

public class Recipe
{
    private ItemStack itemStack;
    private ItemStack[] recipeItems;
    
    public Recipe(final ItemStack itemStack, final ItemStack[] recipeItems) {
        this.itemStack = itemStack;
        this.recipeItems = recipeItems;
    }
    
    public ItemStack getItemStack() {
        return this.itemStack;
    }
    
    public ItemStack[] getRecipeItems() {
        return this.recipeItems;
    }
}
