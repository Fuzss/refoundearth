package com.itayfeder.restored_earth.client;

import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class RottenFleshEntity extends ProjectileItemEntity {
    public RottenFleshEntity(EntityType<? extends RottenFleshEntity> p_i50155_1_, World p_i50155_2_) {
        super(p_i50155_1_, p_i50155_2_);
    }

    public RottenFleshEntity(World p_i1774_1_, LivingEntity p_i1774_2_) {
        super(EntityInit.ROTTEN_FLESH, p_i1774_2_, p_i1774_1_);
    }

    public RottenFleshEntity(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
        super(EntityInit.ROTTEN_FLESH, p_i1775_2_, p_i1775_4_, p_i1775_6_, p_i1775_1_);
    }

    public RottenFleshEntity(FMLPlayMessages.SpawnEntity spawnEntity, World world) {
        this(EntityInit.ROTTEN_FLESH, world);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.ROTTEN_FLESH;
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData getParticle() {
        return  new ItemParticleData(ParticleTypes.ITEM, Items.ROTTEN_FLESH.getDefaultInstance());
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte p_70103_1_) {
        if (p_70103_1_ == 3) {
            IParticleData iparticledata = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(iparticledata, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)2);
    }

    protected void onHit(RayTraceResult p_70227_1_) {
        super.onHit(p_70227_1_);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.remove();
        }

    }
}
