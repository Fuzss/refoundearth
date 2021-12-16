package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.models.BoulderingZombieModel;
import com.itayfeder.restored_earth.client.renderer.entities.models.FancyChickenModel;
import com.itayfeder.restored_earth.entities.BoulderingZombie;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BoulderingZombieRenderer extends HumanoidMobRenderer<BoulderingZombie, BoulderingZombieModel<BoulderingZombie>> {
    private static final ResourceLocation BOULDERING_ZOMBIE_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/bouldering_zombie/bouldering_zombie.png");

    public BoulderingZombieRenderer(EntityRendererProvider.Context p_173952_) {
        super(p_173952_, new BoulderingZombieModel<>(p_173952_.bakeLayer(ModModelLayers.BOULDERING_ZOMBIE)), 0.5F);
    }

    public ResourceLocation getTextureLocation(BoulderingZombie p_110775_1_) {
        return BOULDERING_ZOMBIE_LOCATION;
    }

    protected boolean isShaking(BoulderingZombie p_113773_) {
        return super.isShaking(p_113773_) || p_113773_.isUnderWaterConverting();
    }

}
