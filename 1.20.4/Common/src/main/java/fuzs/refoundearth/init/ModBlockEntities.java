package fuzs.refoundearth.init;

import com.itayfeder.restored_earth.blockentities.RainbowBedBlockEntity;
import fuzs.puzzleslib.api.init.v3.registry.RegistryManager;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {
    static final RegistryManager REGISTRY = RegistryManager.from(RefoundEarth.MOD_ID);
    public static final Holder.Reference<BlockEntityType<RainbowBedBlockEntity>> RAINBOW_BED = REGISTRY.registerBlockEntityType(
            "rainbow_bed",
            () -> BlockEntityType.Builder.of(RainbowBedBlockEntity::new, ModBlocks.RAINBOW_BED.value())
    );

    public static void touch() {

    }
}
