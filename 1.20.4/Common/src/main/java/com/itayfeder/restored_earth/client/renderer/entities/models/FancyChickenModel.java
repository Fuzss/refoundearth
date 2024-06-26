package com.itayfeder.restored_earth.client.renderer.entities.models;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class FancyChickenModel<T extends Entity> extends AgeableListModel<T> {
    public static final String RED_THING = "red_thing";
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart rightWing;
    private final ModelPart leftWing;
    private final ModelPart beak;
    private final ModelPart redThing;

    public FancyChickenModel(ModelPart p_170490_) {
        this.head = p_170490_.getChild("head");
        this.beak = p_170490_.getChild("beak");
        this.redThing = p_170490_.getChild("red_thing");
        this.body = p_170490_.getChild("body");
        this.rightLeg = p_170490_.getChild("right_leg");
        this.leftLeg = p_170490_.getChild("left_leg");
        this.rightWing = p_170490_.getChild("right_wing");
        this.leftWing = p_170490_.getChild("left_wing");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        int i = 16;
        partdefinition.addOrReplaceChild("head",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 3.0F)
                        .texOffs(0, 22)
                        .addBox(0.0F, -10.0F, -3.0F, 0.0F, 5.0F, 5.0F),
                PartPose.offset(0.0F, 13.0F, -4.0F)
        );

        partdefinition.addOrReplaceChild("beak",
                CubeListBuilder.create().texOffs(14, 0).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 13.0F, -4.0F)
        );

        partdefinition.addOrReplaceChild("red_thing",
                CubeListBuilder.create().texOffs(14, 4).addBox(-0.5F, -2.0F, -4.0F, 1.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 13.0F, -4.0F)
        );

        partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(0, 9)
                        .addBox(-3.0F, -4.0F, -3.0F, 6.0F, 8.0F, 6.0F)
                        .texOffs(14, 15)
                        .addBox(0.0F, 4.0F, 1.0F, 0.0F, 7.0F, 10.0F),
                PartPose.offsetAndRotation(0.0F, 14.0F, 0.0F, ((float) Math.PI / 2F), 0.0F, 0.0F)
        );

        CubeListBuilder cubelistbuilder = CubeListBuilder.create()
                .texOffs(26, 0)
                .addBox(-2.0F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F);
        partdefinition.addOrReplaceChild("right_leg", cubelistbuilder, PartPose.offset(2.0F, 17.0F, 1.0F));
        partdefinition.addOrReplaceChild("left_leg", cubelistbuilder, PartPose.offset(-1.0F, 17.0F, 1.0F));

        partdefinition.addOrReplaceChild("right_wing",
                CubeListBuilder.create().texOffs(24, 13).addBox(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F),
                PartPose.offset(-4.0F, 11.0F, 0.0F)
        );

        partdefinition.addOrReplaceChild("left_wing",
                CubeListBuilder.create().texOffs(24, 13).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F),
                PartPose.offset(4.0F, 11.0F, 0.0F)
        );
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.head, this.beak, this.redThing);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.body, this.rightLeg, this.leftLeg, this.rightWing, this.leftWing);
    }

    @Override
    public void setupAnim(T p_102392_, float p_102393_, float p_102394_, float p_102395_, float p_102396_, float p_102397_) {
        this.head.xRot = p_102397_ * ((float) Math.PI / 180F);
        this.head.yRot = p_102396_ * ((float) Math.PI / 180F);
        this.beak.xRot = this.head.xRot;
        this.beak.yRot = this.head.yRot;
        this.redThing.xRot = this.head.xRot;
        this.redThing.yRot = this.head.yRot;
        this.rightLeg.xRot = Mth.cos(p_102393_ * 0.6662F) * 1.4F * p_102394_;
        this.leftLeg.xRot = Mth.cos(p_102393_ * 0.6662F + (float) Math.PI) * 1.4F * p_102394_;
        this.rightWing.zRot = p_102395_;
        this.leftWing.zRot = -p_102395_;
    }
}