package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.ModModelLayers;
import com.itayfeder.restored_earth.entities.BoneSpider;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SpiderEyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Spider;

public class BoneSpiderRenderer<T extends BoneSpider> extends MobRenderer<T, SpiderModel<T>> {
    private static final ResourceLocation SPIDER_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/bone_spider/bone_spider.png");

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