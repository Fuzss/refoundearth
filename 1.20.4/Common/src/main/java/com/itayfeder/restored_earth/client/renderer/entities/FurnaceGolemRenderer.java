package com.itayfeder.restored_earth.client.renderer.entities;

import fuzs.refoundearth.client.init.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.layers.FurnaceGolemTorchLayer;
import com.itayfeder.restored_earth.client.renderer.entities.models.FurnaceGolemModel;
import fuzs.refoundearth.world.entity.animal.FurnaceGolem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FurnaceGolemRenderer extends MobRenderer<FurnaceGolem, FurnaceGolemModel<FurnaceGolem>> {
    private static final ResourceLocation FURNACE_GOLEM_LOCATION = new ResourceLocation(RefoundEarth.MOD_ID,"textures/entity/furnace_golem/furnace_golem.png");

    public FurnaceGolemRenderer(EntityRendererProvider.Context p_174188_) {
        super(p_174188_, new FurnaceGolemModel<>(p_174188_.bakeLayer(ModModelLayers.FURNACE_GOLEM)), 0.7F);
        this.addLayer(new FurnaceGolemTorchLayer(this));
    }

    public ResourceLocation getTextureLocation(FurnaceGolem p_115012_) {
        return FURNACE_GOLEM_LOCATION;
    }

    protected void setupRotations(FurnaceGolem p_115014_, PoseStack p_115015_, float p_115016_, float p_115017_, float p_115018_) {
        super.setupRotations(p_115014_, p_115015_, p_115016_, p_115017_, p_115018_);
        if (!((double)p_115014_.animationSpeed < 0.01D)) {
            float f = 13.0F;
            float f1 = p_115014_.animationPosition - p_115014_.animationSpeed * (1.0F - p_115018_) + 6.0F;
            float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
            p_115015_.mulPose(Vector3f.ZP.rotationDegrees(6.5F * f2));
        }
    }
}