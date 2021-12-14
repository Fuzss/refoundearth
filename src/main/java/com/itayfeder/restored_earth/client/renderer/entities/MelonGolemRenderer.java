package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.client.renderer.entities.layers.MelonGolemHeadLayer;
import com.itayfeder.restored_earth.entities.MelonGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SnowmanHeadLayer;
import net.minecraft.client.renderer.entity.model.SnowManModel;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.util.ResourceLocation;

public class MelonGolemRenderer extends MobRenderer<MelonGolemEntity, SnowManModel<MelonGolemEntity>> {
    private static final ResourceLocation SNOW_GOLEM_LOCATION = new ResourceLocation("textures/entity/snow_golem.png");

    public MelonGolemRenderer(EntityRendererManager p_i46140_1_) {
        super(p_i46140_1_, new SnowManModel<>(), 0.5F);
        this.addLayer(new MelonGolemHeadLayer(this));
    }

    public ResourceLocation getTextureLocation(MelonGolemEntity p_110775_1_) {
        return SNOW_GOLEM_LOCATION;
    }
}