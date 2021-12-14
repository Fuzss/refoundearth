package com.itayfeder.restored_earth.init;

import com.itayfeder.restored_earth.RestoredEarthMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoundInit {
    public static final SoundEvent SKELETON_WOLF_IDLE = create("entity.skeleton_wolf.idle");
    public static final SoundEvent SKELETON_WOLF_HURT = create("entity.skeleton_wolf.hurt");
    public static final SoundEvent SKELETON_WOLF_DEATH = create("entity.skeleton_wolf.death");

    public static final SoundEvent BONE_SPIDER_IDLE = create("entity.bone_spider.idle");
    public static final SoundEvent BONE_SPIDER_DEATH = create("entity.bone_spider.death");

    private static SoundEvent create(String p_219592_0_) {
        return new SoundEvent(new ResourceLocation(RestoredEarthMod.MOD_ID, p_219592_0_)).setRegistryName(new ResourceLocation(RestoredEarthMod.MOD_ID, p_219592_0_));
    }

    @SubscribeEvent
    public static void register(final RegistryEvent.Register<SoundEvent> event) {
        try {
            Field[] fields = SoundInit.class.getDeclaredFields();
            for (Field f : fields) {
                Object obj = f.get(null);
                if (obj instanceof SoundEvent) {
                    event.getRegistry().register((SoundEvent) obj);
                }
            }
        } catch (Exception e) {
        }
    }
}
