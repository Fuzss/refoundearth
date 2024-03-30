package fuzs.refoundearth.init;

import fuzs.puzzleslib.api.init.v3.registry.RegistryManager;
import fuzs.refoundearth.RefoundEarth;
import fuzs.refoundearth.world.level.block.CarvedMelonBlock;
import fuzs.refoundearth.world.level.block.RainbowBedBlock;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {
    static final RegistryManager REGISTRY = RegistryManager.from(RefoundEarth.MOD_ID);
    public static final Holder.Reference<Block> MUD = REGISTRY.registerBlock("mud",
            () -> new LiquidBlock((FlowingFluid) ModFluids.MUD.value(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).mapColor(MapColor.TERRACOTTA_BROWN)
            )
    );
    public static final Holder.Reference<Block> RAINBOW_WOOL = REGISTRY.registerBlock("rainbow_wool",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL))
    );
    public static final Holder.Reference<Block> RAINBOW_CARPET = REGISTRY.registerBlock("rainbow_carpet",
            () -> new CarpetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CARPET))
    );
    public static final Holder.Reference<Block> RAINBOW_BED = REGISTRY.registerBlock("rainbow_bed",
            () -> new RainbowBedBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_BED)
                    .mapColor(blockState -> blockState.getValue(BedBlock.PART) == BedPart.FOOT ?
                            MapColor.COLOR_ORANGE :
                            MapColor.WOOL))
    );
    public static final Holder.Reference<Block> BUTTERCUP = REGISTRY.registerBlock("buttercup",
            () -> new FlowerBlock(MobEffects.ABSORPTION, 5, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION))
    );
    public static final Holder.Reference<Block> PINK_DAISY = REGISTRY.registerBlock("pink_daisy",
            () -> new FlowerBlock(MobEffects.REGENERATION, 5, BlockBehaviour.Properties.ofFullCopy(Blocks.OXEYE_DAISY))
    );
    public static final Holder.Reference<Block> CARVED_MELON = REGISTRY.registerBlock("carved_melon",
            () -> new CarvedMelonBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MELON).isValidSpawn(Blocks::always))
    );

    public static void touch() {

    }
}
