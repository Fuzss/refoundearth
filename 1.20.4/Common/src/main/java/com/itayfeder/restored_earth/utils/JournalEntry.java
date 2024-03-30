package com.itayfeder.restored_earth.utils;

import fuzs.refoundearth.init.ModItems;
import fuzs.refoundearth.init.ModEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class JournalEntry {
    public static final JournalEntry[] JOURNAL_ENTRIES = {
            new JournalEntry(ModEntityTypes.MUDDY_PIG, 30, EntityType.PIG, ModItems.MUDDY_PIG_SPAWN_EGG),
            new JournalEntry(ModEntityTypes.WOOLY_COW, 28, EntityType.COW, ModItems.WOOLY_COW_SPAWN_EGG),
            new JournalEntry(ModEntityTypes.JUMBO_RABBIT, 30, EntityType.RABBIT, ModItems.JUMBO_RABBIT_SPAWN_EGG),
            new JournalEntry(ModEntityTypes.FANCY_CHICKEN, 36, EntityType.CHICKEN, ModItems.FANCY_CHICKEN_SPAWN_EGG),
            new JournalEntry(ModEntityTypes.RAINBOW_SHEEP, 30, EntityType.SHEEP, ModItems.RAINBOW_SHEEP_SPAWN_EGG),
            new JournalEntry(ModEntityTypes.JOLLY_LLAMA, 20, EntityType.LLAMA, ModItems.JOLLY_LLAMA_SPAWN_EGG),
            new JournalEntry(ModEntityTypes.VILER_WITCH, 20, EntityType.WITCH, ModItems.VILER_WITCH_SPAWN_EGG),
            new JournalEntry(ModEntityTypes.TROPICAL_SLIME, 30, EntityType.SLIME, ModItems.TROPICAL_SLIME_SPAWN_EGG),
            new JournalEntry(ModEntityTypes.MELON_GOLEM, 24, EntityType.SNOW_GOLEM, Items.SNOWBALL),
            new JournalEntry(ModEntityTypes.MOOBLOOM, 28, EntityType.COW, ModItems.MOOBLOOM_SPAWN_EGG),
            new JournalEntry(ModEntityTypes.BOULDERING_ZOMBIE, 24, EntityType.ZOMBIE, ModItems.BOULDERING_ZOMBIE_SPAWN_EGG),
            new JournalEntry(ModEntityTypes.FURNACE_GOLEM, 20, EntityType.IRON_GOLEM, Items.BLAST_FURNACE),
            new JournalEntry(ModEntityTypes.SKELETON_WOLF, 36, EntityType.WOLF, ModItems.SKELETON_WOLF_SPAWN_EGG),
            new JournalEntry(ModEntityTypes.BONE_SPIDER, 24, EntityType.SPIDER, ModItems.BONE_SPIDER_SPAWN_EGG),
            new JournalEntry(ModEntityTypes.MOOLIP, 28, EntityType.COW, ModItems.MOOLIP_SPAWN_EGG),
            new JournalEntry(ModEntityTypes.CLUCKSHROOM, 36, EntityType.CHICKEN, ModItems.CLUCKSHROOM_SPAWN_EGG),
            new JournalEntry(ModEntityTypes.LOBBER_ZOMBIE, 24, EntityType.ZOMBIE, ModItems.LOBBER_ZOMBIE_SPAWN_EGG)
    };
    public EntityType<?> type;
    public int size;
    public EntityType<?> family;
    public Item egg;

    public JournalEntry(EntityType<?> type, int size, EntityType<?> family, Item egg) {
        this.type = type;
        this.size = size;
        this.family = family;
        this.egg = egg;
    }
}
