package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.init.BlockInit;
import com.itayfeder.restored_earth.init.EntityInit;
import com.itayfeder.restored_earth.init.ItemInit;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IShearable;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SuspiciousStewItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Optional;
import java.util.UUID;

public class MoobloomEntity extends CowEntity implements IShearable, net.minecraftforge.common.IForgeShearable {
    private Effect effect;
    private int effectDuration;
    private UUID lastLightningBoltUUID;

    public MoobloomEntity(EntityType<? extends MoobloomEntity> p_i50257_1_, World p_i50257_2_) {
        super(p_i50257_1_, p_i50257_2_);
    }

    public float getWalkTargetValue(BlockPos p_205022_1_, IWorldReader p_205022_2_) {
        return p_205022_2_.getBlockState(p_205022_1_.below()).is(Blocks.GRASS_BLOCK) ? 10.0F : p_205022_2_.getBrightness(p_205022_1_) - 0.5F;
    }

    public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
        if (itemstack.getItem() == Items.BOWL && !this.isBaby()) {
            boolean flag = false;
            ItemStack itemstack1;
            FlowerBlock block = (FlowerBlock)BlockInit.BUTTERCUP;
            itemstack1 = new ItemStack(Items.SUSPICIOUS_STEW);
            SuspiciousStewItem.saveMobEffect(itemstack1, block.getSuspiciousStewEffect(), block.getEffectDuration());

            ItemStack itemstack2 = DrinkHelper.createFilledResult(itemstack, p_230254_1_, itemstack1, false);
            p_230254_1_.setItemInHand(p_230254_2_, itemstack2);
            SoundEvent soundevent;
            if (flag) {
                soundevent = SoundEvents.MOOSHROOM_MILK_SUSPICIOUSLY;
            } else {
                soundevent = SoundEvents.MOOSHROOM_MILK;
            }

            this.playSound(soundevent, 1.0F, 1.0F);
            return ActionResultType.sidedSuccess(this.level.isClientSide);
        } else if (false && itemstack.getItem() == Items.SHEARS && this.readyForShearing()) { //Forge: Moved to onSheared
            this.shear(SoundCategory.PLAYERS);
            if (!this.level.isClientSide) {
                itemstack.hurtAndBreak(1, p_230254_1_, (p_213442_1_) -> {
                    p_213442_1_.broadcastBreakEvent(p_230254_2_);
                });
            }

            return ActionResultType.sidedSuccess(this.level.isClientSide);
        } else {
            return super.mobInteract(p_230254_1_, p_230254_2_);
        }
    }

    public void shear(SoundCategory p_230263_1_) {
        this.level.playSound((PlayerEntity)null, this, SoundEvents.MOOSHROOM_SHEAR, p_230263_1_, 1.0F, 1.0F);
        if (!this.level.isClientSide()) {
            ((ServerWorld)this.level).sendParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(0.5D), this.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
            this.remove();
            CowEntity cowentity = EntityType.COW.create(this.level);
            cowentity.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, this.xRot);
            cowentity.setHealth(this.getHealth());
            cowentity.yBodyRot = this.yBodyRot;
            if (this.hasCustomName()) {
                cowentity.setCustomName(this.getCustomName());
                cowentity.setCustomNameVisible(this.isCustomNameVisible());
            }

            if (this.isPersistenceRequired()) {
                cowentity.setPersistenceRequired();
            }

            cowentity.setInvulnerable(this.isInvulnerable());
            this.level.addFreshEntity(cowentity);

            for(int i = 0; i < 5; ++i) {
                this.level.addFreshEntity(new ItemEntity(this.level, this.getX(), this.getY(1.0D), this.getZ(), new ItemStack(ItemInit.BUTTERCUP)));
            }
        }

    }

    public boolean readyForShearing() {
        return this.isAlive() && !this.isBaby();
    }

    @Override
    public boolean isShearable(@javax.annotation.Nonnull ItemStack item, World world, BlockPos pos) {
        return readyForShearing();
    }

    @javax.annotation.Nonnull
    @Override
    public java.util.List<ItemStack> onSheared(@javax.annotation.Nullable PlayerEntity player, @javax.annotation.Nonnull ItemStack item, World world, BlockPos pos, int fortune) {
        world.playSound(null, this, SoundEvents.MOOSHROOM_SHEAR, player == null ? SoundCategory.BLOCKS : SoundCategory.PLAYERS, 1.0F, 1.0F);
        if (!world.isClientSide()) {
            ((ServerWorld)this.level).sendParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(0.5D), this.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
            this.remove();
            CowEntity cowentity = EntityType.COW.create(this.level);
            cowentity.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, this.xRot);
            cowentity.setHealth(this.getHealth());
            cowentity.yBodyRot = this.yBodyRot;
            if (this.hasCustomName()) {
                cowentity.setCustomName(this.getCustomName());
                cowentity.setCustomNameVisible(this.isCustomNameVisible());
            }

            if (this.isPersistenceRequired()) {
                cowentity.setPersistenceRequired();
            }

            cowentity.setInvulnerable(this.isInvulnerable());
            this.level.addFreshEntity(cowentity);

            java.util.List<ItemStack> items = new java.util.ArrayList<>();
            for (int i = 0; i < 5; ++i) {
                items.add(new ItemStack(ItemInit.BUTTERCUP));
            }

            return items;
        }
        return java.util.Collections.emptyList();
    }

    @Override
    public MoobloomEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return EntityInit.MOOBLOOM.create(p_241840_1_);
    }
}
