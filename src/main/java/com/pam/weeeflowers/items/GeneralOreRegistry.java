package com.pam.weeeflowers.items;

import com.pam.weeeflowers.blocks.CropRegistry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;

public class GeneralOreRegistry {
    
	public static final String listAllseed="listAllseed";
	
	public static final String dyeBlack="dyeBlack";
	public static final String dyeBrown="dyeBrown";
	public static final String dyeBlue="dyeBlue";
	public static final String dyeWhite="dyeWhite";

    public static void initOreRegistry() {
        registerGeneralOres();
    }

    public static void registerGeneralOres() {
    	for (Item seed: CropRegistry.getSeeds().values()) {
            OreDictionary.registerOre(listAllseed, seed);
        }
		
    }

    private static void registerFoodOres() {
    	
    	OreDictionary.registerOre(dyeBlack, ItemRegistry.blackdyeItem);
    	OreDictionary.registerOre(dyeBrown, ItemRegistry.browndyeItem);
    	OreDictionary.registerOre(dyeBlue, ItemRegistry.bluedyeItem);
    	OreDictionary.registerOre(dyeWhite, ItemRegistry.whitedyeItem);
    }

    private static void registerOres(String key, Object... items) {
        for (final Object item : items) {
            if (item instanceof Block) {
                OreDictionary.registerOre(key, (Block) item);
            } else if (item instanceof Item) {
                OreDictionary.registerOre(key, (Item) item);
            }

        }
    }

}

