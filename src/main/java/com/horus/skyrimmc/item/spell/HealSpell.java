package com.horus.skyrimmc.item.spell;

import com.horus.skyrimmc.SkyrimMC;
import com.horus.skyrimmc.util.playerdata.IStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class HealSpell extends SpellBase {

    private float healthPerTick = 0;
    
    public HealSpell(String name, float healthPerTick) {

        super(name);

        this.healthPerTick = healthPerTick;
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player,@Nonnull EnumHand handIn) {

        IStorage storage = player.getCapability(SkyrimMC.STORAGE_CAP, null);

        if (player.getHealth() < player.getMaxHealth() && storage.getMagika() > 0) {
            storage.removeMagika(healthPerTick * 2);
            player.setHealth(player.getHealth() + healthPerTick);
        }

        return super.onItemRightClick(world, player, handIn);
    }

    public float getHealthPerTick() {
        return healthPerTick;
    }

}
