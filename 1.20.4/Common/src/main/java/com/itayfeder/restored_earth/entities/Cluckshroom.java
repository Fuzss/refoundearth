package com.itayfeder.restored_earth.entities;

import fuzs.refoundearth.init.ModEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Shearable;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class Cluckshroom extends Chicken implements Shearable, net.minecraftforge.common.IForgeShearable {
    public Cluckshroom(EntityType<? extends Chicken> p_28236_, Level p_28237_) {
        super(p_28236_, p_28237_);
    }

    public Cluckshroom getBreedOffspring(ServerLevel p_148884_, AgeableMob p_148885_) {
        return ModEntityTypes.CLUCKSHROOM.create(p_148884_);
    }

    public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
        if (false && itemstack.getItem() == Items.SHEARS && this.readyForShearing()) { //Forge: Moved to onSheared
            this.shear(SoundSource.PLAYERS);
            if (!this.level.isClientSide) {
                itemstack.hurtAndBreak(1, p_230254_1_, (p_213442_1_) -> {
                    p_213442_1_.broadcastBreakEvent(p_230254_2_);
                });
            }

            return InteractionResult.sidedSuccess(this.level.isClientSide);
        } else {
            return super.mobInteract(p_230254_1_, p_230254_2_);
        }
    }

    public void shear(SoundSource p_230263_1_) {
        this.level.playSound((Player)null, this, SoundEvents.MOOSHROOM_SHEAR, p_230263_1_, 1.0F, 1.0F);
        if (!this.level.isClientSide()) {
            ((ServerLevel)this.level).sendParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(0.5D), this.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
            this.discard();
            Chicken cowentity = EntityType.CHICKEN.create(this.level);
            cowentity.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
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

            for(int i = 0; i < 3; ++i) {
                this.level.addFreshEntity(new ItemEntity(this.level, this.getX(), this.getY(1.0D), this.getZ(), new ItemStack(Items.RED_MUSHROOM)));
            }
        }

    }

    public boolean readyForShearing() {
        return this.isAlive() && !this.isBaby();
    }

    @Override
    public boolean isShearable(@javax.annotation.Nonnull ItemStack item, Level world, BlockPos pos) {
        return readyForShearing();
    }

    @javax.annotation.Nonnull
    @Override
    public java.util.List<ItemStack> onSheared(@javax.annotation.Nullable Player player, @javax.annotation.Nonnull ItemStack item, Level world, BlockPos pos, int fortune) {
        world.playSound(null, this, SoundEvents.MOOSHROOM_SHEAR, player == null ? SoundSource.BLOCKS : SoundSource.PLAYERS, 1.0F, 1.0F);
        if (!world.isClientSide()) {
            ((ServerLevel)this.level).sendParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(0.5D), this.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
            this.discard();
            Chicken cowentity = EntityType.CHICKEN.create(this.level);
            cowentity.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
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
            for (int i = 0; i < 3; ++i) {
                items.add(new ItemStack(Items.RED_MUSHROOM));
            }

            return items;
        }
        return java.util.Collections.emptyList();
    }
}
