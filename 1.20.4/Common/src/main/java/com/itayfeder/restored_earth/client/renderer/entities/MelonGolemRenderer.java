package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.client.renderer.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.layers.MelonGolemHeadLayer;
import com.itayfeder.restored_earth.entities.MelonGolem;
import net.minecraft.client.model.SnowGolemModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SnowGolemHeadLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.SnowGolem;

public class MelonGolemRenderer extends MobRenderer<MelonGolem, SnowGolemModel<MelonGolem>> {
    private static final ResourceLocation SNOW_GOLEM_LOCATION = new ResourceLocation("textures/entity/snow_golem.png");

    public MelonGolemRenderer(EntityRendererProvider.Context p_174393_) {
        super(p_174393_, new SnowGolemModel<>(p_174393_.bakeLayer(ModModelLayers.MELON_GOLEM)), 0.5F);
        this.addLayer(new MelonGolemHeadLayer(this));
    }

    public ResourceLocation getTextureLocation(MelonGolem p_115993_) {
        return SNOW_GOLEM_LOCATION;
    }
}