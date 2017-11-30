package com.pam.weeeflowers.blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.pam.weeeflowers.Weeeflowers;
import com.pam.weeeflowers.items.ItemRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public final class BlockRegistry {

	public static final List<Block> blocks = new ArrayList<Block>();
	
	// Garden blocks
	public static final HashMap<String, BlockBaseFlower> flowers = new HashMap<String, BlockBaseFlower>();
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


	private static boolean initialized = false;

	public static void initBlockRegistry() {
		registerFlowers();
		initialized = true;
	}

	public static BlockBaseFlower getFlower(String flowerName) {
		if(!initialized) {
			FMLLog.bigWarning("BlockRegistry has not been initialized yet.");
			return null;
		}

		if(!flowers.containsKey(flowerName)) {
			FMLLog.bigWarning("Flowers %s is not registered.", flowerName);
			return null;
		}

		return flowers.get(flowerName);
	}

	private static void registerFlowers() {
		addFlower(BLACK, BlockBaseFlower.Region.PLAINS);
		addFlower(BLUE, BlockBaseFlower.Region.PLAINS);
		addFlower(BROWN, BlockBaseFlower.Region.PLAINS);
		addFlower(CYAN, BlockBaseFlower.Region.PLAINS);
		addFlower(DARKGRAY, BlockBaseFlower.Region.PLAINS);
		addFlower(GREEN, BlockBaseFlower.Region.PLAINS);
		addFlower(LIGHTBLUE, BlockBaseFlower.Region.PLAINS);
		addFlower(LIGHTGRAY, BlockBaseFlower.Region.PLAINS);
		addFlower(LIME, BlockBaseFlower.Region.PLAINS);
		addFlower(MAGENTA, BlockBaseFlower.Region.PLAINS);
		addFlower(ORANGE, BlockBaseFlower.Region.PLAINS);
		addFlower(PINK, BlockBaseFlower.Region.PLAINS);
		addFlower(PURPLE, BlockBaseFlower.Region.PLAINS);
		addFlower(RED, BlockBaseFlower.Region.PLAINS);
		addFlower(WHITE, BlockBaseFlower.Region.PLAINS);
		addFlower(YELLOW, BlockBaseFlower.Region.PLAINS);
	}



	private static void addFlower(String flowerName, BlockBaseFlower.Region region) {
		final BlockBaseFlower flower = new BlockBaseFlower(flowerName, region);
		flowers.put(flowerName, flower);
	}

	public static void registerBlock(String registerName, ItemBlock itemBlock, Block block) {
        block.setRegistryName(registerName);
        block.setUnlocalizedName(registerName);
        block.setCreativeTab(Weeeflowers.modTab);
        block.setHardness(0.0F);
        blocks.add(block);

        if (itemBlock != null)
        {
        itemBlock.setRegistryName(registerName);
        itemBlock.setUnlocalizedName(registerName);
        ItemRegistry.itemlist.add(itemBlock);
        }
        return;
    }

    public static void registerBlock(String registerName, Block block) {
        final ItemBlock itemBlock = new ItemBlock(block);
        registerBlock(registerName, itemBlock, block);
    }

    
    @SubscribeEvent
    public void onBlockRegistry(RegistryEvent.Register<Block> e) {
        IForgeRegistry<Block> reg = e.getRegistry();
        reg.registerAll(blocks.toArray(new Block[0]));        
    }
}
