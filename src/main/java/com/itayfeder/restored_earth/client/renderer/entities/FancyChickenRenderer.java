package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.models.FancyChickenModel;
import com.itayfeder.restored_earth.entities.FancyChicken;
import net.minecraft.client.model.ChickenModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Chicken;

public class FancyChickenRenderer extends MobRenderer<FancyChicken, FancyChickenModel<FancyChicken>> {
    private static final ResourceLocation FANCY_CHICKEN_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/fancy_chicken/fancy_chicken.png");

    public FancyChickenRenderer(EntityRendererProvider.Context p_173952_) {
        super(p_173952_, new FancyChickenModel<>(p_173952_.bakeLayer(ModModelLayers.FANCY_CHICKEN)), 0.3F);
    }

    public ResourceLocation getTextureLocation(FancyChicken p_113998_) {
        return FANCY_CHICKEN_LOCATION;
    }

    protected float getBob(FancyChicken p_114000_, float p_114001_) {
        float f = Mth.lerp(p_114001_, p_114000_.oFlap, p_114000_.flap);
        float f1 = Mth.lerp(p_114001_, p_114000_.oFlapSpeed, p_114000_.flapSpeed);
        return (Mth.sin(f) + 1.0F) * f1;
    }
}