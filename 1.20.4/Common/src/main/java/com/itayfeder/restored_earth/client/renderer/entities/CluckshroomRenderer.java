package com.itayfeder.restored_earth.client.renderer.entities;

import fuzs.refoundearth.client.init.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.layers.CluckshroomMushroomLayer;
import com.itayfeder.restored_earth.client.renderer.entities.models.CluckshroomModel;
import com.itayfeder.restored_earth.entities.Cluckshroom;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class CluckshroomRenderer extends MobRenderer<Cluckshroom, CluckshroomModel<Cluckshroom>> {
    private static final ResourceLocation CLUCKSHROOM_LOCATION = new ResourceLocation(RefoundEarth.MOD_ID,"textures/entity/cluckshroom/cluckshroom.png");

    public CluckshroomRenderer(EntityRendererProvider.Context p_i47211_1_) {
        super(p_i47211_1_, new CluckshroomModel<>(p_i47211_1_.bakeLayer(ModModelLayers.CLUCKSHROOM)), 0.3F);
        this.addLayer(new CluckshroomMushroomLayer<>(this));
    }

    public ResourceLocation getTextureLocation(Cluckshroom p_110775_1_) {
        return CLUCKSHROOM_LOCATION;
    }

    protected float getBob(Cluckshroom p_114000_, float p_114001_) {
        float f = Mth.lerp(p_114001_, p_114000_.oFlap, p_114000_.flap);
        float f1 = Mth.lerp(p_114001_, p_114000_.oFlapSpeed, p_114000_.flapSpeed);
        return (Mth.sin(f) + 1.0F) * f1;
    }
}