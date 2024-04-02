package com.itayfeder.restored_earth.client.renderer.entities;

import fuzs.refoundearth.client.init.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.layers.VilerWitchItemLayer;
import com.itayfeder.restored_earth.client.renderer.entities.models.VilerWitchModel;
import fuzs.refoundearth.world.entity.monster.VilerWitch;
import com.mojang.blaze3d.vertex.PoseStack;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class VilerWitchRenderer extends MobRenderer<VilerWitch, VilerWitchModel<VilerWitch>> {
    private static final ResourceLocation VILER_WITCH_LOCATION = new ResourceLocation(RefoundEarth.MOD_ID,"textures/entity/viler_witch/viler_witch.png");

    public VilerWitchRenderer(EntityRendererProvider.Context p_174443_) {
        super(p_174443_, new VilerWitchModel<>(p_174443_.bakeLayer(ModModelLayers.VILER_WITCH)), 0.5F);
        this.addLayer(new VilerWitchItemLayer<>(this));
    }

    public void render(VilerWitch p_116412_, float p_116413_, float p_116414_, PoseStack p_116415_, MultiBufferSource p_116416_, int p_116417_) {
        this.model.setHoldingItem(!p_116412_.getMainHandItem().isEmpty());
        super.render(p_116412_, p_116413_, p_116414_, p_116415_, p_116416_, p_116417_);
    }

    public ResourceLocation getTextureLocation(VilerWitch p_116410_) {
        return VILER_WITCH_LOCATION;
    }

    protected void scale(VilerWitch p_116419_, PoseStack p_116420_, float p_116421_) {
        float f = 0.9375F;
        p_116420_.scale(0.9375F, 0.9375F, 0.9375F);
    }
}