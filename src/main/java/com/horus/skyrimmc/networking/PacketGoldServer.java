package com.horus.skyrimmc.networking;

import com.horus.skyrimmc.SkyrimMC;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;



public class PacketGoldServer implements IMessage {
    private int gold;
    
    public PacketGoldServer() {}
    
    public PacketGoldServer(EntityPlayer player) {
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
    
    public static class Handler implements IMessageHandler<PacketGoldServer, IMessage> {
        @Override
        public IMessage onMessage(PacketGoldServer message, MessageContext ctx) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> handle(message, ctx));
            return null;
        }
        
        private void handle(PacketGoldServer message, MessageContext ctx) {
        	//Main.proxy.handleMana(message.mana, 27);
        	EntityPlayerMP serverPlayer =  ctx.getServerHandler().player;
        	serverPlayer.getCapability(SkyrimMC.GOLD_CAP, null).setGold(message.gold);
        }
    }
}
