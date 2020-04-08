// 
// Decompiled by Procyon v0.5.36
// 

package com.horus.skyrimmc.block;

import com.horus.skyrimmc.SkyrimMC;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import java.util.Random;
import net.minecraft.block.SoundType;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockSkyrimOre extends Block {
    
    public BlockSkyrimOre(String name, Material materialIn) {
        super(materialIn);
        setRegistryName(SkyrimMC.MODID, name);
        setTranslationKey(SkyrimMC.MODID + "." + name);
        setCreativeTab(SkyrimMC.SKYRIMMC_TAB);
        this.setHardness(1.5f);
        this.setResistance(10.0f);
        //this.setSoundType(SoundType.STONE);
    }
    
    public int quantityDropped(final Random random) {
        return 1;
    }
    
    public void addInformation(final ItemStack par1ItemStack, final World worldIn, final List<String> par2List, final ITooltipFlag par4) {
        par2List.add("Region: §6Skyrim");
    }
}
