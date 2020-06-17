package com.horus.skyrimmc;

import com.horus.skyrimmc.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SkyrimTabs {
	
	public static final CreativeTabs WEAPONS = new CreativeTabs(SkyrimMC.MODID + ".weapons") {
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ModItems.GLASS_WARAXE);
        }
    };
    
    public static final CreativeTabs APPAREL = new CreativeTabs(SkyrimMC.MODID + ".apparel") {
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ModItems.GLASS_HELMET);
        }
    };
    
    public static final CreativeTabs POTIONS = new CreativeTabs(SkyrimMC.MODID + ".potions") {
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ModItems.SKOOMA);
        }
    };
    
    public static final CreativeTabs FOOD = new CreativeTabs(SkyrimMC.MODID + ".food") {
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ModItems.SWEET_ROLL);
        }
    };
    
    public static final CreativeTabs INGREDIENTS = new CreativeTabs(SkyrimMC.MODID + ".ingredients") {
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ModItems.DAEDRA_HEART);
        }
    };
    
//  public static final CreativeTabs SCROLLS = new CreativeTabs(SkyrimMC.MODID + ".scrolls") {
//        @SideOnly(Side.CLIENT)
//        public ItemStack createIcon() {
//            return new ItemStack(ModItems.SCROLL);
//        }
//    };

//    public static final CreativeTabs BOOKS = new CreativeTabs(SkyrimMC.MODID + ".books") {
//        @SideOnly(Side.CLIENT)
//        public ItemStack createIcon() {
//            return new ItemStack(ModItems.BOOK);
//        }
//    };
    
//    public static final CreativeTabs KEYS = new CreativeTabs(SkyrimMC.MODID + ".keys") {
//        @SideOnly(Side.CLIENT)
//        public ItemStack createIcon() {
//            return new ItemStack(ModItems.KEY);
//        }
//    };
    
    public static final CreativeTabs MISC = new CreativeTabs(SkyrimMC.MODID + ".misc") {
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CORUNDUM_INGOT);
        }
    };

    public static final CreativeTabs RESTORATION = new CreativeTabs(SkyrimMC.MODID + ".restoration") {
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ModItems.HEAL_SPELL);
        }
    };

}
