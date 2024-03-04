package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.entities.projectiles.MelonSeed;
import com.itayfeder.restored_earth.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LlamaSpit;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class MelonGolem extends AbstractGolem implements RangedAttackMob {
    private static final EntityDataAccessor<Byte> DATA_MELON_ID = SynchedEntityData.defineId(MelonGolem.class, EntityDataSerializers.BYTE);

    public MelonGolem(EntityType<? extends MelonGolem> p_29902_, Level p_29903_) {
        super(p_29902_, p_29903_);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D, 1.0000001E-5F));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Mob.class, 10, true, false, (p_29932_) -> {
            return p_29932_ instanceof Enemy;
        }));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, (double)0.2F);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_MELON_ID, (byte)16);
    }

    public void addAdditionalSaveData(CompoundTag p_29923_) {
        super.addAdditionalSaveData(p_29923_);
        p_29923_.putBoolean("Melon", this.hasMelon());
    }

    public void readAdditionalSaveData(CompoundTag p_29915_) {
        super.readAdditionalSaveData(p_29915_);
        if (p_29915_.contains("Melon")) {
            this.setMelon(p_29915_.getBoolean("Melon"));
        }

    }

    public boolean isSensitiveToWater() {
        return true;
    }

    public void aiStep() {
        super.aiStep();
        if (!this.level.isClientSide) {
            int i = Mth.floor(this.getX());
            int j = Mth.floor(this.getY());
            int k = Mth.floor(this.getZ());
            BlockPos blockpos = new BlockPos(i, j, k);
            Biome biome = this.level.getBiome(blockpos);
            if (biome.shouldSnowGolemBurn(blockpos)) {
                this.hurt(DamageSource.ON_FIRE, 1.0F);
            }

            if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this)) {
                return;
            }

            BlockState blockstate = Blocks.SNOW.defaultBlockState();

            for(int l = 0; l < 4; ++l) {
                i = Mth.floor(this.getX() + (double)((float)(l % 2 * 2 - 1) * 0.25F));
                j = Mth.floor(this.getY());
                k = Mth.floor(this.getZ() + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos blockpos1 = new BlockPos(i, j, k);
                if (this.level.isEmptyBlock(blockpos) && blockstate.canSurvive(this.level, blockpos)) {
                    this.level.setBlockAndUpdate(blockpos1, blockstate);
                }
            }
        }

    }

    public void performRangedAttack(LivingEntity p_29912_, float p_29913_) {
        MelonSeed llamaspit = new MelonSeed(this.level, this);
        double d0 = p_29912_.getX() - this.getX();
        double d1 = p_29912_.getY(0.3333333333333333D) - llamaspit.getY();
        double d2 = p_29912_.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2) * (double)0.2F;
        llamaspit.shoot(d0, d1 + d3, d2, 1.5F, 10.0F);
        if (!this.isSilent()) {
            this.level.playSound((Player)null, this.getX(), this.getY(), this.getZ(), SoundEvents.LLAMA_SPIT, this.getSoundSource(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
        }

        this.level.addFreshEntity(llamaspit);
    }

    protected float getStandingEyeHeight(Pose p_29917_, EntityDimensions p_29918_) {
        return 1.7F;
    }

    protected InteractionResult mobInteract(Player p_29920_, InteractionHand p_29921_) {
        ItemStack itemstack = p_29920_.getItemInHand(p_29921_);
        if (false && itemstack.getItem() == Items.SHEARS && this.readyForShearing()) { //Forge: Moved to onSheared
            this.shear(SoundSource.PLAYERS);
            this.gameEvent(GameEvent.SHEAR, p_29920_);
            if (!this.level.isClientSide) {
                itemstack.hurtAndBreak(1, p_29920_, (p_29910_) -> {
                    p_29910_.broadcastBreakEvent(p_29921_);
                });
            }

            return InteractionResult.sidedSuccess(this.level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    public void shear(SoundSource p_29907_) {
        this.level.playSound((Player)null, this, SoundEvents.SNOW_GOLEM_SHEAR, p_29907_, 1.0F, 1.0F);
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

    public void setMelon(boolean p_29937_) {
        byte b0 = this.entityData.get(DATA_MELON_ID);
        if (p_29937_) {
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
    protected SoundEvent getHurtSound(DamageSource p_29929_) {
        return SoundEvents.SNOW_GOLEM_HURT;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.SNOW_GOLEM_DEATH;
    }

    public Vec3 getLeashOffset() {
        return new Vec3(0.0D, (double)(0.75F * this.getEyeHeight()), (double)(this.getBbWidth() * 0.4F));
    }
}
