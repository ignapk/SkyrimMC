package com.horus.skyrimmc.item;

import com.horus.skyrimmc.SkyrimMC;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import com.horus.skyrimmc.SkyrimTabs;

public class ItemSkyrimIngredient extends Item {

    public ItemSkyrimIngredient(String name) {
        setRegistryName(SkyrimMC.MODID, name);
        setTranslationKey(SkyrimMC.MODID + "." + name);
        setCreativeTab(SkyrimTabs.INGREDIENTS);
    }
}
