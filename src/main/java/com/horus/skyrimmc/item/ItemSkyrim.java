package com.horus.skyrimmc.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import com.horus.skyrimmc.SkyrimMC;
import com.horus.skyrimmc.SkyrimTabs;

public class ItemSkyrim extends Item implements IItem {

    public int price = 0;

    public ItemSkyrim(String name) {
        setRegistryName(SkyrimMC.MODID, name);
        setTranslationKey(SkyrimMC.MODID + "." + name);
        setCreativeTab(SkyrimTabs.MISC);
    }

    public ItemSkyrim(String name, int price) {
        this(name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

