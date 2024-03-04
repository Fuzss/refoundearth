package com.itayfeder.restored_earth.utils;

import com.itayfeder.restored_earth.RestoredEarthMod;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.material.Fluid;

public class ModTags {
    public static class Fluids {
        public static final Tag.Named<Fluid> MUD = register("mud");

        private static Tag.Named<Fluid> register(String name) {
            return FluidTags.bind(RestoredEarthMod.MOD_ID + ":" + name);
        }
    }
}
