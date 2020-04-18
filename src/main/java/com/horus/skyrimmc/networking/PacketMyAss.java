package com.horus.skyrimmc.networking;

import com.horus.skyrimmc.SkyrimMC;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import com.horus.skyrimmc.gui.GuiSkyrimShop;

public class PacketMyAss implements IMessage {

    private ItemStack[] items;
    
    public PacketMyAss() {}
    
    public PacketMyAss(ItemStack[] items) {
        this.items = items;
    }
    
    @Override
    public void fromBytes(ByteBuf buf) {
        int length = ByteBufUtils.readVarShort(buf);
        items = new ItemStack[length];
        for (int i = 0; i<length; i++)
            items[i] = ByteBufUtils.readItemStack(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeVarShort(buf, items.length);
        for(ItemStack item : items) {
            ByteBufUtils.writeItemStack(buf, item);
        }
    }
    
    public static class Handler implements IMessageHandler<PacketMyAss, IMessage> {
        @Override
        public IMessage onMessage(PacketMyAss message, MessageContext ctx) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> handle(message, ctx));
            return null;
        }
        
        @SideOnly(Side.CLIENT)
        private void handle(PacketMyAss message, MessageContext ctx) {
        	EntityPlayer player = Minecraft.getMinecraft().player;
        	Minecraft.getMinecraft().displayGuiScreen(new GuiSkyrimShop(player, message.items));
        }
    }
}
