package fuzs.refoundearth.world.entity.monster;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BoulderingZombie extends Zombie {
    private static final EntityDataAccessor<Boolean> DATA_CLIMBING_ID = SynchedEntityData.defineId(BoulderingZombie.class,
            EntityDataSerializers.BOOLEAN
    );

    public BoulderingZombie(EntityType<? extends BoulderingZombie> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected ItemStack getSkull() {
        return ItemStack.EMPTY;
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        return new WallClimberNavigation(this, level);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_CLIMBING_ID, false);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }
    }

    @Override
    public boolean onClimbable() {
        return this.isClimbing();
    }

    public boolean isClimbing() {
        return this.entityData.get(DATA_CLIMBING_ID);
    }

    public void setClimbing(boolean climbing) {
        this.entityData.set(DATA_CLIMBING_ID, climbing);
    }
}
