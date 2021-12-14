package com.itayfeder.restored_earth.blocks;

import com.itayfeder.restored_earth.entities.MelonGolemEntity;
import com.itayfeder.restored_earth.init.BlockInit;
import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.pattern.BlockMaterialMatcher;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.enchantment.IArmorVanishable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class CarvedMelonBlock extends HorizontalBlock implements IArmorVanishable {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    @Nullable
    private BlockPattern snowGolemBase;
    @Nullable
    private BlockPattern snowGolemFull;
    private static final Predicate<BlockState> MELONS_PREDICATE = (p_210301_0_) -> {
        return p_210301_0_ != null && (p_210301_0_.is(BlockInit.CARVED_MELON));
    };

    public CarvedMelonBlock(AbstractBlock.Properties p_i48432_1_) {
        super(p_i48432_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public void onPlace(BlockState p_220082_1_, World p_220082_2_, BlockPos p_220082_3_, BlockState p_220082_4_, boolean p_220082_5_) {
        if (!p_220082_4_.is(p_220082_1_.getBlock())) {
            this.trySpawnGolem(p_220082_2_, p_220082_3_);
        }
    }

    public boolean canSpawnGolem(IWorldReader p_196354_1_, BlockPos p_196354_2_) {
        return this.getOrCreateSnowGolemBase().find(p_196354_1_, p_196354_2_) != null;
    }

    private void trySpawnGolem(World p_196358_1_, BlockPos p_196358_2_) {
        BlockPattern.PatternHelper blockpattern$patternhelper = this.getOrCreateSnowGolemFull().find(p_196358_1_, p_196358_2_);
        if (blockpattern$patternhelper != null) {
            for (int i = 0; i < this.getOrCreateSnowGolemFull().getHeight(); ++i) {
                CachedBlockInfo cachedblockinfo = blockpattern$patternhelper.getBlock(0, i, 0);
                p_196358_1_.setBlock(cachedblockinfo.getPos(), Blocks.AIR.defaultBlockState(), 2);
                p_196358_1_.levelEvent(2001, cachedblockinfo.getPos(), Block.getId(cachedblockinfo.getState()));
            }

            MelonGolemEntity snowgolementity = EntityInit.MELON_GOLEM.create(p_196358_1_);
            BlockPos blockpos1 = blockpattern$patternhelper.getBlock(0, 2, 0).getPos();
            snowgolementity.moveTo((double) blockpos1.getX() + 0.5D, (double) blockpos1.getY() + 0.05D, (double) blockpos1.getZ() + 0.5D, 0.0F, 0.0F);
            p_196358_1_.addFreshEntity(snowgolementity);

            for (ServerPlayerEntity serverplayerentity : p_196358_1_.getEntitiesOfClass(ServerPlayerEntity.class, snowgolementity.getBoundingBox().inflate(5.0D))) {
                CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayerentity, snowgolementity);
            }

            for (int l = 0; l < this.getOrCreateSnowGolemFull().getHeight(); ++l) {
                CachedBlockInfo cachedblockinfo3 = blockpattern$patternhelper.getBlock(0, l, 0);
                p_196358_1_.blockUpdated(cachedblockinfo3.getPos(), Blocks.AIR);
            }
        }
    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING);
    }

    private BlockPattern getOrCreateSnowGolemBase() {
        if (this.snowGolemBase == null) {
            this.snowGolemBase = BlockPatternBuilder.start().aisle(" ", "#", "#").where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.SNOW_BLOCK))).build();
        }

        return this.snowGolemBase;
    }

    private BlockPattern getOrCreateSnowGolemFull() {
        if (this.snowGolemFull == null) {
            this.snowGolemFull = BlockPatternBuilder.start().aisle("^", "#", "#").where('^', CachedBlockInfo.hasState(MELONS_PREDICATE)).where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.SNOW_BLOCK))).build();
        }

        return this.snowGolemFull;
    }
}