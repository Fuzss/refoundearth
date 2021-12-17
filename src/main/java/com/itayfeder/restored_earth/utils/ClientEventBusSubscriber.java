package com.itayfeder.restored_earth.utils;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.blockentities.RainbowBedRenderer;
import com.itayfeder.restored_earth.client.renderer.entities.*;
import com.itayfeder.restored_earth.client.renderer.entities.models.*;
import com.itayfeder.restored_earth.client.renderer.entities.models.layers.RainbowSheepFurModel;
import com.itayfeder.restored_earth.init.BlockEntityInit;
import com.itayfeder.restored_earth.init.BlockInit;
import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.SnowGolemModel;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        BlockEntityRenderers.register(BlockEntityInit.RAINBOW_BED, RainbowBedRenderer::new);

        ItemBlockRenderTypes.setRenderLayer(BlockInit.BUTTERCUP, RenderType.cutout());

        EntityRenderers.register(EntityInit.MUDDY_PIG, MuddyPigRenderer::new);
        EntityRenderers.register(EntityInit.WOOLY_COW, WoolyCowRenderer::new);
        EntityRenderers.register(EntityInit.JUMBO_RABBIT, JumboRabbitRenderer::new);
        EntityRenderers.register(EntityInit.FANCY_CHICKEN, FancyChickenRenderer::new);
        EntityRenderers.register(EntityInit.RAINBOW_SHEEP, RainbowSheepRenderer::new);
        EntityRenderers.register(EntityInit.JOLLY_LLAMA, JollyLlamaRenderer::new);
        EntityRenderers.register(EntityInit.VILER_WITCH, VilerWitchRenderer::new);
        EntityRenderers.register(EntityInit.TROPICAL_SLIME, TropicalSlimeRenderer::new);
        EntityRenderers.register(EntityInit.MELON_GOLEM, MelonGolemRenderer::new);
        EntityRenderers.register(EntityInit.MOOBLOOM, MoobloomRenderer::new);
        EntityRenderers.register(EntityInit.BOULDERING_ZOMBIE, BoulderingZombieRenderer::new);
        EntityRenderers.register(EntityInit.FURNACE_GOLEM, FurnaceGolemRenderer::new);
        EntityRenderers.register(EntityInit.SKELETON_WOLF, SkeletonWolfRenderer::new);
        EntityRenderers.register(EntityInit.BONE_SPIDER, BoneSpiderRenderer::new);
        EntityRenderers.register(EntityInit.MOOLIP, MoolipRenderer::new);
        EntityRenderers.register(EntityInit.CLUCKSHROOM, CluckshroomRenderer::new);
        EntityRenderers.register(EntityInit.LOBBER_ZOMBIE, LobberZombieRenderer::new);

        EntityRenderers.register(EntityInit.MELON_SEED, MelonSeedRenderer::new);
        EntityRenderers.register(EntityInit.ROTTEN_FLESH, ThrownItemRenderer::new);

    }

    @SubscribeEvent
    public static void onLayerRenderer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.MUDDY_PIG, () -> MuddyPigModel.createBodyLayer(CubeDeformation.NONE));
        event.registerLayerDefinition(ModModelLayers.WOOLY_COW, () -> WoolyCowModel.createBodyLayer());
        event.registerLayerDefinition(ModModelLayers.JUMBO_RABBIT, () -> JumboRabbitModel.createBodyLayer());
        event.registerLayerDefinition(ModModelLayers.FANCY_CHICKEN, () -> FancyChickenModel.createBodyLayer());
        event.registerLayerDefinition(ModModelLayers.RAINBOW_SHEEP, () -> RainbowSheepModel.createBodyLayer());
        event.registerLayerDefinition(ModModelLayers.RAINBOW_SHEEP_FUR, () -> RainbowSheepFurModel.createFurLayer());
        event.registerLayerDefinition(ModModelLayers.JOLLY_LLAMA, () -> JollyLlamaModel.createBodyLayer(CubeDeformation.NONE));
        event.registerLayerDefinition(ModModelLayers.VILER_WITCH, () -> VilerWitchModel.createBodyLayer());
        event.registerLayerDefinition(ModModelLayers.TROPICAL_SLIME, () -> TropicalSlimeModel.createInnerBodyLayer());
        event.registerLayerDefinition(ModModelLayers.TROPICAL_SLIME_OUTER, () -> TropicalSlimeModel.createOuterBodyLayer());
        event.registerLayerDefinition(ModModelLayers.MELON_GOLEM, () -> SnowGolemModel.createBodyLayer());
        event.registerLayerDefinition(ModModelLayers.MOOBLOOM, () -> CowModel.createBodyLayer());
        event.registerLayerDefinition(ModModelLayers.BOULDERING_ZOMBIE, () -> BoulderingZombieModel.createBodyLayer(CubeDeformation.NONE));
        event.registerLayerDefinition(ModModelLayers.FURNACE_GOLEM, () -> FurnaceGolemModel.createBodyLayer());
        event.registerLayerDefinition(ModModelLayers.SKELETON_WOLF, () -> SkeletonWolfModel.createBodyLayer());
        event.registerLayerDefinition(ModModelLayers.BONE_SPIDER, () -> SpiderModel.createSpiderBodyLayer());
        event.registerLayerDefinition(ModModelLayers.MOOLIP, () -> CowModel.createBodyLayer());
        event.registerLayerDefinition(ModModelLayers.CLUCKSHROOM, () -> CluckshroomModel.createBodyLayer());
        event.registerLayerDefinition(ModModelLayers.LOBBER_ZOMBIE, () -> LobberZombieModel.createBodyLayer(CubeDeformation.NONE));

        event.registerLayerDefinition(ModModelLayers.MELON_SEED, () -> MelonSeedModel.createBodyLayer());

    }
}
