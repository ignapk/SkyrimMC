package com.horus.skyrimmc.item;

import com.horus.skyrimmc.SkyrimMC;
import com.horus.skyrimmc.SkyrimTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemSkyrimArmor extends ItemArmor implements IItem {

	public int price = 0;

	public ItemSkyrimArmor(String name, ArmorMaterial material, EntityEquipmentSlot equipmentSlot) {
		super(material, 0, equipmentSlot);
		setRegistryName(SkyrimMC.MODID, name);
		setTranslationKey(SkyrimMC.MODID + "." + name);
		setCreativeTab(SkyrimTabs.APPAREL);
	}

	public ItemSkyrimArmor(String name, ArmorMaterial material, EntityEquipmentSlot equipmentSlot, int price) {
		this(name, material, equipmentSlot);
		this.price = price;
	}

	public int getPrice() {
	    return price;
	}
}
