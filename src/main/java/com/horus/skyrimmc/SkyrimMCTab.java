package com.horus.skyrimmc;

import com.horus.skyrimmc.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SkyrimMCTab extends CreativeTabs {

	public SkyrimMCTab() {
		super(SkyrimMC.MODID);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack createIcon() {
		return new ItemStack(ModItems.GLASS_WARAXE);
	}

}
