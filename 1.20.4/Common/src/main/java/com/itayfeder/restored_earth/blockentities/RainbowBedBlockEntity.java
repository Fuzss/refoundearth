package com.itayfeder.restored_earth.blockentities;

import fuzs.refoundearth.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RainbowBedBlockEntity extends BlockEntity {
    public RainbowBedBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(ModBlockEntities.RAINBOW_BED, p_155229_, p_155230_);
    }
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

}
