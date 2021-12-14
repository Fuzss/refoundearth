package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class JumboRabbitEntity extends RabbitEntity {
    public JumboRabbitEntity(EntityType<? extends RabbitEntity> p_i50247_1_, World p_i50247_2_) {
        super(p_i50247_1_, p_i50247_2_);
    }

    @Override
    public JumboRabbitEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return EntityInit.JUMBO_RABBIT.create(p_241840_1_);
    }
}
