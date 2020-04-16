// 
// Decompiled by Procyon v0.5.36
// 

package com.horus.skyrimmc.util.playerdata;

public class GoldImplementation implements IGold
{
    protected int gold;
    
    public GoldImplementation() {
        this.gold = 0;
    }
    
    @Override
    public int getGold() {
        return this.gold;
    }
    
    @Override
    public void setGold(final int value) {
        this.gold = value;
    }
}
