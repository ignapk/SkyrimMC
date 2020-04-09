// 
// Decompiled by Procyon v0.5.36
// 

package com.horus.skyrimmc;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class KeyHandler
{
    public static KeyBinding openMenu;
    public static KeyBinding spell1;
    public static KeyBinding spell2;
    
    public static void init() {
        KeyHandler.openMenu = new KeyBinding("key.open_menu", 50, "key.categories.skyrimmc");
        KeyHandler.spell1 = new KeyBinding("key.spell1", 44, "key.categories.skyrimmc");
        KeyHandler.spell2 = new KeyBinding("key.spell2", 45, "key.categories.skyrimmc");
        ClientRegistry.registerKeyBinding(KeyHandler.openMenu);
        ClientRegistry.registerKeyBinding(KeyHandler.spell1);
        ClientRegistry.registerKeyBinding(KeyHandler.spell2);
    }
    
    @SubscribeEvent
    public void onKeyInput(final InputEvent.KeyInputEvent event) {
        final EntityPlayer player = (EntityPlayer)Minecraft.getMinecraft().player;
        if (KeyHandler.openMenu.isPressed()) {
            player.openGui((Object)SkyrimMC.instance, 2, (World)Minecraft.getMinecraft().world, (int)player.posX, (int)player.posY, (int)player.posZ);
        }
    }
}
