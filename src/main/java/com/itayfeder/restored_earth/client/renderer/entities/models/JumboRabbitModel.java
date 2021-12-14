package com.itayfeder.restored_earth.client.renderer.entities.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.util.math.MathHelper;

public class JumboRabbitModel<T extends RabbitEntity> extends EntityModel<T> {
    private final ModelRenderer rearFootLeft;
    private final ModelRenderer rearFootRight;
    private final ModelRenderer haunchLeft;
    private final ModelRenderer haunchRight;
    private final ModelRenderer body;
    private final ModelRenderer frontLegLeft;
    private final ModelRenderer frontLegRight;
    private final ModelRenderer head;
    private final ModelRenderer earRight;
    private final ModelRenderer earLeft;
    private final ModelRenderer tail;
    private final ModelRenderer nose;
    private float jumpRotation;

    public JumboRabbitModel() {
        texWidth = 64;
        texHeight = 64;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 17.0F, 8.0F);
        this.setRotation(body, -0.3491F, 0.0F, 0.0F);
        body.texOffs(0, 4).addBox(-4.0F, -4.0F, -14.0F, 8.0F, 8.0F, 14.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 13.0F, -5.0F);
        head.texOffs(30, 7).addBox(-2.5F, -5.0F, -5.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);

        earRight = new ModelRenderer(this);
        earRight.setPos(0.0F, 13.0F, -5.0F);
        this.setRotation(earRight, 0.0F, 0.2618F, 0.0F);
        earRight.texOffs(56, 10).addBox(0.5F, -7.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        earRight.texOffs(56, 0).addBox(0.5F, -18.0F, 0.0F, 3.0F, 11.0F, 1.0F, 0.0F, false);

        earLeft = new ModelRenderer(this);
        earLeft.setPos(0.0F, 13.0F, -5.0F);
        this.setRotation(earLeft, 0.0F, -0.2618F, 0.0F);
        earLeft.texOffs(49, 10).addBox(-2.5F, -7.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        earLeft.texOffs(48, 0).addBox(-3.5F, -18.0F, 0.0F, 3.0F, 11.0F, 1.0F, 0.0F, false);

        frontLegLeft = new ModelRenderer(this);
        frontLegLeft.setPos(-4.0F, 13.0F, -4.5F);
        this.setRotation(frontLegLeft, -0.1745F, 0.0F, 0.0F);
        frontLegLeft.texOffs(3, 27).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 11.0F, 3.0F, 0.0F, false);

        frontLegRight = new ModelRenderer(this);
        frontLegRight.setPos(4.0F, 13.0F, -4.5F);
        this.setRotation(frontLegRight, -0.1745F, 0.0F, 0.0F);
        frontLegRight.texOffs(15, 27).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 11.0F, 3.0F, 0.0F, false);

        nose = new ModelRenderer(this);
        nose.setPos(0.0F, 13.0F, -5.0F);
        nose.texOffs(36, 4).addBox(-0.5F, -3.0F, -5.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        haunchRight = new ModelRenderer(this);
        haunchRight.setPos(4.0F, 12.5F, 1.95F);
        this.setRotation(haunchRight, -0.3491F, 0.0F, 0.0F);
        haunchRight.texOffs(26, 27).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 7.0F, 8.0F, 0.0F, false);

        rearFootRight = new ModelRenderer(this);
        rearFootRight.setPos(4.0F, 12.75F, 1.95F);
        rearFootRight.texOffs(1, 52).addBox(-1.5F, 9.0F, -4.0F, 3.0F, 2.0F, 9.0F, 0.0F, false);

