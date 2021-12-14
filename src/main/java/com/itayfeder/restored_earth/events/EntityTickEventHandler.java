package com.itayfeder.restored_earth.events;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.entities.MuddyPigEntity;
import com.itayfeder.restored_earth.fluids.MudFluid;
import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.pattern.BlockMaterialMatcher;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.CachedBlockInfo;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.UUID;
import java.util.function.Predicate;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EntityTickEventHandler {
    @Nullable
    private static BlockPattern fishPondPattern;
    private static final Predicate<BlockState> NOT_WATER_PREDICATE = (p_210301_0_) -> {
        return p_210301_0_ != null && !p_210301_0_.is(Blocks.WATER);
    };

    @SubscribeEvent
    public static void livingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntityLiving().getType() == EntityType.PIG) {
            PigEntity pig = (PigEntity) event.getEntityLiving();
            if (pig.level.getFluidState(pig.blockPosition()).getType() instanceof MudFluid) {
                CompoundNBT tag = new CompoundNBT();
                MuddyPigEntity newPig = EntityInit.MUDDY_PIG.create(pig.level);
                pig.save(tag);
                newPig.load(tag);
                newPig.setUUID(UUID.randomUUID());
                pig.remove();
                event.getEntityLiving().level.addFreshEntity(newPig);
            }
        }
        if (event.getEntityLiving().getType() == EntityInit.MUDDY_PIG) {
            MuddyPigEntity pig = (MuddyPigEntity) event.getEntityLiving();
            if (pig.level.getFluidState(pig.blockPosition()).getType() instanceof WaterFluid) {
                CompoundNBT tag = new CompoundNBT();
                PigEntity newPig = EntityType.PIG.create(pig.level);
                pig.save(tag);
                newPig.load(tag);
                newPig.setUUID(UUID.randomUUID());
                pig.remove();
                event.getEntityLiving().level.addFreshEntity(newPig);
            }
        }

        if (event.getEntityLiving().getType() == EntityType.PLAYER) {
            BlockPattern.PatternHelper blockpattern$patternhelper = getOrCreateFurnaceGolemFull().find(event.getEntity().level, event.getEntity().blockPosition());
            if (blockpattern$patternhelper != null) {
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            }
        }
    }

    private static BlockPattern getOrCreateFurnaceGolemFull() {
        if (fishPondPattern == null) {
            fishPondPattern = BlockPatternBuilder.start().aisle(" ~~~ ", "~XXX~", "~XXX~", "~XXX~", " ~~~ ").where('~', CachedBlockInfo.hasState(NOT_WATER_PREDICATE)).where('X', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.WATER))).build();
        }

        return fishPondPattern;
    }
}
