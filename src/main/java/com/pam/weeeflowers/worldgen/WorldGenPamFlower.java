package com.pam.weeeflowers.worldgen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

import com.pam.weeeflowers.Weeeflowers;
import com.pam.weeeflowers.blocks.BlockBaseFlower;
import com.pam.weeeflowers.blocks.BlockRegistry;

public class WorldGenPamFlower implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
			net.minecraft.world.gen.IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        final int x = chunkX * 16 + 8;
        final int z = chunkZ * 16 + 8;

        final Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.DEAD) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.SANDY) 
        		|| BiomeDictionary.hasType(biome, BiomeDictionary.Type.WASTELAND) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.END) 
        		|| BiomeDictionary.hasType(biome, BiomeDictionary.Type.NETHER) ) {
            return;
        }
        	for(int i = 0; i < 15; ++i) {
        		if (i == 0)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.BLACK), world, random, x, z);
        		}
        		
        		if (i == 1)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.BLUE), world, random, x, z);
        		}
        		if (i == 2)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.BROWN), world, random, x, z);
        		}
        		if (i == 3)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.CYAN), world, random, x, z);
        		}
        		if (i == 4)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.DARKGRAY), world, random, x, z);
        		}
        		if (i == 5)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.GREEN), world, random, x, z);
        		}
        		if (i == 6)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.LIGHTBLUE), world, random, x, z);
        		}
        		if (i == 7)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.LIGHTGRAY), world, random, x, z);
        		}
        		if (i == 8)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.LIME), world, random, x, z);
        		}
        		if (i == 9)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.MAGENTA), world, random, x, z);
        		}
        		if (i == 10)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.ORANGE), world, random, x, z);
        		}
        		if (i == 11)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.PINK), world, random, x, z);
        		}
        		if (i == 12)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.PURPLE), world, random, x, z);
        		}
        		if (i == 13)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.RED), world, random, x, z);
        		}
        		if (i == 14)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.WHITE), world, random, x, z);
        		}
        		if (i == 15)
        		{
        			generateFlower(BlockRegistry.getFlower(BlockRegistry.YELLOW), world, random, x, z);
        		}
        	}

    }

    private void generateFlower(BlockBaseFlower flowerBlock, World world, Random random, int x, int z) {
        if (random.nextFloat() < Weeeflowers.config.flowerRarity / 8.0f) {
            final int posX = x + world.rand.nextInt(16);
            final int posZ = z + world.rand.nextInt(16);
            final BlockPos newPos = WorldGenHelper.getGroundPos(world, posX, posZ);

            if (newPos != null && flowerBlock.canPlaceBlockAt(world, newPos)) {
                world.setBlockState(newPos, flowerBlock.getDefaultState(), 2);
            }
        }
    }

}