package com.itayfeder.restored_earth.client.renderer.entities.models;

import com.itayfeder.restored_earth.entities.WoolyCow;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

public class WoolyCowModel<T extends WoolyCow> extends QuadrupedModel<T> {
    private float headXRot;

    public WoolyCowModel(ModelPart p_170515_) {
        super(p_170515_, false, 10.0F, 4.0F, 2.0F, 2.0F, 24);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        int i = 12;
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F).texOffs(22, 0).addBox("right_horn", -5.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F).texOffs(22, 0).addBox("left_horn", 4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 4.0F, -8.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(18, 4).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F)
                .texOffs(8, 40).addBox(6.0F, -10.0F, -10.0F, 0.0F, 18.0F, 3.0F)
                .texOffs(2, 40).addBox(-6.0F, -10.0F, -10.0F, 0.0F, 18.0F, 3.0F)
                .texOffs(0, 34).addBox(-6.0F, -10.0F, -10.0F, 12.0F, 0.0F, 3.0F)
                .texOffs(0, 37).addBox(-6.0F, 8.0F, -10.0F, 12.0F, 0.0F, 3.0F)
                .texOffs(20, 34).addBox(-5.5F, -9.99F, -6.99F, 11.0F, 17.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, ((float)Math.PI / 2F), 0.0F, 0.0F));

        CubeListBuilder cubelistbuilder = CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
        partdefinition.addOrReplaceChild("right_hind_leg", cubelistbuilder, PartPose.offset(-3.99F, 12.0F, 6.99F));
        partdefinition.addOrReplaceChild("left_hind_leg", cubelistbuilder, PartPose.offset(3.99F, 12.0F, 6.99F));
        partdefinition.addOrReplaceChild("right_front_leg", cubelistbuilder, PartPose.offset(-3.99F, 12.0F, -5.99F));
        partdefinition.addOrReplaceChild("left_front_leg", cubelistbuilder, PartPose.offset(3.99F, 12.0F, -5.99F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public ModelPart getHead() {
        return this.head;
    }

    public void prepareMobModel(T p_103687_, float p_103688_, float p_103689_, float p_103690_) {
        super.prepareMobModel(p_103687_, p_103688_, p_103689_, p_103690_);
        this.head.y = 6.0F + p_103687_.getHeadEatPositionScale(p_103690_) * 9.0F;
        this.headXRot = p_103687_.getHeadEatAngleScale(p_103690_);
    }

    public void setupAnim(T p_103692_, float p_103693_, float p_103694_, float p_103695_, float p_103696_, float p_103697_) {
        super.setupAnim(p_103692_, p_103693_, p_103694_, p_103695_, p_103696_, p_103697_);
        this.head.xRot = this.headXRot;
    }
}