        haunchLeft = new ModelRenderer(this);
        haunchLeft.setPos(-4.0F, 12.5F, 1.95F);
        this.setRotation(haunchLeft, -0.3491F, 0.0F, 0.0F);
        haunchLeft.texOffs(42, 35).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 7.0F, 8.0F, 0.0F, false);

        rearFootLeft = new ModelRenderer(this);
        rearFootLeft.setPos(-4.0F, 12.75F, 1.95F);
        rearFootLeft.texOffs(26, 52).addBox(-1.5F, 9.0F, -4.0F, 3.0F, 2.0F, 9.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setPos(0.0F, 17.0F, 8.0F);
        this.setRotation(tail, -0.3491F, 0.0F, 0.0F);
        tail.texOffs(52, 14).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
    }

    private void setRotation(ModelRenderer p_178691_1_, float p_178691_2_, float p_178691_3_, float p_178691_4_) {
        p_178691_1_.xRot = p_178691_2_;
        p_178691_1_.yRot = p_178691_3_;
        p_178691_1_.zRot = p_178691_4_;
    }

    public void renderToBuffer(MatrixStack p_103555_, IVertexBuilder p_103556_, int p_103557_, int p_103558_, float p_103559_, float p_103560_, float p_103561_, float p_103562_) {
        if (this.young) {
            float f = 1.5F;
            p_103555_.pushPose();
            p_103555_.scale(0.56666666F, 0.56666666F, 0.56666666F);
            p_103555_.translate(0.0D, 1.375D, 0.125D);
            ImmutableList.of(this.head, this.earLeft, this.earRight, this.nose).forEach((p_103597_) -> {
                p_103597_.render(p_103555_, p_103556_, p_103557_, p_103558_, p_103559_, p_103560_, p_103561_, p_103562_);
            });
            p_103555_.popPose();
            p_103555_.pushPose();
            p_103555_.scale(0.4F, 0.4F, 0.4F);
            p_103555_.translate(0.0D, 2.25D, 0.0D);
            ImmutableList.of(this.rearFootLeft, this.rearFootRight, this.haunchLeft, this.haunchRight, this.body, this.frontLegLeft, this.frontLegRight, this.tail).forEach((p_103587_) -> {
                p_103587_.render(p_103555_, p_103556_, p_103557_, p_103558_, p_103559_, p_103560_, p_103561_, p_103562_);
            });
            p_103555_.popPose();
        } else {
            p_103555_.pushPose();
            p_103555_.scale(0.8F, 0.8F, 0.8F);
            p_103555_.translate(0.0D, 0.4D, 0.0D);
            ImmutableList.of(this.rearFootLeft, this.rearFootRight, this.haunchLeft, this.haunchRight, this.body, this.frontLegLeft, this.frontLegRight, this.head, this.earLeft, this.earRight, this.tail, this.nose).forEach((p_103572_) -> {
                p_103572_.render(p_103555_, p_103556_, p_103557_, p_103558_, p_103559_, p_103560_, p_103561_, p_103562_);
            });
            p_103555_.popPose();
        }

    }

    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        float f = p_225597_4_ - (float)p_225597_1_.tickCount;
        this.nose.xRot = p_225597_6_ * ((float)Math.PI / 180F);
        this.head.xRot = p_225597_6_ * ((float)Math.PI / 180F);
        this.earRight.xRot = p_225597_6_ * ((float)Math.PI / 180F);
        this.earLeft.xRot = p_225597_6_ * ((float)Math.PI / 180F);
        this.nose.yRot = p_225597_5_ * ((float)Math.PI / 180F);
        this.head.yRot = p_225597_5_ * ((float)Math.PI / 180F);
        this.earRight.yRot = this.nose.yRot + 0.2617994F;
        this.earLeft.yRot = this.nose.yRot - 0.2617994F;
        this.jumpRotation = MathHelper.sin(p_225597_1_.getJumpCompletion(f) * (float)Math.PI);
        this.haunchLeft.xRot = (this.jumpRotation * 50.0F - 21.0F) * ((float)Math.PI / 180F);
        this.haunchRight.xRot = (this.jumpRotation * 50.0F - 21.0F) * ((float)Math.PI / 180F);
        this.rearFootLeft.xRot = this.jumpRotation * 50.0F * ((float)Math.PI / 180F);
        this.rearFootRight.xRot = this.jumpRotation * 50.0F * ((float)Math.PI / 180F);
        this.frontLegLeft.xRot = (this.jumpRotation * -40.0F - 11.0F) * ((float)Math.PI / 180F);
        this.frontLegRight.xRot = (this.jumpRotation * -40.0F - 11.0F) * ((float)Math.PI / 180F);
    }

    public void prepareMobModel(T p_212843_1_, float p_212843_2_, float p_212843_3_, float p_212843_4_) {
        super.prepareMobModel(p_212843_1_, p_212843_2_, p_212843_3_, p_212843_4_);
        this.jumpRotation = MathHelper.sin(p_212843_1_.getJumpCompletion(p_212843_4_) * (float)Math.PI);
    }
}