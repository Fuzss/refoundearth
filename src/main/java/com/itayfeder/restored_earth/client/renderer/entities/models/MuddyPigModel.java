package com.itayfeder.restored_earth.client.renderer.entities.models;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class MuddyPigModel<T extends Entity> extends QuadrupedModel<T> {
    public MuddyPigModel(ModelPart p_170799_) {
        super(p_170799_, false, 4.0F, 4.0F, 2.0F, 2.0F, 24);
    }

    public static LayerDefinition createBodyLayer(CubeDeformation p_170801_) {
        MeshDefinition meshdefinition = QuadrupedModel.createBodyMesh(6, p_170801_);
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("head",
                CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, p_170801_)
                        .texOffs(16, 16).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 3.0F, 1.0F, p_170801_)
                        .texOffs(28, 3).addBox(-1.0F, -5.0F, -7.0F, 4.0F, 1.0F, 4.0F, p_170801_)
                        .texOffs(45, 2).addBox(0.0F, -11.0F, -5.0F, 4.0F, 6.0F, 0.0F, p_170801_), PartPose.offset(0.0F, 12.0F, -6.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }
}