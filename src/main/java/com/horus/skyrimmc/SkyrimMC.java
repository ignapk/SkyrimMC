package com.horus.skyrimmc;


import com.horus.skyrimmc.recipes.ModRecipes;
import com.horus.skyrimmc.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = SkyrimMC.MODID, name = SkyrimMC.NAME, version = SkyrimMC.VERSION, acceptedMinecraftVersions = SkyrimMC.MC_VERSION)
public class SkyrimMC {

    public static final String MODID = "skyrimmc";
    public static final String NAME = "SkyrimMC";
    public static final String VERSION = "0.0.3";
    public static final String MC_VERSION = "[1.12.2]";
    
    @SidedProxy(clientSide = "com.horus.skyrimmc.proxy.ClientProxy", serverSide = "com.horus.skyrimmc.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static SkyrimMC instance;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
	ModRecipes.initSmelting();
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
