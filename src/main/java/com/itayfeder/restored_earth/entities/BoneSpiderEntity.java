package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.init.SoundInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import java.util.Random;

public class BoneSpiderEntity extends SpiderEntity {
    public BoneSpiderEntity(EntityType<? extends BoneSpiderEntity> p_i48550_1_, World p_i48550_2_) {
        super(p_i48550_1_, p_i48550_2_);
    }

    public static boolean checkMonsterSpawnRules(EntityType<? extends MonsterEntity> p_223325_0_, IServerWorld p_223325_1_, SpawnReason p_223325_2_, BlockPos p_223325_3_, Random p_223325_4_) {
        return p_223325_1_.getDifficulty() != Difficulty.PEACEFUL &&
                isDarkEnoughToSpawn(p_223325_1_, p_223325_3_, p_223325_4_) &&
                checkMobSpawnRules(p_223325_0_, p_223325_1_, p_223325_2_, p_223325_3_, p_223325_4_);
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 32.0D).add(Attributes.MOVEMENT_SPEED, (double)0.25F);
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
