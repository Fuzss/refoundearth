package com.itayfeder.restored_earth.utils;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class Config {
    public static final String CATEGORY_SPAWNING = "spawning";

    public static ForgeConfigSpec SERVER_CONFIG;

    public static ForgeConfigSpec.BooleanValue WOOLY_COW_SPAWNING;
    public static ForgeConfigSpec.BooleanValue JUMBO_RABBIT_SPAWNING;
    public static ForgeConfigSpec.BooleanValue FANCY_CHICKEN_SPAWNING;
    public static ForgeConfigSpec.BooleanValue RAINBOW_SHEEP_SPAWNING;
    public static ForgeConfigSpec.BooleanValue JOLLY_LLAMA_SPAWNING;
    public static ForgeConfigSpec.BooleanValue VILER_WITCH_SPAWNING;
    public static ForgeConfigSpec.BooleanValue TROPICAL_SLIME_SPAWNING;
    public static ForgeConfigSpec.BooleanValue MOOBLOOM_SPAWNING;
    public static ForgeConfigSpec.BooleanValue BOULDERING_ZOMBIE_SPAWNING;
    public static ForgeConfigSpec.BooleanValue SKELETON_WOLF_SPAWNING;
    public static ForgeConfigSpec.BooleanValue BONE_SPIDER_SPAWNING;
    public static ForgeConfigSpec.BooleanValue MOOLIP_SPAWNING;
    public static ForgeConfigSpec.BooleanValue CLUCKSHROOM_SPAWNING;

    static {
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();

        SERVER_BUILDER.comment("Spawn settings:").push(CATEGORY_SPAWNING);
        WOOLY_COW_SPAWNING = SERVER_BUILDER.comment("Will the Wooly Cow spawn in the wild")
                .define("woolyCowSpawn", true);
        JUMBO_RABBIT_SPAWNING = SERVER_BUILDER.comment("Will the Jumbo Rabbit spawn in the wild")
                .define("jumboRabbitSpawn", true);
        FANCY_CHICKEN_SPAWNING = SERVER_BUILDER.comment("Will the Fancy Chicken spawn in the wild")
                .define("fancyChickenSpawn", true);
        RAINBOW_SHEEP_SPAWNING = SERVER_BUILDER.comment("Will the Rainbow Sheep spawn in the wild")
                .define("rainbowSheepSpawn", true);
        JOLLY_LLAMA_SPAWNING = SERVER_BUILDER.comment("Will the Jolly Llama spawn in the wild")
                .define("jollyLlamaSpawn", true);
        VILER_WITCH_SPAWNING = SERVER_BUILDER.comment("Will the Viler Witch spawn in the wild")
                .define("vilerWitchSpawn", true);
        TROPICAL_SLIME_SPAWNING = SERVER_BUILDER.comment("Will the Tropical Slime spawn in the wild")
                .define("tropicalSlimeSpawn", false);
        MOOBLOOM_SPAWNING = SERVER_BUILDER.comment("Will the Moobloom spawn in the wild")
                .define("moobloomSpawn", true);
        BOULDERING_ZOMBIE_SPAWNING = SERVER_BUILDER.comment("Will the Bouldering Zombie spawn in the wild")
                .define("boulderingZombieSpawn", true);
        SKELETON_WOLF_SPAWNING = SERVER_BUILDER.comment("Will the Skeleton Wolf spawn in the wild")
                .define("skeletonWolfSpawn", true);
        BONE_SPIDER_SPAWNING = SERVER_BUILDER.comment("Will the Bone Spider spawn in the wild")
                .define("boneSpiderSpawn", true);
        MOOLIP_SPAWNING = SERVER_BUILDER.comment("Will the Moolip spawn in the wild")
                .define("moolipSpawn", true);
        CLUCKSHROOM_SPAWNING = SERVER_BUILDER.comment("Will the Cluckshroom spawn in the wild")
                .define("cluckshroomSpawn", true);
        SERVER_BUILDER.pop();


        SERVER_CONFIG = SERVER_BUILDER.build();
    }
}
