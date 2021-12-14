package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.layers.RainbowSheepFurLayer;
import com.itayfeder.restored_earth.client.renderer.entities.models.RainbowSheepModel;
import com.itayfeder.restored_earth.entities.RainbowSheepEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SheepWoolLayer;
import net.minecraft.client.renderer.entity.model.SheepModel;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.ResourceLocation;

public class RainbowSheepRenderer extends MobRenderer<RainbowSheepEntity, RainbowSheepModel<RainbowSheepEntity>> {
    private static final ResourceLocation RAINBOW_SHEEP_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/rainbow_sheep/rainbow_sheep.png");

    public RainbowSheepRenderer(EntityRendererManager p_i47195_1_) {
        super(p_i47195_1_, new RainbowSheepModel<>(), 0.7F);
        this.addLayer(new RainbowSheepFurLayer(this));
    }

    public ResourceLocation getTextureLocation(RainbowSheepEntity p_110775_1_) {
        return RAINBOW_SHEEP_LOCATION;
    }
}