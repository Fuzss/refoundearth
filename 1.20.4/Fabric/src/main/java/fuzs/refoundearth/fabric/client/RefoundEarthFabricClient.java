package fuzs.refoundearth.fabric.client;

import fuzs.refoundearth.RefoundEarth;
import fuzs.refoundearth.client.RefoundEarthClient;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class RefoundEarthFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(RefoundEarth.MOD_ID, RefoundEarthClient::new);
    }
}
