package com.itayfeder.restored_earth.init;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.blockentities.RainbowBedBlockEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockEntityInit {
    public static final TileEntityType<RainbowBedBlockEntity> RAINBOW_BED = TileEntityType.Builder.of(RainbowBedBlockEntity::new, BlockInit.RAINBOW_BED)
            .build(Util.fetchChoiceType(TypeReferences.BLOCK_ENTITY, new ResourceLocation(RestoredEarthMod.MOD_ID, "rainbow_bed").toString()));


    @SubscribeEvent
    public static void registerEntity(RegistryEvent.Register<TileEntityType<?>> event) {
        event.getRegistry().register(RAINBOW_BED.setRegistryName("rainbow_bed"));
    }
}
