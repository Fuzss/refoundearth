package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class FancyChickenEntity extends ChickenEntity {
    public FancyChickenEntity(EntityType<? extends ChickenEntity> p_i50282_1_, World p_i50282_2_) {
        super(p_i50282_1_, p_i50282_2_);
    }

    @Override
    public FancyChickenEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return EntityInit.FANCY_CHICKEN.create(p_241840_1_);
    }
}
