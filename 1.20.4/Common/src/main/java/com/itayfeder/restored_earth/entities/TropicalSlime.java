package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.entities.ai.SlimeHurtByTargetGoal;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;

public class TropicalSlime extends Slime {
    private static final EntityDataAccessor<Integer> DATA_ANIM_ID = SynchedEntityData.defineId(TropicalSlime.class, EntityDataSerializers.INT);

    public TropicalSlime(EntityType<? extends Slime> p_33588_, Level p_33589_) {
        super(p_33588_, p_33589_);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.removeAllGoals();
        this.targetSelector.addGoal(1, (new SlimeHurtByTargetGoal(this)));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }

    protected ParticleOptions getParticleType() {
        return ParticleTypes.RAIN;
    }

    public boolean isOnFire() {
        return false;
    }

    protected void jumpFromGround() {
        Vec3 vec3 = this.getDeltaMovement();
        this.setDeltaMovement(vec3.x, (double)this.getJumpPower(), vec3.z);
        this.hasImpulse = true;
        net.minecraftforge.common.ForgeHooks.onLivingJump(this);
    }

    protected void jumpInLiquid(Tag<Fluid> p_32988_) {
        if (p_32988_ == FluidTags.WATER) {
            Vec3 vec3 = this.getDeltaMovement();
            this.setDeltaMovement(vec3.x, (double)this.getJumpPower(), vec3.z);
            this.hasImpulse = true;
        } else {
            super.jumpInLiquid(p_32988_);
        }
    }

    public boolean causeFallDamage(float p_149717_, float p_149718_, DamageSource p_149719_) {
        return false;
    }

    protected boolean isDealsDamage() {
        return this.isEffectiveAi();
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
    public void addAdditionalSaveData(CompoundTag p_33619_) {
        super.addAdditionalSaveData(p_33619_);
        this.setAnimTimer(p_33619_.getInt("AnimTimer"));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_33607_) {
        super.readAdditionalSaveData(p_33607_);
        p_33607_.putInt("AnimTimer", this.getAnimTimer());
    }

    @Override
    public void tick() {
        super.tick();
        this.setAnimTimer(Mth.positiveModulo(this.getAnimTimer()+1, 48));
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33601_, DifficultyInstance p_33602_, MobSpawnType p_33603_, @Nullable SpawnGroupData p_33604_, @Nullable CompoundTag p_33605_) {
        this.setSize(2, true);

        this.getAttribute(Attributes.FOLLOW_RANGE).addPermanentModifier(new AttributeModifier("Random spawn bonus", this.random.nextGaussian() * 0.05D, AttributeModifier.Operation.MULTIPLY_BASE));
        if (this.random.nextFloat() < 0.05F) {
            this.setLeftHanded(true);
        } else {
            this.setLeftHanded(false);
        }

        return p_33604_;
    }

    @Override
    public void remove(RemovalReason p_149847_) {
        this.setRemoved(p_149847_);
        if (p_149847_ == Entity.RemovalReason.KILLED) {
            this.gameEvent(GameEvent.ENTITY_KILLED);
        }
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
}
