package fuzs.refoundearth.fabric;

import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.refoundearth.RefoundEarth;
import net.fabricmc.api.ModInitializer;

public class RefoundEarthFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstructor.construct(RefoundEarth.MOD_ID, RefoundEarth::new);
    }
}
