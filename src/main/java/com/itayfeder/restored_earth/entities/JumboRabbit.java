package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.level.Level;

public class JumboRabbit extends Rabbit {
    public JumboRabbit(EntityType<? extends Rabbit> p_29656_, Level p_29657_) {
        super(p_29656_, p_29657_);
    }

    public JumboRabbit getBreedOffspring(ServerLevel p_148890_, AgeableMob p_148891_) {
        return EntityInit.JUMBO_RABBIT.create(p_148890_);
    }
}
