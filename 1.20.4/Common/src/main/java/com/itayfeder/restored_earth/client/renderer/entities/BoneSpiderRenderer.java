package com.itayfeder.restored_earth.client.renderer.entities;

import fuzs.refoundearth.client.init.ModModelLayers;
import fuzs.refoundearth.world.entity.monster.BoneSpider;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BoneSpiderRenderer<T extends BoneSpider> extends MobRenderer<T, SpiderModel<T>> {
    private static final ResourceLocation SPIDER_LOCATION = new ResourceLocation(RefoundEarth.MOD_ID,"textures/entity/bone_spider/bone_spider.png");

    public BoneSpiderRenderer(EntityRendererProvider.Context p_174401_) {
        this(p_174401_, ModModelLayers.BONE_SPIDER);
    }

    public BoneSpiderRenderer(EntityRendererProvider.Context p_174403_, ModelLayerLocation p_174404_) {
        super(p_174403_, new SpiderModel<>(p_174403_.bakeLayer(p_174404_)), 0.8F);
    }

    protected float getFlipDegrees(T p_116011_) {
        return 180.0F;
    }

    public ResourceLocation getTextureLocation(T p_116009_) {
        return SPIDER_LOCATION;
    }
}