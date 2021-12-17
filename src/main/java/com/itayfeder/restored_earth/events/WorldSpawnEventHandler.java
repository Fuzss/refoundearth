package com.itayfeder.restored_earth.events;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.init.EntityInit;
import com.itayfeder.restored_earth.utils.Config;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoader;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WorldSpawnEventHandler {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void biomeLoad(BiomeLoadingEvent event) {
        RegistryKey<Biome> biome = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD)) {
            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN)) {
                if (Config.WOOLY_COW_SPAWNING.get()) ReplaceCurrentMobSpawnWithNew(event.getSpawns(), EntityClassification.CREATURE, EntityType.COW, EntityInit.WOOLY_COW);
            }

            if (event.getName().toString().contains("minecraft:giant_spruce_taiga") || event.getName().toString().contains("minecraft:giant_tree_taiga")) {
                if (Config.JUMBO_RABBIT_SPAWNING.get()) event.getSpawns().addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.JUMBO_RABBIT, 4, 2, 3));
            }

            if (event.getName().toString().contains("minecraft:flower_forest")) {
                if (Config.FANCY_CHICKEN_SPAWNING.get()) ReplaceCurrentMobSpawnWithNew(event.getSpawns(), EntityClassification.CREATURE, EntityType.CHICKEN, EntityInit.FANCY_CHICKEN);
                if (!ModList.get().isLoaded("buzzier_bees") && Config.MOOBLOOM_SPAWNING.get()) ReplaceCurrentMobSpawnWithNew(event.getSpawns(), EntityClassification.CREATURE, EntityType.COW, EntityInit.MOOBLOOM);
                if (Config.MOOLIP_SPAWNING.get()) event.getSpawns().addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.MOOLIP, 8, 4, 4));
            }

            if (event.getName().toString().contains("minecraft:plains")) {
                if (Config.RAINBOW_SHEEP_SPAWNING.get()) event.getSpawns().addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.RAINBOW_SHEEP, 1, 1, 1));
            }

            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN) && BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN)) {
                if (Config.JOLLY_LLAMA_SPAWNING.get()) event.getSpawns().addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.JOLLY_LLAMA, 4, 2, 3));
            }

            if (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM) &&
                    !BiomeDictionary.hasType(biome, BiomeDictionary.Type.WATER) &&
                    !BiomeDictionary.hasType(biome, BiomeDictionary.Type.BEACH)) {
                if (Config.VILER_WITCH_SPAWNING.get()) event.getSpawns().addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.VILER_WITCH, 2, 1, 1));
                if (Config.BOULDERING_ZOMBIE_SPAWNING.get()) event.getSpawns().addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.BOULDERING_ZOMBIE, 6, 1, 1));
                if (Config.LOBBER_ZOMBIE_SPAWNING.get()) event.getSpawns().addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.LOBBER_ZOMBIE, 6, 1, 1));
            }


            if (event.getName().toString().contains("minecraft:beach") || event.getName().toString().contains("minecraft:stone_shore")) {
                if (Config.TROPICAL_SLIME_SPAWNING.get()) event.getSpawns().addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.TROPICAL_SLIME, 12, 1, 1));
            }

            if (event.getName().toString().contains("taiga")) {
                if (Config.SKELETON_WOLF_SPAWNING.get()) event.getSpawns().addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.SKELETON_WOLF, 25, 3, 4));
            }

            if (event.getName().toString().contains("dark_forest")) {
                if (Config.BONE_SPIDER_SPAWNING.get()) event.getSpawns().addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityInit.BONE_SPIDER, 20, 1, 2));
            }

            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM)) {
                if (Config.CLUCKSHROOM_SPAWNING.get()) event.getSpawns().addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityInit.CLUCKSHROOM, 8, 4, 4));
            }
        }
    }

    public static void ReplaceCurrentMobSpawnWithNew(MobSpawnInfoBuilder builder, EntityClassification spawnType, EntityType<?> replacedEntity, EntityType<?> replacingEntity) {
        List<MobSpawnInfo.Spawners> spawnList = builder.getSpawner(spawnType);
        for (int i = 0; i < spawnList.size(); i++) {
            MobSpawnInfo.Spawners entry = spawnList.get(i);
            int weight = entry.weight;
            int minCount = entry.minCount;
            int maxCount = entry.maxCount;
            EntityType<?> type = entry.type;
            if (type == replacedEntity) {
                MobSpawnInfo.Spawners replaceType = new MobSpawnInfo.Spawners(replacingEntity, weight, minCount, maxCount);
                spawnList.set(i, replaceType);
            }
        }
    }
}
