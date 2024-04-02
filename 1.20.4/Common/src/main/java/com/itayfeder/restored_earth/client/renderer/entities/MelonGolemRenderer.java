package com.itayfeder.restored_earth.client.renderer.entities;

import fuzs.refoundearth.world.entity.animal.MelonGolem;
import fuzs.refoundearth.client.init.ModModelLayers;
import fuzs.refoundearth.client.renderer.entity.layers.BlockGolemHeadLayer;
import fuzs.refoundearth.init.ModBlocks;
import net.minecraft.client.model.SnowGolemModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MelonGolemRenderer extends MobRenderer<MelonGolem, SnowGolemModel<MelonGolem>> {
    private static final ResourceLocation SNOW_GOLEM_LOCATION = new ResourceLocation("textures/entity/snow_golem.png");

    public MelonGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new SnowGolemModel<>(context.bakeLayer(ModModelLayers.MELON_GOLEM)), 0.5F);
        this.addLayer(new BlockGolemHeadLayer<>(this, context.getBlockRenderDispatcher(), context.getItemRenderer(),
                ModBlocks.CARVED_MELON.value()
        ));
    }

    @Override
    public ResourceLocation getTextureLocation(MelonGolem melonGolem) {
        return SNOW_GOLEM_LOCATION;
    }
}