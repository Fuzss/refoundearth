package com.itayfeder.restored_earth.events;

import fuzs.refoundearth.init.ModBlocks;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RefoundEarth.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WorldLoadEventHandler {
    public static final ConfiguredFeature<?, ?> LAKE_MUD = FeatureUtils.register("lake_mud",
            Feature.LAKE.configured(new LakeFeature.Configuration(BlockStateProvider.simple(ModBlocks.MUD.defaultBlockState()), BlockStateProvider.simple(Blocks.DIRT.defaultBlockState()))));
    public static final PlacedFeature LAKE_MUD_SURFACE = PlacementUtils.register("lake_mud_surface",
            LAKE_MUD.placed(RarityFilter.onAverageOnceEvery(100), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void biomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder gen = event.getGeneration();
        ResourceKey<Biome> biome = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD)) {
            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SWAMP)) {
                gen.addFeature(GenerationStep.Decoration.LAKES, LAKE_MUD_SURFACE);
            }
        }
    }
}
