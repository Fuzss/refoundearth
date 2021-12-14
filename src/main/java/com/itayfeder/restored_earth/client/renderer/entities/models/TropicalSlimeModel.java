package com.itayfeder.restored_earth.client.renderer.entities.models;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TropicalSlimeModel<T extends Entity> extends SegmentedModel<T> {
    private final ModelRenderer outer_slime;
    private final ModelRenderer inner_slime;
    private final ModelRenderer eye0;
    private final ModelRenderer eye1;
    private final ModelRenderer mouth;

    public TropicalSlimeModel(boolean isOuterLayer) {
        texWidth = 64;
        texHeight = 64;

        outer_slime = new ModelRenderer(this);
        inner_slime = new ModelRenderer(this);
        eye0 = new ModelRenderer(this);
        eye1 = new ModelRenderer(this);
        mouth = new ModelRenderer(this);


        if (isOuterLayer) {
            outer_slime.setPos(0.0F, 0.0F, 0.0F);
            outer_slime.texOffs(0, 0).addBox(-8.0F, 8.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        }
        else {
            inner_slime.setPos(0.0F, 0.0F, 0.0F);
            inner_slime.texOffs(0, 40).addBox(-6.0F, 10.0F, -6.0F, 12.0F, 12.0F, 12.0F, 0.0F, false);

            eye0.setPos(0.0F, 0.0F, 0.0F);
            eye0.texOffs(48, 40).addBox(2.5F, 12.0F, -6.5F, 4.0F, 4.0F, 4.0F, 0.0F, false);

            eye1.setPos(0.0F, 0.0F, 0.0F);
            eye1.texOffs(48, 32).addBox(-6.5F, 12.0F, -6.5F, 4.0F, 4.0F, 4.0F, 0.0F, false);

            mouth.setPos(0.0F, 0.0F, 0.0F);
            mouth.texOffs(51, 48).addBox(-2.0F, 18.0F, -6.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        }

    }

    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
    }

    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(this.outer_slime, this.inner_slime, this.eye0, this.eye1, this.mouth);
    }
}