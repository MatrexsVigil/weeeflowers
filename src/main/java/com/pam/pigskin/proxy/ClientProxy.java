package com.pam.pigskin.proxy;


import com.pam.pigskin.Pigskin;
import com.pam.pigskin.Reference;
import com.pam.pigskin.entity.EntityFootball;
import com.pam.pigskin.items.ItemRegistry;
import com.pam.pigskin.items.ItemRenderRegister;
import com.pam.weeeflowers.blocks.ItemModels;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.registries.RegistryManager;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
		ItemModels.preInit();
		int modEntityID = 0;
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID+":footballitem"), EntityFootball.class, "footballitem", ++modEntityID, Pigskin.instance, 64, 10, true);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
		ItemModels.init();
		ItemRenderRegister.registerItemRenderer();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
   
}


