package com.itayfeder.restored_earth.init;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.blockentities.RainbowBedBlockEntity;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockEntityInit {
    public static final BlockEntityType<RainbowBedBlockEntity> RAINBOW_BED = BlockEntityType.Builder.of(RainbowBedBlockEntity::new, BlockInit.RAINBOW_BED)
            .build(Util.fetchChoiceType(References.BLOCK_ENTITY, new ResourceLocation(RestoredEarthMod.MOD_ID, "rainbow_bed").toString()));


    @SubscribeEvent
    public static void registerEntity(RegistryEvent.Register<BlockEntityType<?>> event) {
        event.getRegistry().register(RAINBOW_BED.setRegistryName("rainbow_bed"));
    }
}
