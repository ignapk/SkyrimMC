package com.horus.skyrimmc.item;

import com.horus.skyrimmc.SkyrimMC;
import com.horus.skyrimmc.SkyrimTabs;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraft.client.util.ITooltipFlag;

public class ItemSkyrimSword extends ItemSword {
	
	public ItemSkyrimSword(String name, ToolMaterial material) {
		super(material);
		setRegistryName(SkyrimMC.MODID, name);
		setTranslationKey(SkyrimMC.MODID + "." + name);
		setCreativeTab(SkyrimTabs.WEAPONS);
	}
	
	//@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(final ItemStack stack, final World worldIn, final List<String> tooltip, final ITooltipFlag advanced) {
        tooltip.add("Region: §6Skyrim");
        super.addInformation(stack, worldIn, tooltip, advanced);
    }

}
