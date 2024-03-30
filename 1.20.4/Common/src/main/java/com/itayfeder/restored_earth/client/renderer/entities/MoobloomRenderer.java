package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.client.renderer.entities.layers.MoobloomFlowerLayer;
import com.itayfeder.restored_earth.entities.Moobloom;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MoobloomRenderer extends MobRenderer<Moobloom, CowModel<Moobloom>> {
    private static final ResourceLocation MOOBLOOM_LOCATION = new ResourceLocation(RefoundEarth.MOD_ID,"textures/entity/moobloom/moobloom.png");

    public MoobloomRenderer(EntityRendererProvider.Context p_174324_) {
        super(p_174324_, new CowModel<>(p_174324_.bakeLayer(ModelLayers.MOOSHROOM)), 0.7F);
        this.addLayer(new MoobloomFlowerLayer<>(this));
    }

    public ResourceLocation getTextureLocation(Moobloom p_115514_) {
        return MOOBLOOM_LOCATION;
    }
}