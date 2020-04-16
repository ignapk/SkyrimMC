package com.horus.skyrimmc.item;

import com.horus.skyrimmc.SkyrimMC;
import com.horus.skyrimmc.SkyrimTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemSkyrimArmor extends ItemArmor {

	public ItemSkyrimArmor(String name, ArmorMaterial material, EntityEquipmentSlot equipmentSlot) {
		super(material, 0, equipmentSlot);
		setRegistryName(SkyrimMC.MODID, name);
		setTranslationKey(SkyrimMC.MODID + "." + name);
		setCreativeTab(SkyrimTabs.APPAREL);
	}

}
