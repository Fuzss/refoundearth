package com.itayfeder.restored_earth.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.ClimberPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.world.World;

public class BoulderingZombieEntity extends ZombieEntity {
    private static final DataParameter<Byte> DATA_FLAGS_ID = EntityDataManager.defineId(BoulderingZombieEntity.class, DataSerializers.BYTE);

    public BoulderingZombieEntity(EntityType<? extends ZombieEntity> p_i48549_1_, World p_i48549_2_) {
        super(p_i48549_1_, p_i48549_2_);
    }

    protected ItemStack getSkull() {
        return ItemStack.EMPTY;
    }

    @Override
    protected boolean convertsInWater() {
        return false;
    }

    protected PathNavigator createNavigation(World p_175447_1_) {
        return new ClimberPathNavigator(this, p_175447_1_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }

    }

    public boolean onClimbable() {
        return this.isClimbing();
    }

    public boolean isClimbing() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public void setClimbing(boolean p_70839_1_) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (p_70839_1_) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }
}
