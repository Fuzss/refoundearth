package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.models.MuddyPigModel;
import com.itayfeder.restored_earth.entities.MuddyPigEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import net.minecraft.client.renderer.entity.model.PigModel;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.ResourceLocation;

public class MuddyPigRenderer extends MobRenderer<MuddyPigEntity, MuddyPigModel<MuddyPigEntity>> {
    private static final ResourceLocation MUDDY_PIG_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/muddy_pig/muddy_pig.png");

    public MuddyPigRenderer(EntityRendererManager p_i47198_1_) {
        super(p_i47198_1_, new MuddyPigModel<>(), 0.7F);
        this.addLayer(new SaddleLayer<>(this, new MuddyPigModel<>(0.5F), new ResourceLocation("textures/entity/pig/pig_saddle.png")));
    }

    public ResourceLocation getTextureLocation(MuddyPigEntity p_110775_1_) {
        return MUDDY_PIG_LOCATION;
    }
}