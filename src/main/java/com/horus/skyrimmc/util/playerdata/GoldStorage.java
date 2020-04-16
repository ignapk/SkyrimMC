// 
// Decompiled by Procyon v0.5.36
// 

package com.horus.skyrimmc.util.playerdata;

import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class GoldStorage implements Capability.IStorage<IGold>
{
    public NBTBase writeNBT(final Capability<IGold> capability, final IGold instance, final EnumFacing side) {
        return (NBTBase)new NBTTagInt(instance.getGold());
    }
    
    public void readNBT(final Capability<IGold> capability, final IGold instance, final EnumFacing side, final NBTBase nbt) {
        instance.setGold(((NBTPrimitive)nbt).getInt());
    }
}
