// 
// Decompiled by Procyon v0.5.36
// 

package com.horus.skyrimmc.util;

import net.minecraft.init.Items;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import com.horus.skyrimmc.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import com.horus.skyrimmc.init.ModBlocks;
import com.horus.skyrimmc.gui.Recipe;
import com.google.common.collect.Multimap;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

public class RecipeUtil
{
    public static boolean hasItem(final EntityPlayer player, final ItemStack is, final int amount) {
        if (is == null) {
            return false;
        }
        int found = 0;
        for (final ItemStack stack : player.inventory.mainInventory) {
            if (stack != null && areItemStacksEqual(stack, is)) {
                found += stack.getCount();
            }
            if (found >= amount) {
                return true;
            }
        }
        return false;
    }
    
    public static void removeItem(final EntityPlayer player, final ItemStack is, final int amount) {
        if (is == null) {
            return;
        }
        final IItemHandler ih = (IItemHandler)player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
        for (int i = 0; i < ih.getSlots(); ++i) {
            final ItemStack stack = ih.getStackInSlot(i);
            if (stack != null && areItemStacksEqual(is, stack)) {
                final ItemStack extract = ih.extractItem(i, is.getCount(), false);
                //is.stackSize -= extract.stackSize;
                is.shrink(extract.getCount());
                if (is.getCount() == 0) {
                    break;
                }
            }
        }
    }
    
    public static boolean areItemStacksEqual(final ItemStack stack1, final ItemStack stack2) {
        if (stack1 == null || stack2 == null) {
            return stack1 == stack2;
        }
        return stack1.isItemEqual(stack2) && ItemStack.areItemStackTagsEqual(stack1, stack2);
    }
    
    public static void addAnvilRecipes(final Multimap<String, Recipe> items) {
        addDAEDRIC(items);
        addDWARVEN(items);
        addEBONY(items);
        addELVEN(items);
        addGLASS(items);
        addIRON(items);
        addORCISH(items);
        addSTEEL(items);
    }
    
    public static void addCraftingTableRecipes() {
        //GameRegistry.addRecipe(new ItemStack((Block)BlockHandler.anvil, 1), new Object[] { "AAA", " B ", "BBB", 'A', new ItemStack(Blocks.field_150339_S, 1), 'B', new ItemStack((Item)ItemHandler.STEEL_INGOT, 1) });
    }
    
    public static void addSmeltingRecipes() {
        //GameRegistry.addSmelting((Block)BlockHandler.corundumOre, new ItemStack((Item)ItemHandler.corundum_INGOT, 1), 0.1f);
        //GameRegistry.addSmelting((Block)BlockHandler.EBONYOre, new ItemStack((Item)ItemHandler.EBONY_INGOT, 1), 0.1f);
        //GameRegistry.addSmelting((Block)BlockHandler.MALACHITEOre, new ItemStack((Item)ItemHandler.MALACHITE_INGOT, 1), 0.1f);
        //GameRegistry.addSmelting((Block)BlockHandler.MOONSTONEOre, new ItemStack((Item)ItemHandler.MOONSTONE_INGOT, 1), 0.1f);
        //GameRegistry.addSmelting((Block)BlockHandler.ORICHALCUMOre, new ItemStack((Item)ItemHandler.ORICHALCUM_INGOT, 1), 0.1f);
        //GameRegistry.addSmelting((Block)BlockHandler.QUICKSILVEROre, new ItemStack((Item)ItemHandler.QUICKSILVER_INGOT, 1), 0.1f);
        //GameRegistry.addSmelting((Block)BlockHandler.silverOre, new ItemStack((Item)ItemHandler.silver_INGOT, 1), 0.1f);
        //GameRegistry.addShapelessRecipe(new ItemStack((Item)ItemHandler.STEEL_INGOT, 1), new Object[] { new ItemStack(Items.IRON_INGOT, 1), new ItemStack(Items.field_151044_h, 1) });
    }
    
