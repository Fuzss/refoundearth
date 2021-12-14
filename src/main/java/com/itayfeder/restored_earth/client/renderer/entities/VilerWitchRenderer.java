package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.layers.VilerWitchHeldItemLayer;
import com.itayfeder.restored_earth.client.renderer.entities.models.VilerWitchModel;
import com.itayfeder.restored_earth.entities.VilerWitchEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class VilerWitchRenderer extends MobRenderer<VilerWitchEntity, VilerWitchModel<VilerWitchEntity>> {
    private static final ResourceLocation VILER_WITCH_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/viler_witch/viler_witch.png");

    public VilerWitchRenderer(EntityRendererManager p_i46131_1_) {
        super(p_i46131_1_, new VilerWitchModel<>(0.0F), 0.5F);
        this.addLayer(new VilerWitchHeldItemLayer<>(this));
    }

    public void render(VilerWitchEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
        this.model.setHoldingItem(!p_225623_1_.getMainHandItem().isEmpty());
        super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
    }

    public ResourceLocation getTextureLocation(VilerWitchEntity p_110775_1_) {
        return VILER_WITCH_LOCATION;
    }

    protected void scale(VilerWitchEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
        float f = 0.9375F;
        p_225620_2_.scale(0.9375F, 0.9375F, 0.9375F);
    }
}