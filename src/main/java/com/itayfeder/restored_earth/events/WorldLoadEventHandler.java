package com.itayfeder.restored_earth.events;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.init.BlockInit;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WorldLoadEventHandler {
    public static final ConfiguredFeature<?, ?> LAKE_MUD = register("lake_mud",
            Feature.LAKE.configured(new BlockStateFeatureConfig(BlockInit.MUD.defaultBlockState())).decorated(Placement.WATER_LAKE.configured(new ChanceConfig(4))));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void biomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder gen = event.getGeneration();
        RegistryKey<Biome> biome = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD)) {
            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SWAMP)) {
                gen.addFeature(GenerationStage.Decoration.LAKES, LAKE_MUD);
            }
        }
    }
}
