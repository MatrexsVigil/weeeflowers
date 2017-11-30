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
	public static final String blackFlower = "blackFlower";
	public static final String blueFlower = "blueFlower";
	public static final String brownFlower = "brownFlower";
	public static final String cyanFlower = "cyanFlower";
	public static final String darkgrayFlower = "darkgrayFlower";
	public static final String greenFlower = "greenFlower";
	public static final String lightblueFlower = "lightblueFlower";
	public static final String lightgrayFlower = "lightgrayFlower";
	public static final String limeFlower = "limeFlower";
	public static final String magentaFlower = "magentaFlower";
	public static final String orangeFlower = "orangeFlower";
	public static final String pinkFlower = "pinkFlower";
	public static final String purpleFlower = "purpleFlower";
	public static final String redFlower = "redFlower";
	public static final String whiteFlower = "whiteFlower";
	public static final String yellowFlower = "yellowFlower";


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
		addFlower(blackFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(blueFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(brownFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(cyanFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(darkgrayFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(greenFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(lightblueFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(lightgrayFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(limeFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(magentaFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(orangeFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(pinkFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(purpleFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(redFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(whiteFlower, BlockBaseFlower.Region.PLAINS);
		addFlower(yellowFlower, BlockBaseFlower.Region.PLAINS);
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
