package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.client.renderer.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.models.SkeletonWolfModel;
import fuzs.refoundearth.world.entity.monster.SkeletonWolf;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SkeletonWolfRenderer extends MobRenderer<SkeletonWolf, SkeletonWolfModel<SkeletonWolf>> {
    private static final ResourceLocation WOLF_LOCATION = new ResourceLocation(RefoundEarth.MOD_ID,"textures/entity/skeleton_wolf/skeleton_wolf.png");
    private static final ResourceLocation WOLF_ANGRY_LOCATION = new ResourceLocation(RefoundEarth.MOD_ID,"textures/entity/skeleton_wolf/skeleton_wolf_angry.png");

    public SkeletonWolfRenderer(EntityRendererProvider.Context p_i47187_1_) {
        super(p_i47187_1_, new SkeletonWolfModel<>(p_i47187_1_.bakeLayer(ModModelLayers.SKELETON_WOLF)), 0.5F);
    }

    protected float getBob(SkeletonWolf p_77044_1_, float p_77044_2_) {
        return p_77044_1_.getTailAngle();
    }

    public ResourceLocation getTextureLocation(SkeletonWolf p_110775_1_) {
        return WOLF_LOCATION;
    }
}