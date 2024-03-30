package com.itayfeder.restored_earth.entities;

import fuzs.refoundearth.init.ModEntityTypes;
import fuzs.refoundearth.init.ModLootTables;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class WoolyCow extends Cow implements net.minecraftforge.common.IForgeShearable {
    private static final EntityDataAccessor<Boolean> DATA_SHEARED_ID = SynchedEntityData.defineId(WoolyCow.class, EntityDataSerializers.BOOLEAN);
    private EatBlockGoal eatBlockGoal;
    private int eatAnimationTick;

    public WoolyCow(EntityType<? extends Cow> p_28285_, Level p_28286_) {
        super(ModEntityTypes.WOOLY_COW, p_28286_);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.eatBlockGoal = new EatBlockGoal(this);
        this.goalSelector.addGoal(5, this.eatBlockGoal);
    }

    protected void customServerAiStep() {
        this.eatAnimationTick = this.eatBlockGoal.getEatAnimationTick();
        super.customServerAiStep();
    }

    public void aiStep() {
        if (this.level.isClientSide) {
            this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        }

        super.aiStep();
    }

    public WoolyCow getBreedOffspring(ServerLevel p_148890_, AgeableMob p_148891_) {
        return ModEntityTypes.WOOLY_COW.create(p_148890_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_SHEARED_ID, false);
    }

    public void addAdditionalSaveData(CompoundTag p_29864_) {
        super.addAdditionalSaveData(p_29864_);
        p_29864_.putBoolean("Sheared", this.isSheared());
    }

    public void readAdditionalSaveData(CompoundTag p_29845_) {
        super.readAdditionalSaveData(p_29845_);
        this.setSheared(p_29845_.getBoolean("Sheared"));
    }

    public boolean isSheared() {
        return this.entityData.get(DATA_SHEARED_ID);
    }

    public void setSheared(boolean p_29568_) {
        this.entityData.set(DATA_SHEARED_ID, p_29568_);
    }

    public void ate() {
        this.setSheared(false);
        if (this.isBaby()) {
            this.ageUp(60);
        }

    }

    public boolean readyForShearing() {
        return this.isAlive() && !this.isSheared() && !this.isBaby();
    }

    @Override
    public boolean isShearable(@javax.annotation.Nonnull ItemStack item, Level world, BlockPos pos) {
        return readyForShearing();
    }

    @javax.annotation.Nonnull
    @Override
    public java.util.List<ItemStack> onSheared(@Nullable Player player, @javax.annotation.Nonnull ItemStack item, Level world, BlockPos pos, int fortune) {
        world.playSound(null, this, SoundEvents.SHEEP_SHEAR, player == null ? SoundSource.BLOCKS : SoundSource.PLAYERS, 1.0F, 1.0F);
        if (!world.isClientSide) {
            this.setSheared(true);
            java.util.List<ItemStack> items = new java.util.ArrayList<>();
            items.add(new ItemStack(Items.BROWN_WOOL, 1));

            return items;
        }
        return java.util.Collections.emptyList();
    }

    public void handleEntityEvent(byte p_29814_) {
        if (p_29814_ == 10) {
            this.eatAnimationTick = 40;
        } else {
            super.handleEntityEvent(p_29814_);
        }

    }

    public float getHeadEatPositionScale(float p_29881_) {
        if (this.eatAnimationTick <= 0) {
            return 0.0F;
        } else if (this.eatAnimationTick >= 4 && this.eatAnimationTick <= 36) {
            return 1.0F;
        } else {
            return this.eatAnimationTick < 4 ? ((float)this.eatAnimationTick - p_29881_) / 4.0F : -((float)(this.eatAnimationTick - 40) - p_29881_) / 4.0F;
        }
    }

    public float getHeadEatAngleScale(float p_29883_) {
        if (this.eatAnimationTick > 4 && this.eatAnimationTick <= 36) {
            float f = ((float)(this.eatAnimationTick - 4) - p_29883_) / 32.0F;
            return ((float)Math.PI / 5F) + 0.21991149F * Mth.sin(f * 28.7F);
        } else {
            return this.eatAnimationTick > 0 ? ((float)Math.PI / 5F) : this.getXRot() * ((float)Math.PI / 180F);
        }
    }

    @Override
    public ResourceLocation getDefaultLootTable() {
        if (this.isSheared()) {
            return EntityType.COW.getDefaultLootTable();
        } else {
            return ModLootTables.COW_WOOLY;
        }
    }
}