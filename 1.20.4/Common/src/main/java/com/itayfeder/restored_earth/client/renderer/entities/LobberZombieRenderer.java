package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.models.LobberZombieModel;
import com.itayfeder.restored_earth.entities.LobberZombie;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LobberZombieRenderer extends HumanoidMobRenderer<LobberZombie, LobberZombieModel<LobberZombie>> {
    private static final ResourceLocation LOBBER_ZOMBIE_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/lobber_zombie/lobber_zombie.png");

    public LobberZombieRenderer(EntityRendererProvider.Context p_173952_) {
        super(p_173952_, new LobberZombieModel<>(p_173952_.bakeLayer(ModModelLayers.LOBBER_ZOMBIE)), 0.5F);
    }

    public ResourceLocation getTextureLocation(LobberZombie p_110775_1_) {
        return LOBBER_ZOMBIE_LOCATION;
    }

    protected boolean isShaking(LobberZombie p_113773_) {
        return super.isShaking(p_113773_) || p_113773_.isUnderWaterConverting();
    }

}
