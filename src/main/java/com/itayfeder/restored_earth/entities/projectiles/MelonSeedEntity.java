package com.itayfeder.restored_earth.entities.projectiles;

import com.itayfeder.restored_earth.entities.MelonGolemEntity;
import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.LlamaSpitEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class MelonSeedEntity extends LlamaSpitEntity {
    public MelonSeedEntity(EntityType<? extends MelonSeedEntity> p_i50162_1_, World p_i50162_2_) {
        super(p_i50162_1_, p_i50162_2_);
    }

    public MelonSeedEntity(World p_i47273_1_, MelonGolemEntity p_i47273_2_) {
        this(EntityInit.MELON_SEED, p_i47273_1_);
        super.setOwner(p_i47273_2_);
        this.setPos(p_i47273_2_.getX() - (double)(p_i47273_2_.getBbWidth() + 1.0F) * 0.5D * (double)MathHelper.sin(p_i47273_2_.yBodyRot * ((float)Math.PI / 180F)), p_i47273_2_.getEyeY() - (double)0.1F, p_i47273_2_.getZ() + (double)(p_i47273_2_.getBbWidth() + 1.0F) * 0.5D * (double)MathHelper.cos(p_i47273_2_.yBodyRot * ((float)Math.PI / 180F)));
    }

    @OnlyIn(Dist.CLIENT)
    public MelonSeedEntity(World p_i47274_1_, double p_i47274_2_, double p_i47274_4_, double p_i47274_6_, double p_i47274_8_, double p_i47274_10_, double p_i47274_12_) {
        this(EntityInit.MELON_SEED, p_i47274_1_);
        this.setPos(p_i47274_2_, p_i47274_4_, p_i47274_6_);

        this.setDeltaMovement(p_i47274_8_, p_i47274_10_, p_i47274_12_);
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
