package com.horus.skyrimmc.item.spell;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import com.horus.skyrimmc.SkyrimMC;
import com.horus.skyrimmc.SkyrimTabs;

public class SpellBase extends Item {

    public SpellBase(String name) {
        setRegistryName(SkyrimMC.MODID, name);
        setTranslationKey(SkyrimMC.MODID + "." + name);
        setCreativeTab(SkyrimTabs.RESTORATION);
    }
}
