package fuzs.refoundearth.world.entity.projectile;

import fuzs.refoundearth.init.ModEntityTypes;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

/**
 * Copied from {@link net.minecraft.world.entity.projectile.Snowball}.
 */
public class RottenFlesh extends ThrowableItemProjectile {

    public RottenFlesh(EntityType<? extends RottenFlesh> entityType, Level level) {
        super(entityType, level);
    }

    public RottenFlesh(Level level, LivingEntity shooter) {
        super(ModEntityTypes.ROTTEN_FLESH.value(), shooter, level);
    }

    public RottenFlesh(Level level, double x, double y, double z) {
        super(ModEntityTypes.ROTTEN_FLESH.value(), x, y, z, level);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.ROTTEN_FLESH;
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.level()
                        .addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()),
                                this.getX(),
                                this.getY(),
                                this.getZ(),
                                0.0D,
                                0.0D,
                                0.0D
                        );
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        hitResult.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 2.0F);
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }
}