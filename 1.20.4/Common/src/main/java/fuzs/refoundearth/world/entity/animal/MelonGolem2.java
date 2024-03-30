package fuzs.refoundearth.world.entity.animal;

import com.itayfeder.restored_earth.entities.projectiles.MelonSeed;
import fuzs.refoundearth.init.ModItems;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.JumpControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

public class MelonGolem2 extends SnowGolem {
    private static final EntityDataAccessor<Boolean> DATA_IS_CHARGING = SynchedEntityData.defineId(Ghast.class, EntityDataSerializers.BOOLEAN);

    private int jumpTicks;
    private int jumpDuration;
    private boolean wasOnGround;
    private int jumpDelayTicks;

    public MelonGolem2(EntityType<? extends SnowGolem> entityType, Level level) {
        super(entityType, level);
        this.jumpControl = new MelonGolemJumpControl(this);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_IS_CHARGING, false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MelonGolemAttackGoal(this, 1.25, 20, 10.0F));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0, 1.0F));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Mob.class, 10, true, false, Enemy.class::isInstance));
    }

    public boolean isCharging() {
        return this.entityData.get(DATA_IS_CHARGING);
    }

    public void setCharging(boolean charging) {
        this.entityData.set(DATA_IS_CHARGING, charging);
    }

    @Override
    public void performRangedAttack(LivingEntity target, float velocity) {
        Snowball snowball = new MelonSeed(this.level(), this);
        double d = target.getEyeY() - 1.1;
        double e = target.getX() - this.getX();
        double f = d - snowball.getY();
        double g = target.getZ() - this.getZ();
        double h = Math.sqrt(e * e + g * g) * 0.2;
        snowball.shoot(e, f + h, g, 1.6F, 12.0F);
        this.playSound(SoundEvents.FOX_SPIT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(snowball);
    }

    @Override
    public void shear(SoundSource source) {
        this.level().playSound(null, this, SoundEvents.SNOW_GOLEM_SHEAR, source, 1.0F, 1.0F);
        if (!this.level().isClientSide()) {
            this.setPumpkin(false);
            this.spawnAtLocation(new ItemStack(ModItems.CARVED_MELON.value()), 1.7F);
        }
    }

    @Override
    protected float getJumpPower() {
        float f = 0.3F;
        if (this.horizontalCollision || this.moveControl.hasWanted() && this.moveControl.getWantedY() > this.getY() + 0.5) {
            f = 0.5F;
        }

        Path path = this.navigation.getPath();
        if (path != null && !path.isDone()) {
            Vec3 vec3 = path.getNextEntityPos(this);
            if (vec3.y > this.getY() + 0.5) {
                f = 0.5F;
            }
        }

        if (this.moveControl.getSpeedModifier() <= 0.6) {
            f = 0.2F;
        }

        return f + this.getJumpBoostPower();
    }

    @Override
    protected void jumpFromGround() {
        super.jumpFromGround();
        double d = this.moveControl.getSpeedModifier();
        if (d > 0.0) {
            double e = this.getDeltaMovement().horizontalDistanceSqr();
            if (e < 0.01) {
                this.moveRelative(0.1F, new Vec3(0.0, 0.0, 1.0));
            }
        }

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)1);
        }
    }

    public void startJumping() {
        this.setJumping(true);
        this.jumpDuration = 10;
        this.jumpTicks = 0;
    }

    @Override
    public void customServerAiStep() {
        if (this.jumpDelayTicks > 0) {
            --this.jumpDelayTicks;
        }

        if (this.onGround()) {
            if (!this.wasOnGround) {
                this.setJumping(false);
                this.checkLandingDelay();
            }

            if (!this.getJumpControl().wantJump()) {
                if (this.moveControl.hasWanted() && this.jumpDelayTicks == 0) {
                    Path path = this.navigation.getPath();
                    Vec3 vec3 = new Vec3(this.moveControl.getWantedX(), this.moveControl.getWantedY(), this.moveControl.getWantedZ());
                    if (path != null && !path.isDone()) {
                        vec3 = path.getNextEntityPos(this);
                    }

                    this.facePoint(vec3.x, vec3.z);
                    this.startJumping();
                }
            } else if (!this.getJumpControl().canJump()) {
                this.getJumpControl().setCanJump(true);
            }
        }

        this.wasOnGround = this.onGround();
    }

    @Override
    public boolean canSpawnSprintParticle() {
        return false;
    }

    private void facePoint(double x, double z) {
        this.setYRot((float)(Mth.atan2(z - this.getZ(), x - this.getX()) * 57.2957763671875) - 90.0F);
    }

    private void setLandingDelay() {
        if (this.moveControl.getSpeedModifier() < 2.2) {
            this.jumpDelayTicks = 10;
        } else {
            this.jumpDelayTicks = 1;
        }
    }

    private void checkLandingDelay() {
        this.setLandingDelay();
        this.getJumpControl().setCanJump(false);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.jumpTicks != this.jumpDuration) {
            ++this.jumpTicks;
        } else if (this.jumpDuration != 0) {
            this.jumpTicks = 0;
            this.jumpDuration = 0;
            this.setJumping(false);
        }
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 1) {
            this.spawnSprintParticle();
            this.jumpDuration = 10;
            this.jumpTicks = 0;
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public MelonGolemJumpControl getJumpControl() {
        return (MelonGolemJumpControl) super.getJumpControl();
    }

    public static class MelonGolemJumpControl extends JumpControl {
        private final MelonGolem2 rabbit;
        private boolean canJump;

        public MelonGolemJumpControl(MelonGolem2 rabbit) {
            super(rabbit);
            this.rabbit = rabbit;
        }

        public boolean wantJump() {
            return this.jump;
        }

        public boolean canJump() {
            return this.canJump;
        }

        public void setCanJump(boolean canJump) {
            this.canJump = canJump;
        }

        @Override
        public void tick() {
            if (this.jump) {
                this.rabbit.startJumping();
                this.jump = false;
            }
        }
    }

    public static class MelonGolemAttackGoal extends RangedAttackGoal {
        private final MelonGolem2 melonGolem;

        public MelonGolemAttackGoal(MelonGolem2 rangedAttackMob, double speedModifier, int attackInterval, float attackRadius) {
            super(rangedAttackMob, speedModifier, attackInterval, attackRadius);
            this.melonGolem = rangedAttackMob;
        }

        @Override
        public void stop() {
            super.stop();
            this.melonGolem.setCharging(false);
        }

        @Override
        public void tick() {
            super.tick();
            this.melonGolem.setCharging(this.attackTime > 0 && this.attackTime < this.attackIntervalMin / 2);
        }
    }
}
