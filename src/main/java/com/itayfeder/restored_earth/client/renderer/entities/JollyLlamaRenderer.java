package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.models.JollyLlamaModel;
import com.itayfeder.restored_earth.entities.JollyLlamaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.LlamaDecorLayer;
import net.minecraft.client.renderer.entity.model.LlamaModel;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.util.ResourceLocation;

public class JollyLlamaRenderer extends MobRenderer<JollyLlamaEntity, JollyLlamaModel<JollyLlamaEntity>> {
    private static final ResourceLocation JOLLY_LLAMA_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/jolly_llama/jolly_llama.png");

    public JollyLlamaRenderer(EntityRendererManager p_i47203_1_) {
        super(p_i47203_1_, new JollyLlamaModel<>(0.0F), 0.7F);
    }

    public ResourceLocation getTextureLocation(JollyLlamaEntity p_110775_1_) {
        return JOLLY_LLAMA_LOCATION;
    }
}