package com.itayfeder.restored_earth.client.renderer.entities;

import fuzs.refoundearth.client.init.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.models.JollyLlamaModel;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.horse.Llama;

public class JollyLlamaRenderer extends MobRenderer<Llama, JollyLlamaModel<Llama>> {
    private static final ResourceLocation TEXTURE_LOCATION = RefoundEarth.id("textures/entity/jolly_llama/jolly_llama.png");

    public JollyLlamaRenderer(EntityRendererProvider.Context context) {
        super(context, new JollyLlamaModel<>(context.bakeLayer(ModModelLayers.JOLLY_LLAMA)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(Llama llama) {
        return TEXTURE_LOCATION;
    }
}