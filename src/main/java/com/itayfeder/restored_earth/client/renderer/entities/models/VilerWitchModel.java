package com.itayfeder.restored_earth.client.renderer.entities.models;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.IHasHead;
import net.minecraft.client.renderer.entity.model.IHeadToggle;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.entity.model.VillagerModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.util.math.MathHelper;

public class VilerWitchModel<T extends Entity> extends SegmentedModel<T> implements IHasHead, IHeadToggle {
    protected ModelRenderer head;
    protected ModelRenderer hat;
    protected final ModelRenderer body;
    protected final ModelRenderer arms;
    protected final ModelRenderer leg0;
    protected final ModelRenderer leg1;
    protected final ModelRenderer nose;

    private boolean holdingItem;
    private final ModelRenderer mole = (new ModelRenderer(this)).setTexSize(128, 128);

    public VilerWitchModel(float p_i51059_1_) {
        texWidth = 128;
        texHeight = 128;

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        head.texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, 0.0F, true);
        head.texOffs(0, 37).addBox(-4.5F, -4.0F, -4.5F, 9.0F, 5.0F, 9.0F, 0.0F, false);

        nose = new ModelRenderer(this);
        nose.setPos(0.0F, -2.0F, 0.0F);
        head.addChild(nose);
        nose.texOffs(0, 0).addBox(-1.0F, 0.0F, -6.75F, 1.0F, 1.0F, 1.0F, -0.25F, true);
        nose.texOffs(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, 0.0F, true);

        body = new ModelRenderer(this);
        body.setPos(0.0F, 0.0F, 0.0F);
        body.texOffs(16, 20).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, 0.0F, true);
        body.texOffs(30, 44).addBox(-5.0F, 0.0F, -3.5F, 10.0F, 19.0F, 7.0F, 0.0F, true);
        body.texOffs(0, 92).addBox(-5.5F, 8.0F, -4.0F, 11.0F, 3.0F, 8.0F, 0.0F, false);

        arms = new ModelRenderer(this);
        arms.setPos(0.0F, 2.0F, 0.0F);
        setRotationAngle(arms, -0.9163F, 0.0F, 0.0F);
        arms.texOffs(40, 34).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, true);
        arms.texOffs(44, 22).addBox(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, true);
        arms.texOffs(44, 22).addBox(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, true);
        arms.texOffs(42, 11).addBox(4.0F, -3.0F, -3.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);
        arms.texOffs(32, 0).addBox(-9.0F, -3.0F, -3.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);

        leg0 = new ModelRenderer(this);
        leg0.setPos(2.0F, 12.0F, 0.0F);
        leg0.texOffs(0, 21).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
        leg0.texOffs(0, 78).addBox(-2.5F, 7.0F, -2.5F, 5.0F, 3.0F, 5.0F, 0.0F, false);

        leg1 = new ModelRenderer(this);
        leg1.setPos(-2.0F, 12.0F, 0.0F);
        leg1.texOffs(0, 21).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        leg1.texOffs(0, 78).addBox(-2.5F, 7.0F, -2.5F, 5.0F, 3.0F, 5.0F, 0.0F, false);

        hat = new ModelRenderer(this);
        hat.setPos(5.0F, -8.03F, -5.0F);
        hat.texOffs(4, 70).addBox(-15.0F, -2.02F, -5.0F, 20.0F, 2.0F, 20.0F, 0.0F, true);

        ModelRenderer hat2 = new ModelRenderer(this);
        hat2.setPos(-6.75F, 0.03F, 7.0F);
        hat.addChild(hat2);
        setRotationAngle(hat2, -0.0349F, 0.0F, 0.0262F);
        hat2.texOffs(0, 51).addBox(-2.0F, -5.5F, -5.0F, 7.0F, 4.0F, 7.0F, 0.0F, true);

        ModelRenderer hat3 = new ModelRenderer(this);
        hat3.setPos(0.0F, -3.0F, 0.0F);
        hat2.addChild(hat3);
        setRotationAngle(hat3, -0.1571F, 0.0F, 0.0524F);
        hat3.texOffs(0, 62).addBox(-0.75F, -5.5F, -3.0F, 4.0F, 4.0F, 4.0F, 0.0F, true);

        ModelRenderer hat4 = new ModelRenderer(this);
        hat4.setPos(0.0F, -3.0F, 0.0F);
        hat3.addChild(hat4);
        setRotationAngle(hat4, -0.4014F, 0.0F, 0.1047F);
        hat4.texOffs(16, 67).addBox(0.5F, -4.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.25F, true);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(this.head, this.body, this.leg0, this.leg1, this.arms, this.hat);
    }

    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        boolean flag = false;
        if (p_225597_1_ instanceof AbstractVillagerEntity) {
            flag = ((AbstractVillagerEntity)p_225597_1_).getUnhappyCounter() > 0;
        }

        this.head.yRot = p_225597_5_ * ((float)Math.PI / 180F);
        this.head.xRot = p_225597_6_ * ((float)Math.PI / 180F);
        if (flag) {
            this.head.zRot = 0.3F * MathHelper.sin(0.45F * p_225597_4_);
            this.head.xRot = 0.4F;
        } else {
            this.head.zRot = 0.0F;
        }

        this.arms.y = 3.0F;
        this.arms.z = -1.0F;
        this.arms.xRot = -0.75F;
        this.leg0.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_ * 0.5F;
        this.leg1.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_ * 0.5F;
        this.leg0.yRot = 0.0F;
        this.leg1.yRot = 0.0F;

        this.nose.setPos(0.0F, -2.0F, 0.0F);
        float f = 0.01F * (float)(p_225597_1_.getId() % 10);
        this.nose.xRot = MathHelper.sin((float)p_225597_1_.tickCount * f) * 4.5F * ((float)Math.PI / 180F);
        this.nose.yRot = 0.0F;
        this.nose.zRot = MathHelper.cos((float)p_225597_1_.tickCount * f) * 2.5F * ((float)Math.PI / 180F);
        if (this.holdingItem) {
            this.nose.setPos(0.0F, 1.0F, -1.5F);
            this.nose.xRot = -0.9F;
        }
    }

    public ModelRenderer getHead() {
        return this.head;
    }

    public void hatVisible(boolean p_217146_1_) {
        this.head.visible = p_217146_1_;
        this.hat.visible = p_217146_1_;
    }


    public ModelRenderer getNose() {
        return this.nose;
    }

    public void setHoldingItem(boolean p_205074_1_) {
        this.holdingItem = p_205074_1_;
    }
}