package com.itayfeder.restored_earth.blocks;

import com.itayfeder.restored_earth.blockentities.RainbowBedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RainbowBedBlock extends BedBlock {
    public RainbowBedBlock(Properties p_49455_) {
        super(DyeColor.WHITE, p_49455_);
    }

    public BlockEntity newBlockEntity(BlockPos p_152175_, BlockState p_152176_) {
        return new RainbowBedBlockEntity(p_152175_, p_152176_);
    }
}
