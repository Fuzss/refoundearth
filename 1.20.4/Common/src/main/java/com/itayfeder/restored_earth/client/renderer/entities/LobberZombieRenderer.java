package com.itayfeder.restored_earth.client.renderer.entities;

import fuzs.refoundearth.RefoundEarth;
import fuzs.refoundearth.client.init.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;

public class LobberZombieRenderer extends ZombieRenderer {
    private static final ResourceLocation TEXTURE_LOCATION = RefoundEarth.id("textures/entity/lobber_zombie/lobber_zombie.png");

    public LobberZombieRenderer(EntityRendererProvider.Context context) {
        super(context, ModModelLayers.LOBBER_ZOMBIE, ModModelLayers.LOBBER_ZOMBIE_INNER_ARMOR, ModModelLayers.LOBBER_ZOMBIE_OUTER_ARMOR);
    }

    @Override
    public ResourceLocation getTextureLocation(Zombie zombie) {
        return TEXTURE_LOCATION;
    }
}
