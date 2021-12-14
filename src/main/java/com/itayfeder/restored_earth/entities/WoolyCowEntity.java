package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.init.EntityInit;
import com.itayfeder.restored_earth.utils.ModLootTables;
import net.minecraft.client.audio.SoundSource;
import net.minecraft.command.impl.data.EntityDataAccessor;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IForgeShearable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class WoolyCowEntity extends CowEntity implements IForgeShearable {
    private static final DataParameter<Boolean> DATA_SHEARED_ID = EntityDataManager.defineId(WoolyCowEntity.class, DataSerializers.BOOLEAN);
    private EatGrassGoal eatBlockGoal;
    private int eatAnimationTick;

    public WoolyCowEntity(EntityType<? extends CowEntity> p_i48567_1_, World p_i48567_2_) {
        super(p_i48567_1_, p_i48567_2_);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.eatBlockGoal = new EatGrassGoal(this);
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

    @Override
    public WoolyCowEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return EntityInit.WOOLY_COW.create(p_241840_1_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_SHEARED_ID, false);
    }

    public void addAdditionalSaveData(CompoundNBT p_29864_) {
        super.addAdditionalSaveData(p_29864_);
        p_29864_.putBoolean("Sheared", this.isSheared());
    }

    public void readAdditionalSaveData(CompoundNBT p_29845_) {
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
    public boolean isShearable(@Nonnull ItemStack item, World world, BlockPos pos) {
        return readyForShearing();
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nullable PlayerEntity player, @Nonnull ItemStack item, World world, BlockPos pos, int fortune) {
        world.playSound(null, this, SoundEvents.SHEEP_SHEAR, player == null ? SoundCategory.BLOCKS : SoundCategory.PLAYERS, 1.0F, 1.0F);
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
            return ((float)Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
        } else {
            return this.eatAnimationTick > 0 ? ((float)Math.PI / 5F) : this.xRot * ((float)Math.PI / 180F);
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
