package com.horus.skyrimmc.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import com.horus.skyrimmc.SkyrimMC;
import com.horus.skyrimmc.SkyrimTabs;

public class ItemSkyrim extends Item {

    public ItemSkyrim(String name) {
        setRegistryName(SkyrimMC.MODID, name);
        setTranslationKey(SkyrimMC.MODID + "." + name);
        setCreativeTab(SkyrimTabs.MISC);
    }
}

