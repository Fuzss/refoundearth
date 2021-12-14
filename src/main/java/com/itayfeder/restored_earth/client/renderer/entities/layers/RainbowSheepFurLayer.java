package com.itayfeder.restored_earth.client.renderer.entities.layers;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.models.RainbowSheepModel;
import com.itayfeder.restored_earth.client.renderer.entities.models.layers.RainbowSheepFurModel;
import com.itayfeder.restored_earth.entities.RainbowSheepEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.SheepModel;
import net.minecraft.client.renderer.entity.model.SheepWoolModel;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.util.ResourceLocation;

public class RainbowSheepFurLayer extends LayerRenderer<RainbowSheepEntity, RainbowSheepModel<RainbowSheepEntity>> {
    private static final ResourceLocation RAINBOW_SHEEP_FUR_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/rainbow_sheep/rainbow_sheep_fur.png");
    private final RainbowSheepFurModel<RainbowSheepEntity> model = new RainbowSheepFurModel<>();

    public RainbowSheepFurLayer(IEntityRenderer<RainbowSheepEntity, RainbowSheepModel<RainbowSheepEntity>> p_i50925_1_) {
        super(p_i50925_1_);
    }

    public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, RainbowSheepEntity p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
        if (!p_225628_4_.isSheared() && !p_225628_4_.isInvisible()) {
            coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, RAINBOW_SHEEP_FUR_LOCATION, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, 1.0F, 1.0F, 1.0F);
        }
    }
}