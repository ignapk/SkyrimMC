// 
// Decompiled by Procyon v0.5.36
// 

package com.horus.skyrimmc.gui;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    public Object getServerGuiElement(final int ID, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        if (ID == 1) {
            return new GuiSkyrimAnvil(player);
        }
        if (ID == 2) {
            return new GuiMenuSelect();
        }
        return null;
    }
    
    public Object getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int x, final int y, final int z) {
        if (ID == 1) {
            return new GuiSkyrimAnvil(player);
        }
        if (ID == 2) {
            return new GuiMenuSelect();
        }
        return null;
    }
}