    private static void addDAEDRIC(final Multimap<String, Recipe> items) {
        items.put("DAEDRIC", new Recipe(new ItemStack((Item)ModItems.DAEDRIC_BATTLEAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack((Item)ModItems.DAEDRA_HEART), new ItemStack((Item)ModItems.EBONY_INGOT, 5) }));
        items.put("DAEDRIC", new Recipe(new ItemStack((Item)ModItems.DAEDRIC_DAGGER, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack((Item)ModItems.DAEDRA_HEART), new ItemStack((Item)ModItems.EBONY_INGOT, 1) }));
        items.put("DAEDRIC", new Recipe(new ItemStack((Item)ModItems.DAEDRIC_GREATSWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 3), new ItemStack((Item)ModItems.DAEDRA_HEART), new ItemStack((Item)ModItems.EBONY_INGOT, 5) }));
        items.put("DAEDRIC", new Recipe(new ItemStack((Item)ModItems.DAEDRIC_MACE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack((Item)ModItems.DAEDRA_HEART), new ItemStack((Item)ModItems.EBONY_INGOT, 3) }));
        items.put("DAEDRIC", new Recipe(new ItemStack((Item)ModItems.DAEDRIC_SWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack((Item)ModItems.DAEDRA_HEART), new ItemStack((Item)ModItems.EBONY_INGOT, 2) }));
        items.put("DAEDRIC", new Recipe(new ItemStack((Item)ModItems.DAEDRIC_WARAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack((Item)ModItems.DAEDRA_HEART), new ItemStack((Item)ModItems.EBONY_INGOT, 2) }));
        items.put("DAEDRIC", new Recipe(new ItemStack((Item)ModItems.DAEDRIC_WARHAMMER, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 3), new ItemStack((Item)ModItems.DAEDRA_HEART), new ItemStack((Item)ModItems.EBONY_INGOT, 5) }));
    }
    
    private static void addDWARVEN(final Multimap<String, Recipe> items) {
        items.put("DWARVEN", new Recipe(new ItemStack((Item)ModItems.DWARVEN_BATTLEAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.DWARVEN_METAL_INGOT, 2), new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.STEEL_INGOT, 2) }));
        items.put("DWARVEN", new Recipe(new ItemStack((Item)ModItems.DWARVEN_DAGGER, 1), new ItemStack[] { new ItemStack((Item)ModItems.DWARVEN_METAL_INGOT, 1), new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.STEEL_INGOT, 1) }));
        items.put("DWARVEN", new Recipe(new ItemStack((Item)ModItems.DWARVEN_GREATSWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.DWARVEN_METAL_INGOT, 2), new ItemStack((Item)ModItems.LEATHER_STRIPS, 3), new ItemStack(Items.IRON_INGOT, 2), new ItemStack((Item)ModItems.STEEL_INGOT, 2) }));
        items.put("DWARVEN", new Recipe(new ItemStack((Item)ModItems.DWARVEN_MACE, 1), new ItemStack[] { new ItemStack((Item)ModItems.DWARVEN_METAL_INGOT, 2), new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.STEEL_INGOT, 1) }));
        items.put("DWARVEN", new Recipe(new ItemStack((Item)ModItems.DWARVEN_SWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.DWARVEN_METAL_INGOT, 1), new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.STEEL_INGOT, 1) }));
        items.put("DWARVEN", new Recipe(new ItemStack((Item)ModItems.DWARVEN_WARAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.DWARVEN_METAL_INGOT, 1), new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.STEEL_INGOT, 1) }));
        items.put("DWARVEN", new Recipe(new ItemStack((Item)ModItems.DWARVEN_WARHAMMER, 1), new ItemStack[] { new ItemStack((Item)ModItems.DWARVEN_METAL_INGOT, 2), new ItemStack((Item)ModItems.LEATHER_STRIPS, 3), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.STEEL_INGOT, 2) }));
    }
    
    private static void addEBONY(final Multimap<String, Recipe> items) {
        items.put("EBONY", new Recipe(new ItemStack((Item)ModItems.EBONY_BATTLEAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.EBONY_INGOT, 5), new ItemStack((Item)ModItems.LEATHER_STRIPS, 2) }));
        items.put("EBONY", new Recipe(new ItemStack((Item)ModItems.EBONY_DAGGER, 1), new ItemStack[] { new ItemStack((Item)ModItems.EBONY_INGOT, 1), new ItemStack((Item)ModItems.LEATHER_STRIPS, 1) }));
        items.put("EBONY", new Recipe(new ItemStack((Item)ModItems.EBONY_GREATSWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.EBONY_INGOT, 5), new ItemStack((Item)ModItems.LEATHER_STRIPS, 3) }));
        items.put("EBONY", new Recipe(new ItemStack((Item)ModItems.EBONY_MACE, 1), new ItemStack[] { new ItemStack((Item)ModItems.EBONY_INGOT, 3), new ItemStack((Item)ModItems.LEATHER_STRIPS, 1) }));
        items.put("EBONY", new Recipe(new ItemStack((Item)ModItems.EBONY_SWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.EBONY_INGOT, 2), new ItemStack((Item)ModItems.LEATHER_STRIPS, 1) }));
        items.put("EBONY", new Recipe(new ItemStack((Item)ModItems.EBONY_WARAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.EBONY_INGOT, 2), new ItemStack((Item)ModItems.LEATHER_STRIPS, 2) }));
        items.put("EBONY", new Recipe(new ItemStack((Item)ModItems.EBONY_WARHAMMER, 1), new ItemStack[] { new ItemStack((Item)ModItems.EBONY_INGOT, 5), new ItemStack((Item)ModItems.LEATHER_STRIPS, 3) }));
    }
    
    private static void addELVEN(final Multimap<String, Recipe> items) {
        items.put("ELVEN", new Recipe(new ItemStack((Item)ModItems.ELVEN_BATTLEAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack(Items.IRON_INGOT, 2), new ItemStack((Item)ModItems.MOONSTONE_INGOT, 2), new ItemStack((Item)ModItems.QUICKSILVER_INGOT, 1) }));
        items.put("ELVEN", new Recipe(new ItemStack((Item)ModItems.ELVEN_DAGGER, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.MOONSTONE_INGOT, 1), new ItemStack((Item)ModItems.QUICKSILVER_INGOT, 1) }));
        items.put("ELVEN", new Recipe(new ItemStack((Item)ModItems.ELVEN_GREATSWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 3), new ItemStack(Items.IRON_INGOT, 2), new ItemStack((Item)ModItems.MOONSTONE_INGOT, 2), new ItemStack((Item)ModItems.QUICKSILVER_INGOT, 1) }));
        items.put("ELVEN", new Recipe(new ItemStack((Item)ModItems.ELVEN_MACE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.MOONSTONE_INGOT, 2), new ItemStack((Item)ModItems.QUICKSILVER_INGOT, 1) }));
        items.put("ELVEN", new Recipe(new ItemStack((Item)ModItems.ELVEN_SWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.MOONSTONE_INGOT, 1), new ItemStack((Item)ModItems.QUICKSILVER_INGOT, 1) }));
        items.put("ELVEN", new Recipe(new ItemStack((Item)ModItems.ELVEN_WARAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.MOONSTONE_INGOT, 1), new ItemStack((Item)ModItems.QUICKSILVER_INGOT, 1) }));
        items.put("ELVEN", new Recipe(new ItemStack((Item)ModItems.ELVEN_WARHAMMER, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 3), new ItemStack(Items.IRON_INGOT, 2), new ItemStack((Item)ModItems.MOONSTONE_INGOT, 2), new ItemStack((Item)ModItems.QUICKSILVER_INGOT, 1) }));
    }
    
    private static void addGLASS(final Multimap<String, Recipe> items) {
        items.put("GLASS", new Recipe(new ItemStack((Item)ModItems.GLASS_BATTLEAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack((Item)ModItems.MOONSTONE_INGOT, 2), new ItemStack((Item)ModItems.MALACHITE_INGOT, 2) }));
        items.put("GLASS", new Recipe(new ItemStack((Item)ModItems.GLASS_DAGGER, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack((Item)ModItems.MOONSTONE_INGOT, 1), new ItemStack((Item)ModItems.MALACHITE_INGOT, 1) }));
        items.put("GLASS", new Recipe(new ItemStack((Item)ModItems.GLASS_GREATSWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 3), new ItemStack((Item)ModItems.MOONSTONE_INGOT, 2), new ItemStack((Item)ModItems.MALACHITE_INGOT, 2) }));
        items.put("GLASS", new Recipe(new ItemStack((Item)ModItems.GLASS_MACE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack((Item)ModItems.MOONSTONE_INGOT, 1), new ItemStack((Item)ModItems.MALACHITE_INGOT, 2) }));
        items.put("GLASS", new Recipe(new ItemStack((Item)ModItems.GLASS_SWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack((Item)ModItems.MOONSTONE_INGOT, 1), new ItemStack((Item)ModItems.MALACHITE_INGOT, 1) }));
        items.put("GLASS", new Recipe(new ItemStack((Item)ModItems.GLASS_WARAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack((Item)ModItems.MOONSTONE_INGOT, 1), new ItemStack((Item)ModItems.MALACHITE_INGOT, 1) }));
        items.put("GLASS", new Recipe(new ItemStack((Item)ModItems.GLASS_WARHAMMER, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 3), new ItemStack((Item)ModItems.MOONSTONE_INGOT, 2), new ItemStack((Item)ModItems.MALACHITE_INGOT, 3) }));
    }
    
    private static void addIRON(final Multimap<String, Recipe> items) {
        items.put("IRON", new Recipe(new ItemStack((Item)ModItems.IRON_BATTLEAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack(Items.IRON_INGOT, 4) }));
        items.put("IRON", new Recipe(new ItemStack((Item)ModItems.IRON_DAGGER, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack(Items.IRON_INGOT, 1) }));
        items.put("IRON", new Recipe(new ItemStack((Item)ModItems.IRON_GREATSWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack(Items.IRON_INGOT, 4) }));
        items.put("IRON", new Recipe(new ItemStack((Item)ModItems.IRON_MACE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack(Items.IRON_INGOT, 3) }));
        items.put("IRON", new Recipe(new ItemStack((Item)ModItems.IRON_SWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack(Items.IRON_INGOT, 2) }));
        items.put("IRON", new Recipe(new ItemStack((Item)ModItems.IRON_WARAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack(Items.IRON_INGOT, 2) }));
        items.put("IRON", new Recipe(new ItemStack((Item)ModItems.IRON_WARHAMMER, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 3), new ItemStack(Items.IRON_INGOT, 4) }));
    }
    
    private static void addORCISH(final Multimap<String, Recipe> items) {
        items.put("ORCISH", new Recipe(new ItemStack((Item)ModItems.ORCISH_BATTLEAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.ORICHALCUM_INGOT, 4) }));
        items.put("ORCISH", new Recipe(new ItemStack((Item)ModItems.ORCISH_DAGGER, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.ORICHALCUM_INGOT, 1) }));
        items.put("ORCISH", new Recipe(new ItemStack((Item)ModItems.ORCISH_GREATSWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 3), new ItemStack(Items.IRON_INGOT, 2), new ItemStack((Item)ModItems.ORICHALCUM_INGOT, 4) }));
        items.put("ORCISH", new Recipe(new ItemStack((Item)ModItems.ORCISH_MACE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.ORICHALCUM_INGOT, 3) }));
        items.put("ORCISH", new Recipe(new ItemStack((Item)ModItems.ORCISH_SWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.ORICHALCUM_INGOT, 2) }));
        items.put("ORCISH", new Recipe(new ItemStack((Item)ModItems.ORCISH_WARAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.ORICHALCUM_INGOT, 2) }));
        items.put("ORCISH", new Recipe(new ItemStack((Item)ModItems.ORCISH_WARHAMMER, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 3), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.ORICHALCUM_INGOT, 4) }));
    }
    
    private static void addSTEEL(final Multimap<String, Recipe> items) {
        items.put("STEEL", new Recipe(new ItemStack((Item)ModItems.STEEL_BATTLEAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.STEEL_INGOT, 4) }));
        items.put("STEEL", new Recipe(new ItemStack((Item)ModItems.STEEL_DAGGER, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.STEEL_INGOT, 1) }));
        items.put("STEEL", new Recipe(new ItemStack((Item)ModItems.STEEL_GREATSWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 3), new ItemStack(Items.IRON_INGOT, 2), new ItemStack((Item)ModItems.STEEL_INGOT, 4) }));
        items.put("STEEL", new Recipe(new ItemStack((Item)ModItems.STEEL_MACE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.STEEL_INGOT, 3) }));
        items.put("STEEL", new Recipe(new ItemStack((Item)ModItems.STEEL_SWORD, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.STEEL_INGOT, 2) }));
        items.put("STEEL", new Recipe(new ItemStack((Item)ModItems.STEEL_WARAXE, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 2), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.STEEL_INGOT, 2) }));
        items.put("STEEL", new Recipe(new ItemStack((Item)ModItems.STEEL_WARHAMMER, 1), new ItemStack[] { new ItemStack((Item)ModItems.LEATHER_STRIPS, 3), new ItemStack(Items.IRON_INGOT, 1), new ItemStack((Item)ModItems.STEEL_INGOT, 4) }));
    }
}
