package com.itayfeder.restored_earth.client.renderer.entities.models;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.SheepEntity;

public class RainbowSheepModel<T extends SheepEntity> extends QuadrupedModel<T> {
    private float headXRot;

    public RainbowSheepModel() {
        super(12, 0.0F, false, 8.0F, 4.0F, 2.0F, 2.0F, 24);
        texWidth = 64;
        texHeight = 32;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 7.0F, 2.0F);
        body.texOffs(36, 0).addBox(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F, 0.0F, true);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 8.0F, -8.0F);
        head.texOffs(0, 0).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 6.0F, 8.0F, 0.0F, true);

        leg0 = new ModelRenderer(this);
        leg0.setPos(3.0F, 14.0F, 7.0F);
        leg0.texOffs(0, 18).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, true);

        leg1 = new ModelRenderer(this);
        leg1.setPos(-3.0F, 14.0F, 7.0F);
        leg1.texOffs(0, 18).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, true);

        leg2 = new ModelRenderer(this);
        leg2.setPos(3.0F, 14.0F, -5.0F);
        leg2.texOffs(16, 18).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, true);

        leg3 = new ModelRenderer(this);
        leg3.setPos(-3.0F, 14.0F, -5.0F);
        leg3.texOffs(16, 18).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, true);
    }

    public void prepareMobModel(T p_212843_1_, float p_212843_2_, float p_212843_3_, float p_212843_4_) {
        super.prepareMobModel(p_212843_1_, p_212843_2_, p_212843_3_, p_212843_4_);
        this.head.y = 8.0F + p_212843_1_.getHeadEatPositionScale(p_212843_4_) * 9.0F;
        this.headXRot = p_212843_1_.getHeadEatAngleScale(p_212843_4_);
    }

    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setupAnim(p_225597_1_, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        this.head.xRot = this.headXRot;
    }
}