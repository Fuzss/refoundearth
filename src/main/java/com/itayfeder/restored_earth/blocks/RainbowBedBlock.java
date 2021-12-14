package com.itayfeder.restored_earth.blocks;

import com.itayfeder.restored_earth.blockentities.RainbowBedBlockEntity;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class RainbowBedBlock extends BedBlock {
    public RainbowBedBlock(Properties p_49455_) {
        super(DyeColor.WHITE, p_49455_);
    }

    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new RainbowBedBlockEntity();
    }
}
