package com.itayfeder.restored_earth.client.renderer.entities.models;

import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.VillagerHeadModel;
import net.minecraft.client.model.VillagerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.AbstractVillager;

public class VilerWitchModel<T extends Entity> extends HierarchicalModel<T> implements HeadedModel, VillagerHeadModel {
    private boolean holdingItem;
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart hat;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    protected final ModelPart nose;

    public VilerWitchModel(ModelPart p_171055_) {
        this.root = p_171055_;
        this.head = p_171055_.getChild("head");
        this.hat = this.head.getChild("hat");
        this.nose = this.head.getChild("nose");
        this.rightLeg = p_171055_.getChild("right_leg");
        this.leftLeg = p_171055_.getChild("left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = VillagerModel.createBodyModel();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F)
                .texOffs(0, 37).addBox(-4.5F, -4.0F, -4.5F, 9.0F, 5.0F, 9.0F), PartPose.ZERO);

        PartDefinition partdefinition2 = partdefinition1.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(4, 70).addBox(-15.0F, -2.02F, -5.0F, 20.0F, 2.0F, 20.0F), PartPose.offset(5.0F, -8.03F, -5.0F));
        PartDefinition partdefinition3 = partdefinition2.addOrReplaceChild("hat2", CubeListBuilder.create().texOffs(0, 51).addBox(-2.0F, -5.5F, -5.0F, 7.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(-6.75F, 0.03F, 7.0F, -0.0349F, 0.0F, 0.0262F));
        PartDefinition partdefinition4 = partdefinition3.addOrReplaceChild("hat3", CubeListBuilder.create().texOffs(0, 62).addBox(-0.75F, -5.5F, -3.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.1571F, 0.0F, 0.0524F));
        partdefinition4.addOrReplaceChild("hat4", CubeListBuilder.create().texOffs(16, 67).addBox(0.5F, -4.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.4014F, 0.0F, 0.1047F));
        partdefinition2.addOrReplaceChild("hat_rim", CubeListBuilder.create().texOffs(30, 47).addBox(-8.0F, -8.0F, -6.0F, 0F, 0F, 0F), PartPose.rotation((-(float)Math.PI / 2F), 0.0F, 0.0F));

        PartDefinition partdefinition6 = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F), PartPose.ZERO);
        partdefinition6.addOrReplaceChild("jacket", CubeListBuilder.create()
                .texOffs(30, 44).addBox(-5.0F, 0.0F, -3.5F, 10.0F, 19.0F, 7.0F)
                .texOffs(0, 92).addBox(-5.5F, 8.0F, -4.0F, 11.0F, 3.0F, 8.0F), PartPose.ZERO);

        partdefinition.addOrReplaceChild("arms", CubeListBuilder.create()
                .texOffs(40, 34).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F)
                .texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, true)
                .texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F)
                .texOffs(42, 11).addBox(4.0F, -3.0F, -3.0F, 5.0F, 5.0F, 6.0F)
                .texOffs(32, 0).addBox(-9.0F, -3.0F, -3.0F, 5.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, -0.75F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create()
                .texOffs(0, 21).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F)
                .texOffs(0, 78).addBox(-2.5F, 7.0F, -2.5F, 5.0F, 3.0F, 5.0F), PartPose.offset(-2.0F, 12.0F, 0.0F));

        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create()
                .texOffs(0, 21).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F)
                .texOffs(0, 78).mirror().addBox(-2.5F, 7.0F, -2.5F, 5.0F, 3.0F, 5.0F), PartPose.offset(2.0F, 12.0F, 0.0F));


        PartDefinition partdefinition5 = partdefinition1.getChild("nose");
        partdefinition5.addOrReplaceChild("mole", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 3.0F, -6.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, -2.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public void setupAnim(T p_104053_, float p_104054_, float p_104055_, float p_104056_, float p_104057_, float p_104058_) {
        boolean flag = false;
        if (p_104053_ instanceof AbstractVillager) {
            flag = ((AbstractVillager)p_104053_).getUnhappyCounter() > 0;
        }

        this.head.yRot = p_104057_ * ((float)Math.PI / 180F);
        this.head.xRot = p_104058_ * ((float)Math.PI / 180F);
        if (flag) {
            this.head.zRot = 0.3F * Mth.sin(0.45F * p_104056_);
            this.head.xRot = 0.4F;
        } else {
            this.head.zRot = 0.0F;
        }

        this.rightLeg.xRot = Mth.cos(p_104054_ * 0.6662F) * 1.4F * p_104055_ * 0.5F;
        this.leftLeg.xRot = Mth.cos(p_104054_ * 0.6662F + (float)Math.PI) * 1.4F * p_104055_ * 0.5F;
        this.rightLeg.yRot = 0.0F;
        this.leftLeg.yRot = 0.0F;

        this.nose.setPos(0.0F, -2.0F, 0.0F);
        float f = 0.01F * (float)(p_104053_.getId() % 10);
        this.nose.xRot = Mth.sin((float)p_104053_.tickCount * f) * 4.5F * ((float)Math.PI / 180F);
        this.nose.yRot = 0.0F;
        this.nose.zRot = Mth.cos((float)p_104053_.tickCount * f) * 2.5F * ((float)Math.PI / 180F);
        if (this.holdingItem) {
            this.nose.setPos(0.0F, 1.0F, -1.5F);
            this.nose.xRot = -0.9F;
        }
    }

    public ModelPart root() {
        return this.root;
    }

    public ModelPart getNose() {
        return this.nose;
    }

    public void setHoldingItem(boolean p_104075_) {
        this.holdingItem = p_104075_;
    }

    public ModelPart getHead() {
        return this.head;
    }

    public void hatVisible(boolean p_104060_) {
        this.head.visible = p_104060_;
        this.hat.visible = p_104060_;
    }
}