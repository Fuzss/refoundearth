package com.itayfeder.restored_earth.blocks;

import com.itayfeder.restored_earth.entities.MelonGolem;
import com.itayfeder.restored_earth.init.BlockInit;
import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockMaterialPredicate;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class CarvedMelonBlock extends HorizontalDirectionalBlock implements Wearable {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    @Nullable
    private BlockPattern snowGolemBase;
    @Nullable
    private BlockPattern snowGolemFull;
    private static final Predicate<BlockState> MELONS_PREDICATE = (p_51396_) -> {
        return p_51396_ != null && (p_51396_.is(BlockInit.CARVED_MELON));
    };

    public CarvedMelonBlock(BlockBehaviour.Properties p_51375_) {
        super(p_51375_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));

        DispenserBlock.registerBehavior(this, new OptionalDispenseItemBehavior() {
            protected ItemStack execute(BlockSource p_123437_, ItemStack p_123438_) {
                Level level = p_123437_.getLevel();
                BlockPos blockpos = p_123437_.getPos().relative(p_123437_.getBlockState().getValue(DispenserBlock.FACING));
                CarvedMelonBlock carvedpumpkinblock = (CarvedMelonBlock)BlockInit.CARVED_MELON;
                if (level.isEmptyBlock(blockpos) && carvedpumpkinblock.canSpawnGolem(level, blockpos)) {
                    if (!level.isClientSide) {
                        level.setBlock(blockpos, carvedpumpkinblock.defaultBlockState(), 3);
                        level.gameEvent((Entity)null, GameEvent.BLOCK_PLACE, blockpos);
                    }

                    p_123438_.shrink(1);
                    this.setSuccess(true);
                } else {
                    this.setSuccess(ArmorItem.dispenseArmor(p_123437_, p_123438_));
                }

                return p_123438_;
            }
        });
    }

    public void onPlace(BlockState p_51387_, Level p_51388_, BlockPos p_51389_, BlockState p_51390_, boolean p_51391_) {
        if (!p_51390_.is(p_51387_.getBlock())) {
            this.trySpawnGolem(p_51388_, p_51389_);
        }
    }

    public boolean canSpawnGolem(LevelReader p_51382_, BlockPos p_51383_) {
        return this.getOrCreateSnowGolemBase().find(p_51382_, p_51383_) != null;
    }

    private void trySpawnGolem(Level p_51379_, BlockPos p_51380_) {
        BlockPattern.BlockPatternMatch blockpattern$blockpatternmatch = this.getOrCreateSnowGolemFull().find(p_51379_, p_51380_);
        if (blockpattern$blockpatternmatch != null) {
            for(int i = 0; i < this.getOrCreateSnowGolemFull().getHeight(); ++i) {
                BlockInWorld blockinworld = blockpattern$blockpatternmatch.getBlock(0, i, 0);
                p_51379_.setBlock(blockinworld.getPos(), Blocks.AIR.defaultBlockState(), 2);
                p_51379_.levelEvent(2001, blockinworld.getPos(), Block.getId(blockinworld.getState()));
            }

            MelonGolem snowgolem = EntityInit.MELON_GOLEM.create(p_51379_);
            BlockPos blockpos1 = blockpattern$blockpatternmatch.getBlock(0, 2, 0).getPos();
            snowgolem.moveTo((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.05D, (double)blockpos1.getZ() + 0.5D, 0.0F, 0.0F);
            p_51379_.addFreshEntity(snowgolem);

            for(ServerPlayer serverplayer : p_51379_.getEntitiesOfClass(ServerPlayer.class, snowgolem.getBoundingBox().inflate(5.0D))) {
                CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayer, snowgolem);
            }

            for(int l = 0; l < this.getOrCreateSnowGolemFull().getHeight(); ++l) {
                BlockInWorld blockinworld3 = blockpattern$blockpatternmatch.getBlock(0, l, 0);
                p_51379_.blockUpdated(blockinworld3.getPos(), Blocks.AIR);
            }
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_51377_) {
        return this.defaultBlockState().setValue(FACING, p_51377_.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_51385_) {
        p_51385_.add(FACING);
    }

    private BlockPattern getOrCreateSnowGolemBase() {
        if (this.snowGolemBase == null) {
            this.snowGolemBase = BlockPatternBuilder.start().aisle(" ", "#", "#").where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.SNOW_BLOCK))).build();
        }

        return this.snowGolemBase;
    }

    private BlockPattern getOrCreateSnowGolemFull() {
        if (this.snowGolemFull == null) {
            this.snowGolemFull = BlockPatternBuilder.start().aisle("^", "#", "#").where('^', BlockInWorld.hasState(MELONS_PREDICATE)).where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.SNOW_BLOCK))).build();
        }

        return this.snowGolemFull;
    }

}