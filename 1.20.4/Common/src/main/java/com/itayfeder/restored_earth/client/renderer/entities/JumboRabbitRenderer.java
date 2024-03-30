package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.client.renderer.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.models.JumboRabbitModel;
import fuzs.refoundearth.world.entity.animal.EarthRabbit;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class JumboRabbitRenderer extends MobRenderer<EarthRabbit, JumboRabbitModel<EarthRabbit>> {
    private static final ResourceLocation MUDDY_PIG_LOCATION = new ResourceLocation(RefoundEarth.MOD_ID,"textures/entity/jumbo_rabbit/jumbo_rabbit.png");

    public JumboRabbitRenderer(EntityRendererProvider.Context p_174340_) {
        super(p_174340_, new JumboRabbitModel<>(p_174340_.bakeLayer(ModModelLayers.JUMBO_RABBIT)), 0.4F);
    }

    public ResourceLocation getTextureLocation(EarthRabbit p_115697_) {
        return MUDDY_PIG_LOCATION;
    }
}