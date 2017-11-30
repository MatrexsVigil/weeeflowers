package com.pam.weeeflowers.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pam.weeeflowers.blocks.CropRegistry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ConfigHandler {

    

	private final Configuration config;

    private static final String CATEGORY_GENERAL = "general";

    public static boolean cropsdropSeeds;
    public int seedrarity;
    public int flowerRarity;
   

    public final HashMap<String, Boolean> seedDropFromGrass = new HashMap<String, Boolean>();

    public ConfigHandler(Configuration config) {
        this.config = config;

        initSettings();
    }

    private void initSettings() {
        config.load();

        initGeneralSettings();

        if (config.hasChanged()) {
            config.save();
        }
    }



    private void initGeneralSettings() {
    	cropsdropSeeds = config.get(CATEGORY_GENERAL, "cropsdropSeeds", false).getBoolean();
        seedrarity = config.get(CATEGORY_GENERAL, "seedrarity", 1).getInt();
        initSeedDropFromGrassSetting("blackflowerseeddropfromgrass", CropRegistry.BLACK);
        initSeedDropFromGrassSetting("blueflowerseeddropfromgrass", CropRegistry.BLUE);
        initSeedDropFromGrassSetting("brownflowerseeddropfromgrass", CropRegistry.BROWN);
        initSeedDropFromGrassSetting("cyanflowerseeddropfromgrass", CropRegistry.CYAN);
        initSeedDropFromGrassSetting("darkgrayflowerseeddropfromgrass", CropRegistry.DARKGRAY);
        initSeedDropFromGrassSetting("greenflowerseeddropfromgrass", CropRegistry.GREEN);
        initSeedDropFromGrassSetting("lightblueflowerseeddropfromgrass", CropRegistry.LIGHTBLUE);
        initSeedDropFromGrassSetting("lightgrayflowerseeddropfromgrass", CropRegistry.LIGHTGRAY);
        initSeedDropFromGrassSetting("limeflowerseeddropfromgrass", CropRegistry.LIME);
        initSeedDropFromGrassSetting("magentaflowerseeddropfromgrass", CropRegistry.MAGENTA);
        initSeedDropFromGrassSetting("orangeflowerseeddropfromgrass", CropRegistry.ORANGE);
        initSeedDropFromGrassSetting("pinkflowerseeddropfromgrass", CropRegistry.PINK);
        initSeedDropFromGrassSetting("purpleflowerseeddropfromgrass", CropRegistry.PURPLE);
        initSeedDropFromGrassSetting("redflowerseeddropfromgrass", CropRegistry.RED);
        initSeedDropFromGrassSetting("whiteflowerseeddropfromgrass", CropRegistry.WHITE);
        initSeedDropFromGrassSetting("yellowflowerseeddropfromgrass", CropRegistry.YELLOW);
        flowerRarity = config.get(CATEGORY_GENERAL, "flowerRarity", 2).getInt();

    }


    private void initSeedDropFromGrassSetting(String key, String item) {
        boolean doDrop = config.get(CATEGORY_GENERAL, key, false).getBoolean();

        seedDropFromGrass.put(item, doDrop);
    }

   
}
