package fuzs.refoundearth.init;

import fuzs.puzzleslib.api.init.v3.registry.RegistryManager;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {
    static final RegistryManager REGISTRY = RegistryManager.from(RefoundEarth.MOD_ID);
    public static final Holder.Reference<SoundEvent> SKELETON_WOLF_IDLE = REGISTRY.registerSoundEvent("entity.skeleton_wolf.idle");
    public static final Holder.Reference<SoundEvent> SKELETON_WOLF_HURT = REGISTRY.registerSoundEvent("entity.skeleton_wolf.hurt");
    public static final Holder.Reference<SoundEvent> SKELETON_WOLF_DEATH = REGISTRY.registerSoundEvent("entity.skeleton_wolf.death");
    public static final Holder.Reference<SoundEvent> BONE_SPIDER_IDLE = REGISTRY.registerSoundEvent("entity.bone_spider.idle");
    public static final Holder.Reference<SoundEvent> BONE_SPIDER_DEATH = REGISTRY.registerSoundEvent("entity.bone_spider.death");

    public static void touch() {

    }
}
