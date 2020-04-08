package com.horus.skyrimmc.item;

import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

public class ItemSkyrimGreatsword extends ItemSkyrimSword {
	
	public ItemSkyrimGreatsword(String name, ToolMaterial material) {
		super(name, material);
	}
	
	
	public void onUpdate(final ItemStack stack, final World worldIn, final Entity entityIn, final int itemSlot, final boolean isSelected) {
	    if (isSelected) {
               /*if (worldIn.field_72995_K) {
                   return;
               }*/
               if (entityIn instanceof EntityLivingBase) {
                   final EntityLivingBase entity = (EntityLivingBase)entityIn;
                   entity.setSprinting(false);
                   entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 10, 1));
               }
           }
           super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
        }

}
