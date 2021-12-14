package com.itayfeder.restored_earth.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.AbstractRaiderEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.raid.Raid;

import javax.annotation.Nullable;

public class VilerWitchEntity extends WitchEntity {
    public VilerWitchEntity(EntityType<? extends WitchEntity> p_i50188_1_, World p_i50188_2_) {
        super(p_i50188_1_, p_i50188_2_);
    }

    @Override
    public boolean canJoinRaid() {
        return false;
    }

    @Nullable
    @Override
    public Raid getCurrentRaid() {
        return null;
    }

    @Override
    public void performRangedAttack(LivingEntity p_82196_1_, float p_82196_2_) {
        if (!this.isDrinkingPotion()) {
            Vector3d vector3d = p_82196_1_.getDeltaMovement();
            double d0 = p_82196_1_.getX() + vector3d.x - this.getX();
            double d1 = p_82196_1_.getEyeY() - (double)1.1F - this.getY();
            double d2 = p_82196_1_.getZ() + vector3d.z - this.getZ();
            float f = MathHelper.sqrt(d0 * d0 + d2 * d2);
            Potion potion = Potions.HARMING;
            if (p_82196_1_ instanceof AbstractRaiderEntity) {
                if (p_82196_1_.getHealth() <= 4.0F) {
                    potion = Potions.HEALING;
                } else {
                    potion = Potions.REGENERATION;
                }

                this.setTarget((LivingEntity)null);
            } else if (f >= 8.0F && !p_82196_1_.hasEffect(Effects.MOVEMENT_SLOWDOWN)) {
                potion = Potions.SLOWNESS;
            } else if (p_82196_1_.getHealth() >= 8.0F && !p_82196_1_.hasEffect(Effects.POISON)) {
                potion = Potions.POISON;
            } else if (f <= 3.0F && !p_82196_1_.hasEffect(Effects.WEAKNESS) && this.random.nextFloat() < 0.25F) {
                potion = Potions.WEAKNESS;
            }

            PotionEntity potionentity = new PotionEntity(this.level, this);
            potionentity.setItem(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), potion));
            potionentity.xRot -= -20.0F;
            potionentity.shoot(d0, d1 + (double)(f * 0.2F), d2, 0.75F, 8.0F);
            if (!this.isSilent()) {
                this.level.playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.WITCH_THROW, this.getSoundSource(), 1.0F, 0.8F + this.random.nextFloat() * 0.4F);
            }

            this.level.addFreshEntity(potionentity);
        }
    }
}
