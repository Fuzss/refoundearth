package com.itayfeder.restored_earth.client.renderer.entities.layers;

import com.itayfeder.restored_earth.client.renderer.entities.models.CluckshroomModel;
import com.itayfeder.restored_earth.entities.Cluckshroom;
import com.itayfeder.restored_earth.entities.Moobloom;
import com.itayfeder.restored_earth.init.BlockInit;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class CluckshroomMushroomLayer <T extends Cluckshroom> extends RenderLayer<T, CluckshroomModel<T>> {
    public CluckshroomMushroomLayer(RenderLayerParent<T, CluckshroomModel<T>> p_117243_) {
        super(p_117243_);
    }

    public void render(PoseStack p_117256_, MultiBufferSource p_117257_, int p_117258_, T p_117259_, float p_117260_, float p_117261_, float p_117262_, float p_117263_, float p_117264_, float p_117265_) {
        if (!p_117259_.isBaby()) {
            Minecraft minecraft = Minecraft.getInstance();
            boolean flag = minecraft.shouldEntityAppearGlowing(p_117259_) && p_117259_.isInvisible();
            if (!p_117259_.isInvisible() || flag) {
                BlockRenderDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRenderer();
                BlockState blockstate = Blocks.RED_MUSHROOM.defaultBlockState();
                int i = LivingEntityRenderer.getOverlayCoords(p_117259_, 0.0F);
                p_117256_.pushPose();
                p_117256_.translate((double)-0.05F, (double)0.45F, 0.1D);
                p_117256_.mulPose(Vector3f.YP.rotationDegrees(-78.5F));
                p_117256_.scale(-0.75F, -0.75F, 0.75F);
                p_117256_.translate(-0.5D, -0.5D, -0.5D);
                blockrendererdispatcher.renderSingleBlock(blockstate, p_117256_, p_117257_, p_117258_, i);
                p_117256_.popPose();
                p_117256_.pushPose();
                this.getParentModel().getHead().translateAndRotate(p_117256_);
                p_117256_.translate(0.05D, (double)-0.7F, -0.05D);
                //p_225628_1_.mulPose(Vector3f.YP.rotationDegrees(-78.0F));
                p_117256_.scale(-0.75F, -0.75F, 0.75F);
                p_117256_.translate(-0.5D, -0.5D, -0.5D);
                blockrendererdispatcher.renderSingleBlock(blockstate, p_117256_, p_117257_, p_117258_, i);
                p_117256_.popPose();
            }
        }
    }
}
