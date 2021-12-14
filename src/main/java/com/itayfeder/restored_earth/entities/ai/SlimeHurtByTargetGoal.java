package com.itayfeder.restored_earth.entities.ai;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.GameRules;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class SlimeHurtByTargetGoal extends TargetGoal {
    private static final EntityPredicate HURT_BY_TARGETING = (new EntityPredicate()).allowUnseeable().ignoreInvisibilityTesting();
    private boolean alertSameType;
    private int timestamp;
    private final Class<?>[] toIgnoreDamage;
    private Class<?>[] toIgnoreAlert;

    public SlimeHurtByTargetGoal(MobEntity p_i50317_1_, Class<?>... p_i50317_2_) {
        super(p_i50317_1_, true);
        this.toIgnoreDamage = p_i50317_2_;
        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
    }

    public boolean canUse() {
        int i = this.mob.getLastHurtByMobTimestamp();
        LivingEntity livingentity = this.mob.getLastHurtByMob();
        if (i != this.timestamp && livingentity != null) {
            if (livingentity.getType() == EntityType.PLAYER && this.mob.level.getGameRules().getBoolean(GameRules.RULE_UNIVERSAL_ANGER)) {
                return false;
            } else {
                for(Class<?> oclass : this.toIgnoreDamage) {
                    if (oclass.isAssignableFrom(livingentity.getClass())) {
                        return false;
                    }
                }

                return this.canAttack(livingentity, HURT_BY_TARGETING);
            }
        } else {
            return false;
        }
    }

    public SlimeHurtByTargetGoal setAlertOthers(Class<?>... p_220794_1_) {
        this.alertSameType = true;
        this.toIgnoreAlert = p_220794_1_;
        return this;
    }

    public void start() {
        this.mob.setTarget(this.mob.getLastHurtByMob());
        this.targetMob = this.mob.getTarget();
        this.timestamp = this.mob.getLastHurtByMobTimestamp();
        this.unseenMemoryTicks = 300;
        if (this.alertSameType) {
            this.alertOthers();
        }

        super.start();
    }

    protected void alertOthers() {
        double d0 = this.getFollowDistance();
        AxisAlignedBB axisalignedbb = AxisAlignedBB.unitCubeFromLowerCorner(this.mob.position()).inflate(d0, 10.0D, d0);
        List<MobEntity> list = this.mob.level.getLoadedEntitiesOfClass(this.mob.getClass(), axisalignedbb);
        Iterator iterator = list.iterator();

        while(true) {
            MobEntity mobentity;
            while(true) {
                if (!iterator.hasNext()) {
                    return;
                }

                mobentity = (MobEntity)iterator.next();
                if (this.mob != mobentity && mobentity.getTarget() == null && (!(this.mob instanceof TameableEntity) || ((TameableEntity)this.mob).getOwner() == ((TameableEntity)mobentity).getOwner()) && !mobentity.isAlliedTo(this.mob.getLastHurtByMob())) {
                    if (this.toIgnoreAlert == null) {
                        break;
                    }

                    boolean flag = false;

                    for(Class<?> oclass : this.toIgnoreAlert) {
                        if (mobentity.getClass() == oclass) {
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        break;
                    }
                }
            }

            this.alertOther(mobentity, this.mob.getLastHurtByMob());
        }
    }

    protected void alertOther(MobEntity p_220793_1_, LivingEntity p_220793_2_) {
        p_220793_1_.setTarget(p_220793_2_);
    }
}