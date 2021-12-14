package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.layers.TropicalSlimeGelLayer;
import com.itayfeder.restored_earth.client.renderer.entities.models.TropicalSlimeModel;
import com.itayfeder.restored_earth.entities.TropicalSlimeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SlimeGelLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class TropicalSlimeRenderer extends MobRenderer<TropicalSlimeEntity, TropicalSlimeModel<TropicalSlimeEntity>> {

    public TropicalSlimeRenderer(EntityRendererManager p_i47193_1_) {
        super(p_i47193_1_, new TropicalSlimeModel<>(false), 0.5F);
        this.addLayer(new TropicalSlimeGelLayer<>(this));
    }

    public void render(TropicalSlimeEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
        this.shadowRadius = 0.25F * (float)p_225623_1_.getSize();
        super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
    }

    protected void scale(TropicalSlimeEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
        float f = 0.999F;
        p_225620_2_.scale(0.999F, 0.999F, 0.999F);
        p_225620_2_.translate(0.0D, (double)0.001F, 0.0D);
    }

    public ResourceLocation getTextureLocation(TropicalSlimeEntity p_115974_) {
        String loc = "textures/entity/tropical_slime/tropical_slime_" + (p_115974_.getAnimTimer()+1) + ".png";
        return new ResourceLocation(RestoredEarthMod.MOD_ID, loc);

    }
}