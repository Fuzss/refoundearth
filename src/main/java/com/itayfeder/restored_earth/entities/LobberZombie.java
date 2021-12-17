package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.entities.projectiles.RottenFlesh;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LobberZombie extends Zombie implements RangedAttackMob {

    public LobberZombie(EntityType<? extends LobberZombie> p_32889_, Level p_32890_) {
        super(p_32889_, p_32890_);
    }

    protected ItemStack getSkull() {
        return ItemStack.EMPTY;
    }

    protected boolean convertsInWater() {
        return true;
    }

    @Override
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
        super.addBehaviourGoals();
    }

    @Override
    public void performRangedAttack(LivingEntity p_33317_, float p_33318_) {
        RottenFlesh snowball = new RottenFlesh(this.level, this);
        double d0 = p_33317_.getEyeY() - (double)1.1F;
        double d1 = p_33317_.getX() - this.getX();
        double d2 = d0 - snowball.getY();
        double d3 = p_33317_.getZ() - this.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
        snowball.shoot(d1, d2 + d4, d3, 1.6F, 12.0F);
        this.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(snowball);
    }
}