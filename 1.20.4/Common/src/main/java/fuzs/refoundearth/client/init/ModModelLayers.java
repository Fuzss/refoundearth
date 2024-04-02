package fuzs.refoundearth.client.init;

import fuzs.puzzleslib.api.client.init.v1.ModelLayerFactory;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.client.model.geom.ModelLayerLocation;

public class ModModelLayers {
    static final ModelLayerFactory MODEL_LAYERS = ModelLayerFactory.from(RefoundEarth.MOD_ID);
    public static final ModelLayerLocation MUDDY_PIG = MODEL_LAYERS.register("muddy_pig");
    public static final ModelLayerLocation WOOLY_COW = MODEL_LAYERS.register("wooly_cow");
    public static final ModelLayerLocation JUMBO_RABBIT = MODEL_LAYERS.register("jumbo_rabbit");
    public static final ModelLayerLocation FANCY_CHICKEN = MODEL_LAYERS.register("fancy_chicken");
    public static final ModelLayerLocation RAINBOW_SHEEP = MODEL_LAYERS.register("rainbow_sheep");
    public static final ModelLayerLocation RAINBOW_SHEEP_FUR = MODEL_LAYERS.register("rainbow_sheep", "fur");
    public static final ModelLayerLocation JOLLY_LLAMA = MODEL_LAYERS.register("jolly_llama");
    public static final ModelLayerLocation VILER_WITCH = MODEL_LAYERS.register("viler_witch");
    public static final ModelLayerLocation TROPICAL_SLIME = MODEL_LAYERS.register("tropical_slime");
    public static final ModelLayerLocation TROPICAL_SLIME_OUTER = MODEL_LAYERS.register("tropical_slime", "outer");
    public static final ModelLayerLocation MELON_GOLEM = MODEL_LAYERS.register("melon_golem");
    public static final ModelLayerLocation MOOBLOOM = MODEL_LAYERS.register("moobloom");
    public static final ModelLayerLocation BOULDERING_ZOMBIE = MODEL_LAYERS.register("bouldering_zombie");
    public static final ModelLayerLocation FURNACE_GOLEM = MODEL_LAYERS.register("furnace_golem");
    public static final ModelLayerLocation SKELETON_WOLF = MODEL_LAYERS.register("skeleton_wolf");
    public static final ModelLayerLocation BONE_SPIDER = MODEL_LAYERS.register("bone_spider");
    public static final ModelLayerLocation MELON_SEED = MODEL_LAYERS.register("melon_seed");
    public static final ModelLayerLocation MOOLIP = MODEL_LAYERS.register("moolip");
    public static final ModelLayerLocation CLUCKSHROOM = MODEL_LAYERS.register("cluckshroom");
    public static final ModelLayerLocation LOBBER_ZOMBIE = MODEL_LAYERS.register("lobber_zombie");
    public static final ModelLayerLocation LOBBER_ZOMBIE_INNER_ARMOR = MODEL_LAYERS.registerInnerArmor("lobber_zombie");
    public static final ModelLayerLocation LOBBER_ZOMBIE_OUTER_ARMOR = MODEL_LAYERS.registerOuterArmor("lobber_zombie");
}
