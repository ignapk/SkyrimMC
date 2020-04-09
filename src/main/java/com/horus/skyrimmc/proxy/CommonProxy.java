package com.horus.skyrimmc.proxy;

import com.horus.skyrimmc.SkyrimMC;
import com.horus.skyrimmc.block.BlockSkyrimOre;
import com.horus.skyrimmc.block.BlockSkyrimAnvil;
import com.horus.skyrimmc.init.ModBlocks;
import com.horus.skyrimmc.item.ItemSkyrim;
import com.horus.skyrimmc.item.ItemSkyrimArmor;
import com.horus.skyrimmc.item.ItemSkyrimSword;
import com.horus.skyrimmc.item.ItemSkyrimGreatsword;
import com.horus.skyrimmc.item.ItemSkyrimConsumable;
import com.horus.skyrimmc.item.ItemSkyrimDrinkable;
import com.horus.skyrimmc.materials.SkyrimMaterials;
import com.horus.skyrimmc.gui.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@EventBusSubscriber(modid = SkyrimMC.MODID)
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
    
    }

    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler((Object)SkyrimMC.instance, (IGuiHandler)new GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent event) {
    
    }
    
    @SubscribeEvent
	public static void registerItems(Register<Item> event) {
		final Item[] items = {

			new ItemSkyrim("corundum_ingot"),
			new ItemSkyrim("dwarven_metal_ingot"),
			new ItemSkyrim("ebony_ingot"),
			new ItemSkyrim("malachite_ingot"),
			new ItemSkyrim("moonstone_ingot"),
			new ItemSkyrim("orichalcum_ingot"),
			new ItemSkyrim("quicksilver_ingot"),
			new ItemSkyrim("silver_ingot"),
			new ItemSkyrim("steel_ingot"),
			new ItemSkyrim("daedra_heart"),
			new ItemSkyrim("leather_strips"),
			
			new ItemSkyrimConsumable("cabbage", 2, 2.0f, false),
			new ItemSkyrimConsumable("carrot", 2, 2.0f, false),
			new ItemSkyrimConsumable("green_apple", 1, 1.75f, false),
			new ItemSkyrimConsumable("sweet_roll", 5, 2.5f, false),
			new ItemSkyrimConsumable("tomato", 2, 2.0f, false),
			new ItemSkyrimConsumable("venison", 4, 0.3f, true),
			new ItemSkyrimDrinkable("ale", true),
			new ItemSkyrimDrinkable("skooma", true),
			 
			new ItemSkyrimSword("ancient_nord_battleaxe", SkyrimMaterials.ANCIENT_NORD_TOOL),  
		        new ItemSkyrimGreatsword("ancient_nord_greatsword", SkyrimMaterials.ANCIENT_NORD_TOOL),  
		        new ItemSkyrimSword("ancient_nord_sword", SkyrimMaterials.ANCIENT_NORD_TOOL),  
		        new ItemSkyrimSword("ancient_nord_waraxe", SkyrimMaterials.ANCIENT_NORD_TOOL),  
		        new ItemSkyrimSword("daedric_battleaxe", SkyrimMaterials.DAEDRIC_TOOL),  
		        new ItemSkyrimSword("daedric_dagger", SkyrimMaterials.DAEDRIC_TOOL),  
		        new ItemSkyrimGreatsword("daedric_greatsword", SkyrimMaterials.DAEDRIC_TOOL),  
		        new ItemSkyrimSword("daedric_mace", SkyrimMaterials.DAEDRIC_TOOL),  
		        new ItemSkyrimSword("daedric_sword", SkyrimMaterials.DAEDRIC_TOOL),  
		        new ItemSkyrimSword("daedric_waraxe", SkyrimMaterials.DAEDRIC_TOOL),  
		        new ItemSkyrimSword("daedric_warhammer", SkyrimMaterials.DAEDRIC_TOOL),  
		        new ItemSkyrimSword("dragonbone_battleaxe", SkyrimMaterials.DRAGONBONE_TOOL),  
		        new ItemSkyrimSword("dragonbone_dagger", SkyrimMaterials.DRAGONBONE_TOOL),  
		        new ItemSkyrimGreatsword("dragonbone_greatsword", SkyrimMaterials.DRAGONBONE_TOOL),  
		        new ItemSkyrimSword("dragonbone_mace", SkyrimMaterials.DRAGONBONE_TOOL),  
		        new ItemSkyrimSword("dragonbone_sword", SkyrimMaterials.DRAGONBONE_TOOL),  
		        new ItemSkyrimSword("dragonbone_waraxe", SkyrimMaterials.DRAGONBONE_TOOL),  
		        new ItemSkyrimSword("dragonbone_warhammer", SkyrimMaterials.DRAGONBONE_TOOL),  
		        new ItemSkyrimSword("dwarven_battleaxe", SkyrimMaterials.DWARVEN_TOOL),  
		        new ItemSkyrimSword("dwarven_dagger", SkyrimMaterials.DWARVEN_TOOL),  
		        new ItemSkyrimGreatsword("dwarven_greatsword", SkyrimMaterials.DWARVEN_TOOL),  
		        new ItemSkyrimSword("dwarven_mace", SkyrimMaterials.DWARVEN_TOOL),  
		        new ItemSkyrimSword("dwarven_sword", SkyrimMaterials.DWARVEN_TOOL),  
		        new ItemSkyrimSword("dwarven_waraxe", SkyrimMaterials.DWARVEN_TOOL),  
		        new ItemSkyrimSword("dwarven_warhammer", SkyrimMaterials.DWARVEN_TOOL),  
		        new ItemSkyrimSword("ebony_battleaxe", SkyrimMaterials.EBONY_TOOL),  
		        new ItemSkyrimSword("ebony_dagger", SkyrimMaterials.EBONY_TOOL),  
		        new ItemSkyrimGreatsword("ebony_greatsword", SkyrimMaterials.EBONY_TOOL),  
		        new ItemSkyrimSword("ebony_mace", SkyrimMaterials.EBONY_TOOL),  
		        new ItemSkyrimSword("ebony_sword", SkyrimMaterials.EBONY_TOOL),  
		        new ItemSkyrimSword("ebony_waraxe", SkyrimMaterials.EBONY_TOOL),  
		        new ItemSkyrimSword("ebony_warhammer", SkyrimMaterials.EBONY_TOOL),  
		        new ItemSkyrimSword("elven_battleaxe", SkyrimMaterials.ELVEN_TOOL),  
		        new ItemSkyrimSword("elven_dagger", SkyrimMaterials.ELVEN_TOOL),  
		        new ItemSkyrimGreatsword("elven_greatsword", SkyrimMaterials.ELVEN_TOOL),  
		        new ItemSkyrimSword("elven_mace", SkyrimMaterials.ELVEN_TOOL),  
		        new ItemSkyrimSword("elven_sword", SkyrimMaterials.ELVEN_TOOL),  
		        new ItemSkyrimSword("elven_waraxe", SkyrimMaterials.ELVEN_TOOL),  
		        new ItemSkyrimSword("elven_warhammer", SkyrimMaterials.ELVEN_TOOL),  
		        new ItemSkyrimSword("falmer_sword", SkyrimMaterials.FALMER_TOOL),  
		        new ItemSkyrimSword("falmer_waraxe", SkyrimMaterials.FALMER_TOOL),  
		        new ItemSkyrimSword("glass_battleaxe", SkyrimMaterials.GLASS_TOOL),  
		        new ItemSkyrimSword("glass_dagger", SkyrimMaterials.GLASS_TOOL),  
		        new ItemSkyrimGreatsword("glass_greatsword", SkyrimMaterials.GLASS_TOOL),  
		        new ItemSkyrimSword("glass_mace", SkyrimMaterials.GLASS_TOOL),  
		        new ItemSkyrimSword("glass_sword", SkyrimMaterials.GLASS_TOOL),  
		        new ItemSkyrimSword("glass_waraxe", SkyrimMaterials.GLASS_TOOL),  
		        new ItemSkyrimSword("glass_warhammer", SkyrimMaterials.GLASS_TOOL),  
		        new ItemSkyrimSword("imperial_sword", Item.ToolMaterial.IRON),  
		        new ItemSkyrimSword("iron_battleaxe", Item.ToolMaterial.IRON),  
		        new ItemSkyrimSword("iron_dagger", Item.ToolMaterial.IRON),  
		        new ItemSkyrimGreatsword("iron_greatsword", Item.ToolMaterial.IRON),  
		        new ItemSkyrimSword("iron_mace", Item.ToolMaterial.IRON),  
		        new ItemSkyrimSword("iron_sword", Item.ToolMaterial.IRON),  
		        new ItemSkyrimSword("iron_waraxe", Item.ToolMaterial.IRON),  
		        new ItemSkyrimSword("iron_warhammer", Item.ToolMaterial.IRON),  
		        new ItemSkyrimSword("orcish_battleaxe", SkyrimMaterials.ORCISH_TOOL),  
		        new ItemSkyrimSword("orcish_dagger", SkyrimMaterials.ORCISH_TOOL),  
		        new ItemSkyrimGreatsword("orcish_greatsword", SkyrimMaterials.ORCISH_TOOL),  
		        new ItemSkyrimSword("orcish_mace", SkyrimMaterials.ORCISH_TOOL),  
		        new ItemSkyrimSword("orcish_sword", SkyrimMaterials.ORCISH_TOOL),  
		        new ItemSkyrimSword("orcish_waraxe", SkyrimMaterials.ORCISH_TOOL),  
		        new ItemSkyrimSword("orcish_warhammer", SkyrimMaterials.ORCISH_TOOL),  
		        new ItemSkyrimSword("steel_battleaxe", SkyrimMaterials.STEEL_TOOL),  
		        new ItemSkyrimSword("steel_dagger", SkyrimMaterials.STEEL_TOOL),  
		        new ItemSkyrimGreatsword("steel_greatsword", SkyrimMaterials.STEEL_TOOL),  
		        new ItemSkyrimSword("steel_mace", SkyrimMaterials.STEEL_TOOL),  
        		new ItemSkyrimSword("steel_sword", SkyrimMaterials.STEEL_TOOL),
			new ItemSkyrimSword("steel_waraxe", SkyrimMaterials.STEEL_TOOL),  
			new ItemSkyrimSword("steel_warhammer", SkyrimMaterials.STEEL_TOOL),  
			
			new ItemSkyrimArmor("ancient_nord_helmet", SkyrimMaterials.ANCIENT_NORD_ARMOR, EntityEquipmentSlot.HEAD),  
		        new ItemSkyrimArmor("ancient_nord_chestplate", SkyrimMaterials.ANCIENT_NORD_ARMOR, EntityEquipmentSlot.CHEST),  
		        new ItemSkyrimArmor("ancient_nord_leggins", SkyrimMaterials.ANCIENT_NORD_ARMOR, EntityEquipmentSlot.LEGS),  
		        new ItemSkyrimArmor("ancient_nord_boots", SkyrimMaterials.ANCIENT_NORD_ARMOR, EntityEquipmentSlot.FEET),  
		        new ItemSkyrimArmor("daedric_helmet", SkyrimMaterials.DAEDRIC_ARMOR, EntityEquipmentSlot.HEAD),  
		        new ItemSkyrimArmor("daedric_chestplate", SkyrimMaterials.DAEDRIC_ARMOR, EntityEquipmentSlot.CHEST),  
		        new ItemSkyrimArmor("daedric_leggins", SkyrimMaterials.DAEDRIC_ARMOR, EntityEquipmentSlot.LEGS),  
		        new ItemSkyrimArmor("daedric_boots", SkyrimMaterials.DAEDRIC_ARMOR, EntityEquipmentSlot.FEET),  
		        new ItemSkyrimArmor("dwarven_helmet", SkyrimMaterials.DWARVEN_ARMOR, EntityEquipmentSlot.HEAD),  
		        new ItemSkyrimArmor("dwarven_chestplate", SkyrimMaterials.DWARVEN_ARMOR, EntityEquipmentSlot.CHEST),  
		        new ItemSkyrimArmor("dwarven_leggins", SkyrimMaterials.DWARVEN_ARMOR, EntityEquipmentSlot.LEGS),  
		        new ItemSkyrimArmor("dwarven_boots", SkyrimMaterials.DWARVEN_ARMOR, EntityEquipmentSlot.FEET),  
		        new ItemSkyrimArmor("ebony_helmet", SkyrimMaterials.EBONY_ARMOR, EntityEquipmentSlot.HEAD),  
		        new ItemSkyrimArmor("ebony_chestplate", SkyrimMaterials.EBONY_ARMOR, EntityEquipmentSlot.CHEST),  
		        new ItemSkyrimArmor("ebony_leggins", SkyrimMaterials.EBONY_ARMOR, EntityEquipmentSlot.LEGS),  
		        new ItemSkyrimArmor("ebony_boots", SkyrimMaterials.EBONY_ARMOR, EntityEquipmentSlot.FEET),  
		        new ItemSkyrimArmor("elven_helmet", SkyrimMaterials.ELVEN_ARMOR, EntityEquipmentSlot.HEAD),  
		        new ItemSkyrimArmor("elven_chestplate", SkyrimMaterials.ELVEN_ARMOR, EntityEquipmentSlot.CHEST),  
		        new ItemSkyrimArmor("elven_leggins", SkyrimMaterials.ELVEN_ARMOR, EntityEquipmentSlot.LEGS),  
		        new ItemSkyrimArmor("elven_boots", SkyrimMaterials.ELVEN_ARMOR, EntityEquipmentSlot.FEET),  
		        new ItemSkyrimArmor("falmer_helmet", SkyrimMaterials.FALMER_ARMOR, EntityEquipmentSlot.HEAD),  
		        new ItemSkyrimArmor("falmer_chestplate", SkyrimMaterials.FALMER_ARMOR, EntityEquipmentSlot.CHEST),  
		        new ItemSkyrimArmor("falmer_leggins", SkyrimMaterials.FALMER_ARMOR, EntityEquipmentSlot.LEGS),  
		        new ItemSkyrimArmor("falmer_boots", SkyrimMaterials.FALMER_ARMOR, EntityEquipmentSlot.FEET),  
		        new ItemSkyrimArmor("glass_helmet", SkyrimMaterials.GLASS_ARMOR, EntityEquipmentSlot.HEAD),  
		        new ItemSkyrimArmor("glass_chestplate", SkyrimMaterials.GLASS_ARMOR, EntityEquipmentSlot.CHEST),  
		        new ItemSkyrimArmor("glass_leggins", SkyrimMaterials.GLASS_ARMOR, EntityEquipmentSlot.LEGS),  
		        new ItemSkyrimArmor("glass_boots", SkyrimMaterials.GLASS_ARMOR, EntityEquipmentSlot.FEET),
		        new ItemSkyrimArmor("hide_helmet", SkyrimMaterials.HIDE_ARMOR, EntityEquipmentSlot.HEAD),  
		        new ItemSkyrimArmor("hide_chestplate", SkyrimMaterials.HIDE_ARMOR, EntityEquipmentSlot.CHEST),  
		        new ItemSkyrimArmor("hide_leggins", SkyrimMaterials.HIDE_ARMOR, EntityEquipmentSlot.LEGS),  
		        new ItemSkyrimArmor("hide_boots" , SkyrimMaterials.HIDE_ARMOR, EntityEquipmentSlot.FEET),  
		        new ItemSkyrimArmor("imperial_helmet", SkyrimMaterials.IMPERIAL_ARMOR, EntityEquipmentSlot.HEAD),  
		        new ItemSkyrimArmor("imperial_chestplate", SkyrimMaterials.IMPERIAL_ARMOR, EntityEquipmentSlot.CHEST),  
		        new ItemSkyrimArmor("imperial_leggins", SkyrimMaterials.IMPERIAL_ARMOR, EntityEquipmentSlot.LEGS),  
		        new ItemSkyrimArmor("imperial_boots", SkyrimMaterials.IMPERIAL_ARMOR, EntityEquipmentSlot.FEET),  
		        new ItemSkyrimArmor("iron_helmet", SkyrimMaterials.IRON_ARMOR, EntityEquipmentSlot.HEAD),  
		        new ItemSkyrimArmor("iron_chestplate", SkyrimMaterials.IRON_ARMOR, EntityEquipmentSlot.CHEST),  
		        new ItemSkyrimArmor("iron_leggins", SkyrimMaterials.IRON_ARMOR, EntityEquipmentSlot.LEGS),  
		        new ItemSkyrimArmor("iron_boots", SkyrimMaterials.IRON_ARMOR, EntityEquipmentSlot.FEET),  
		        new ItemSkyrimArmor("orcish_helmet", SkyrimMaterials.ORCISH_ARMOR, EntityEquipmentSlot.HEAD),  
		        new ItemSkyrimArmor("orcish_chestplate", SkyrimMaterials.ORCISH_ARMOR, EntityEquipmentSlot.CHEST),  
		        new ItemSkyrimArmor("orcish_leggins", SkyrimMaterials.ORCISH_ARMOR, EntityEquipmentSlot.LEGS),  
		        new ItemSkyrimArmor("orcish_boots", SkyrimMaterials.ORCISH_ARMOR, EntityEquipmentSlot.FEET),
		        new ItemSkyrimArmor("scaled_helmet", SkyrimMaterials.SCALED_ARMOR, EntityEquipmentSlot.HEAD),  
		        new ItemSkyrimArmor("scaled_chestplate", SkyrimMaterials.SCALED_ARMOR, EntityEquipmentSlot.CHEST),  
		        new ItemSkyrimArmor("scaled_leggins", SkyrimMaterials.SCALED_ARMOR, EntityEquipmentSlot.LEGS),  
		        new ItemSkyrimArmor("scaled_boots", SkyrimMaterials.SCALED_ARMOR, EntityEquipmentSlot.FEET),  
		        new ItemSkyrimArmor("steel_helmet", SkyrimMaterials.STEEL_ARMOR, EntityEquipmentSlot.HEAD),  
		        new ItemSkyrimArmor("steel_chestplate", SkyrimMaterials.STEEL_ARMOR, EntityEquipmentSlot.CHEST),  
		        new ItemSkyrimArmor("steel_leggins", SkyrimMaterials.STEEL_ARMOR, EntityEquipmentSlot.LEGS),  
		        new ItemSkyrimArmor("steel_boots", SkyrimMaterials.STEEL_ARMOR, EntityEquipmentSlot.FEET),
		        new ItemSkyrimArmor("stormcloak_helmet", SkyrimMaterials.STORMCLOAK_ARMOR, EntityEquipmentSlot.HEAD),  
		        new ItemSkyrimArmor("stormcloak_chestplate", SkyrimMaterials.STORMCLOAK_ARMOR, EntityEquipmentSlot.CHEST),  
		        new ItemSkyrimArmor("stormcloak_leggins", SkyrimMaterials.STORMCLOAK_ARMOR, EntityEquipmentSlot.LEGS),  
		        new ItemSkyrimArmor("stormcloak_boots", SkyrimMaterials.STORMCLOAK_ARMOR, EntityEquipmentSlot.FEET)
						
		};

		final Item[] itemBlocks = {
			new ItemBlock(ModBlocks.ANVIL).setRegistryName(ModBlocks.ANVIL.getRegistryName()),
			new ItemBlock(ModBlocks.CORUNDUM_ORE).setRegistryName(ModBlocks.CORUNDUM_ORE.getRegistryName()),
			new ItemBlock(ModBlocks.EBONY_ORE).setRegistryName(ModBlocks.EBONY_ORE.getRegistryName()),
			new ItemBlock(ModBlocks.MALACHITE_ORE).setRegistryName(ModBlocks.MALACHITE_ORE.getRegistryName()),
			new ItemBlock(ModBlocks.MOONSTONE_ORE).setRegistryName(ModBlocks.MOONSTONE_ORE.getRegistryName()),
			new ItemBlock(ModBlocks.ORICHALCUM_ORE).setRegistryName(ModBlocks.ORICHALCUM_ORE.getRegistryName()),
			new ItemBlock(ModBlocks.QUICKSILVER_ORE).setRegistryName(ModBlocks.QUICKSILVER_ORE.getRegistryName()),
			new ItemBlock(ModBlocks.SILVER_ORE).setRegistryName(ModBlocks.SILVER_ORE.getRegistryName())
		};

		event.getRegistry().registerAll(items);
		event.getRegistry().registerAll(itemBlocks);
	}
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		final Block[] blocks = {
			new BlockSkyrimAnvil("anvil", Material.ANVIL),
			new BlockSkyrimOre("corundum_ore", Material.ROCK),
			new BlockSkyrimOre("ebony_ore", Material.ROCK),
			new BlockSkyrimOre("malachite_ore", Material.ROCK),
			new BlockSkyrimOre("moonstone_ore", Material.ROCK),
			new BlockSkyrimOre("orichalcum_ore", Material.ROCK),
			new BlockSkyrimOre("quicksilver_ore", Material.ROCK),
			new BlockSkyrimOre("silver_ore", Material.ROCK)
		};

		event.getRegistry().registerAll(blocks);
	}
	
}
