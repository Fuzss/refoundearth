package com.itayfeder.restored_earth.entities;

import fuzs.refoundearth.init.ModEntityTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.level.Level;

public class MuddyPig extends Pig {

    public MuddyPig(EntityType<? extends Pig> p_29462_, Level p_29463_) {
        super(ModEntityTypes.MUDDY_PIG, p_29463_);
    }
}