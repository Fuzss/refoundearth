package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.layers.MoolipFlowerLayer;
import com.itayfeder.restored_earth.entities.Moolip;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MoolipRenderer extends MobRenderer<Moolip, CowModel<Moolip>> {
    private static final ResourceLocation MOOLIP_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/moolip/moolip.png");

    public MoolipRenderer(EntityRendererProvider.Context p_174324_) {
        super(p_174324_, new CowModel<>(p_174324_.bakeLayer(ModelLayers.MOOSHROOM)), 0.7F);
        this.addLayer(new MoolipFlowerLayer<>(this));
    }

    public ResourceLocation getTextureLocation(Moolip p_115514_) {
        return MOOLIP_LOCATION;
    }
}