package com.horus.skyrimmc.item.spell;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import com.horus.skyrimmc.SkyrimMC;
import com.horus.skyrimmc.SkyrimTabs;
import net.minecraft.item.ItemSnowball;

public class DamageSpellBase extends ItemSnowball {

    public DamageSpellBase(String name, int damage) {
        setRegistryName(SkyrimMC.MODID, name);
        setTranslationKey(SkyrimMC.MODID + "." + name);
        setCreativeTab(SkyrimTabs.DESTRUCTION);

        setMaxDamage(damage);
    }
}
