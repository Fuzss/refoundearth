package com.itayfeder.restored_earth.client.renderer.entities.models.layers;

import com.itayfeder.restored_earth.entities.RainbowSheep;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.animal.Sheep;

public class RainbowSheepFurModel<T extends RainbowSheep> extends QuadrupedModel<T> {
    private float headXRot;

    public RainbowSheepFurModel(ModelPart p_170900_) {
        super(p_170900_, false, 8.0F, 4.0F, 2.0F, 2.0F, 24);
    }

    public static LayerDefinition createFurLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 8.0F, -8.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(22, 20).addBox(-6.0F, -11.0F, -8.0F, 12.0F, 19.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 2.0F, ((float)Math.PI / 2F), 0.0F, 0.0F));
        CubeListBuilder cubelistbuilder = CubeListBuilder.create().texOffs(0, 13).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(-0.25F));
        partdefinition.addOrReplaceChild("right_hind_leg", cubelistbuilder, PartPose.offset(-3.0F, 14.0F, 7.0F));
        partdefinition.addOrReplaceChild("left_hind_leg", cubelistbuilder, PartPose.offset(3.0F, 14.0F, 7.0F));
        CubeListBuilder cubelistbuilder1 = CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(-0.25F));
        partdefinition.addOrReplaceChild("right_front_leg", cubelistbuilder1, PartPose.offset(-3.0F, 14.0F, -5.0F));
        partdefinition.addOrReplaceChild("left_front_leg", cubelistbuilder1, PartPose.offset(3.0F, 14.0F, -5.0F));
        return LayerDefinition.create(meshdefinition, 64, 48);
    }

    public void prepareMobModel(T p_103661_, float p_103662_, float p_103663_, float p_103664_) {
        super.prepareMobModel(p_103661_, p_103662_, p_103663_, p_103664_);
        this.head.y = 8.0F + p_103661_.getHeadEatPositionScale(p_103664_) * 9.0F;
        this.headXRot = p_103661_.getHeadEatAngleScale(p_103664_);
    }

    public void setupAnim(T p_103666_, float p_103667_, float p_103668_, float p_103669_, float p_103670_, float p_103671_) {
        super.setupAnim(p_103666_, p_103667_, p_103668_, p_103669_, p_103670_, p_103671_);
        this.head.xRot = this.headXRot;
    }
}