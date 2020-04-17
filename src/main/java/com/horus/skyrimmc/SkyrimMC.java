package com.horus.skyrimmc;


import com.horus.skyrimmc.recipes.ModRecipes;
import com.horus.skyrimmc.proxy.CommonProxy;
import com.horus.skyrimmc.util.playerdata.IGold;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = SkyrimMC.MODID, name = SkyrimMC.NAME, version = SkyrimMC.VERSION, acceptedMinecraftVersions = SkyrimMC.MC_VERSION)
public class SkyrimMC {

    public static final String MODID = "skyrimmc";
    public static final String NAME = "SkyrimMC";
    public static final String VERSION = "0.0.4";
    public static final String MC_VERSION = "[1.12.2]";
    
    @SidedProxy(clientSide = "com.horus.skyrimmc.proxy.ClientProxy", serverSide = "com.horus.skyrimmc.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static SkyrimMC instance;
    
    @CapabilityInject(IGold.class)
    public static final Capability<IGold> GOLD_CAP;
    
    public static SimpleNetworkWrapper SNW_INSTANCE;

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
    
    static {
        GOLD_CAP = null;
    }
}
