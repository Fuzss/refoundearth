package com.itayfeder.restored_earth.fluids;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.init.BlockInit;
import com.itayfeder.restored_earth.init.FluidInit;
import com.itayfeder.restored_earth.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidAttributes;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class MudFluid extends FlowingFluid {
    public MudFluid() {
    }

    public Fluid getFlowing() {
        return FluidInit.FLOWING_MUD;
    }

    public Fluid getSource() {
        return FluidInit.MUD;
    }

    public Item getBucket() {
        return ItemInit.MUD_BUCKET;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(World p_204522_1_, BlockPos p_204522_2_, FluidState p_204522_3_, Random p_204522_4_) {
        if (!p_204522_3_.isSource() && !(Boolean)p_204522_3_.getValue(FALLING)) {
            if (p_204522_4_.nextInt(64) == 0) {
                p_204522_1_.playLocalSound((double)p_204522_2_.getX() + 0.5D, (double)p_204522_2_.getY() + 0.5D, (double)p_204522_2_.getZ() + 0.5D, SoundEvents.WATER_AMBIENT, SoundCategory.BLOCKS, p_204522_4_.nextFloat() * 0.25F + 0.75F, p_204522_4_.nextFloat() + 0.5F, false);
            }
        } else if (p_204522_4_.nextInt(10) == 0) {
            p_204522_1_.addParticle(ParticleTypes.UNDERWATER, (double)p_204522_2_.getX() + p_204522_4_.nextDouble(), (double)p_204522_2_.getY() + p_204522_4_.nextDouble(), (double)p_204522_2_.getZ() + p_204522_4_.nextDouble(), 0.0D, 0.0D, 0.0D);
        }

    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public IParticleData getDripParticle() {
        return ParticleTypes.DRIPPING_WATER;
    }

    protected boolean canConvertToSource() {
        return true;
    }

    protected void beforeDestroyingBlock(IWorld p_205580_1_, BlockPos p_205580_2_, BlockState p_205580_3_) {
        TileEntity tileentity = p_205580_3_.hasTileEntity() ? p_205580_1_.getBlockEntity(p_205580_2_) : null;
        Block.dropResources(p_205580_3_, p_205580_1_, p_205580_2_, tileentity);
    }

    public int getSlopeFindDistance(IWorldReader p_185698_1_) {
        return 4;
    }

    public BlockState createLegacyBlock(FluidState p_204527_1_) {
        return (BlockState) BlockInit.MUD.defaultBlockState().setValue(FlowingFluidBlock.LEVEL, getLegacyLevel(p_204527_1_));
    }

    public boolean isSame(Fluid p_207187_1_) {
        return p_207187_1_ == FluidInit.MUD || p_207187_1_ == FluidInit.FLOWING_MUD;
    }

    public int getDropOff(IWorldReader p_204528_1_) {
        return 1;
    }

    public int getTickDelay(IWorldReader p_205569_1_) {
        return 15;
    }

    public boolean canBeReplacedWith(FluidState p_215665_1_, IBlockReader p_215665_2_, BlockPos p_215665_3_, Fluid p_215665_4_, Direction p_215665_5_) {
        return p_215665_5_ == Direction.DOWN && !p_215665_4_.is(FluidTags.WATER);
    }
    @Override
    protected FluidAttributes createAttributes() {
        return FluidAttributes.builder(new ResourceLocation(RestoredEarthMod.MOD_ID, "block/mud_still"),
                new ResourceLocation(RestoredEarthMod.MOD_ID, "block/mud_flow")).density(1000).viscosity(2000).build(this);
    }


    protected float getExplosionResistance() {
        return 100.0F;
    }

    public static class Source extends MudFluid {
        public Source() {
        }

        public int getAmount(FluidState p_207192_1_) {
            return 8;
        }

        public boolean isSource(FluidState p_207193_1_) {
            return true;
        }
    }

    public static class Flowing extends MudFluid {
        public Flowing() {
        }

        protected void createFluidStateDefinition(StateContainer.Builder<Fluid, FluidState> p_207184_1_) {
            super.createFluidStateDefinition(p_207184_1_);
            p_207184_1_.add(new Property[]{LEVEL});
        }

        public int getAmount(FluidState p_207192_1_) {
            return (Integer)p_207192_1_.getValue(LEVEL);
        }

        public boolean isSource(FluidState p_207193_1_) {
            return false;
        }
    }
}