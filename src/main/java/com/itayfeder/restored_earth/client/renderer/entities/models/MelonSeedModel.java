package com.itayfeder.restored_earth.client.renderer.entities.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.LlamaSpitModel;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MelonSeedModel<T extends Entity> extends LlamaSpitModel<T> {
    private final ModelRenderer body = new ModelRenderer(this);

    public MelonSeedModel() {
        this.body.texOffs(0, 0).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F);
        this.body.setPos(0.0F, 0.0F, 0.0F);

    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(this.body);
    }


}