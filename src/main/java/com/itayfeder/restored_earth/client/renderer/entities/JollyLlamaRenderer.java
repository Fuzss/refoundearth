package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.models.JollyLlamaModel;
import com.itayfeder.restored_earth.entities.JollyLlama;
import net.minecraft.client.model.LlamaModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.LlamaDecorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.horse.Llama;

public class JollyLlamaRenderer extends MobRenderer<JollyLlama, JollyLlamaModel<JollyLlama>> {
    private static final ResourceLocation JOLLY_LLAMA_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/jolly_llama/jolly_llama.png");

    public JollyLlamaRenderer(EntityRendererProvider.Context p_174293_) {
        super(p_174293_, new JollyLlamaModel<>(p_174293_.bakeLayer(ModModelLayers.JOLLY_LLAMA)), 0.7F);
    }

    public ResourceLocation getTextureLocation(JollyLlama p_115355_) {
        return JOLLY_LLAMA_LOCATION;
    }
}