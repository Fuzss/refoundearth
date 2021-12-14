package com.itayfeder.restored_earth.utils;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.blockentities.RainbowBedRenderer;
import com.itayfeder.restored_earth.client.renderer.entities.*;
import com.itayfeder.restored_earth.init.BlockEntityInit;
import com.itayfeder.restored_earth.init.BlockInit;
import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.LlamaSpitRenderer;
import net.minecraft.client.renderer.tileentity.BedTileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.projectile.LlamaSpitEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

        ClientRegistry.bindTileEntityRenderer(BlockEntityInit.RAINBOW_BED, RainbowBedRenderer::new);

        RenderTypeLookup.setRenderLayer(BlockInit.BUTTERCUP, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.PINK_DAISY, RenderType.cutout());

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MUDDY_PIG, MuddyPigRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.WOOLY_COW, WoolyCowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.JUMBO_RABBIT, JumboRabbitRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FANCY_CHICKEN, FancyChickenRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.RAINBOW_SHEEP, RainbowSheepRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.JOLLY_LLAMA, JollyLlamaRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.VILER_WITCH, VilerWitchRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.TROPICAL_SLIME, TropicalSlimeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MELON_GOLEM, MelonGolemRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MOOBLOOM, MoobloomRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.BOULDERING_ZOMBIE, BoulderingZombieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FURNACE_GOLEM, FurnaceGolemRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.SKELETON_WOLF, SkeletonWolfRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.BONE_SPIDER, BoneSpiderRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MOOLIP, MoolipRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.CLUCKSHROOM, CluckshroomRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityInit.MELON_SEED, MelonSeedRenderer::new);

    }
}
