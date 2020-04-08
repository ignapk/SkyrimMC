package com.horus.skyrimmc.item;

import com.horus.skyrimmc.SkyrimMC;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;

public class ItemSkyrimConsumable extends ItemFood {

    private float healAmount;

    public ItemSkyrimConsumable(String name, final int amount, final float saturation, final boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setRegistryName(SkyrimMC.MODID, name);
        setTranslationKey(SkyrimMC.MODID + "." + name);
        setCreativeTab(SkyrimMC.SKYRIMMC_TAB);
        this.healAmount = (float)(20 % amount);
    }
    
    @Override
    public void addInformation(final ItemStack stack, final World worldIn, final List<String> tooltip, final ITooltipFlag advanced) {
        tooltip.add("Region: §6Skyrim");
        tooltip.add("Heals: §4" + this.healAmount);
    }
}
