package com.itayfeder.restored_earth.client.renderer.entities.models;

import com.google.common.collect.ImmutableList;
import fuzs.refoundearth.world.entity.animal.EarthRabbit;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class JumboRabbitModel<T extends EarthRabbit> extends EntityModel<T> {
    private final ModelPart leftRearFoot;
    private final ModelPart rightRearFoot;
    private final ModelPart leftHaunch;
    private final ModelPart rightHaunch;
    private final ModelPart body;
    private final ModelPart leftFrontLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart head;
    private final ModelPart rightEar;
    private final ModelPart leftEar;
    private final ModelPart tail;
    private final ModelPart nose;
    private float jumpRotation;

    public JumboRabbitModel(ModelPart p_170881_) {
        this.leftRearFoot = p_170881_.getChild("left_hind_foot");
        this.rightRearFoot = p_170881_.getChild("right_hind_foot");
        this.leftHaunch = p_170881_.getChild("left_haunch");
        this.rightHaunch = p_170881_.getChild("right_haunch");
        this.body = p_170881_.getChild("body");
        this.leftFrontLeg = p_170881_.getChild("left_front_leg");
        this.rightFrontLeg = p_170881_.getChild("right_front_leg");
        this.head = p_170881_.getChild("head");
        this.rightEar = p_170881_.getChild("right_ear");
        this.leftEar = p_170881_.getChild("left_ear");
        this.tail = p_170881_.getChild("tail");
        this.nose = p_170881_.getChild("nose");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("left_hind_foot", CubeListBuilder.create().texOffs(26, 52).addBox(-1.5F, 9.0F, -4.0F, 3.0F, 2.0F, 9.0F), PartPose.offset(-4.0F, 12.75F, 1.95F));

        partdefinition.addOrReplaceChild("right_hind_foot", CubeListBuilder.create().texOffs(1, 52).addBox(-1.5F, 9.0F, -4.0F, 3.0F, 2.0F, 9.0F), PartPose.offset(4.0F, 12.75F, 1.95F));

        partdefinition.addOrReplaceChild("left_haunch", CubeListBuilder.create().texOffs(42, 35).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(-4.0F, 12.5F, 1.95F, -0.34906584F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("right_haunch", CubeListBuilder.create().texOffs(26, 27).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(4.0F, 12.5F, 1.95F, -0.34906584F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 4).addBox(-4.0F, -4.0F, -14.0F, 8.0F, 8.0F, 14.0F), PartPose.offsetAndRotation(0.0F, 17.0F, 8.0F, -0.34906584F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(3, 27).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(-4.0F, 13.0F, -4.5F, -0.17453292F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(15, 27).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(4.0F, 13.0F, -4.5F, -0.17453292F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(30, 7).addBox(-2.5F, -5.0F, -5.0F, 5.0F, 5.0F, 6.0F), PartPose.offset(0.0F, 13.0F, -5.0F));

        partdefinition.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(56, 10).addBox(0.5F, -7.0F, 0.0F, 2.0F, 2.0F, 1.0F)
                .texOffs(56, 0).addBox(0.5F, -18.0F, 0.0F, 3.0F, 11.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 13.0F, -5.0F, 0.0F, -0.2617994F, 0.0F));
        partdefinition.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(49, 10).addBox(-2.5F, -7.0F, 0.0F, 2.0F, 2.0F, 1.0F)
                .texOffs(48, 0).addBox(-3.5F, -18.0F, 0.0F, 3.0F, 11.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 13.0F, -5.0F, 0.0F, 0.2617994F, 0.0F));

        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(52, 14).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 17.0F, 8.0F, -0.3490659F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(36, 4).addBox(-0.5F, -3.0F, -5.5F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 13.0F, -5.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public void renderToBuffer(PoseStack p_103555_, VertexConsumer p_103556_, int p_103557_, int p_103558_, float p_103559_, float p_103560_, float p_103561_, float p_103562_) {
        if (this.young) {
            float f = 1.5F;
            p_103555_.pushPose();
            p_103555_.scale(0.56666666F, 0.56666666F, 0.56666666F);
            p_103555_.translate(0.0D, 1.375D, 0.125D);
            ImmutableList.of(this.head, this.leftEar, this.rightEar, this.nose).forEach((p_103597_) -> {
                p_103597_.render(p_103555_, p_103556_, p_103557_, p_103558_, p_103559_, p_103560_, p_103561_, p_103562_);
            });
            p_103555_.popPose();
            p_103555_.pushPose();
            p_103555_.scale(0.4F, 0.4F, 0.4F);
            p_103555_.translate(0.0D, 2.25D, 0.0D);
            ImmutableList.of(this.leftRearFoot, this.rightRearFoot, this.leftHaunch, this.rightHaunch, this.body, this.leftFrontLeg, this.rightFrontLeg, this.tail).forEach((p_103587_) -> {
                p_103587_.render(p_103555_, p_103556_, p_103557_, p_103558_, p_103559_, p_103560_, p_103561_, p_103562_);
            });
            p_103555_.popPose();
        } else {
            p_103555_.pushPose();
            p_103555_.scale(0.8F, 0.8F, 0.8F);
            p_103555_.translate(0.0D, 0.4D, 0.0D);
            ImmutableList.of(this.leftRearFoot, this.rightRearFoot, this.leftHaunch, this.rightHaunch, this.body, this.leftFrontLeg, this.rightFrontLeg, this.head, this.rightEar, this.leftEar, this.tail, this.nose).forEach((p_103572_) -> {
                p_103572_.render(p_103555_, p_103556_, p_103557_, p_103558_, p_103559_, p_103560_, p_103561_, p_103562_);
            });
            p_103555_.popPose();
        }

    }

    public void setupAnim(T p_103548_, float p_103549_, float p_103550_, float p_103551_, float p_103552_, float p_103553_) {
        float f = p_103551_ - (float)p_103548_.tickCount;
        this.nose.xRot = p_103553_ * ((float)Math.PI / 180F);
        this.head.xRot = p_103553_ * ((float)Math.PI / 180F);
        this.rightEar.xRot = p_103553_ * ((float)Math.PI / 180F);
        this.leftEar.xRot = p_103553_ * ((float)Math.PI / 180F);
        this.nose.yRot = p_103552_ * ((float)Math.PI / 180F);
        this.head.yRot = p_103552_ * ((float)Math.PI / 180F);
        this.rightEar.yRot = this.nose.yRot + 0.2617994F;
        this.leftEar.yRot = this.nose.yRot - 0.2617994F;
        this.jumpRotation = Mth.sin(p_103548_.getJumpCompletion(f) * (float)Math.PI);
        this.leftHaunch.xRot = (this.jumpRotation * 50.0F - 21.0F) * ((float)Math.PI / 180F);
        this.rightHaunch.xRot = (this.jumpRotation * 50.0F - 21.0F) * ((float)Math.PI / 180F);
        this.leftRearFoot.xRot = this.jumpRotation * 50.0F * ((float)Math.PI / 180F);
        this.rightRearFoot.xRot = this.jumpRotation * 50.0F * ((float)Math.PI / 180F);
        this.leftFrontLeg.xRot = (this.jumpRotation * -40.0F - 11.0F) * ((float)Math.PI / 180F);
        this.rightFrontLeg.xRot = (this.jumpRotation * -40.0F - 11.0F) * ((float)Math.PI / 180F);
    }

    public void prepareMobModel(T p_103543_, float p_103544_, float p_103545_, float p_103546_) {
        super.prepareMobModel(p_103543_, p_103544_, p_103545_, p_103546_);
        this.jumpRotation = Mth.sin(p_103543_.getJumpCompletion(p_103546_) * (float)Math.PI);
    }
}
