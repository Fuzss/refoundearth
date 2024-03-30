package fuzs.refoundearth.world.entity.monster;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class VilerWitch extends Witch {

    public VilerWitch(EntityType<? extends Witch> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void performRangedAttack(LivingEntity target, float velocity) {
        if (!this.isDrinkingPotion()) {
            Vec3 vec3 = target.getDeltaMovement();
            double d = target.getX() + vec3.x - this.getX();
            double e = target.getEyeY() - 1.1F - this.getY();
            double f = target.getZ() + vec3.z - this.getZ();
            double g = Math.sqrt(d * d + f * f);
            Potion potion = Potions.HARMING;
            if (target instanceof Raider) {
                if (target.getHealth() <= 4.0F) {
                    potion = Potions.HEALING;
                } else {
                    potion = Potions.REGENERATION;
                }

                this.setTarget(null);
            } else if (g >= 8.0 && !target.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                potion = Potions.SLOWNESS;
            } else if (target.getHealth() >= 8.0F && !target.hasEffect(MobEffects.POISON)) {
                potion = Potions.POISON;
            } else if (g <= 3.0 && !target.hasEffect(MobEffects.WEAKNESS) && this.random.nextFloat() < 0.25F) {
                potion = Potions.WEAKNESS;
            }

            ThrownPotion thrownPotion = new ThrownPotion(this.level(), this);
            // this is the only change :(
            thrownPotion.setItem(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), potion));
            thrownPotion.setXRot(thrownPotion.getXRot() - -20.0F);
            thrownPotion.shoot(d, e + g * 0.2, f, 0.75F, 8.0F);
            if (!this.isSilent()) {
                this.level()
                        .playSound(null,
                                this.getX(),
                                this.getY(),
                                this.getZ(),
                                SoundEvents.WITCH_THROW,
                                this.getSoundSource(),
                                1.0F,
                                0.8F + this.random.nextFloat() * 0.4F
                        );
            }

            this.level().addFreshEntity(thrownPotion);
        }
    }
}
