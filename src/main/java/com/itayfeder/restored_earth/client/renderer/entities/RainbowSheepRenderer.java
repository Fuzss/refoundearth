package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.layers.RainbowSheepFurLayer;
import com.itayfeder.restored_earth.client.renderer.entities.models.RainbowSheepModel;
import com.itayfeder.restored_earth.entities.RainbowSheep;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SheepFurLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Sheep;

public class RainbowSheepRenderer extends MobRenderer<RainbowSheep, RainbowSheepModel<RainbowSheep>> {
    private static final ResourceLocation RAINBOW_SHEEP_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/rainbow_sheep/rainbow_sheep.png");

    public RainbowSheepRenderer(EntityRendererProvider.Context p_174366_) {
        super(p_174366_, new RainbowSheepModel<>(p_174366_.bakeLayer(ModModelLayers.RAINBOW_SHEEP)), 0.7F);
        this.addLayer(new RainbowSheepFurLayer(this, p_174366_.getModelSet()));
    }

    public ResourceLocation getTextureLocation(RainbowSheep p_115840_) {
        return RAINBOW_SHEEP_LOCATION;
    }
}