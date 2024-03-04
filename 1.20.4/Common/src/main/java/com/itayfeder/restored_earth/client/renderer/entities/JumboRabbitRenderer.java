package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.models.JumboRabbitModel;
import com.itayfeder.restored_earth.client.renderer.entities.models.MuddyPigModel;
import com.itayfeder.restored_earth.entities.JumboRabbit;
import com.itayfeder.restored_earth.entities.MuddyPig;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import net.minecraft.resources.ResourceLocation;

public class JumboRabbitRenderer extends MobRenderer<JumboRabbit, JumboRabbitModel<JumboRabbit>> {
    private static final ResourceLocation MUDDY_PIG_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/jumbo_rabbit/jumbo_rabbit.png");

    public JumboRabbitRenderer(EntityRendererProvider.Context p_174340_) {
        super(p_174340_, new JumboRabbitModel<>(p_174340_.bakeLayer(ModModelLayers.JUMBO_RABBIT)), 0.4F);
    }

    public ResourceLocation getTextureLocation(JumboRabbit p_115697_) {
        return MUDDY_PIG_LOCATION;
    }
}