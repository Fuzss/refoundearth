package fuzs.refoundearth.world.entity.animal;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.level.Level;

public class EarthRabbit extends Rabbit {

    public EarthRabbit(EntityType<? extends Rabbit> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public Rabbit getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return (Rabbit) this.getType().create(level);
    }

    @Override
    public Variant getVariant() {
        return Variant.BROWN;
    }

    @Override
    public void setVariant(Variant variant) {
        // NO-OP
    }
}
