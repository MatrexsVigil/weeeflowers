package com.pam.weeeflowers.items;

import java.util.Map;

import com.pam.weeeflowers.Weeeflowers;
import com.pam.weeeflowers.blocks.CropRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class SeedDropRegistry {

    public static void getSeedDrops() {
        for (Map.Entry<String, Boolean> entry : Weeeflowers.config.seedDropFromGrass.entrySet()) {
            if (entry.getValue()) {
                final Item item = CropRegistry.getSeed(entry.getKey());

                if (item == null) continue;

                MinecraftForge.addGrassSeed(new ItemStack(item, 1, 0), Weeeflowers.config.seedrarity);
            }
        }
    }
}


