package com.itayfeder.restored_earth.client.renderer.entities.models;

import com.itayfeder.restored_earth.entities.WoolyCowEntity;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class WoolyCowModel<T extends WoolyCowEntity> extends QuadrupedModel<T> {
    private float headXRot;

    public WoolyCowModel() {
        super(12, 0.0F, false, 10.0F, 4.0F, 2.0F, 2.0F, 24);
        texWidth = 64;
        texHeight = 64;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 5.0F, 2.0F);
        body.texOffs(18, 4).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, 0.0F, false);
        body.texOffs(8, 40).addBox(6.0F, -10.0F, -10.0F, 0.0F, 18.0F, 3.0F, 0.0F, false);
        body.texOffs(2, 40).addBox(-6.0F, -10.0F, -10.0F, 0.0F, 18.0F, 3.0F, 0.0F, false);
        body.texOffs(0, 34).addBox(-6.0F, -10.0F, -10.0F, 12.0F, 0.0F, 3.0F, 0.0F, false);
        body.texOffs(0, 37).addBox(-6.0F, 8.0F, -10.0F, 12.0F, 0.0F, 3.0F, 0.0F, false);
        body.texOffs(20, 34).addBox(-5.5F, -9.99F, -6.99F, 11.0F, 17.0F, 10.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 4.0F, -8.0F);
        head.texOffs(0, 0).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, 0.0F, false);
        head.texOffs(22, 0).addBox(4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        head.texOffs(22, 0).addBox(-5.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        leg0 = new ModelRenderer(this);
        leg0.setPos(4.0F, 12.0F, 7.0F);
        leg0.texOffs(0, 16).addBox(-9.99F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        leg1 = new ModelRenderer(this);
        leg1.setPos(-4.0F, 12.0F, 7.0F);
        leg1.texOffs(0, 16).addBox(5.99F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        leg2 = new ModelRenderer(this);
        leg2.setPos(4.0F, 12.0F, -6.0F);
        leg2.texOffs(0, 16).addBox(-9.99F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        leg3 = new ModelRenderer(this);
        leg3.setPos(-4.0F, 12.0F, -6.0F);
        leg3.texOffs(0, 16).addBox(5.99F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

    }

    public ModelRenderer getHead() {
        return this.head;
    }

    @Override
    public void prepareMobModel(T p_103687_, float p_103688_, float p_103689_, float p_103690_) {
        super.prepareMobModel(p_103687_, p_103688_, p_103689_, p_103690_);
        this.head.y = 6.0F + p_103687_.getHeadEatPositionScale(p_103690_) * 9.0F;
        this.headXRot = p_103687_.getHeadEatAngleScale(p_103690_);
    }

    @Override
    public void setupAnim(T p_103692_, float p_103693_, float p_103694_, float p_103695_, float p_103696_, float p_103697_) {
        super.setupAnim(p_103692_, p_103693_, p_103694_, p_103695_, p_103696_, p_103697_);
        this.head.xRot = this.headXRot;
    }
}