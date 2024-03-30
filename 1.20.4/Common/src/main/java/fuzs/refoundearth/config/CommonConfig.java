package fuzs.refoundearth.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CommonConfig {
    public static final String CATEGORY_SPAWNING = "spawning";

    public static ModConfigSpec SERVER_CONFIG;

    public static ModConfigSpec.BooleanValue WOOLY_COW_SPAWNING;
    public static ModConfigSpec.BooleanValue JUMBO_RABBIT_SPAWNING;
    public static ModConfigSpec.BooleanValue FANCY_CHICKEN_SPAWNING;
    public static ModConfigSpec.BooleanValue RAINBOW_SHEEP_SPAWNING;
    public static ModConfigSpec.BooleanValue JOLLY_LLAMA_SPAWNING;
    public static ModConfigSpec.BooleanValue VILER_WITCH_SPAWNING;
    public static ModConfigSpec.BooleanValue TROPICAL_SLIME_SPAWNING;
    public static ModConfigSpec.BooleanValue MOOBLOOM_SPAWNING;
    public static ModConfigSpec.BooleanValue BOULDERING_ZOMBIE_SPAWNING;
    public static ModConfigSpec.BooleanValue SKELETON_WOLF_SPAWNING;
    public static ModConfigSpec.BooleanValue BONE_SPIDER_SPAWNING;
    public static ModConfigSpec.BooleanValue MOOLIP_SPAWNING;
    public static ModConfigSpec.BooleanValue CLUCKSHROOM_SPAWNING;
    public static ModConfigSpec.BooleanValue LOBBER_ZOMBIE_SPAWNING;

    static {
        ModConfigSpec.Builder SERVER_BUILDER = new ModConfigSpec.Builder();

        SERVER_BUILDER.comment("Spawn settings:").push(CATEGORY_SPAWNING);
        WOOLY_COW_SPAWNING = SERVER_BUILDER.comment("Will the Wooly Cow spawn in the wild.")
                .define("woolyCowSpawn", true);
        JUMBO_RABBIT_SPAWNING = SERVER_BUILDER.comment("Will the Jumbo Rabbit spawn in the wild.")
                .define("jumboRabbitSpawn", true);
        FANCY_CHICKEN_SPAWNING = SERVER_BUILDER.comment("Will the Fancy Chicken spawn in the wild.")
                .define("fancyChickenSpawn", true);
        RAINBOW_SHEEP_SPAWNING = SERVER_BUILDER.comment("Will the Rainbow Sheep spawn in the wild.")
                .define("rainbowSheepSpawn", true);
        JOLLY_LLAMA_SPAWNING = SERVER_BUILDER.comment("Will the Jolly Llama spawn in the wild.")
                .define("jollyLlamaSpawn", true);
        VILER_WITCH_SPAWNING = SERVER_BUILDER.comment("Will the Viler Witch spawn in the wild.")
                .define("vilerWitchSpawn", true);
        TROPICAL_SLIME_SPAWNING = SERVER_BUILDER.comment("Will the Tropical Slime spawn in the wild.")
                .define("tropicalSlimeSpawn", false);
        MOOBLOOM_SPAWNING = SERVER_BUILDER.comment("Will the Moobloom spawn in the wild.")
                .define("moobloomSpawn", true);
        BOULDERING_ZOMBIE_SPAWNING = SERVER_BUILDER.comment("Will the Bouldering Zombie spawn in the wild.")
                .define("boulderingZombieSpawn", true);
        SKELETON_WOLF_SPAWNING = SERVER_BUILDER.comment("Will the Skeleton Wolf spawn in the wild.")
                .define("skeletonWolfSpawn", true);
        BONE_SPIDER_SPAWNING = SERVER_BUILDER.comment("Will the Bone Spider spawn in the wild.")
                .define("boneSpiderSpawn", true);
        MOOLIP_SPAWNING = SERVER_BUILDER.comment("Will the Moolip spawn in the wild.")
                .define("moolipSpawn", true);
        CLUCKSHROOM_SPAWNING = SERVER_BUILDER.comment("Will the Cluckshroom spawn in the wild.")
                .define("cluckshroomSpawn", true);
        LOBBER_ZOMBIE_SPAWNING = SERVER_BUILDER.comment("Will the Lobber Zombie spawn in the wild.")
                .define("lobberZombieSpawn", true);
        SERVER_BUILDER.pop();


        SERVER_CONFIG = SERVER_BUILDER.build();
    }
}
