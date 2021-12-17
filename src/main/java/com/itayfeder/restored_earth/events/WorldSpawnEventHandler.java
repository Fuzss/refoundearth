package com.itayfeder.restored_earth.events;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.init.EntityInit;
import com.itayfeder.restored_earth.utils.Config;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
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

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WorldSpawnEventHandler {


    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void biomeLoad(BiomeLoadingEvent event) {
        ResourceKey<Biome> biome = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD)) {
            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN) ||
                    event.getName().toString().contains("minecraft:grove") || event.getName().toString().contains("minecraft:snowy_slopes")) {
                if (Config.WOOLY_COW_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityInit.WOOLY_COW, 8, 4, 4));
                if (Config.WOOLY_COW_SPAWNING.get()) ReplaceCurrentMobSpawnWithNew(event.getSpawns(), MobCategory.CREATURE, EntityType.COW, EntityInit.WOOLY_COW);
            }

            if (event.getName().toString().contains("minecraft:old_growth_pine_taiga") || event.getName().toString().contains("minecraft:old_growth_spruce_taiga")) {
                if (Config.JUMBO_RABBIT_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityInit.JUMBO_RABBIT, 4, 2, 3));
            }

            if (event.getName().toString().contains("minecraft:flower_forest")) {
                if (Config.FANCY_CHICKEN_SPAWNING.get()) ReplaceCurrentMobSpawnWithNew(event.getSpawns(), MobCategory.CREATURE, EntityType.CHICKEN, EntityInit.FANCY_CHICKEN);
                if (!ModList.get().isLoaded("buzzier_bees") && Config.MOOBLOOM_SPAWNING.get()) ReplaceCurrentMobSpawnWithNew(event.getSpawns(), MobCategory.CREATURE, EntityType.COW, EntityInit.MOOBLOOM);
                if (Config.MOOLIP_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityInit.MOOLIP, 8, 4, 4));
            }

            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS) || event.getName().toString().contains("minecraft:meadow")) {
                if (Config.RAINBOW_SHEEP_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityInit.RAINBOW_SHEEP, 1, 1, 1));
            }

            if (event.getName().toString().contains("minecraft:snowy_peaks") || event.getName().toString().contains("minecraft:jagged_peaks") ||
            event.getName().toString().contains("minecraft:grove") || event.getName().toString().contains("minecraft:snowy_slopes")) {
                if (Config.JOLLY_LLAMA_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityInit.JOLLY_LLAMA, 4, 2, 3));
            }

            if (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM) &&
                    !BiomeDictionary.hasType(biome, BiomeDictionary.Type.WATER) &&
                    !BiomeDictionary.hasType(biome, BiomeDictionary.Type.BEACH)) {
                if (Config.VILER_WITCH_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityInit.VILER_WITCH, 3, 1, 1));
                if (Config.BOULDERING_ZOMBIE_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityInit.BOULDERING_ZOMBIE, 6, 1, 1));
                if (Config.LOBBER_ZOMBIE_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityInit.LOBBER_ZOMBIE, 6, 1, 1));
            }

            if (event.getName().toString().contains("minecraft:beach") || event.getName().toString().contains("minecraft:stone_shore")) {
                if (Config.TROPICAL_SLIME_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityInit.TROPICAL_SLIME, 25, 1, 1));
            }

            if (event.getName().toString().contains("taiga")) {
                if (Config.SKELETON_WOLF_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityInit.SKELETON_WOLF, 25, 3, 4));
            }

            if (event.getName().toString().contains("dark_forest")) {
                if (Config.BONE_SPIDER_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityInit.BONE_SPIDER, 20, 1, 2));
            }

            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM)) {
                if (Config.CLUCKSHROOM_SPAWNING.get()) event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityInit.CLUCKSHROOM, 8, 4, 4));
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
