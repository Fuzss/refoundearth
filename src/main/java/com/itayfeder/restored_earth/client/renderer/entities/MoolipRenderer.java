package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.layers.MoobloomFlowerLayer;
import com.itayfeder.restored_earth.client.renderer.entities.layers.MoolipFlowerLayer;
import com.itayfeder.restored_earth.entities.MoobloomEntity;
import com.itayfeder.restored_earth.entities.MoolipEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.util.ResourceLocation;

public class MoolipRenderer extends MobRenderer<MoolipEntity, CowModel<MoolipEntity>> {
    private static final ResourceLocation MOOLIP_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/moolip/moolip.png");

    public MoolipRenderer(EntityRendererManager p_i47200_1_) {
        super(p_i47200_1_, new CowModel<>(), 0.7F);
        this.addLayer(new MoolipFlowerLayer<>(this));
    }

    public ResourceLocation getTextureLocation(MoolipEntity p_110775_1_) {
        return MOOLIP_LOCATION;
    }
}