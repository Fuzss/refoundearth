package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.layers.TropicalSlimeOuterLayer;
import com.itayfeder.restored_earth.client.renderer.entities.models.TropicalSlimeModel;
import com.itayfeder.restored_earth.entities.TropicalSlime;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SlimeOuterLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Slime;

public class TropicalSlimeRenderer extends MobRenderer<TropicalSlime, TropicalSlimeModel<TropicalSlime>> {

    public TropicalSlimeRenderer(EntityRendererProvider.Context p_174391_) {
        super(p_174391_, new TropicalSlimeModel<>(p_174391_.bakeLayer(ModModelLayers.TROPICAL_SLIME)), 0.25F);
        this.addLayer(new TropicalSlimeOuterLayer<>(this, p_174391_.getModelSet()));
    }

    public void render(TropicalSlime p_115976_, float p_115977_, float p_115978_, PoseStack p_115979_, MultiBufferSource p_115980_, int p_115981_) {
        this.shadowRadius = 0.25F * (float)p_115976_.getSize();
        super.render(p_115976_, p_115977_, p_115978_, p_115979_, p_115980_, p_115981_);
    }

    protected void scale(TropicalSlime p_115983_, PoseStack p_115984_, float p_115985_) {
        float f = 0.999F;
        p_115984_.scale(0.999F, 0.999F, 0.999F);
        p_115984_.translate(0.0D, (double)0.001F, 0.0D);
    }

    public ResourceLocation getTextureLocation(TropicalSlime p_115974_) {
        String loc = "textures/entity/tropical_slime/tropical_slime_" + (p_115974_.getAnimTimer()+1) + ".png";
        return new ResourceLocation(RestoredEarthMod.MOD_ID, loc);

    }
}