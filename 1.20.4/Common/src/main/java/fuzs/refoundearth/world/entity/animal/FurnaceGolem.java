package fuzs.refoundearth.world.entity.animal;

import fuzs.refoundearth.RefoundEarth;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.level.Level;

public class FurnaceGolem extends IronGolem {
    public static final String TAG_ANGERED = RefoundEarth.id("angered").toString();
    private static final EntityDataAccessor<Boolean> DATA_ANGERED_ID = SynchedEntityData.defineId(FurnaceGolem.class,
            EntityDataSerializers.BOOLEAN
    );

    public FurnaceGolem(EntityType<? extends FurnaceGolem> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean flag = super.doHurtTarget(target);
        if (flag && target instanceof LivingEntity) {
            target.setSecondsOnFire(2);
        }

        return flag;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ANGERED_ID, false);
    }

    public boolean isAngered() {
        return this.entityData.get(DATA_ANGERED_ID);
    }

    private void setAngered(boolean angered) {
        this.entityData.set(DATA_ANGERED_ID, angered);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean(TAG_ANGERED, this.isAngered());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setAngered(tag.getBoolean(TAG_ANGERED));
    }

    @Override
    public void tick() {
        super.tick();
        this.setAngered(this.isAngry());
    }
}
