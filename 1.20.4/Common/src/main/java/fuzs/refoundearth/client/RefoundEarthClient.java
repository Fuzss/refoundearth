package fuzs.refoundearth.client;

import com.itayfeder.restored_earth.client.renderer.entities.*;
import com.itayfeder.restored_earth.client.renderer.entities.models.*;
import com.itayfeder.restored_earth.client.renderer.entities.models.layers.RainbowSheepFurModel;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.api.client.core.v1.context.EntityRenderersContext;
import fuzs.puzzleslib.api.client.core.v1.context.LayerDefinitionsContext;
import fuzs.puzzleslib.api.client.core.v1.context.RenderTypesContext;
import fuzs.refoundearth.client.init.ModModelLayers;
import fuzs.refoundearth.init.ModBlocks;
import fuzs.refoundearth.init.ModEntityTypes;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.SnowGolemModel;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.level.block.Block;

public class RefoundEarthClient implements ClientModConstructor {

    @Override
    public void onRegisterEntityRenderers(EntityRenderersContext context) {
        context.registerEntityRenderer(ModEntityTypes.MUDDY_PIG.value(), MuddyPigRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.WOOLY_COW.value(), WoolyCowRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.JUMBO_RABBIT.value(), JumboRabbitRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.FANCY_CHICKEN.value(), FancyChickenRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.RAINBOW_SHEEP.value(), RainbowSheepRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.JOLLY_LLAMA.value(), JollyLlamaRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.VILER_WITCH.value(), VilerWitchRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.TROPICAL_SLIME.value(), TropicalSlimeRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.MELON_GOLEM.value(), MelonGolemRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.MOOBLOOM.value(), MoobloomRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.BOULDERING_ZOMBIE.value(), BoulderingZombieRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.FURNACE_GOLEM.value(), FurnaceGolemRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.SKELETON_WOLF.value(), SkeletonWolfRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.BONE_SPIDER.value(), BoneSpiderRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.MOOLIP.value(), MoolipRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.CLUCKSHROOM.value(), CluckshroomRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.LOBBER_ZOMBIE.value(), LobberZombieRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.MELON_SEED.value(), MelonSeedRenderer::new);
        context.registerEntityRenderer(ModEntityTypes.ROTTEN_FLESH.value(), ThrownItemRenderer::new);
    }

    @Override
    public void onRegisterBlockRenderTypes(RenderTypesContext<Block> context) {
        context.registerRenderType(RenderType.cutout(), ModBlocks.BUTTERCUP.value(), ModBlocks.PINK_DAISY.value());
    }

    @Override
    public void onRegisterLayerDefinitions(LayerDefinitionsContext context) {
        context.registerLayerDefinition(ModModelLayers.MUDDY_PIG, () -> MuddyPigModel.createBodyLayer(CubeDeformation.NONE));
        context.registerLayerDefinition(ModModelLayers.WOOLY_COW, WoolyCowModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.JUMBO_RABBIT, JumboRabbitModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.FANCY_CHICKEN, FancyChickenModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.RAINBOW_SHEEP, RainbowSheepModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.RAINBOW_SHEEP_FUR, RainbowSheepFurModel::createFurLayer);
        context.registerLayerDefinition(ModModelLayers.JOLLY_LLAMA, () -> JollyLlamaModel.createBodyLayer(CubeDeformation.NONE));
        context.registerLayerDefinition(ModModelLayers.VILER_WITCH, VilerWitchModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.TROPICAL_SLIME, TropicalSlimeModel::createInnerBodyLayer);
        context.registerLayerDefinition(ModModelLayers.TROPICAL_SLIME_OUTER, TropicalSlimeModel::createOuterBodyLayer);
        context.registerLayerDefinition(ModModelLayers.MELON_GOLEM, SnowGolemModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.MOOBLOOM, CowModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.BOULDERING_ZOMBIE, () -> BoulderingZombieModel.createBodyLayer(CubeDeformation.NONE));
        context.registerLayerDefinition(ModModelLayers.FURNACE_GOLEM, FurnaceGolemModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.SKELETON_WOLF, SkeletonWolfModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.BONE_SPIDER, SpiderModel::createSpiderBodyLayer);
        context.registerLayerDefinition(ModModelLayers.MOOLIP, CowModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.CLUCKSHROOM, CluckshroomModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.LOBBER_ZOMBIE, () -> LobberZombieModel.createBodyLayer(CubeDeformation.NONE));
        context.registerLayerDefinition(ModModelLayers.MELON_SEED, MelonSeedModel::createBodyLayer);
    }
}
