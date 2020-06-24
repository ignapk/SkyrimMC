package com.horus.skyrimmc.item.spell;

import com.horus.skyrimmc.entity.projectile.EntityFirebolt;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import com.horus.skyrimmc.SkyrimMC;
import com.horus.skyrimmc.SkyrimTabs;
import net.minecraft.item.ItemSnowball;
import com.horus.skyrimmc.util.playerdata.IStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class DamageSpellBase extends ItemSnowball {

    public DamageSpellBase(String name, int damage) {
        setRegistryName(SkyrimMC.MODID, name);
        setTranslationKey(SkyrimMC.MODID + "." + name);
        setCreativeTab(SkyrimTabs.DESTRUCTION);

        setMaxDamage(damage);
    }
    
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        IStorage storage = playerIn.getCapability(SkyrimMC.STORAGE_CAP, null);

//        if (!playerIn.capabilities.isCreativeMode)
//        {
//            itemstack.shrink(1);
//        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ENDERDRAGON_FIREBALL_EPLD, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
            EntityFirebolt entityfirebolt = new EntityFirebolt(worldIn, playerIn);
            entityfirebolt.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(entityfirebolt);
        }

        storage.removeMagika(3);

        //playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
