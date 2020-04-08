// 
// Decompiled by Procyon v0.5.36
// 

package com.horus.skyrimmc.block;

import com.horus.skyrimmc.SkyrimMC;
import java.util.List;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.client.gui.GuiScreen;
import com.horus.skyrimmc.gui.GuiSkyrimAnvil;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.BlockFalling;
import net.minecraft.client.util.ITooltipFlag;

public class BlockSkyrimAnvil extends BlockFalling
{
    protected static final AxisAlignedBB X_AXIS_AABB;
    protected static final AxisAlignedBB Z_AXIS_AABB;
    
    public BlockSkyrimAnvil(String name, final Material materialIn) {
        super(materialIn);
        setRegistryName(SkyrimMC.MODID, name);
        setTranslationKey(SkyrimMC.MODID + "." + name);
        setCreativeTab(SkyrimMC.SKYRIMMC_TAB);
        this.setLightOpacity(0);
    }
    
    public boolean renderAsNormalBlock(final IBlockState state) {
        return false;
    }
    
    public boolean isOpaqueCube(final IBlockState state) {
        return false;
    }
    
    public boolean onBlockActivated(final World worldIn, final BlockPos pos, final IBlockState state, final EntityPlayer playerIn, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ) {
        if (!worldIn.isRemote) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiSkyrimAnvil(playerIn));
            
        }
        return true;
    }
    
    public AxisAlignedBB getBoundingBox(final IBlockState state, final IBlockAccess source, final BlockPos pos) {
        return BlockSkyrimAnvil.Z_AXIS_AABB;
    }
    
    protected void onStartFalling(final EntityFallingBlock fallingEntity) {
        fallingEntity.setHurtEntities(true);
    }
    
    public void onEndFalling(final World worldIn, final BlockPos pos, IBlockState fallingState, IBlockState hitState) {
        worldIn.playEvent(1031, pos, 0);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(final IBlockState blockState, final IBlockAccess blockAccess, final BlockPos pos, final EnumFacing side) {
        return true;
    }
    
    public void addInformation(final ItemStack par1ItemStack, final World worldIn, final List<String> par2List, final ITooltipFlag par4) {
        par2List.add("Region: §6Skyrim");
    }
    
    static {
        X_AXIS_AABB = new AxisAlignedBB(0.0, 0.0, 0.125, 1.0, 1.0, 0.875);
        Z_AXIS_AABB = new AxisAlignedBB(0.125, 0.0, 0.0, 0.875, 1.0, 1.0);
    }
}
