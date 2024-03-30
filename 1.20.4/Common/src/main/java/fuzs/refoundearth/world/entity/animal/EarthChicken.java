package fuzs.refoundearth.world.entity.animal;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.level.Level;

public class EarthChicken extends Chicken {

    public EarthChicken(EntityType<? extends Chicken> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public Chicken getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return (Chicken) this.getType().create(level);
    }
}
