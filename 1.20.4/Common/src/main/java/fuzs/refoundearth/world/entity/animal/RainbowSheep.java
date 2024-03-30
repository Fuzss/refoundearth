package fuzs.refoundearth.world.entity.animal;

import fuzs.refoundearth.init.ModBlocks;
import fuzs.refoundearth.init.ModEntityTypes;
import fuzs.refoundearth.init.ModLootTables;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;

public class RainbowSheep extends Sheep {

    public RainbowSheep(EntityType<? extends RainbowSheep> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public Sheep getBreedOffspring(ServerLevel serverLevel, AgeableMob otherParent) {
        return (Sheep) this.getType().create(serverLevel);
    }

    @Override
    public void shear(SoundSource source) {
        this.level().playSound(null, this, SoundEvents.SHEEP_SHEAR, source, 1.0F, 1.0F);
        this.setSheared(true);
        int i = 1 + this.random.nextInt(3);

        for (int j = 0; j < i; ++j) {
            ItemEntity item = this.spawnAtLocation(ModBlocks.RAINBOW_WOOL.value(), 1);
            if (item != null) {
                item.setDeltaMovement(item.getDeltaMovement()
                        .add((this.random.nextFloat() - this.random.nextFloat()) * 0.1F,
                                this.random.nextFloat() * 0.05F,
                                (this.random.nextFloat() - this.random.nextFloat()) * 0.1F
                        ));
            }
        }
    }

    @Override
    public ResourceLocation getDefaultLootTable() {
        return this.isSheared() ? super.getDefaultLootTable() : ModLootTables.SHEEP_RAINBOW;
    }
}
