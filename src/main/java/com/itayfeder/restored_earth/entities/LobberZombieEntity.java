package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.client.RottenFleshEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class LobberZombieEntity extends ZombieEntity implements IRangedAttackMob {
    public LobberZombieEntity(EntityType<? extends ZombieEntity> p_i48549_1_, World p_i48549_2_) {
        super(p_i48549_1_, p_i48549_2_);
    }

    protected ItemStack getSkull() {
        return ItemStack.EMPTY;
    }

    @Override
    protected boolean convertsInWater() {
        return false;
    }

    @Override
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
        super.addBehaviourGoals();
    }

    @Override
    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
        RottenFleshEntity snowballentity = new RottenFleshEntity(this.level, this);
        double d0 = p_82196_1_.getEyeY() - (double)1.1F;
        double d1 = p_82196_1_.getX() - this.getX();
        double d2 = d0 - snowballentity.getY();
        double d3 = p_82196_1_.getZ() - this.getZ();
        float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
        snowballentity.shoot(d1, d2 + (double)f, d3, 1.6F, 12.0F);
        this.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(snowballentity);
    }
}
