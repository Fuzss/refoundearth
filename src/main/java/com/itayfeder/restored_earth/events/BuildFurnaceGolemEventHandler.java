package com.itayfeder.restored_earth.events;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.entities.FurnaceGolemEntity;
import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.pattern.BlockMaterialMatcher;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.function.Predicate;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BuildFurnaceGolemEventHandler {
    @Nullable
    private static BlockPattern furnaceGolemBase;
    @Nullable
    private static BlockPattern furnaceGolemFull;
    private static final Predicate<BlockState> PUMPKINS_PREDICATE = (p_210301_0_) -> {
        return p_210301_0_ != null && (p_210301_0_.is(Blocks.CARVED_PUMPKIN) || p_210301_0_.is(Blocks.JACK_O_LANTERN));
    };

    @SubscribeEvent
    public static void blockPlace(BlockEvent.EntityPlaceEvent event) {
        if (!event.getPlacedAgainst().is(event.getPlacedBlock().getBlock())) {
            trySpawnGolem(event.getEntity().level, event.getPos());
        }
    }

    private static void trySpawnGolem(World p_196358_1_, BlockPos p_196358_2_) {
        BlockPattern.PatternHelper blockpattern$patternhelper = getOrCreateFurnaceGolemFull().find(p_196358_1_, p_196358_2_);
        if (blockpattern$patternhelper != null) {
            for(int j = 0; j < getOrCreateFurnaceGolemFull().getWidth(); ++j) {
                for(int k = 0; k < getOrCreateFurnaceGolemFull().getHeight(); ++k) {
                    CachedBlockInfo cachedblockinfo2 = blockpattern$patternhelper.getBlock(j, k, 0);
                    p_196358_1_.setBlock(cachedblockinfo2.getPos(), Blocks.AIR.defaultBlockState(), 2);
                    p_196358_1_.levelEvent(2001, cachedblockinfo2.getPos(), Block.getId(cachedblockinfo2.getState()));
                }
            }

            BlockPos blockpos = blockpattern$patternhelper.getBlock(1, 2, 0).getPos();
            FurnaceGolemEntity furnacegolementity = EntityInit.FURNACE_GOLEM.create(p_196358_1_);
            furnacegolementity.setPlayerCreated(true);
            furnacegolementity.moveTo((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.05D, (double)blockpos.getZ() + 0.5D, 0.0F, 0.0F);
            p_196358_1_.addFreshEntity(furnacegolementity);

            for(ServerPlayerEntity serverplayerentity1 : p_196358_1_.getEntitiesOfClass(ServerPlayerEntity.class, furnacegolementity.getBoundingBox().inflate(5.0D))) {
                CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayerentity1, furnacegolementity);
            }

            for(int i1 = 0; i1 < getOrCreateFurnaceGolemFull().getWidth(); ++i1) {
                for(int j1 = 0; j1 < getOrCreateFurnaceGolemFull().getHeight(); ++j1) {
                    CachedBlockInfo cachedblockinfo1 = blockpattern$patternhelper.getBlock(i1, j1, 0);
                    p_196358_1_.blockUpdated(cachedblockinfo1.getPos(), Blocks.AIR);
                }
            }
        }

    }

    private static BlockPattern getOrCreateFurnaceGolemBase() {
        if (furnaceGolemBase == null) {
            furnaceGolemBase = BlockPatternBuilder.start().aisle("~ ~", "#X#", "~#~").where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.IRON_BLOCK))).where('X', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.BLAST_FURNACE))).where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }

        return furnaceGolemBase;
    }

    private static BlockPattern getOrCreateFurnaceGolemFull() {
        if (furnaceGolemFull == null) {
            furnaceGolemFull = BlockPatternBuilder.start().aisle("~^~", "#X#", "~#~").where('^', CachedBlockInfo.hasState(PUMPKINS_PREDICATE)).where('X', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.BLAST_FURNACE))).where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.IRON_BLOCK))).where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }

        return furnaceGolemFull;
    }
}
