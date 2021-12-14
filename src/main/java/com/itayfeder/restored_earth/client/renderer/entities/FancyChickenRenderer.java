package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.models.FancyChickenModel;
import com.itayfeder.restored_earth.entities.FancyChickenEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.ChickenModel;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class FancyChickenRenderer extends MobRenderer<FancyChickenEntity, FancyChickenModel<FancyChickenEntity>> {
    private static final ResourceLocation FANCY_CHICKEN_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/fancy_chicken/fancy_chicken.png");

    public FancyChickenRenderer(EntityRendererManager p_i47211_1_) {
        super(p_i47211_1_, new FancyChickenModel<>(), 0.3F);
    }

    public ResourceLocation getTextureLocation(FancyChickenEntity p_110775_1_) {
        return FANCY_CHICKEN_LOCATION;
    }

    protected float getBob(FancyChickenEntity p_77044_1_, float p_77044_2_) {
        float f = MathHelper.lerp(p_77044_2_, p_77044_1_.oFlap, p_77044_1_.flap);
        float f1 = MathHelper.lerp(p_77044_2_, p_77044_1_.oFlapSpeed, p_77044_1_.flapSpeed);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
}