package fuzs.refoundearth.world.level.block;

import com.itayfeder.restored_earth.blockentities.RainbowBedBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RainbowBedBlock extends BedBlock {
    public static final MapCodec<BedBlock> CODEC = simpleCodec(RainbowBedBlock::new);

    public RainbowBedBlock(Properties properties) {
        super(DyeColor.WHITE, properties);
    }

    @Override
    public MapCodec<BedBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new RainbowBedBlockEntity(blockPos, blockState);
    }
}
