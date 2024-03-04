package com.itayfeder.restored_earth.client.renderer.entities.models;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

public class TropicalSlimeModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart root;

    public TropicalSlimeModel(ModelPart p_170955_) {
        this.root = p_170955_;
    }

    public static LayerDefinition createOuterBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 8.0F, -8.0F, 16.0F, 16.0F, 16.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static LayerDefinition createInnerBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("cube", CubeListBuilder.create().texOffs(0, 40).addBox(-6.0F, 10.0F, -6.0F, 12.0F, 12.0F, 12.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(48, 40).addBox(2.5F, 12.0F, -6.5F, 4.0F, 4.0F, 4.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(48, 32).addBox(-6.5F, 12.0F, -6.5F, 4.0F, 4.0F, 4.0F), PartPose.ZERO);
        partdefinition.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(51, 48).addBox(-2.0F, 18.0F, -6.5F, 2.0F, 2.0F, 2.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public void setupAnim(T p_103831_, float p_103832_, float p_103833_, float p_103834_, float p_103835_, float p_103836_) {
    }

    public ModelPart root() {
        return this.root;
    }
}