package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.models.WoolyCowModel;
import com.itayfeder.restored_earth.entities.WoolyCowEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.ResourceLocation;

public class WoolyCowRenderer extends MobRenderer<WoolyCowEntity, WoolyCowModel<WoolyCowEntity>> {
    private static final ResourceLocation WOOLY_COW_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/wooly_cow/wooly_cow.png");
    private static final ResourceLocation WOOLY_COW_SHEARED_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/wooly_cow/wooly_cow_sheared.png");

    public WoolyCowRenderer(EntityRendererManager p_i47210_1_) {
        super(p_i47210_1_, new WoolyCowModel<>(), 0.7F);
    }

    public ResourceLocation getTextureLocation(WoolyCowEntity p_114029_) {
        return p_114029_.isSheared() ? WOOLY_COW_SHEARED_LOCATION : WOOLY_COW_LOCATION;
    }
}