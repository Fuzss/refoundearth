package com.itayfeder.restored_earth.client.renderer.entities.models;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.entity.Entity;

public class MuddyPigModel<T extends Entity> extends QuadrupedModel<T> {
    public MuddyPigModel() {
        this(0.0F);
    }

    public MuddyPigModel(float p_i1151_1_) {
        super(6, p_i1151_1_, false, 4.0F, 4.0F, 2.0F, 2.0F, 24);
        this.head.texOffs(16, 16).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 3.0F, 1.0F, p_i1151_1_);
        this.head.texOffs(28, 3).addBox(-1.0F, -5.0F, -7.0F, 4.0F, 1.0F, 4.0F, p_i1151_1_);
        this.head.texOffs(45, 2).addBox(0.0F, -11.0F, -5.0F, 4.0F, 6.0F, 0.0F, p_i1151_1_);
    }
}