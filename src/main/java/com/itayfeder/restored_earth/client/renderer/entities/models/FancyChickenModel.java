package com.itayfeder.restored_earth.client.renderer.entities.models;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class FancyChickenModel<T extends Entity> extends AgeableModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer leg0;
    private final ModelRenderer leg1;
    private final ModelRenderer wing0;
    private final ModelRenderer wing1;
    private final ModelRenderer beak;
    private final ModelRenderer redThing;

    public FancyChickenModel() {
        texWidth = 64;
        texHeight = 32;

        head = new ModelRenderer(this);
        head.setPos(0.0F, 13.0F, -4.0F);
        head.texOffs(0, 0).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 3.0F, 0.0F, true);
        head.texOffs(0, 22).addBox(0.0F, -10.0F, -3.0F, 0.0F, 5.0F, 5.0F, 0.0F, false);

        beak = new ModelRenderer(this);
        beak.setPos(0.0F, 13.0F, -4.0F);
        beak.texOffs(14, 0).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 2.0F, 2.0F, 0.0F, true);

        redThing = new ModelRenderer(this);
        redThing.setPos(0.0F, 13.0F, -4.0F);
        redThing.texOffs(14, 4).addBox(-0.5F, -2.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);

        body = new ModelRenderer(this);
        body.setPos(0.0F, 14.0F, 0.0F);
        body.texOffs(0, 9).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, true);
        body.texOffs(14, 15).addBox(0.0F, 4.0F, 1.0F, 0.0F, 7.0F, 10.0F, 0.0F, false);

        leg0 = new ModelRenderer(this);
        leg0.setPos(2.0F, 17.0F, 1.0F);
        leg0.texOffs(26, 0).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F, 0.0F, true);

        leg1 = new ModelRenderer(this);
        leg1.setPos(-1.0F, 17.0F, 1.0F);
        leg1.texOffs(26, 0).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F, 0.0F, true);

        wing0 = new ModelRenderer(this);
        wing0.setPos(3.0F, 11.0F, 0.0F);
        wing0.texOffs(24, 13).addBox(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, true);

        wing1 = new ModelRenderer(this);
        wing1.setPos(-3.0F, 11.0F, 0.0F);
        wing1.texOffs(24, 13).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, true);
    }

    protected Iterable<ModelRenderer> headParts() {
        return ImmutableList.of(this.head, this.beak, this.redThing);
    }

    protected Iterable<ModelRenderer> bodyParts() {
        return ImmutableList.of(this.body, this.leg0, this.leg1, this.wing0, this.wing1);
    }

    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.head.xRot = p_225597_6_ * ((float)Math.PI / 180F);
        this.head.yRot = p_225597_5_ * ((float)Math.PI / 180F);
        this.beak.xRot = this.head.xRot;
        this.beak.yRot = this.head.yRot;
        this.redThing.xRot = this.head.xRot;
        this.redThing.yRot = this.head.yRot;
        this.body.xRot = ((float)Math.PI / 2F);
        this.leg0.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_;
        this.leg1.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_225597_3_;
        this.wing0.zRot = -p_225597_4_;
        this.wing1.zRot = p_225597_4_;
    }
}