package com.pam.weeeflowers.proxy;

import com.pam.weeeflowers.items.SeedDropRegistry;
import com.pam.weeeflowers.blocks.BlockRegistry;
import com.pam.weeeflowers.blocks.CropRegistry;
import com.pam.weeeflowers.items.GeneralOreRegistry;
import com.pam.weeeflowers.items.ItemRegistry;
import com.pam.weeeflowers.worldgen.WorldGenPamFlower;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
    	CropRegistry.registerCrops();
        BlockRegistry.initBlockRegistry();
        MinecraftForge.EVENT_BUS.register(new BlockRegistry());
        ItemRegistry.registerItems();
        MinecraftForge.EVENT_BUS.register(new ItemRegistry());
    }

    public void init(FMLInitializationEvent e) {
		GameRegistry.registerWorldGenerator(new WorldGenPamFlower(), 0);
		onBlocksAndItemsLoaded();	
    }

    public void postInit(FMLPostInitializationEvent e) {
    	
    }

     public void onBlocksAndItemsLoaded() {
    	 GeneralOreRegistry.initOreRegistry();
        SeedDropRegistry.getSeedDrops();

    }
}
