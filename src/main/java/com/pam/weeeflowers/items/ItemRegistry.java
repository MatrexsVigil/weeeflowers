package com.pam.weeeflowers.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pam.weeeflowers.Weeeflowers;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public final class ItemRegistry {
	public static final List<Item> itemlist = new ArrayList<Item>();
    public static final HashMap<String, Item> items = new HashMap<String, Item>();


	// Items
    public static Item blackdyeItem;
    public static Item bluedyeItem;
    public static Item browndyeItem;
    public static Item whitedyeItem;
    

	public static boolean initialized = false;

	public static void registerItems() {
		registerAllItems();

		
		
		initialized = true;
	}



	private static void registerAllItems() {
		blackdyeItem = registerGenericItem("blackdyeitem");
		bluedyeItem = registerGenericItem("bluedyeitem");
		browndyeItem = registerGenericItem("browndyeitem");
		whitedyeItem = registerGenericItem("whitedyeitem");
	}

	private static Item registerGenericItem(String registryName) {
		final Item item = new Item();

		return registerItem(item, registryName);
	}

    public static Item registerItem(Item item, String registryName) {
        item.setCreativeTab(Weeeflowers.modTab);
        item.setRegistryName(registryName);
        item.setUnlocalizedName(registryName);
        itemlist.add(item);
        return item;
    }
    
    @SubscribeEvent
    public void onItemRegistry(RegistryEvent.Register<Item> e) {
        IForgeRegistry<Item> reg = e.getRegistry();
        reg.registerAll(itemlist.toArray(new Item[0]));        
       
    }
}
