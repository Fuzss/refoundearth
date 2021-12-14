package com.itayfeder.restored_earth.client.renderer.entities;

import com.google.common.collect.Maps;
import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.layers.MoobloomFlowerLayer;
import com.itayfeder.restored_earth.entities.MoobloomEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.MooshroomMushroomLayer;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;

import java.util.Map;

public class MoobloomRenderer extends MobRenderer<MoobloomEntity, CowModel<MoobloomEntity>> {
    private static final ResourceLocation MOOBLOOM_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/moobloom/moobloom.png");


    public MoobloomRenderer(EntityRendererManager p_i47200_1_) {
        super(p_i47200_1_, new CowModel<>(), 0.7F);
        this.addLayer(new MoobloomFlowerLayer<>(this));
    }

    public ResourceLocation getTextureLocation(MoobloomEntity p_110775_1_) {
        return MOOBLOOM_LOCATION;
    }
}