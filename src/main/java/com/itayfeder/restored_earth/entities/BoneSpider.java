package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.init.SoundInit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

public class BoneSpider extends Spider {
    public BoneSpider(EntityType<? extends BoneSpider> p_33786_, Level p_33787_) {
        super(p_33786_, p_33787_);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 32.0D).add(Attributes.MOVEMENT_SPEED, (double)0.25F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundInit.BONE_SPIDER_IDLE;
    }

    protected SoundEvent getDeathSound() {
        return SoundInit.BONE_SPIDER_DEATH;
    }

    protected float getSoundVolume() {
        return 0.5F;
    }
}
