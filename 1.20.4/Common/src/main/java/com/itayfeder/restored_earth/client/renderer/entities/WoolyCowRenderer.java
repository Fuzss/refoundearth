package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.models.WoolyCowModel;
import com.itayfeder.restored_earth.entities.WoolyCow;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cow;

public class WoolyCowRenderer extends MobRenderer<WoolyCow, WoolyCowModel<WoolyCow>> {
    private static final ResourceLocation WOOLY_COW_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/wooly_cow/wooly_cow.png");
    private static final ResourceLocation WOOLY_COW_SHEARED_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/wooly_cow/wooly_cow_sheared.png");

    public WoolyCowRenderer(EntityRendererProvider.Context p_173956_) {
        super(p_173956_, new WoolyCowModel<>(p_173956_.bakeLayer(ModModelLayers.WOOLY_COW)), 0.7F);
    }

    public ResourceLocation getTextureLocation(WoolyCow p_114029_) {
        return p_114029_.isSheared() ? WOOLY_COW_SHEARED_LOCATION : WOOLY_COW_LOCATION;
    }
}