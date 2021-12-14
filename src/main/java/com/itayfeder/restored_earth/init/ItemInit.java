package com.itayfeder.restored_earth.init;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.items.JournalItem;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {
    public static final Item MUD_BUCKET = new BucketItem(FluidInit.MUD, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(ItemGroup.TAB_MISC));
    public static final Item FANCY_FEATHER = new Item((new Item.Properties()).tab(ItemGroup.TAB_MATERIALS));
    public static final Item HORN = new Item((new Item.Properties()).tab(ItemGroup.TAB_MATERIALS));

    public static final Item RAINBOW_WOOL = new BlockItem(BlockInit.RAINBOW_WOOL, (new Item.Properties()).tab(ItemGroup.TAB_BUILDING_BLOCKS));
    public static final Item RAINBOW_CARPET = new BlockItem(BlockInit.RAINBOW_CARPET, (new Item.Properties()).tab(ItemGroup.TAB_DECORATIONS));
    public static final Item RAINBOW_BED = new BlockItem(BlockInit.RAINBOW_BED, (new Item.Properties()).tab(ItemGroup.TAB_DECORATIONS));
    public static final Item BUTTERCUP = new BlockItem(BlockInit.BUTTERCUP, (new Item.Properties()).tab(ItemGroup.TAB_DECORATIONS));
    public static final Item PINK_DAISY = new BlockItem(BlockInit.PINK_DAISY, (new Item.Properties()).tab(ItemGroup.TAB_DECORATIONS));
    public static final Item CARVED_MELON = new BlockItem(BlockInit.CARVED_MELON, (new Item.Properties()).tab(ItemGroup.TAB_BUILDING_BLOCKS));

    public static final Item MUDDY_PIG_SPAWN_EGG = new SpawnEggItem(EntityInit.MUDDY_PIG, 15771042, 5912611, (new Item.Properties()).tab(ItemGroup.TAB_MISC));
    public static final Item WOOLY_COW_SPAWN_EGG = new SpawnEggItem(EntityInit.WOOLY_COW, 13926720, 16634012, (new Item.Properties()).tab(ItemGroup.TAB_MISC));
    public static final Item JUMBO_RABBIT_SPAWN_EGG = new SpawnEggItem(EntityInit.JUMBO_RABBIT, 14261130, 15846073, (new Item.Properties()).tab(ItemGroup.TAB_MISC));
    public static final Item FANCY_CHICKEN_SPAWN_EGG = new SpawnEggItem(EntityInit.FANCY_CHICKEN, 2504745, 16032275, (new Item.Properties()).tab(ItemGroup.TAB_MISC));
    public static final Item RAINBOW_SHEEP_SPAWN_EGG = new SpawnEggItem(EntityInit.RAINBOW_SHEEP, 16777215, 16777215, (new Item.Properties()).tab(ItemGroup.TAB_MISC));
    public static final Item JOLLY_LLAMA_SPAWN_EGG = new SpawnEggItem(EntityInit.JOLLY_LLAMA, 6764327, 2446631, (new Item.Properties()).tab(ItemGroup.TAB_MISC));
    public static final Item VILER_WITCH_SPAWN_EGG = new SpawnEggItem(EntityInit.VILER_WITCH, 11247501, 1316907, (new Item.Properties()).tab(ItemGroup.TAB_MISC));
    public static final Item TROPICAL_SLIME_SPAWN_EGG = new SpawnEggItem(EntityInit.TROPICAL_SLIME, 2514301, 16036882, (new Item.Properties()).tab(ItemGroup.TAB_MISC));
    public static final Item MOOBLOOM_SPAWN_EGG = new SpawnEggItem(EntityInit.MOOBLOOM, 16635136, 16644026, (new Item.Properties()).tab(ItemGroup.TAB_MISC));
    public static final Item BOULDERING_ZOMBIE_SPAWN_EGG = new SpawnEggItem(EntityInit.BOULDERING_ZOMBIE, 5068634, 5909021, (new Item.Properties()).tab(ItemGroup.TAB_MISC));
    public static final Item SKELETON_WOLF_SPAWN_EGG = new SpawnEggItem(EntityInit.SKELETON_WOLF, 13355465, 14954030, (new Item.Properties()).tab(ItemGroup.TAB_MISC));
    public static final Item BONE_SPIDER_SPAWN_EGG = new SpawnEggItem(EntityInit.BONE_SPIDER, 3938857, 14084069, (new Item.Properties()).tab(ItemGroup.TAB_MISC));
    public static final Item MOOLIP_SPAWN_EGG = new SpawnEggItem(EntityInit.MOOLIP, 16226494, 16644026, (new Item.Properties()).tab(ItemGroup.TAB_MISC));
    public static final Item CLUCKSHROOM_SPAWN_EGG = new SpawnEggItem(EntityInit.CLUCKSHROOM, 13835810, 16171930, (new Item.Properties()).tab(ItemGroup.TAB_MISC));

    public static final Item JOURNAL = new JournalItem((new Item.Properties()).tab(ItemGroup.TAB_MATERIALS));


    public static void register(IForgeRegistry<Item> registry, Item item, String id) {
        item.setRegistryName(new ResourceLocation(RestoredEarthMod.MOD_ID, id));
        registry.register(item);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> registry) {
        register(registry.getRegistry(), MUD_BUCKET, "mud_bucket");
        register(registry.getRegistry(), FANCY_FEATHER, "fancy_feather");
        register(registry.getRegistry(), HORN, "horn");

        register(registry.getRegistry(), RAINBOW_WOOL, "rainbow_wool");
        register(registry.getRegistry(), RAINBOW_CARPET, "rainbow_carpet");
        register(registry.getRegistry(), RAINBOW_BED, "rainbow_bed");
        register(registry.getRegistry(), BUTTERCUP, "buttercup");
        register(registry.getRegistry(), PINK_DAISY, "pink_daisy");
        register(registry.getRegistry(), CARVED_MELON, "carved_melon");

        register(registry.getRegistry(), MUDDY_PIG_SPAWN_EGG, "muddy_pig_spawn_egg");
        register(registry.getRegistry(), WOOLY_COW_SPAWN_EGG, "wooly_cow_spawn_egg");
        register(registry.getRegistry(), JUMBO_RABBIT_SPAWN_EGG, "jumbo_rabbit_spawn_egg");
        register(registry.getRegistry(), FANCY_CHICKEN_SPAWN_EGG, "fancy_chicken_spawn_egg");
        register(registry.getRegistry(), RAINBOW_SHEEP_SPAWN_EGG, "rainbow_sheep_spawn_egg");
        register(registry.getRegistry(), JOLLY_LLAMA_SPAWN_EGG, "jolly_llama_spawn_egg");
        register(registry.getRegistry(), VILER_WITCH_SPAWN_EGG, "viler_witch_spawn_egg");
        register(registry.getRegistry(), TROPICAL_SLIME_SPAWN_EGG, "tropical_slime_spawn_egg");
        register(registry.getRegistry(), MOOBLOOM_SPAWN_EGG, "moobloom_spawn_egg");
        register(registry.getRegistry(), BOULDERING_ZOMBIE_SPAWN_EGG, "bouldering_zombie_spawn_egg");
        register(registry.getRegistry(), SKELETON_WOLF_SPAWN_EGG, "skeleton_wolf_spawn_egg");
        register(registry.getRegistry(), BONE_SPIDER_SPAWN_EGG, "bone_spider_spawn_egg");
        register(registry.getRegistry(), MOOLIP_SPAWN_EGG, "moolip_spawn_egg");
        register(registry.getRegistry(), CLUCKSHROOM_SPAWN_EGG, "cluckshroom_spawn_egg");

        register(registry.getRegistry(), JOURNAL, "journal");

    }
}
