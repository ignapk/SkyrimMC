// 
// Decompiled by Procyon v0.5.36
// 

package com.horus.skyrimmc.util.playerdata;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import com.horus.skyrimmc.SkyrimMC;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class PlayerConstruction
{
    @SubscribeEvent
    public void onEntityConstruct(final AttachCapabilitiesEvent event) {
        event.addCapability(new ResourceLocation("skyrimmc", "IGold"), (ICapabilityProvider)new ICapabilitySerializable<NBTPrimitive>() {
            IGold instance = (IGold)SkyrimMC.GOLD_CAP.getDefaultInstance();
            
            public boolean hasCapability(final Capability<?> capability, final EnumFacing facing) {
                return capability == SkyrimMC.GOLD_CAP;
            }
            
            public <T> T getCapability(final Capability<T> capability, final EnumFacing facing) {
                return (T)((capability == SkyrimMC.GOLD_CAP) ? SkyrimMC.GOLD_CAP.cast(this.instance) : null);
            }
            
            public NBTPrimitive serializeNBT() {
                return (NBTPrimitive)SkyrimMC.GOLD_CAP.getStorage().writeNBT((Capability)SkyrimMC.GOLD_CAP, this.instance, (EnumFacing)null);
            }
            
            public void deserializeNBT(final NBTPrimitive nbt) {
                SkyrimMC.GOLD_CAP.getStorage().readNBT((Capability)SkyrimMC.GOLD_CAP, this.instance, (EnumFacing)null, (NBTBase)nbt);
            }
        });
        event.addCapability(new ResourceLocation("skyrimmc", "IStorage"), (ICapabilityProvider)new ICapabilitySerializable<NBTTagCompound>() {
            private IStorage instance = (IStorage)SkyrimMC.STORAGE_CAP.getDefaultInstance();

            public boolean hasCapability(final Capability<?> capability, final EnumFacing facing) {
                return capability == SkyrimMC.STORAGE_CAP;
            }

            public <T> T getCapability(final Capability<T> capability, final EnumFacing facing) {
                return hasCapability(capability, facing) ? SkyrimMC.STORAGE_CAP.cast(this.instance) : null;
            }

            public NBTTagCompound serializeNBT() {
                return (NBTTagCompound) SkyrimMC.STORAGE_CAP.getStorage().writeNBT(SkyrimMC.STORAGE_CAP, this.instance, null);
            }

            public void deserializeNBT(NBTTagCompound nbt) {
                SkyrimMC.STORAGE_CAP.getStorage().readNBT(SkyrimMC.STORAGE_CAP, this.instance, null, nbt);
            }
        });
    }
}
