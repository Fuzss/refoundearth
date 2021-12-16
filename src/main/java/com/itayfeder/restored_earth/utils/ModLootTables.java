package com.itayfeder.restored_earth.utils;

import com.google.common.collect.Sets;
import com.itayfeder.restored_earth.RestoredEarthMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public class ModLootTables {
    public static final ResourceLocation SHEEP_RAINBOW = new ResourceLocation(RestoredEarthMod.MOD_ID,"entities/sheep/rainbow");
    public static final ResourceLocation COW_WOOLY = new ResourceLocation(RestoredEarthMod.MOD_ID,"entities/cow/wooly");
}
