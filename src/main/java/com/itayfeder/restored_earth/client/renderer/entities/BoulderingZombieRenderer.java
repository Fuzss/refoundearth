package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.models.BoulderingZombieModel;
import com.itayfeder.restored_earth.entities.BoulderingZombieEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.ZombieModel;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;

public class BoulderingZombieRenderer extends BipedRenderer<BoulderingZombieEntity, BoulderingZombieModel<BoulderingZombieEntity>> {
    private static final ResourceLocation BOULDERING_ZOMBIE_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/bouldering_zombie/bouldering_zombie.png");

    public BoulderingZombieRenderer(EntityRendererManager p_i50974_1_) {
        super(p_i50974_1_, new BoulderingZombieModel<>(0.0F), 0.5F);
    }

    public ResourceLocation getTextureLocation(BoulderingZombieEntity p_110775_1_) {
        return BOULDERING_ZOMBIE_LOCATION;
    }

    protected boolean isShaking(BoulderingZombieEntity p_230495_1_) {
        return p_230495_1_.isUnderWaterConverting();
    }
}