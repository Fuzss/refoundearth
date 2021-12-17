package com.itayfeder.restored_earth.entities.projectiles;

import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.fmllegacy.network.FMLPlayMessages;
import net.minecraftforge.fmllegacy.network.ICustomPacket;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

public class RottenFlesh extends ThrowableItemProjectile {
    public RottenFlesh(EntityType<? extends RottenFlesh> p_37391_, Level p_37392_) {
        super(p_37391_, p_37392_);
    }

    public RottenFlesh(Level p_37399_, LivingEntity p_37400_) {
        super(EntityInit.ROTTEN_FLESH, p_37400_, p_37399_);
    }

    public RottenFlesh(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
        super(EntityInit.ROTTEN_FLESH, p_37395_, p_37396_, p_37397_, p_37394_);
    }

    public RottenFlesh(FMLPlayMessages.SpawnEntity spawnEntity, Level world) {
        this(EntityInit.ROTTEN_FLESH, world);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    protected Item getDefaultItem() {
        return Items.ROTTEN_FLESH;
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return new ItemParticleOption(ParticleTypes.ITEM,  Items.ROTTEN_FLESH.getDefaultInstance());
    }

    public void handleEntityEvent(byte p_37402_) {
        if (p_37402_ == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    protected void onHitEntity(EntityHitResult p_37404_) {
        super.onHitEntity(p_37404_);
        Entity entity = p_37404_.getEntity();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)2);
    }

    protected void onHit(HitResult p_37406_) {
        super.onHit(p_37406_);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();
        }

    }
}