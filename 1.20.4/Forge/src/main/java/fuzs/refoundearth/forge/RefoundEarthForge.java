package fuzs.refoundearth.forge;

import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.refoundearth.RefoundEarth;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

@Mod(RefoundEarth.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RefoundEarthForge {

    @SubscribeEvent
    public static void onConstructMod(final FMLConstructModEvent evt) {
        ModConstructor.construct(RefoundEarth.MOD_ID, RefoundEarth::new);
    }
}
