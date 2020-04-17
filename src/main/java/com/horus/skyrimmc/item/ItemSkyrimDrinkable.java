package com.horus.skyrimmc.item;

import com.horus.skyrimmc.SkyrimMC;
import com.horus.skyrimmc.SkyrimTabs;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.item.EnumAction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.item.Item;
import net.minecraft.stats.StatList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class ItemSkyrimDrinkable extends ItemSkyrim {

    private boolean isAlcoholic;

    public ItemSkyrimDrinkable(String name, final boolean isAlcoholic) {
        super(name);
        setCreativeTab(SkyrimTabs.POTIONS);
        this.isAlcoholic = isAlcoholic;
    }
    
    public ItemSkyrimDrinkable(String name, final boolean isAlcoholic, int price) {
        this(name, isAlcoholic);
        this.price = price;
    }

    public ItemStack onItemUseFinish(final ItemStack stack, final World worldIn, final EntityLivingBase entityLiving) {
        final EntityPlayer entityPlayer = (entityLiving instanceof EntityPlayer) ? (EntityPlayer)entityLiving : null;
        if (entityPlayer == null || !entityPlayer.capabilities.isCreativeMode) {
            stack.setCount(stack.getCount()-1); //stack.shrink();
        }
        if (entityPlayer != null) {
            //TODO: fix me
            //entityPlayer.triggerAchievement(StatList.getObjectUseStats((Item)this));
        }
        entityPlayer.sendMessage(new TextComponentString("[Skyrimmc] - You throw the remains of your drink away"));
        return stack;
    }
    
    public int getMaxItemUseDuration(final ItemStack stack) {
        return 32;
    }
    
    public EnumAction getItemUseAction(final ItemStack stack) {
        return EnumAction.DRINK;
    }
    
    public ActionResult<ItemStack> onItemRightClick(final World worldIn, final EntityPlayer playerIn, final EnumHand hand) {
        playerIn.setActiveHand(hand);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
    }
}
