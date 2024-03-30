package fuzs.refoundearth.neoforge;

import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.refoundearth.RefoundEarth;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;

@Mod(RefoundEarth.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RefoundEarthNeoForge {

    @SubscribeEvent
    public static void onConstructMod(final FMLConstructModEvent evt) {
        ModConstructor.construct(RefoundEarth.MOD_ID, RefoundEarth::new);
    }
}
