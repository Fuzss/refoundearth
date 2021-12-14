package com.itayfeder.restored_earth.client.renderer.entities;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.layers.CluckshroomMushroomLayer;
import com.itayfeder.restored_earth.client.renderer.entities.layers.MoobloomFlowerLayer;
import com.itayfeder.restored_earth.client.renderer.entities.models.CluckshroomModel;
import com.itayfeder.restored_earth.entities.CluckshroomEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.ChickenModel;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class CluckshroomRenderer extends MobRenderer<CluckshroomEntity, CluckshroomModel<CluckshroomEntity>> {
    private static final ResourceLocation CLUCKSHROOM_LOCATION = new ResourceLocation(RestoredEarthMod.MOD_ID,"textures/entity/cluckshroom/cluckshroom.png");

    public CluckshroomRenderer(EntityRendererManager p_i47211_1_) {
        super(p_i47211_1_, new CluckshroomModel<>(), 0.3F);
        this.addLayer(new CluckshroomMushroomLayer<>(this));
    }

    public ResourceLocation getTextureLocation(CluckshroomEntity p_110775_1_) {
        return CLUCKSHROOM_LOCATION;
    }

    protected float getBob(CluckshroomEntity p_77044_1_, float p_77044_2_) {
        float f = MathHelper.lerp(p_77044_2_, p_77044_1_.oFlap, p_77044_1_.flap);
        float f1 = MathHelper.lerp(p_77044_2_, p_77044_1_.oFlapSpeed, p_77044_1_.flapSpeed);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
}