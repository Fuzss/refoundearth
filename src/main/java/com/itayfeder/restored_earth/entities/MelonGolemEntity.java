package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.entities.projectiles.MelonSeedEntity;
import com.itayfeder.restored_earth.init.ItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.LlamaSpitEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class MelonGolemEntity extends GolemEntity implements IRangedAttackMob {
    private static final DataParameter<Byte> DATA_MELON_ID = EntityDataManager.defineId(SnowGolemEntity.class, DataSerializers.BYTE);

    public MelonGolemEntity(EntityType<? extends MelonGolemEntity> p_i50244_1_, World p_i50244_2_) {
        super(p_i50244_1_, p_i50244_2_);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 1.0000001E-5F));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MobEntity.class, 10, true, false, (p_213621_0_) -> {
            return p_213621_0_ instanceof IMob;
        }));
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, (double)0.2F);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_MELON_ID, (byte)16);
    }

    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.putBoolean("Melon", this.hasMelon());
    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        if (p_70037_1_.contains("Melon")) {
            this.setMelon(p_70037_1_.getBoolean("Melon"));
        }

    }

    public boolean isSensitiveToWater() {
        return true;
    }

    public void aiStep() {
        super.aiStep();
        if (!this.level.isClientSide) {
            int i = MathHelper.floor(this.getX());
            int j = MathHelper.floor(this.getY());
            int k = MathHelper.floor(this.getZ());
            if (this.level.getBiome(new BlockPos(i, 0, k)).getTemperature(new BlockPos(i, j, k)) > 1.0F) {
                this.hurt(DamageSource.ON_FIRE, 1.0F);
            }

            if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this)) {
                return;
            }

            BlockState blockstate = Blocks.SNOW.defaultBlockState();

            for(int l = 0; l < 4; ++l) {
                i = MathHelper.floor(this.getX() + (double)((float)(l % 2 * 2 - 1) * 0.25F));
                j = MathHelper.floor(this.getY());
                k = MathHelper.floor(this.getZ() + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos blockpos = new BlockPos(i, j, k);
                if (this.level.isEmptyBlock(blockpos) && this.level.getBiome(blockpos).getTemperature(blockpos) < 0.8F && blockstate.canSurvive(this.level, blockpos)) {
                    this.level.setBlockAndUpdate(blockpos, blockstate);
                }
            }
        }

    }

    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
        MelonSeedEntity llamaspitentity = new MelonSeedEntity(this.level, this);
        double d0 = p_82196_1_.getX() - this.getX();
        double d1 = p_82196_1_.getY(0.3333333333333333D) - llamaspitentity.getY();
        double d2 = p_82196_1_.getZ() - this.getZ();
        float f = MathHelper.sqrt(d0 * d0 + d2 * d2) * 0.2F;
        llamaspitentity.shoot(d0, d1 + (double)f, d2, 1.5F, 10.0F);
        if (!this.isSilent()) {
            this.level.playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.SNOW_GOLEM_SHOOT, this.getSoundSource(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
        }

        this.level.addFreshEntity(llamaspitentity);
    }

    protected float getStandingEyeHeight(Pose p_213348_1_, EntitySize p_213348_2_) {
        return 1.7F;
    }

    protected ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
        if (false && itemstack.getItem() == Items.SHEARS && this.readyForShearing()) { //Forge: Moved to onSheared
            this.shear(SoundCategory.PLAYERS);
            if (!this.level.isClientSide) {
                itemstack.hurtAndBreak(1, p_230254_1_, (p_213622_1_) -> {
                    p_213622_1_.broadcastBreakEvent(p_230254_2_);
                });
            }

            return ActionResultType.sidedSuccess(this.level.isClientSide);
        } else {
            return ActionResultType.PASS;
        }
    }

    public void shear(SoundCategory p_230263_1_) {
        this.level.playSound((PlayerEntity)null, this, SoundEvents.SNOW_GOLEM_SHEAR, p_230263_1_, 1.0F, 1.0F);
        if (!this.level.isClientSide()) {
            this.setMelon(false);
            this.spawnAtLocation(new ItemStack(ItemInit.CARVED_MELON), 1.7F);
        }

    }

    public boolean readyForShearing() {
        return this.isAlive() && this.hasMelon();
    }

    public boolean hasMelon() {
        return (this.entityData.get(DATA_MELON_ID) & 16) != 0;
    }

    public void setMelon(boolean p_184747_1_) {
        byte b0 = this.entityData.get(DATA_MELON_ID);
        if (p_184747_1_) {
            this.entityData.set(DATA_MELON_ID, (byte)(b0 | 16));
        } else {
            this.entityData.set(DATA_MELON_ID, (byte)(b0 & -17));
        }

    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SNOW_GOLEM_AMBIENT;
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.SNOW_GOLEM_HURT;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.SNOW_GOLEM_DEATH;
    }

    @OnlyIn(Dist.CLIENT)
    public Vector3d getLeashOffset() {
        return new Vector3d(0.0D, (double)(0.75F * this.getEyeHeight()), (double)(this.getBbWidth() * 0.4F));
    }
}
