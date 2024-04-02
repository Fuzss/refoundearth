package com.itayfeder.restored_earth.client.renderer.entities;

import fuzs.refoundearth.client.init.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.layers.RainbowSheepFurLayer;
import com.itayfeder.restored_earth.client.renderer.entities.models.RainbowSheepModel;
import fuzs.refoundearth.world.entity.animal.RainbowSheep;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RainbowSheepRenderer extends MobRenderer<RainbowSheep, RainbowSheepModel<RainbowSheep>> {
    private static final ResourceLocation RAINBOW_SHEEP_LOCATION = new ResourceLocation(RefoundEarth.MOD_ID,"textures/entity/rainbow_sheep/rainbow_sheep.png");

    public RainbowSheepRenderer(EntityRendererProvider.Context p_174366_) {
        super(p_174366_, new RainbowSheepModel<>(p_174366_.bakeLayer(ModModelLayers.RAINBOW_SHEEP)), 0.7F);
        this.addLayer(new RainbowSheepFurLayer(this, p_174366_.getModelSet()));
    }

    public ResourceLocation getTextureLocation(RainbowSheep p_115840_) {
        return RAINBOW_SHEEP_LOCATION;
    }
}