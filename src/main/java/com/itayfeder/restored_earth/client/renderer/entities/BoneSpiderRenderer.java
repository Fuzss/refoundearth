package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.entities.BoneSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SpiderEyesLayer;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.util.ResourceLocation;

public class BoneSpiderRenderer<T extends BoneSpiderEntity> extends MobRenderer<T, SpiderModel<T>> {
    private static final ResourceLocation SPIDER_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/bone_spider/bone_spider.png");

    public BoneSpiderRenderer(EntityRendererManager p_i46139_1_) {
        super(p_i46139_1_, new SpiderModel<>(), 0.8F);
    }

    protected float getFlipDegrees(T p_77037_1_) {
        return 180.0F;
    }

    public ResourceLocation getTextureLocation(T p_110775_1_) {
        return SPIDER_LOCATION;
    }
}