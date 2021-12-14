package com.itayfeder.restored_earth.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class FurnaceGolemEntity extends IronGolemEntity {
    private static final DataParameter<Boolean> DATA_ANGERED = EntityDataManager.defineId(FurnaceGolemEntity.class, DataSerializers.BOOLEAN);

    public FurnaceGolemEntity(EntityType<? extends IronGolemEntity> p_i50267_1_, World p_i50267_2_) {
        super(p_i50267_1_, p_i50267_2_);
    }

    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        if (flag && p_70652_1_ instanceof LivingEntity) {
            ((LivingEntity)p_70652_1_).setSecondsOnFire(2);
        }

        return flag;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ANGERED, false);
    }

    public boolean isAngered() {
        return this.entityData.get(DATA_ANGERED);
    }

    private void setAngered(boolean p_175476_1_) {
        this.entityData.set(DATA_ANGERED, p_175476_1_);
    }

    public void addAdditionalSaveData(CompoundNBT p_29864_) {
        super.addAdditionalSaveData(p_29864_);
        p_29864_.putBoolean("Angered", this.isAngered());
    }

    public void readAdditionalSaveData(CompoundNBT p_29845_) {
        super.readAdditionalSaveData(p_29845_);
        this.setAngered(p_29845_.getBoolean("Angered"));
    }

    @Override
    public void tick() {
        super.tick();
        setAngered(this.isAngry());
    }
}
