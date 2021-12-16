package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.level.Level;

public class FancyChicken extends Chicken {
    public FancyChicken(EntityType<? extends Chicken> p_28236_, Level p_28237_) {
        super(p_28236_, p_28237_);
    }

    public FancyChicken getBreedOffspring(ServerLevel p_148884_, AgeableMob p_148885_) {
        return EntityInit.FANCY_CHICKEN.create(p_148884_);
    }
}
