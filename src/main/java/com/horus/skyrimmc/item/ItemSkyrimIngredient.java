package com.horus.skyrimmc.item;

import com.horus.skyrimmc.SkyrimMC;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import com.horus.skyrimmc.SkyrimTabs;

public class ItemSkyrimIngredient extends Item implements IItem {

    public int price = 0;

    public ItemSkyrimIngredient(String name) {
        setRegistryName(SkyrimMC.MODID, name);
        setTranslationKey(SkyrimMC.MODID + "." + name);
        setCreativeTab(SkyrimTabs.INGREDIENTS);
    }

    public ItemSkyrimIngredient(String name, int price) {
        this(name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
