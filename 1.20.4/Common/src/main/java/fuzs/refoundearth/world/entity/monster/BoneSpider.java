package fuzs.refoundearth.world.entity.monster;

import fuzs.refoundearth.init.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

public class BoneSpider extends Spider {

    public BoneSpider(EntityType<? extends BoneSpider> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 32.0)
                .add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.BONE_SPIDER_IDLE.value();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.BONE_SPIDER_DEATH.value();
    }

    @Override
    protected float getSoundVolume() {
        return 0.5F;
    }
}
