package com.itayfeder.restored_earth.events;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.client.renderer.entities.FurnaceGolemRenderer;
import com.itayfeder.restored_earth.entities.FurnaceGolem;
import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockMaterialPredicate;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.function.Predicate;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BuildFurnaceGolemEventHandler {
    private static final Predicate<BlockState> PUMPKINS_PREDICATE = (p_210301_0_) -> {
        return p_210301_0_ != null && (p_210301_0_.is(Blocks.CARVED_PUMPKIN) || p_210301_0_.is(Blocks.JACK_O_LANTERN));
    };
    private static final BlockPattern furnaceGolemFull = BlockPatternBuilder.start().aisle("~^~", "#X#", "~#~").where('^', BlockInWorld.hasState(PUMPKINS_PREDICATE)).where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.IRON_BLOCK))).where('X', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.BLAST_FURNACE))).where('~', BlockInWorld.hasState(BlockMaterialPredicate.forMaterial(Material.AIR))).build();

    @SubscribeEvent
    public static void blockPlace(BlockEvent.EntityPlaceEvent event) {
        if (!event.getPlacedAgainst().is(event.getPlacedBlock().getBlock())) {
            trySpawnGolem(event.getEntity().level, event.getPos());
        }
    }

    private static void trySpawnGolem(Level p_51379_, BlockPos p_51380_) {
        BlockPattern.BlockPatternMatch blockpattern$blockpatternmatch = furnaceGolemFull.find(p_51379_, p_51380_);
        if (blockpattern$blockpatternmatch != null) {
            for(int j = 0; j < furnaceGolemFull.getWidth(); ++j) {
                for(int k = 0; k < furnaceGolemFull.getHeight(); ++k) {
                    BlockInWorld blockinworld2 = blockpattern$blockpatternmatch.getBlock(j, k, 0);
                    p_51379_.setBlock(blockinworld2.getPos(), Blocks.AIR.defaultBlockState(), 2);
                    p_51379_.levelEvent(2001, blockinworld2.getPos(), Block.getId(blockinworld2.getState()));
                }
            }

            BlockPos blockpos = blockpattern$blockpatternmatch.getBlock(1, 2, 0).getPos();
            FurnaceGolem irongolem = EntityInit.FURNACE_GOLEM.create(p_51379_);
            irongolem.setPlayerCreated(true);
            irongolem.moveTo((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.05D, (double)blockpos.getZ() + 0.5D, 0.0F, 0.0F);
            p_51379_.addFreshEntity(irongolem);

            for(ServerPlayer serverplayer1 : p_51379_.getEntitiesOfClass(ServerPlayer.class, irongolem.getBoundingBox().inflate(5.0D))) {
                CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayer1, irongolem);
            }

            for(int i1 = 0; i1 < furnaceGolemFull.getWidth(); ++i1) {
                for(int j1 = 0; j1 < furnaceGolemFull.getHeight(); ++j1) {
                    BlockInWorld blockinworld1 = blockpattern$blockpatternmatch.getBlock(i1, j1, 0);
                    p_51379_.blockUpdated(blockinworld1.getPos(), Blocks.AIR);
                }
            }
        }

    }
}
