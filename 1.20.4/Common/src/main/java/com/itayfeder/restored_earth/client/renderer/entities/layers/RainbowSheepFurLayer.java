package com.itayfeder.restored_earth.client.renderer.entities.layers;

import fuzs.refoundearth.client.init.ModModelLayers;
import com.itayfeder.restored_earth.client.renderer.entities.models.RainbowSheepModel;
import com.itayfeder.restored_earth.client.renderer.entities.models.layers.RainbowSheepFurModel;
import fuzs.refoundearth.world.entity.animal.RainbowSheep;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class RainbowSheepFurLayer extends RenderLayer<RainbowSheep, RainbowSheepModel<RainbowSheep>> {
    private static final ResourceLocation RAINBOW_SHEEP_FUR_LOCATION = new ResourceLocation(RefoundEarth.MOD_ID,"textures/entity/rainbow_sheep/rainbow_sheep_fur.png");
    private final RainbowSheepFurModel<RainbowSheep> model;

    public RainbowSheepFurLayer(RenderLayerParent<RainbowSheep, RainbowSheepModel<RainbowSheep>> p_174533_, EntityModelSet p_174534_) {
        super(p_174533_);
        this.model = new RainbowSheepFurModel<>(p_174534_.bakeLayer(ModModelLayers.RAINBOW_SHEEP_FUR));
    }

    public void render(PoseStack p_117421_, MultiBufferSource p_117422_, int p_117423_, RainbowSheep p_117424_, float p_117425_, float p_117426_, float p_117427_, float p_117428_, float p_117429_, float p_117430_) {
        if (!p_117424_.isSheared()) {
            if (p_117424_.isInvisible()) {
                Minecraft minecraft = Minecraft.getInstance();
                boolean flag = minecraft.shouldEntityAppearGlowing(p_117424_);
                if (flag) {
                    this.getParentModel().copyPropertiesTo(this.model);
                    this.model.prepareMobModel(p_117424_, p_117425_, p_117426_, p_117427_);
                    this.model.setupAnim(p_117424_, p_117425_, p_117426_, p_117428_, p_117429_, p_117430_);
                    VertexConsumer vertexconsumer = p_117422_.getBuffer(RenderType.outline(RAINBOW_SHEEP_FUR_LOCATION));
                    this.model.renderToBuffer(p_117421_, vertexconsumer, p_117423_, LivingEntityRenderer.getOverlayCoords(p_117424_, 0.0F), 0.0F, 0.0F, 0.0F, 1.0F);
                }

            } else {

                coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, RAINBOW_SHEEP_FUR_LOCATION, p_117421_, p_117422_, p_117423_, p_117424_, p_117425_, p_117426_, p_117428_, p_117429_, p_117430_, p_117427_, 1.0F, 1.0F, 1.0F);
            }
        }
    }
}