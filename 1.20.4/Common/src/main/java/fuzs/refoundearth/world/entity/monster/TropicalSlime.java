package fuzs.refoundearth.world.entity.monster;

import com.google.common.base.Predicates;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class TropicalSlime extends Slime {
    private static final int ANIMATION_DURATION = 48;

    public int animationTicks;

    public TropicalSlime(EntityType<? extends Slime> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.removeAllGoals(Predicates.alwaysTrue());
        this.targetSelector.addGoal(1, new GenericHurtByTargetGoal(this));
    }

    @Override
    protected ParticleOptions getParticleType() {
        return ParticleTypes.RAIN;
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    @Override
    protected boolean isDealsDamage() {
        return this.isEffectiveAi();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            ++this.animationTicks;
            this.animationTicks %= ANIMATION_DURATION;
        }
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        SpawnGroupData spawnGroupData = super.finalizeSpawn(level, difficulty, reason, spawnData, dataTag);
        this.setSize(2, true);
        return spawnGroupData;
    }

    /**
     * Copied from {@link HurtByTargetGoal} which has a stupid {@link PathfinderMob} restriction which is not even
     * used.
     */
    static class GenericHurtByTargetGoal extends TargetGoal {
        private static final TargetingConditions HURT_BY_TARGETING = TargetingConditions.forCombat()
                .ignoreLineOfSight()
                .ignoreInvisibilityTesting();
        private int timestamp;
        private final Class<?>[] toIgnoreDamage;

        public GenericHurtByTargetGoal(Mob mob, Class<?>... toIgnoreDamage) {
            super(mob, true);
            this.toIgnoreDamage = toIgnoreDamage;
            this.setFlags(EnumSet.of(Goal.Flag.TARGET));
        }

        @Override
        public boolean canUse() {
            int lastHurtByMobTimestamp = this.mob.getLastHurtByMobTimestamp();
            LivingEntity livingEntity = this.mob.getLastHurtByMob();
            if (lastHurtByMobTimestamp != this.timestamp && livingEntity != null) {
                if (livingEntity.getType() == EntityType.PLAYER &&
                        this.mob.level().getGameRules().getBoolean(GameRules.RULE_UNIVERSAL_ANGER)) {
                    return false;
                } else {
                    for (Class<?> class_ : this.toIgnoreDamage) {
                        if (class_.isAssignableFrom(livingEntity.getClass())) {
                            return false;
                        }
                    }

                    return this.canAttack(livingEntity, HURT_BY_TARGETING);
                }
            } else {
                return false;
            }
        }

        @Override
        public void start() {
            this.mob.setTarget(this.mob.getLastHurtByMob());
            this.targetMob = this.mob.getTarget();
            this.timestamp = this.mob.getLastHurtByMobTimestamp();
            this.unseenMemoryTicks = 300;
            super.start();
        }
    }
}
