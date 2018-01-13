package com.pam.pigskin.loottables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.pam.pigskin.Pigskin;
import com.pam.pigskin.items.ItemRegistry;

import net.minecraft.item.Item;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.KilledByPlayer;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;

public class LootHelper {
    public static final Set<CustomLootPool> additionalLootPools = new HashSet<CustomLootPool>();

    static {
       

        // LootTable for Pigs
        if (Pigskin.config.pigsdropPigskin) {
            final ArrayList<LootEntryItem> pigEntries = new ArrayList<LootEntryItem>();
            pigEntries.add(createLootEntryItem(ItemRegistry.pigskinItem, 50, 0,
                    new LootFunction[]{new SetCount(new LootCondition[]{}, new RandomValueRange(1, Pigskin.config.pigdropamountMax))},
                    new KilledByPlayer(false)));

            additionalLootPools.add(new CustomLootPool(
                    LootTableList.ENTITIES_PIG,
                    pigEntries, true));
        }
        
        // LootTable for Pigmen
        if (Pigskin.config.zombiepigmendropPigskin) {
            final ArrayList<LootEntryItem> zombiepigmenEntries = new ArrayList<LootEntryItem>();
            zombiepigmenEntries.add(createLootEntryItem(ItemRegistry.pigskinItem, 50, 0,
                    new LootFunction[]{new SetCount(new LootCondition[]{}, new RandomValueRange(1, Pigskin.config.zombiepigmendropamountMax))},
                    new KilledByPlayer(false)));

            additionalLootPools.add(new CustomLootPool(
                    LootTableList.ENTITIES_ZOMBIE_PIGMAN,
                    zombiepigmenEntries, true));
        }

    }


    private static LootEntryItem createLootEntryItem(Item item, int weight, int quality) {
        return createLootEntryItem(item, weight, quality, new LootFunction[]{});
    }

    private static LootEntryItem createLootEntryItem(Item item, int weight, int quality, LootFunction[] lootFunctions, LootCondition... lootConditions) {
        return new LootEntryItem(item, weight, quality, lootFunctions, lootConditions, "harvestcraft." + item.getUnlocalizedName());
    }
}
