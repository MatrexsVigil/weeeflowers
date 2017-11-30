package com.pam.weeeflowers.blocks;

import java.text.MessageFormat;
import java.util.HashMap;

import com.pam.weeeflowers.blocks.growables.BlockPamCrop;
import com.pam.weeeflowers.items.ItemRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.fml.common.FMLLog;

public class CropRegistry {

	public static final String CROP_BLOCK_NAME = "pam{0}crop";
	//public static final String ITEM_NAME = "{0}item";
	public static final String SEED_ITEM_NAME = "{0}seeditem";

	public static final String BLACK = "black";
	public static final String BLUE = "blue";
	public static final String BROWN = "brown";
	public static final String CYAN = "cyan";
	public static final String DARKGRAY = "darkgray";
	public static final String GREEN = "green";
	public static final String LIGHTBLUE = "lightblue";
	public static final String LIGHTGRAY = "lightgray";
	public static final String LIME = "lime";
	public static final String MAGENTA = "magenta";
	public static final String ORANGE = "orange";
	public static final String PINK = "pink";
	public static final String PURPLE = "purple";
	public static final String RED = "red";
	public static final String WHITE = "white";
	public static final String YELLOW = "yellow";
	

	public static final String[] cropNames = new String[] {BLACK, BLUE, BROWN, CYAN, DARKGRAY, GREEN, LIGHTBLUE, LIGHTGRAY, 
			LIME, MAGENTA, ORANGE, PINK, PURPLE, RED, WHITE, YELLOW};

	private static boolean isInitialized = false;

	private static final HashMap<String, Item> seeds = new HashMap<String, Item>();
	//private static final HashMap<String, ItemSeedFood> foods = new HashMap<String, ItemSeedFood>();

	private static final HashMap<String, BlockPamCrop> crops = new HashMap<String, BlockPamCrop>();

	public static HashMap<String, Item> getSeeds() {
		return seeds;
	}

	//public static HashMap<String, ItemSeedFood> getFoods() {
	//	return foods;
	//}

	public static HashMap<String, BlockPamCrop> getCrops() {
		if(!isInitialized) {
			FMLLog.bigWarning("Crop registry is not initialized.");
			return new HashMap<String, BlockPamCrop>();
		}
		return crops;
	}

	public static boolean isInitialized() {
		return isInitialized;
	}

	public static Item getSeed(String cropName) {
		if(!isInitialized()) {
			FMLLog.bigWarning("Crop registry has not been initialized yet.");
			return null;
		}

		if(!seeds.containsKey(cropName)) {
			FMLLog.bigWarning("No seed for key %s", cropName);
			return null;
		}

		return seeds.get(cropName);
	}

	//public static ItemSeedFood getFood(String cropName) {
	//	if(!isInitialized()) {
	//		FMLLog.bigWarning("Crop registry has not been initialized yet.");
	//		return null;
	//	}
	//
	//	if(!foods.containsKey(cropName)) {
	//		FMLLog.bigWarning("No food for key %s", cropName);
	//		return null;
	//	}
	//
	//	return foods.get(cropName);
	//}

	public static BlockPamCrop getCrop(String cropName) {
		if(!isInitialized()) {
			FMLLog.bigWarning("Crop registry has not been initialized yet.");
			return null;
		}

		if(!crops.containsKey(cropName)) {
			FMLLog.bigWarning("No crop for key %s", cropName);
			return null;
		}

		return crops.get(cropName);
	}

	public static void registerCrops() {
		if(isInitialized)
			return;

		for(String cropName : cropNames) {
			registerCrop(cropName);
		}

		isInitialized = true;
	}

	private static void registerCrop(String cropName) {
		final String registryName = MessageFormat.format(CROP_BLOCK_NAME, cropName);
		final BlockPamCrop cropBlock = new BlockPamCrop(registryName, cropName);

		BlockRegistry.registerBlock(registryName, null, cropBlock);

		//final ItemSeedFood item = createItem(cropBlock);
		//ItemRegistry.registerItem(item, MessageFormat.format(ITEM_NAME, cropName));
		//cropBlock.setFood(item);

		final Item seedItem = createSeed(cropBlock);
		ItemRegistry.registerItem(seedItem, getSeedName(cropName));
		cropBlock.setSeed(seedItem);

		seeds.put(cropName, seedItem);
		//foods.put(cropName, item);
		crops.put(cropName, cropBlock);
	}
	
	private static String getSeedName(String cropName) {
		return MessageFormat.format(SEED_ITEM_NAME, cropName);
	}


	//private static ItemPamSeedFood createItem(BlockPamCrop cropBlock) {
	//	return new ItemPamSeedFood(HarvestCraft.config.cropfoodRestore, HarvestCraft.config.cropsaturationRestore,
	//			cropBlock);
	//}

	private static Item createSeed(BlockPamCrop cropBlock) {
		return new ItemSeeds(cropBlock, Blocks.FARMLAND);
	}
}
