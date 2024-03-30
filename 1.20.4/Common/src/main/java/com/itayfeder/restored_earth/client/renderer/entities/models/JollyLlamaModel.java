package com.itayfeder.restored_earth.client.renderer.entities.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.horse.AbstractChestedHorse;

public class JollyLlamaModel<T extends AbstractChestedHorse> extends EntityModel<T> {
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart rightHindLeg;
    private final ModelPart leftHindLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart rightChest;
    private final ModelPart leftChest;

    public JollyLlamaModel(ModelPart modelPart) {
        this.head = modelPart.getChild("head");
        this.body = modelPart.getChild("body");
        this.rightChest = modelPart.getChild("right_chest");
        this.leftChest = modelPart.getChild("left_chest");
        this.rightHindLeg = modelPart.getChild("right_hind_leg");
        this.leftHindLeg = modelPart.getChild("left_hind_leg");
        this.rightFrontLeg = modelPart.getChild("right_front_leg");
        this.leftFrontLeg = modelPart.getChild("left_front_leg");
    }

    public static LayerDefinition createBodyLayer(CubeDeformation cubeDeformation) {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation deform1 = cubeDeformation.extend(0.1F);
        partdefinition.addOrReplaceChild("head",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-2.0F, -14.0F, -10.0F, 4.0F, 4.0F, 9.0F, cubeDeformation)
                        .texOffs(0, 14)
                        .addBox("neck", -4.0F, -16.0F, -6.0F, 8.0F, 18.0F, 6.0F, cubeDeformation)
                        .texOffs(17, 0)
                        .addBox("ear", -4.0F, -19.0F, -4.0F, 3.0F, 3.0F, 2.0F, cubeDeformation)
                        .texOffs(17, 0)
                        .addBox("ear", 1.0F, -19.0F, -4.0F, 3.0F, 3.0F, 2.0F, cubeDeformation)
                        .texOffs(89, 44)
                        .addBox("head_decor", -4.0F, -15.0F, -7.0F, 8.0F, 12.0F, 8.0F, deform1)
                        .texOffs(28, 50)
                        .addBox("neck_decor", -2.0F, -14.0F, -10.0F, 4.0F, 4.0F, 9.0F, deform1)
                        .texOffs(82, 30)
                        .addBox("right_horm", 4.0F, -29.75F, -2.0F, 7.0F, 16.0F, 0.0F)
                        .texOffs(75, 30)
                        .addBox("left_horm", -11.0F, -29.75F, -2.0F, 7.0F, 16.0F, 0.0F),
                PartPose.offset(0.0F, 7.0F, -6.0F)
        );
        partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(29, 0)
                        .addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, cubeDeformation)
                        .texOffs(84, 0)
                        .addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, cubeDeformation.extend(0.5F)),
                PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, ((float) Math.PI / 2F), 0.0F, 0.0F)
        );
        partdefinition.addOrReplaceChild("right_chest",
                CubeListBuilder.create().texOffs(45, 28).addBox(-3.0F, 0.0F, 0.0F, 8.0F, 8.0F, 3.0F, cubeDeformation),
                PartPose.offsetAndRotation(-8.5F, 3.0F, 3.0F, 0.0F, ((float) Math.PI / 2F), 0.0F)
        );
        partdefinition.addOrReplaceChild("left_chest",
                CubeListBuilder.create().texOffs(45, 41).addBox(-3.0F, 0.0F, 0.0F, 8.0F, 8.0F, 3.0F, cubeDeformation),
                PartPose.offsetAndRotation(5.5F, 3.0F, 3.0F, 0.0F, ((float) Math.PI / 2F), 0.0F)
        );
        int i = 4;
        int j = 14;
        CubeListBuilder cubelistbuilder = CubeListBuilder.create()
                .texOffs(29, 29)
                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, cubeDeformation);
        partdefinition.addOrReplaceChild("right_hind_leg", cubelistbuilder, PartPose.offset(-3.5F, 10.0F, 6.0F));
        partdefinition.addOrReplaceChild("left_hind_leg", cubelistbuilder, PartPose.offset(3.5F, 10.0F, 6.0F));
        partdefinition.addOrReplaceChild("right_front_leg", cubelistbuilder, PartPose.offset(-3.5F, 10.0F, -5.0F));
        partdefinition.addOrReplaceChild("left_front_leg", cubelistbuilder, PartPose.offset(3.5F, 10.0F, -5.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.xRot = headPitch * ((float) Math.PI / 180F);
        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.rightHindLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftHindLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        boolean flag = !entity.isBaby() && entity.hasChest();
        this.rightChest.visible = flag;
        this.leftChest.visible = flag;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int p_103058_, int packedOverlay, float red, float green, float blue, float alpha) {
        if (this.young) {
            float f = 2.0F;
            poseStack.pushPose();
            float f1 = 0.7F;
            poseStack.scale(0.71428573F, 0.64935064F, 0.7936508F);
            poseStack.translate(0.0D, 1.3125D, (double) 0.22F);
            this.head.render(poseStack, buffer, p_103058_, packedOverlay, red, green, blue, alpha);
            poseStack.popPose();
            poseStack.pushPose();
            float f2 = 1.1F;
            poseStack.scale(0.625F, 0.45454544F, 0.45454544F);
            poseStack.translate(0.0D, 2.0625D, 0.0D);
            this.body.render(poseStack, buffer, p_103058_, packedOverlay, red, green, blue, alpha);
            poseStack.popPose();
            poseStack.pushPose();
            poseStack.scale(0.45454544F, 0.41322312F, 0.45454544F);
            poseStack.translate(0.0D, 2.0625D, 0.0D);
            ImmutableList.of(this.rightHindLeg,
                    this.leftHindLeg,
                    this.rightFrontLeg,
                    this.leftFrontLeg,
                    this.rightChest,
                    this.leftChest
            ).forEach((p_103083_) -> {
                p_103083_.render(poseStack, buffer, p_103058_, packedOverlay, red, green, blue, alpha);
            });
            poseStack.popPose();
        } else {
            ImmutableList.of(this.head,
                    this.body,
                    this.rightHindLeg,
                    this.leftHindLeg,
                    this.rightFrontLeg,
                    this.leftFrontLeg,
                    this.rightChest,
                    this.leftChest
            ).forEach((p_103073_) -> {
                p_103073_.render(poseStack, buffer, p_103058_, packedOverlay, red, green, blue, alpha);
            });
        }
    }
}