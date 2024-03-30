package com.itayfeder.restored_earth.client.renderer.entities.models;

import fuzs.refoundearth.world.entity.animal.FurnaceGolem;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class FurnaceGolemModel<T extends FurnaceGolem> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;

    public FurnaceGolemModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
        this.rightArm = root.getChild("rightArm");
        this.leftArm = root.getChild("leftArm");
        this.rightLeg = root.getChild("rightLeg");
        this.leftLeg = root.getChild("leftLeg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 70).mirror().addBox(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, -7.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -12.0F, -5.5F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(24, 0).mirror().addBox(-1.0F, -5.0F, -7.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(6, 18).addBox(-4.0F, -12.0F, -7.5F, 8.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -2.0F));

        PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(60, 21).mirror().addBox(9.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -7.0F, 0.0F));

        PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(60, 58).mirror().addBox(-13.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -7.0F, 0.0F));

        PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(37, 0).mirror().addBox(-2.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 11.0F, 0.0F));

        PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(60, 0).addBox(-2.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 11.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public ModelPart root() {
        return this.root;
    }

    public void setupAnim(T p_102962_, float p_102963_, float p_102964_, float p_102965_, float p_102966_, float p_102967_) {
        this.head.yRot = p_102966_ * ((float)Math.PI / 180F);
        this.head.xRot = p_102967_ * ((float)Math.PI / 180F);
        this.rightLeg.xRot = -1.5F * Mth.triangleWave(p_102963_, 13.0F) * p_102964_;
        this.leftLeg.xRot = 1.5F * Mth.triangleWave(p_102963_, 13.0F) * p_102964_;
        this.rightLeg.yRot = 0.0F;
        this.leftLeg.yRot = 0.0F;
    }

    public void prepareMobModel(T p_102957_, float p_102958_, float p_102959_, float p_102960_) {
        int i = p_102957_.getAttackAnimationTick();
        if (i > 0) {
            this.rightArm.xRot = -2.0F + 1.5F * Mth.triangleWave((float)i - p_102960_, 10.0F);
            this.leftArm.xRot = -2.0F + 1.5F * Mth.triangleWave((float)i - p_102960_, 10.0F);
        } else {
            int j = p_102957_.getOfferFlowerTick();
            if (j > 0) {
                this.rightArm.xRot = -0.8F + 0.025F * Mth.triangleWave((float)j, 70.0F);
                this.leftArm.xRot = 0.0F;
            } else {
                this.rightArm.xRot = (-0.2F + 1.5F * Mth.triangleWave(p_102958_, 13.0F)) * p_102959_;
                this.leftArm.xRot = (-0.2F - 1.5F * Mth.triangleWave(p_102958_, 13.0F)) * p_102959_;
            }
        }

    }

    public ModelPart getFlowerHoldingArm() {
        return this.rightArm;
    }
}
