package com.itayfeder.restored_earth.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.level.Level;

public class FurnaceGolem extends IronGolem {
    private static final EntityDataAccessor<Boolean> DATA_ANGERED = SynchedEntityData.defineId(FurnaceGolem.class, EntityDataSerializers.BOOLEAN);

    public FurnaceGolem(EntityType<? extends FurnaceGolem> p_28834_, Level p_28835_) {
        super(p_28834_, p_28835_);
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

    public void addAdditionalSaveData(CompoundTag p_29864_) {
        super.addAdditionalSaveData(p_29864_);
        p_29864_.putBoolean("Angered", this.isAngered());
    }

    public void readAdditionalSaveData(CompoundTag p_29845_) {
        super.readAdditionalSaveData(p_29845_);
        this.setAngered(p_29845_.getBoolean("Angered"));
    }

    @Override
    public void tick() {
        super.tick();
        setAngered(this.isAngry());
    }
}
