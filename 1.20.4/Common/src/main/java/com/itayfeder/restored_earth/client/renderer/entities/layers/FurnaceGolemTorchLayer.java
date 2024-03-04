package com.itayfeder.restored_earth.client.renderer.entities.layers;

import com.itayfeder.restored_earth.client.renderer.entities.models.FurnaceGolemModel;
import com.itayfeder.restored_earth.entities.FurnaceGolem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.Blocks;

public class FurnaceGolemTorchLayer extends RenderLayer<FurnaceGolem, FurnaceGolemModel<FurnaceGolem>> {
    public FurnaceGolemTorchLayer(RenderLayerParent<FurnaceGolem, FurnaceGolemModel<FurnaceGolem>> p_117159_) {
        super(p_117159_);
    }

    public void render(PoseStack p_117172_, MultiBufferSource p_117173_, int p_117174_, FurnaceGolem p_117175_, float p_117176_, float p_117177_, float p_117178_, float p_117179_, float p_117180_, float p_117181_) {
        if (p_117175_.getOfferFlowerTick() != 0) {
            p_117172_.pushPose();
            ModelPart modelpart = this.getParentModel().getFlowerHoldingArm();
            modelpart.translateAndRotate(p_117172_);
            p_117172_.translate(-1.1875D, 1.0625D, -0.9375D);
            p_117172_.translate(0.5D, 0.5D, 0.5D);
            float f = 0.5F;
            p_117172_.scale(0.5F, 0.5F, 0.5F);
            p_117172_.mulPose(Vector3f.XP.rotationDegrees(-90.0F));
            p_117172_.translate(-0.5D, -0.5D, -0.5D);
            Minecraft.getInstance().getBlockRenderer().renderSingleBlock(Blocks.TORCH.defaultBlockState(), p_117172_, p_117173_, p_117174_, OverlayTexture.NO_OVERLAY);
            p_117172_.popPose();
        }
    }
}