package com.horus.skyrimmc.networking;

import com.horus.skyrimmc.SkyrimMC;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;



public class PacketGold implements IMessage {
    private int gold;
    
    public PacketGold() {}
    
    public PacketGold(EntityPlayer player) {
        gold = player.getCapability(SkyrimMC.GOLD_CAP, null).getGold();
    }
    
    @Override
    public void fromBytes(ByteBuf buf) {
        gold = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(gold);
    }
    
    public static class Handler implements IMessageHandler<PacketGold, IMessage> {
        @Override
        public IMessage onMessage(PacketGold message, MessageContext ctx) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> handle(message, ctx));
            return null;
        }
        
        @SideOnly(Side.CLIENT)
        private void handle(PacketGold message, MessageContext ctx) {
        	//Main.proxy.handleMana(message.mana, 27);
        	EntityPlayer player = Minecraft.getMinecraft().player;
        	player.getCapability(SkyrimMC.GOLD_CAP, null).setGold(message.gold);
        }
    }
}
