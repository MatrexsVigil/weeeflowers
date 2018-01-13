package com.pam.pigskin.proxy;

import com.pam.pigskin.items.ItemRegistry;
import com.pam.pigskin.loottables.LootTableLoadEventHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
    	ItemRegistry.registerItems();
        MinecraftForge.EVENT_BUS.register(new ItemRegistry());
    }

    public void init(FMLInitializationEvent e) {
    	onBlocksAndItemsLoaded();
    	
    }

    public void postInit(FMLPostInitializationEvent e) {
    	
    }
    
    public void onBlocksAndItemsLoaded() {
    	MinecraftForge.EVENT_BUS.register(new LootTableLoadEventHandler());
    }

}
