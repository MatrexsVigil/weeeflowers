package com.pam.weeeflowers.blocks;

import static com.pam.weeeflowers.Weeeflowers.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.pam.weeeflowers.Weeeflowers;
import com.pam.weeeflowers.worldgen.WorldGenHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.event.ForgeEventFactory;

public class BlockBaseFlower extends BlockBush {
    public static final Map<String, List<ItemStack>> drops = new HashMap<String, List<ItemStack>>();

    public enum Region {
        PLAINS(EnumPlantType.Plains, Blocks.GRASS, Blocks.DIRT),
        DESERT(EnumPlantType.Desert, Blocks.SAND);

        private final EnumPlantType plantType;

        private final Block[] soilBlocks;

        Region(EnumPlantType plantType, Block... soilBlocks) {
            this.plantType = plantType;
            this.soilBlocks = soilBlocks;
        }

        public EnumPlantType getPlantType() {
            return plantType;
        }

        public Block[] getSoilBlocks() {
            return soilBlocks;
        }
    }

    private final String type;
    private final String name;
    private final Region region;

    public BlockBaseFlower(String type, Region region) {
        super(Material.GRASS);
        this.type = type;
        this.name = type.toLowerCase();
        this.region = region;

        this.setCreativeTab(Weeeflowers.modTab);
        this.setSoundType(SoundType.PLANT);
        this.setTickRandomly(true);

        BlockRegistry.registerBlock(name, this);
    }

    

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState blockState = worldIn.getBlockState(pos);
        return WorldGenHelper.canReplace(blockState, worldIn, pos) && checkSoilBlock(worldIn, pos);
    }

    private boolean checkSoilBlock(World world, BlockPos pos) {
        final Block soilBlock = world.getBlockState(pos.down()).getBlock();

        for (Block acceptableBlock : region.getSoilBlocks()) {
            if (acceptableBlock == soilBlock) return true;
        }
        return false;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return region.getPlantType();
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    }

    public String getName() {
        return name;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return getDefaultState();
        return state;
    }
}