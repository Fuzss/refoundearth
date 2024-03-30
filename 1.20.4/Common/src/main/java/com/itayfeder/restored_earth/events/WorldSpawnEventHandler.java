package com.itayfeder.restored_earth.events;

import fuzs.refoundearth.init.ModEntityTypes;
import fuzs.refoundearth.config.CommonConfig;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ISystemReportExtender;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = RefoundEarth.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WorldSpawnEventHandler {


    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void biomeLoad(BiomeLoadingEvent event) {
        ResourceKey<Biome> biome = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD)) {
            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN) ||
                    event.getName().toString().contains("minecraft:grove") || event.getName().toString().contains("minecraft:snowy_slopes")) {
                if (CommonConfig.WOOLY_COW_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(
                        ModEntityTypes.WOOLY_COW, 8, 4, 4));
                if (CommonConfig.WOOLY_COW_SPAWNING.get()) ReplaceCurrentMobSpawnWithNew(event.getSpawns(), MobCategory.CREATURE, EntityType.COW, ModEntityTypes.WOOLY_COW);
            }

            if (event.getName().toString().contains("minecraft:old_growth_pine_taiga") || event.getName().toString().contains("minecraft:old_growth_spruce_taiga")) {
                if (CommonConfig.JUMBO_RABBIT_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(
                        ModEntityTypes.JUMBO_RABBIT, 4, 2, 3));
            }

            if (event.getName().toString().contains("minecraft:flower_forest")) {
                if (CommonConfig.FANCY_CHICKEN_SPAWNING.get()) ReplaceCurrentMobSpawnWithNew(event.getSpawns(), MobCategory.CREATURE, EntityType.CHICKEN, ModEntityTypes.FANCY_CHICKEN);
                if (!ModList.get().isLoaded("buzzier_bees") && CommonConfig.MOOBLOOM_SPAWNING.get()) ReplaceCurrentMobSpawnWithNew(event.getSpawns(), MobCategory.CREATURE, EntityType.COW, ModEntityTypes.MOOBLOOM);
                if (CommonConfig.MOOLIP_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(
                        ModEntityTypes.MOOLIP, 8, 4, 4));
            }

            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS) || event.getName().toString().contains("minecraft:meadow")) {
                if (CommonConfig.RAINBOW_SHEEP_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(
                        ModEntityTypes.RAINBOW_SHEEP, 1, 1, 1));
            }

            if (event.getName().toString().contains("minecraft:snowy_peaks") || event.getName().toString().contains("minecraft:jagged_peaks") ||
            event.getName().toString().contains("minecraft:grove") || event.getName().toString().contains("minecraft:snowy_slopes")) {
                if (CommonConfig.JOLLY_LLAMA_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(
                        ModEntityTypes.JOLLY_LLAMA, 4, 2, 3));
            }

            if (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM) &&
                    !BiomeDictionary.hasType(biome, BiomeDictionary.Type.WATER) &&
                    !BiomeDictionary.hasType(biome, BiomeDictionary.Type.BEACH)) {
                if (CommonConfig.VILER_WITCH_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
                        ModEntityTypes.VILER_WITCH, 3, 1, 1));
                if (CommonConfig.BOULDERING_ZOMBIE_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
                        ModEntityTypes.BOULDERING_ZOMBIE, 6, 1, 1));
                if (CommonConfig.LOBBER_ZOMBIE_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
                        ModEntityTypes.LOBBER_ZOMBIE, 6, 1, 1));
            }

            if (event.getName().toString().contains("minecraft:beach") || event.getName().toString().contains("minecraft:stone_shore")) {
                if (CommonConfig.TROPICAL_SLIME_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
                        ModEntityTypes.TROPICAL_SLIME, 25, 1, 1));
            }

            if (event.getName().toString().contains("taiga")) {
                if (CommonConfig.SKELETON_WOLF_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
                        ModEntityTypes.SKELETON_WOLF, 25, 3, 4));
            }

            if (event.getName().toString().contains("dark_forest")) {
                if (CommonConfig.BONE_SPIDER_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(
                        ModEntityTypes.BONE_SPIDER, 20, 1, 2));
            }

            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM)) {
                if (CommonConfig.CLUCKSHROOM_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(
                        ModEntityTypes.CLUCKSHROOM, 8, 4, 4));
            }
        }
    }

    public static void ReplaceCurrentMobSpawnWithNew(MobSpawnSettingsBuilder builder, MobCategory spawnType, EntityType<?> replacedEntity, EntityType<?> replacingEntity) {
        List<MobSpawnSettings.SpawnerData> spawnList = builder.getSpawner(spawnType);
        for (int i = 0; i < spawnList.size(); i++) {
            MobSpawnSettings.SpawnerData entry = spawnList.get(i);
            int weight = entry.getWeight().asInt();
            int minCount = entry.minCount;
            int maxCount = entry.maxCount;
            EntityType<?> type = entry.type;
            if (type == replacedEntity) {
                MobSpawnSettings.SpawnerData replaceType = new MobSpawnSettings.SpawnerData(replacingEntity, weight, minCount, maxCount);
                spawnList.set(i, replaceType);
            }
        }
    }
}
