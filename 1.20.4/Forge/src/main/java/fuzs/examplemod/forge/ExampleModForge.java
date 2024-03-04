package fuzs.examplemod.forge;

import fuzs.examplemod.ExampleMod;
import fuzs.puzzleslib.api.core.v1.ModConstructor;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

@Mod(ExampleMod.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleModForge {

    @SubscribeEvent
    public static void onConstructMod(final FMLConstructModEvent evt) {
        ModConstructor.construct(ExampleMod.MOD_ID, ExampleMod::new);
    }
}
