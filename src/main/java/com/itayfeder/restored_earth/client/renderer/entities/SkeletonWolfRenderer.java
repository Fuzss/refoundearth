package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.models.SkeletonWolfModel;
import com.itayfeder.restored_earth.entities.SkeletonWolfEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.WolfCollarLayer;
import net.minecraft.client.renderer.entity.model.WolfModel;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.ResourceLocation;

public class SkeletonWolfRenderer extends MobRenderer<SkeletonWolfEntity, SkeletonWolfModel<SkeletonWolfEntity>> {
    private static final ResourceLocation WOLF_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/skeleton_wolf/skeleton_wolf.png");
    private static final ResourceLocation WOLF_ANGRY_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/skeleton_wolf/skeleton_wolf_angry.png");

    public SkeletonWolfRenderer(EntityRendererManager p_i47187_1_) {
        super(p_i47187_1_, new SkeletonWolfModel<>(), 0.5F);
    }

    protected float getBob(SkeletonWolfEntity p_77044_1_, float p_77044_2_) {
        return p_77044_1_.getTailAngle();
    }

    public ResourceLocation getTextureLocation(SkeletonWolfEntity p_110775_1_) {
        return WOLF_LOCATION;
    }
}