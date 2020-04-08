// 
// Decompiled by Procyon v0.5.36
// 

package com.horus.skyrimmc.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class GuiSkyrimIngame extends Gui
{
    private Minecraft mc;
    protected ResourceLocation bow_crosshair;
    protected ResourceLocation bow_crosshair_sneaking_unseen;
    protected ResourceLocation bow_crosshair_sneaking_seen;
    private boolean renderMobHealth;
    private float currentMobHealth;
    private boolean isPlayerSeen;
    
    public GuiSkyrimIngame() {
        this.mc = Minecraft.getMinecraft();
        this.bow_crosshair = new ResourceLocation("skyrimmc", "textures/gui/bow_crosshair.png");
        this.bow_crosshair_sneaking_unseen = new ResourceLocation("skyrimmc", "textures/gui/bow_crosshair_sneaking_unseen.png");
        this.bow_crosshair_sneaking_seen = new ResourceLocation("skyrimmc", "textures/gui/bow_crosshair_sneaking_seen.png");
        this.renderMobHealth = false;
        this.currentMobHealth = 0.0f;
        this.isPlayerSeen = false;
    }
    
    /*@SubscribeEvent
    public void onClientTick(final TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (EntityUtil.canEntityBeSeen((EntityLivingBase)this.mc.player)) {
                this.isPlayerSeen = true;
            }
            else {
                this.isPlayerSeen = false;
            }
        }
    }*/
    
    @SubscribeEvent
    public void onAttackEntity(final AttackEntityEvent event) {
    }
    
    @SubscribeEvent
    public void renderGameOverlay(final RenderGameOverlayEvent.Pre event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.HEALTH || event.getType() == RenderGameOverlayEvent.ElementType.ARMOR || event.getType() == RenderGameOverlayEvent.ElementType.FOOD) {
            event.setCanceled(true);
        }
    }
    
    @SubscribeEvent
    public void renderGameOverlay(final RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        final int width = event.getResolution().getScaledWidth();
        final int height = event.getResolution().getScaledHeight();
        final FontRenderer fontrenderer = this.mc.fontRenderer;
        final ResourceLocation icons = new ResourceLocation("skyrimmc", "textures/gui/icons.png");
        GlStateManager.disableLighting();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.depthMask(false);
        this.mc.renderEngine.bindTexture(icons);
        this.drawTexturedModalRect(width / 2 - 110, 10, 0, 37, 221, 14);
        this.drawTexturedModalRect(20, height - 40, 0, 51, 102, 10);
        this.drawTexturedModalRect(width / 2 - 50, height - 40, 0, 51, 102, 10);
        this.drawTexturedModalRect(width - 120, height - 40, 0, 51, 102, 10);
        final float magicka = 82.0f;
        final float health = (float)(this.mc.player.getHealth() * 4.1);
        final float stamina = (float)(this.mc.player.getFoodStats().getFoodLevel() / 20);
        final float barMaxWidth = 80.0f;
        final float healthBarWidth = barMaxWidth * (this.mc.player.getHealth() / this.mc.player.getMaxHealth());
        final float healthBarStartX = width / 2 - 39 + (barMaxWidth - healthBarWidth) / 2.0f;
        final float staminaBarWidth = barMaxWidth * (this.mc.player.getFoodStats().getFoodLevel() / 20);
        final float staminaBarStartX = width - 109 + (barMaxWidth - staminaBarWidth);
        this.drawTexturedModalRect(31, height - 38, 11, 64, (int)magicka, 6);
        this.drawTexturedModalRect(healthBarStartX, (float)(height - 38), 11, 72, (int)healthBarWidth, 6);
        this.drawTexturedModalRect(staminaBarStartX, (float)(height - 38), 11, 80, (int)staminaBarWidth, 6);
        final int exp = (int)(this.mc.player.experience * 183.0f);
        int r = 0;
        if (this.mc.player.rotationYaw < 0.0f) {
            r = -MathHelper.floor((double)(this.mc.player.rotationYaw % 360.0f));
        }
        else {
            r = MathHelper.floor((double)(this.mc.player.rotationYaw % 360.0f));
        }
        final boolean flag1 = r > 0 && r < 180;
        final boolean flag2 = r <= 270 && r >= 90;
        final boolean flag3 = r <= 180 && r >= 0;
        final boolean flag4 = this.mc.player.rotationYaw < 0.0f;
        if (r == 0) {
            this.drawCenteredString(fontrenderer, "S", width / 2, 13, 16777215);
            this.drawCenteredString(fontrenderer, "E", width / 2 - 90, 13, 16777215);
            this.drawCenteredString(fontrenderer, "W", width / 2 + 90, 13, 16777215);
        }
        else if (!flag4) {
            this.drawCenteredString(fontrenderer, flag2 ? "N" : "", width / 2 - r + 180, 13, 16777215);
            if (!flag1) {
                r -= 360;
            }
            this.drawCenteredString(fontrenderer, flag2 ? "" : "S", width / 2 - r, 13, 16777215);
            this.drawCenteredString(fontrenderer, flag3 ? "" : "E", width / 2 - r - 90, 13, 16777215);
            this.drawCenteredString(fontrenderer, flag3 ? "W" : "", width / 2 - r + 90, 13, 16777215);
        }
        else if (flag4) {
            this.drawCenteredString(fontrenderer, flag2 ? "N" : "", width / 2 + r - 180, 13, 16777215);
            if (!flag1) {
                r -= 360;
            }
            this.drawCenteredString(fontrenderer, flag2 ? "" : "S", width / 2 + r, 13, 16777215);
            this.drawCenteredString(fontrenderer, flag3 ? "" : "W", width / 2 + r + 90, 13, 16777215);
            this.drawCenteredString(fontrenderer, flag3 ? "E" : "", width / 2 + r - 90, 13, 16777215);
        }
        this.mc.renderEngine.bindTexture(icons);
        if (this.renderMobHealth) {
            this.drawTexturedModalRect(width / 2 - 78.5f, 32.0f, 3, 88, 157, 8);
            this.drawTexturedModalRect(width / 2 - 78.5f + 9.0f, 35.0f, 10, 102, (int)(142.0f % this.currentMobHealth), 2);
        }
        /*final IGold gold = (IGold)this.mc.player.getCapability((Capability)Skyrimcraft.GOLD_CAP, (EnumFacing)null);
        if (gold != null) {
            this.func_73731_b(fontrenderer, "Gold: " + gold.getGold(), 10, 10, -2838729);
        }*/
    }
}
