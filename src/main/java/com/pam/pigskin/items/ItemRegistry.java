package com.pam.pigskin.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.pam.pigskin.Pigskin;

import com.pam.pigskin.items.ItemRenderRegister;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public final class ItemRegistry {
	public static final List<Item> itemlist = new ArrayList<Item>();
    public static final HashMap<String, Item> items = new HashMap<String, Item>();

	// Items
    public static Item pigskinItem;
    public static Item footballItem;
    

	public static boolean initialized = false;

	public static void registerItems() {
		registerAllItems();
		registerFootballItems();
		
		
		initialized = true;
	}



	private static void registerAllItems() {
		pigskinItem = registerGenericItem("pigskinitem");
		
	}
	
	private static void registerFootballItems() {
		footballItem = registerItemFootball("footballitem");
	}

	private static Item registerGenericItem(String registryName) {
		final Item item = new Item();

		return registerItem(item, registryName);
	}

	private static Item registerItemFootball(String registryName) {
		final Item item = new ItemFootball();

		return registerItem(item, registryName);
	}

    public static Item registerItem(Item item, String registryName) {
        item.setCreativeTab(Pigskin.modTab);
        item.setRegistryName(registryName);
        item.setUnlocalizedName(registryName);
        itemlist.add(item);
        return item;
    }
    
    @SubscribeEvent
    public void onItemRegistry(RegistryEvent.Register<Item> e) {
        IForgeRegistry<Item> reg = e.getRegistry();
        reg.registerAll(itemlist.toArray(new Item[0]));
        GeneralOreRegistry.initOreRegistry();
    }
}

