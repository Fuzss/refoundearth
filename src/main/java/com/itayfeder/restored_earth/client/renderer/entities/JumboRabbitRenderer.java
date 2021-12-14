package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.models.JumboRabbitModel;
import com.itayfeder.restored_earth.entities.JumboRabbitEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.RabbitModel;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class JumboRabbitRenderer extends MobRenderer<JumboRabbitEntity, JumboRabbitModel<JumboRabbitEntity>> {
    private static final ResourceLocation MUDDY_PIG_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/jumbo_rabbit/jumbo_rabbit.png");


    public JumboRabbitRenderer(EntityRendererManager p_i47196_1_) {
        super(p_i47196_1_, new JumboRabbitModel<>(), 0.4F);
    }

    public ResourceLocation getTextureLocation(JumboRabbitEntity p_110775_1_) {
        return MUDDY_PIG_LOCATION;
    }
}