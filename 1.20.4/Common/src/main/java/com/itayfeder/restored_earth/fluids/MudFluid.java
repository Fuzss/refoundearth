package com.itayfeder.restored_earth.fluids;

import fuzs.refoundearth.init.ModItems;
import fuzs.refoundearth.init.ModBlocks;
import fuzs.refoundearth.init.ModFluids;
import fuzs.refoundearth.init.ModGameRules;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraftforge.fluids.FluidAttributes;

public abstract class MudFluid extends WaterFluid {

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_MUD;
    }

    @Override
    public Fluid getSource() {
        return ModFluids.MUD;
    }

    @Override
    public Item getBucket() {
        return ModItems.MUD_BUCKET.value();
    }

    @Override
    protected boolean canConvertToSource(Level level) {
        return level.getGameRules().getBoolean(ModGameRules.MUD_SOURCE_CONVERSION);
    }

    @Override
    public BlockState createLegacyBlock(FluidState p_76466_) {
        return ModBlocks.MUD.defaultBlockState().setValue(LiquidBlock.LEVEL, Integer.valueOf(getLegacyLevel(p_76466_)));
    }

    @Override
    public boolean isSame(Fluid fluid) {
        return fluid == ModFluids.MUD || fluid == ModFluids.FLOWING_MUD;
    }

    @Override
    public int getTickDelay(LevelReader level) {
        return 15;
    }

    @Override
    protected FluidAttributes createAttributes() {
        return FluidAttributes.builder(new ResourceLocation(RefoundEarth.MOD_ID, "block/mud_still"),
                new ResourceLocation(RefoundEarth.MOD_ID, "block/mud_flow")).density(1000).viscosity(2000).build(this);
    }

    public static class Flowing extends MudFluid {
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState fluidState) {
            return fluidState.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return false;
        }
    }

    public static class Source extends MudFluid {
        @Override
        public int getAmount(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return true;
        }
    }
}
