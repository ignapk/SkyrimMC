// 
// Decompiled by Procyon v0.5.36
// 

package com.horus.skyrimmc.gui;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class GuiMethods extends Gui
{
    public void drawSizedText(final FontRenderer fr, final String string, final int x, final int y, final int big_small) {
        if (big_small == 0) {
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            this.drawString(fr, string, x * 2, y * 2, -1);
            GlStateManager.popMatrix();
        }
        else if (big_small == 1) {
            GlStateManager.pushMatrix();
            GlStateManager.scale(2.0f, 2.0f, 2.0f);
            this.drawString(fr, string, (x - 5) / 2, (y - 5) / 2, -1);
            GlStateManager.popMatrix();
        }
    }
    
    public void drawCube() {
    }
}
