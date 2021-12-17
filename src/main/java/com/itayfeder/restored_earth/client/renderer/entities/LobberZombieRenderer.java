package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.models.BoulderingZombieModel;
import com.itayfeder.restored_earth.client.renderer.entities.models.LobberZombieModel;
import com.itayfeder.restored_earth.entities.BoulderingZombieEntity;
import com.itayfeder.restored_earth.entities.LobberZombieEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class LobberZombieRenderer extends BipedRenderer<LobberZombieEntity, LobberZombieModel<LobberZombieEntity>> {
    private static final ResourceLocation LOBBER_ZOMBIE_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/lobber_zombie/lobber_zombie.png");

    public LobberZombieRenderer(EntityRendererManager p_i50974_1_) {
        super(p_i50974_1_, new LobberZombieModel<>(0.0F), 0.5F);
    }

    public ResourceLocation getTextureLocation(LobberZombieEntity p_110775_1_) {
        return LOBBER_ZOMBIE_LOCATION;
    }

    protected boolean isShaking(LobberZombieEntity p_230495_1_) {
        return p_230495_1_.isUnderWaterConverting();
    }
}