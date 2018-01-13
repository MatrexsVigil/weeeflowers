package com.pam.pigskin.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ConfigHandler {

    

	private final Configuration config;

    private static final String CATEGORY_GENERAL = "general";

    public boolean pigsdropPigskin;
    public int pigdropamountMax;
    public boolean zombiepigmendropPigskin;
    public int zombiepigmendropamountMax;

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
    	pigsdropPigskin = config.get(CATEGORY_GENERAL, "pigsdropPigskin", true, "Enable to have pigs drop pigskin.").getBoolean();
    	pigdropamountMax = config.get(CATEGORY_GENERAL, "pigdropamountMax", 3, "Cannot be set to 0.  Set pigsdropPigskin to false to disable.").getInt();
    	zombiepigmendropPigskin = config.get(CATEGORY_GENERAL, "zombiepigmendropPigskin", true, "Enable to have zombie pigmen drop pigskin.").getBoolean();
    	zombiepigmendropamountMax = config.get(CATEGORY_GENERAL, "zombiepigmendropamountMax", 1, "Cannot be set to 0.  Set zombiepigmendropPigskin to false to disable.").getInt();

    }

   
}
