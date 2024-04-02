package fuzs.refoundearth.world.entity.projectile;

import fuzs.refoundearth.init.ModEntityTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.LlamaSpit;
import net.minecraft.world.level.Level;

public class MelonSeed extends LlamaSpit {

    public MelonSeed(EntityType<? extends MelonSeed> entityType, Level level) {
        super(entityType, level);
    }

    public MelonSeed(Level level, LivingEntity spitter) {
        this(ModEntityTypes.MELON_SEED.value(), level);
        this.setOwner(spitter);
        this.setPos(spitter.getX() - (double)(spitter.getBbWidth() + 1.0F) * 0.5 * (double)Mth.sin(spitter.yBodyRot * 0.017453292F), spitter.getEyeY() - 0.1, spitter.getZ() + (double)(spitter.getBbWidth() + 1.0F) * 0.5 * (double)Mth.cos(spitter.yBodyRot * 0.017453292F));
    }
}
