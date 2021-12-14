package com.itayfeder.restored_earth.blockentities;

import com.itayfeder.restored_earth.init.BlockEntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;

public class RainbowBedBlockEntity extends TileEntity {
    public RainbowBedBlockEntity() {
        super(BlockEntityInit.RAINBOW_BED);
    }

    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(this.worldPosition, 11, this.getUpdateTag());
    }
}
