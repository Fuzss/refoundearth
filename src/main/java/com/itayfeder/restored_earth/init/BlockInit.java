package com.itayfeder.restored_earth.init;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.blocks.CarvedMelonBlock;
import com.itayfeder.restored_earth.blocks.RainbowBedBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.DyeColor;
import net.minecraft.potion.Effects;
import net.minecraft.state.properties.BedPart;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    public static final Block MUD = new FlowingFluidBlock(FluidInit.MUD, AbstractBlock.Properties.of(Material.WATER).noCollission().strength(100.0F).noDrops());
    public static final Block RAINBOW_WOOL = new Block(AbstractBlock.Properties.of(Material.WOOL, MaterialColor.COLOR_ORANGE).strength(0.8F).sound(SoundType.WOOL));
    public static final Block RAINBOW_CARPET = new CarpetBlock(DyeColor.BLACK, AbstractBlock.Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_ORANGE).strength(0.1F).sound(SoundType.WOOL));
    public static final Block RAINBOW_BED = new RainbowBedBlock(AbstractBlock.Properties.of(Material.WOOL, (p_152613_) -> {
        return p_152613_.getValue(BedBlock.PART) == BedPart.FOOT ? MaterialColor.COLOR_ORANGE : MaterialColor.WOOL;
    }).sound(SoundType.WOOD).strength(0.2F).noOcclusion());

    public static final Block BUTTERCUP = new FlowerBlock(Effects.ABSORPTION, 5, AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS));
    public static final Block PINK_DAISY = new FlowerBlock(Effects.REGENERATION, 5, AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS));

    public static final Block CARVED_MELON = new CarvedMelonBlock(AbstractBlock.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_LIGHT_GREEN).strength(1.0F).sound(SoundType.WOOD).isValidSpawn(BlockInit::always));

    public static void register(IForgeRegistry<Block> registry, Block block, String id) {
        block.setRegistryName(new ResourceLocation(RestoredEarthMod.MOD_ID, id));
        registry.register(block);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> registry) {
        register(registry.getRegistry(), MUD, "mud");

        register(registry.getRegistry(), RAINBOW_WOOL, "rainbow_wool");
        register(registry.getRegistry(), RAINBOW_CARPET, "rainbow_carpet");
        register(registry.getRegistry(), RAINBOW_BED, "rainbow_bed");

        register(registry.getRegistry(), BUTTERCUP, "buttercup");
        register(registry.getRegistry(), PINK_DAISY, "pink_daisy");

        register(registry.getRegistry(), CARVED_MELON, "carved_melon");
    }











    private static Boolean always(BlockState p_50810_, IBlockReader p_50811_, BlockPos p_50812_, EntityType<?> p_50813_) {
        return (boolean)true;
    }
}
