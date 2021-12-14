package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.entities.ai.SlimeHurtByTargetGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class TropicalSlimeEntity extends SlimeEntity {
    private static final DataParameter<Integer> DATA_ANIM_ID = EntityDataManager.defineId(TropicalSlimeEntity.class, DataSerializers.INT);

    public TropicalSlimeEntity(EntityType<? extends TropicalSlimeEntity> p_i48552_1_, World p_i48552_2_) {
        super(p_i48552_1_, p_i48552_2_);
        this.moveControl = new TropicalSlimeEntity.MoveHelperController(this);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new TropicalSlimeEntity.FloatGoal(this));
        this.goalSelector.addGoal(2, new TropicalSlimeEntity.AttackGoal(this));
        this.goalSelector.addGoal(3, new TropicalSlimeEntity.FaceRandomGoal(this));
        this.goalSelector.addGoal(5, new TropicalSlimeEntity.HopGoal(this));
        this.targetSelector.addGoal(1, (new SlimeHurtByTargetGoal(this)));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
    }

    protected IParticleData getParticleType() {
        return ParticleTypes.RAIN;
    }

    public boolean isOnFire() {
        return false;
    }

    protected void jumpFromGround() {
        Vector3d vector3d = this.getDeltaMovement();
        this.setDeltaMovement(vector3d.x, (double)(this.getJumpPower() + (float)this.getSize() * 0.1F), vector3d.z);
        this.hasImpulse = true;
        net.minecraftforge.common.ForgeHooks.onLivingJump(this);
    }

    protected void jumpInLiquid(ITag<Fluid> p_180466_1_) {
        if (p_180466_1_ == FluidTags.WATER) {
            Vector3d vector3d = this.getDeltaMovement();
            this.setDeltaMovement(vector3d.x, (double)(0.22F + (float)this.getSize() * 0.05F), vector3d.z);
            this.hasImpulse = true;
        } else {
            super.jumpInLiquid(p_180466_1_);
        }

    }

    public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
        return false;
    }

    protected boolean isDealsDamage() {
        return this.isEffectiveAi();
    }

    private float getSoundPitch() {
        float f = this.isTiny() ? 1.4F : 0.8F;
        return ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * f;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ANIM_ID, 0);
    }

    public int getAnimTimer() {
        return this.entityData.get(DATA_ANIM_ID);
    }

    public void setAnimTimer(int p_29568_) {
        this.entityData.set(DATA_ANIM_ID, p_29568_);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT p_33619_) {
        super.addAdditionalSaveData(p_33619_);
        this.setAnimTimer(p_33619_.getInt("AnimTimer"));
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT p_33607_) {
        super.readAdditionalSaveData(p_33607_);
        p_33607_.putInt("AnimTimer", this.getAnimTimer());
    }

    @Override
    public void tick() {
        super.tick();
        this.setAnimTimer(MathHelper.positiveModulo(this.getAnimTimer()+1, 48));
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        this.setSize(2, true);

        this.getAttribute(Attributes.FOLLOW_RANGE).addPermanentModifier(new AttributeModifier("Random spawn bonus", this.random.nextGaussian() * 0.05D, AttributeModifier.Operation.MULTIPLY_BASE));
        if (this.random.nextFloat() < 0.05F) {
            this.setLeftHanded(true);
        } else {
            this.setLeftHanded(false);
        }

        return p_213386_4_;
    }

    @Override
    public void remove(boolean keepData) {
        this.removed = true;
        if (!keepData)
            this.invalidateCaps();
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return this.getType().getDefaultLootTable();
    }

    @SubscribeEvent
    protected void setSize(int p_70799_1_, boolean p_70799_2_) {
        super.setSize(p_70799_1_, p_70799_2_);
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue((double)(p_70799_1_ * p_70799_1_ * p_70799_1_));
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double)(0.2F + 0.1F * (float)p_70799_1_));
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((double)p_70799_1_);
        if (p_70799_2_) {
            this.setHealth(this.getMaxHealth());
        }

        this.xpReward = p_70799_1_;
    }

    static class AttackGoal extends Goal {
        private final TropicalSlimeEntity slime;
        private int growTiredTimer;

        public AttackGoal(TropicalSlimeEntity p_i45824_1_) {
            this.slime = p_i45824_1_;
            this.setFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity livingentity = this.slime.getTarget();
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else {
                return livingentity instanceof PlayerEntity && ((PlayerEntity)livingentity).abilities.invulnerable ? false : this.slime.getMoveControl() instanceof TropicalSlimeEntity.MoveHelperController;
            }
        }

        public void start() {
            this.growTiredTimer = 300;
            super.start();
        }

        public boolean canContinueToUse() {
            LivingEntity livingentity = this.slime.getTarget();
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else if (livingentity instanceof PlayerEntity && ((PlayerEntity)livingentity).abilities.invulnerable) {
                return false;
            } else {
                return --this.growTiredTimer > 0;
            }
        }

        public void tick() {
            this.slime.lookAt(this.slime.getTarget(), 10.0F, 10.0F);
            ((TropicalSlimeEntity.MoveHelperController)this.slime.getMoveControl()).setDirection(this.slime.yRot, this.slime.isDealsDamage());
        }
    }

    static class FaceRandomGoal extends Goal {
        private final TropicalSlimeEntity slime;
        private float chosenDegrees;
        private int nextRandomizeTime;

        public FaceRandomGoal(TropicalSlimeEntity p_i45820_1_) {
            this.slime = p_i45820_1_;
            this.setFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        public boolean canUse() {
            return this.slime.getTarget() == null && (this.slime.isOnGround() || this.slime.isInWater() || this.slime.isInLava() || this.slime.hasEffect(Effects.LEVITATION)) && this.slime.getMoveControl() instanceof TropicalSlimeEntity.MoveHelperController;
        }

        public void tick() {
            if (--this.nextRandomizeTime <= 0) {
                this.nextRandomizeTime = 40 + this.slime.getRandom().nextInt(60);
                this.chosenDegrees = (float)this.slime.getRandom().nextInt(360);
            }

            ((TropicalSlimeEntity.MoveHelperController)this.slime.getMoveControl()).setDirection(this.chosenDegrees, false);
        }
    }

    static class FloatGoal extends Goal {
        private final TropicalSlimeEntity slime;

        public FloatGoal(TropicalSlimeEntity p_i45823_1_) {
            this.slime = p_i45823_1_;
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
            p_i45823_1_.getNavigation().setCanFloat(true);
        }

        public boolean canUse() {
            return (this.slime.isInWater() || this.slime.isInLava()) && this.slime.getMoveControl() instanceof TropicalSlimeEntity.MoveHelperController;
        }

        public void tick() {
            if (this.slime.getRandom().nextFloat() < 0.8F) {
                this.slime.getJumpControl().jump();
            }

            ((TropicalSlimeEntity.MoveHelperController)this.slime.getMoveControl()).setWantedMovement(1.2D);
        }
    }

    static class HopGoal extends Goal {
        private final TropicalSlimeEntity slime;

        public HopGoal(TropicalSlimeEntity p_i45822_1_) {
            this.slime = p_i45822_1_;
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        public boolean canUse() {
            return !this.slime.isPassenger();
        }

        public void tick() {
            ((TropicalSlimeEntity.MoveHelperController)this.slime.getMoveControl()).setWantedMovement(1.0D);
        }
    }

    static class MoveHelperController extends MovementController {
        private float yRot;
        private int jumpDelay;
        private final TropicalSlimeEntity slime;
        private boolean isAggressive;

        public MoveHelperController(TropicalSlimeEntity p_i45821_1_) {
            super(p_i45821_1_);
            this.slime = p_i45821_1_;
            this.yRot = 180.0F * p_i45821_1_.yRot / (float)Math.PI;
        }

        public void setDirection(float p_179920_1_, boolean p_179920_2_) {
            this.yRot = p_179920_1_;
            this.isAggressive = p_179920_2_;
        }

        public void setWantedMovement(double p_179921_1_) {
            this.speedModifier = p_179921_1_;
            this.operation = MovementController.Action.MOVE_TO;
        }

        public void tick() {
            this.mob.yRot = this.rotlerp(this.mob.yRot, this.yRot, 90.0F);
            this.mob.yHeadRot = this.mob.yRot;
            this.mob.yBodyRot = this.mob.yRot;
            if (this.operation != MovementController.Action.MOVE_TO) {
                this.mob.setZza(0.0F);
            } else {
                this.operation = MovementController.Action.WAIT;
                if (this.mob.isOnGround()) {
                    this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                    if (this.jumpDelay-- <= 0) {
                        this.jumpDelay = this.slime.getJumpDelay();
                        if (this.isAggressive) {
                            this.jumpDelay /= 3;
                        }

                        this.slime.getJumpControl().jump();
                        if (this.slime.doPlayJumpSound()) {
                            this.slime.playSound(this.slime.getJumpSound(), this.slime.getSoundVolume(), this.slime.getSoundPitch());
                        }
                    } else {
                        this.slime.xxa = 0.0F;
                        this.slime.zza = 0.0F;
                        this.mob.setSpeed(0.0F);
                    }
                } else {
                    this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                }

            }
        }
    }
}
