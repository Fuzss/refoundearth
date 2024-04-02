package com.itayfeder.restored_earth.client.renderer.entities;

import fuzs.refoundearth.client.init.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.models.MuddyPigModel;
import com.itayfeder.restored_earth.entities.MuddyPig;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import net.minecraft.resources.ResourceLocation;

public class MuddyPigRenderer extends MobRenderer<MuddyPig, MuddyPigModel<MuddyPig>> {
    private static final ResourceLocation MUDDY_PIG_LOCATION = new ResourceLocation(RefoundEarth.MOD_ID,"textures/entity/muddy_pig/muddy_pig.png");

    public MuddyPigRenderer(EntityRendererProvider.Context p_174340_) {
        super(p_174340_, new MuddyPigModel<>(p_174340_.bakeLayer(ModModelLayers.MUDDY_PIG)), 0.7F);
        this.addLayer(new SaddleLayer<>(this, new MuddyPigModel<>(p_174340_.bakeLayer(ModelLayers.PIG_SADDLE)), new ResourceLocation("textures/entity/pig/pig_saddle.png")));
    }

    public ResourceLocation getTextureLocation(MuddyPig p_115697_) {
        return MUDDY_PIG_LOCATION;
    }
}