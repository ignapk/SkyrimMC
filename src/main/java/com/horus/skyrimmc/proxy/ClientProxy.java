package com.horus.skyrimmc.proxy;

import com.horus.skyrimmc.SkyrimMC;
import com.horus.skyrimmc.init.ModItems;
import com.horus.skyrimmc.init.ModBlocks;
import com.horus.skyrimmc.gui.GuiSkyrimIngame;
import com.horus.skyrimmc.KeyHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@EventBusSubscriber(value = Side.CLIENT, modid = SkyrimMC.MODID)
public class ClientProxy extends CommonProxy {
    
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }
    
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        KeyHandler.init();
        MinecraftForge.EVENT_BUS.register((Object)new KeyHandler());
        MinecraftForge.EVENT_BUS.register((Object)new GuiSkyrimIngame());
    }
    
    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
    
    @SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
	
		registerModel(ModItems.CORUNDUM_INGOT, 0);
		registerModel(ModItems.DWARVEN_METAL_INGOT, 0);
		registerModel(ModItems.EBONY_INGOT, 0);
		registerModel(ModItems.MALACHITE_INGOT, 0);
		registerModel(ModItems.MOONSTONE_INGOT, 0);
		registerModel(ModItems.ORICHALCUM_INGOT, 0);
		registerModel(ModItems.QUICKSILVER_INGOT, 0);
		registerModel(ModItems.SILVER_INGOT, 0);
		registerModel(ModItems.STEEL_INGOT, 0);
		registerModel(ModItems.SOLID_DWEMER_METAL, 0);
		registerModel(ModItems.DAEDRA_HEART, 0);
		registerModel(ModItems.LEATHER_STRIPS, 0);
		registerModel(ModItems.CABBAGE, 0);
		registerModel(ModItems.CARROT, 0);
		registerModel(ModItems.GREEN_APPLE, 0);
		registerModel(ModItems.SWEET_ROLL, 0);
		registerModel(ModItems.TOMATO, 0);
		registerModel(ModItems.VENISON, 0);
		registerModel(ModItems.ALE, 0);
		registerModel(ModItems.SKOOMA, 0);
		registerModel(ModItems.ANCIENT_NORD_BATTLEAXE, 0);
		registerModel(ModItems.ANCIENT_NORD_GREATSWORD, 0);
		registerModel(ModItems.ANCIENT_NORD_SWORD, 0);
		registerModel(ModItems.ANCIENT_NORD_WARAXE, 0);
		registerModel(ModItems.DAEDRIC_BATTLEAXE, 0);
		registerModel(ModItems.DAEDRIC_DAGGER, 0);
		registerModel(ModItems.DAEDRIC_GREATSWORD, 0);
		registerModel(ModItems.DAEDRIC_MACE, 0);
		registerModel(ModItems.DAEDRIC_SWORD, 0);
		registerModel(ModItems.DAEDRIC_WARAXE, 0);
		registerModel(ModItems.DAEDRIC_WARHAMMER, 0);
		registerModel(ModItems.DRAGONBONE_BATTLEAXE, 0);
		registerModel(ModItems.DRAGONBONE_DAGGER, 0);
		registerModel(ModItems.DRAGONBONE_GREATSWORD, 0);
		registerModel(ModItems.DRAGONBONE_MACE, 0);
		registerModel(ModItems.DRAGONBONE_SWORD, 0);
		registerModel(ModItems.DRAGONBONE_WARAXE, 0);
		registerModel(ModItems.DRAGONBONE_WARHAMMER, 0);
		registerModel(ModItems.DWARVEN_BATTLEAXE, 0);
		registerModel(ModItems.DWARVEN_DAGGER, 0);
		registerModel(ModItems.DWARVEN_GREATSWORD, 0);
		registerModel(ModItems.DWARVEN_MACE, 0);
		registerModel(ModItems.DWARVEN_SWORD, 0);
		registerModel(ModItems.DWARVEN_WARAXE, 0);
		registerModel(ModItems.DWARVEN_WARHAMMER, 0);
		registerModel(ModItems.EBONY_BATTLEAXE, 0);
		registerModel(ModItems.EBONY_DAGGER, 0);
		registerModel(ModItems.EBONY_GREATSWORD, 0);
		registerModel(ModItems.EBONY_MACE, 0);
		registerModel(ModItems.EBONY_SWORD, 0);
		registerModel(ModItems.EBONY_WARAXE, 0);
		registerModel(ModItems.EBONY_WARHAMMER, 0);
		registerModel(ModItems.ELVEN_BATTLEAXE, 0);
		registerModel(ModItems.ELVEN_DAGGER, 0);
		registerModel(ModItems.ELVEN_GREATSWORD, 0);
		registerModel(ModItems.ELVEN_MACE, 0);
		registerModel(ModItems.ELVEN_SWORD, 0);
		registerModel(ModItems.ELVEN_WARAXE, 0);
		registerModel(ModItems.ELVEN_WARHAMMER, 0);
		registerModel(ModItems.FALMER_SWORD, 0);
		registerModel(ModItems.FALMER_WARAXE, 0);
		registerModel(ModItems.GLASS_BATTLEAXE, 0);
		registerModel(ModItems.GLASS_DAGGER, 0);
		registerModel(ModItems.GLASS_GREATSWORD, 0);
		registerModel(ModItems.GLASS_MACE, 0);
		registerModel(ModItems.GLASS_SWORD, 0);
		registerModel(ModItems.GLASS_WARAXE, 0);
		registerModel(ModItems.GLASS_WARHAMMER, 0);
		registerModel(ModItems.IMPERIAL_SWORD, 0);
		registerModel(ModItems.IRON_BATTLEAXE, 0);
		registerModel(ModItems.IRON_DAGGER, 0);
		registerModel(ModItems.IRON_GREATSWORD, 0);
		registerModel(ModItems.IRON_MACE, 0);
		registerModel(ModItems.IRON_SWORD, 0);
		registerModel(ModItems.IRON_WARAXE, 0);
		registerModel(ModItems.IRON_WARHAMMER, 0);
		registerModel(ModItems.ORCISH_BATTLEAXE, 0);
		registerModel(ModItems.ORCISH_DAGGER, 0);
		registerModel(ModItems.ORCISH_GREATSWORD, 0);
		registerModel(ModItems.ORCISH_MACE, 0);
		registerModel(ModItems.ORCISH_SWORD, 0);
		registerModel(ModItems.ORCISH_WARAXE, 0);
		registerModel(ModItems.ORCISH_WARHAMMER, 0);
		registerModel(ModItems.STEEL_BATTLEAXE, 0);
		registerModel(ModItems.STEEL_DAGGER, 0);
		registerModel(ModItems.STEEL_GREATSWORD, 0);
		registerModel(ModItems.STEEL_MACE, 0);
		registerModel(ModItems.STEEL_SWORD, 0);
		registerModel(ModItems.STEEL_WARAXE, 0);
		registerModel(ModItems.STEEL_WARHAMMER, 0);

		registerModel(ModItems.ANCIENT_NORD_HELMET, 0);
		registerModel(ModItems.ANCIENT_NORD_CHESTPLATE, 0);
		registerModel(ModItems.ANCIENT_NORD_LEGGINS, 0);
		registerModel(ModItems.ANCIENT_NORD_BOOTS, 0);
		registerModel(ModItems.DAEDRIC_HELMET, 0);
		registerModel(ModItems.DAEDRIC_CHESTPLATE, 0);
		registerModel(ModItems.DAEDRIC_LEGGINS, 0);
		registerModel(ModItems.DAEDRIC_BOOTS, 0);
		registerModel(ModItems.DWARVEN_HELMET, 0);
		registerModel(ModItems.DWARVEN_CHESTPLATE, 0);
		registerModel(ModItems.DWARVEN_LEGGINS, 0);
		registerModel(ModItems.DWARVEN_BOOTS, 0);
		registerModel(ModItems.EBONY_HELMET, 0);
		registerModel(ModItems.EBONY_CHESTPLATE, 0);
		registerModel(ModItems.EBONY_LEGGINS, 0);
		registerModel(ModItems.EBONY_BOOTS, 0);
		registerModel(ModItems.ELVEN_HELMET, 0);
		registerModel(ModItems.ELVEN_CHESTPLATE, 0);
		registerModel(ModItems.ELVEN_LEGGINS, 0);
		registerModel(ModItems.ELVEN_BOOTS, 0);
		registerModel(ModItems.FALMER_HELMET, 0);
		registerModel(ModItems.FALMER_CHESTPLATE, 0);
		registerModel(ModItems.FALMER_LEGGINS, 0);
		registerModel(ModItems.FALMER_BOOTS, 0);
		registerModel(ModItems.GLASS_HELMET, 0);
		registerModel(ModItems.GLASS_CHESTPLATE, 0);
		registerModel(ModItems.GLASS_LEGGINS, 0);
		registerModel(ModItems.GLASS_BOOTS, 0);
		registerModel(ModItems.HIDE_HELMET, 0);
		registerModel(ModItems.HIDE_CHESTPLATE, 0);
		registerModel(ModItems.HIDE_LEGGINS, 0);
		registerModel(ModItems.HIDE_BOOTS, 0);
		registerModel(ModItems.IMPERIAL_HELMET, 0);
		registerModel(ModItems.IMPERIAL_CHESTPLATE, 0);
		registerModel(ModItems.IMPERIAL_LEGGINS, 0);
		registerModel(ModItems.IMPERIAL_BOOTS, 0);
		registerModel(ModItems.IRON_HELMET, 0);
		registerModel(ModItems.IRON_CHESTPLATE, 0);
		registerModel(ModItems.IRON_LEGGINS, 0);
		registerModel(ModItems.IRON_BOOTS, 0);
		registerModel(ModItems.ORCISH_HELMET, 0);
		registerModel(ModItems.ORCISH_CHESTPLATE, 0);
		registerModel(ModItems.ORCISH_LEGGINS, 0);
		registerModel(ModItems.ORCISH_BOOTS, 0);
		registerModel(ModItems.SCALED_HELMET, 0);
		registerModel(ModItems.SCALED_CHESTPLATE, 0);
		registerModel(ModItems.SCALED_LEGGINS, 0);
		registerModel(ModItems.SCALED_BOOTS, 0);
		registerModel(ModItems.STEEL_HELMET, 0);
		registerModel(ModItems.STEEL_CHESTPLATE, 0);
		registerModel(ModItems.STEEL_LEGGINS, 0);
		registerModel(ModItems.STEEL_BOOTS, 0);
		registerModel(ModItems.STORMCLOAK_HELMET, 0);
		registerModel(ModItems.STORMCLOAK_CHESTPLATE, 0);
		registerModel(ModItems.STORMCLOAK_LEGGINS, 0);
		registerModel(ModItems.STORMCLOAK_BOOTS, 0);
		//registerModel(ModItems.STORMCLOAK1_HELMET, 0);
		//registerModel(ModItems.STORMCLOAK1_CHESTPLATE, 0);

		registerModel(Item.getItemFromBlock(ModBlocks.ANVIL), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.FORGE3), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.FORGE4), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.FORGE5), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.GRINDSTONE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.SMELTER), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.TANNING_RACK), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.WORKBENCH), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.CORUNDUM_ORE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.EBONY_ORE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.MALACHITE_ORE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.MOONSTONE_ORE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.ORICHALCUM_ORE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.QUICKSILVER_ORE), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.SILVER_ORE), 0);
	}

	private static void registerModel(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
    
    
}
