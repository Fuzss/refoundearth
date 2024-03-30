package com.itayfeder.restored_earth.client.renderer.entities.models;

import fuzs.refoundearth.world.entity.monster.LobberZombie;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class LobberZombieModel<T extends LobberZombie> extends HumanoidModel<T> {

    public LobberZombieModel(ModelPart p_170677_) { super(p_170677_); }

    public static LayerDefinition createBodyLayer(CubeDeformation p_170536_) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(p_170536_, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(32, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, p_170536_), PartPose.offset(-5.0F, 2.0F + 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 32).mirror().addBox(-1.0F, -2.0F, -2.0F, 5.0F, 14.0F, 4.0F, p_170536_), PartPose.offset(5.0F, 2.0F + 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170536_), PartPose.offset(-1.9F, 12.0F + 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, p_170536_), PartPose.offset(1.9F, 12.0F + 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, p_170536_), PartPose.offset(0.0F, 0.0F + 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public void setupAnim(T p_102001_, float p_102002_, float p_102003_, float p_102004_, float p_102005_, float p_102006_) {
        super.setupAnim(p_102001_, p_102002_, p_102003_, p_102004_, p_102005_, p_102006_);
        AnimationUtils.animateZombieArms(this.leftArm, this.rightArm, this.isAggressive(p_102001_), this.attackTime, p_102004_);
    }

    public boolean isAggressive(T p_104155_) {
        return p_104155_.isAggressive();
    }
}