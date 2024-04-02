package com.itayfeder.restored_earth.client.renderer.entities;

import fuzs.refoundearth.world.entity.projectile.MelonSeed;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import fuzs.refoundearth.RefoundEarth;
import fuzs.refoundearth.client.init.ModModelLayers;
import net.minecraft.client.model.LlamaSpitModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

/**
 * Copied from {@link net.minecraft.client.renderer.entity.LlamaSpitRenderer}.
 */
public class MelonSeedRenderer extends EntityRenderer<MelonSeed> {
    private static final ResourceLocation MELON_SEED_LOCATION = RefoundEarth.id("textures/entity/melon_golem/melon_seed.png");

    private final LlamaSpitModel<MelonSeed> model;

    public MelonSeedRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new LlamaSpitModel<>(context.bakeLayer(ModModelLayers.MELON_SEED));
    }

    @Override
    public void render(MelonSeed melonSeed, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.translate(0.0, 0.15, 0.0);
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, melonSeed.yRotO, melonSeed.getYRot()) - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTick, melonSeed.xRotO, melonSeed.getXRot())));
        this.model.setupAnim(melonSeed, partialTick, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = buffer.getBuffer(this.model.renderType(this.getTextureLocation(melonSeed)));
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();
        super.render(melonSeed, entityYaw, partialTick, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(MelonSeed melonSeed) {
        return MELON_SEED_LOCATION;
    }
}