package fuzs.refoundearth.init;

import fuzs.puzzleslib.api.init.v3.tags.BoundTagFactory;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

public class ModTags {
    static final BoundTagFactory TAGS = BoundTagFactory.make(RefoundEarth.MOD_ID);
    public static final TagKey<Fluid> MUD = TAGS.registerFluidTag("mud");

    public static void touch() {

    }
}
