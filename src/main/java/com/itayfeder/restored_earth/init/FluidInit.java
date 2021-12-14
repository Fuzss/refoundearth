package com.itayfeder.restored_earth.init;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.fluids.MudFluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FluidInit {
    public static final FlowingFluid FLOWING_MUD = new MudFluid.Flowing();
    public static final FlowingFluid MUD = new MudFluid.Source();

    public static void register(IForgeRegistry<Fluid> registry, Fluid fluid, String id) {
        fluid.setRegistryName(new ResourceLocation(RestoredEarthMod.MOD_ID, id));
        registry.register(fluid);
    }

    @SubscribeEvent
    public static void registerFluids(RegistryEvent.Register<Fluid> registry) {
        register(registry.getRegistry(), FLOWING_MUD, "flowing_mud");
        register(registry.getRegistry(), MUD, "mud");
    }
}
