package fuzs.refoundearth.init;

import com.itayfeder.restored_earth.fluids.MudFluid;
import fuzs.puzzleslib.api.init.v3.registry.RegistryManager;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.core.Holder;
import net.minecraft.world.level.material.Fluid;

public class ModFluids {
    static final RegistryManager REGISTRY = RegistryManager.from(RefoundEarth.MOD_ID);
    public static final Holder.Reference<Fluid> FLOWING_MUD = REGISTRY.registerFluid("flowing_mud", () -> new MudFluid.Flowing());
    public static final Holder.Reference<Fluid> MUD = REGISTRY.registerFluid("mud", () -> new MudFluid.Source());

    public static void touch() {

    }
}
