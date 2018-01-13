package com.pam.pigskin.items;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;

public class GeneralOreRegistry {
    public static final String materialPigskin = "materialPigskin";
   
    
    public static void initOreRegistry() {
        registerGeneralOres();
    }

    public static void registerGeneralOres() {
        OreDictionary.registerOre(materialPigskin,  ItemRegistry.pigskinItem);
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

