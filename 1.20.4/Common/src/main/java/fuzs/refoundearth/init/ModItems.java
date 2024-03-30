package fuzs.refoundearth.init;

import com.itayfeder.restored_earth.items.JournalItem;
import fuzs.puzzleslib.api.init.v3.registry.RegistryManager;
import fuzs.refoundearth.RefoundEarth;
import net.minecraft.core.Holder;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItems {
    static final RegistryManager REGISTRY = RegistryManager.from(RefoundEarth.MOD_ID);
    public static final Holder.Reference<Item> MUD_BUCKET = REGISTRY.registerItem("mud_bucket", () -> new BucketItem(ModFluids.MUD.value(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final Holder.Reference<Item> FANCY_FEATHER = REGISTRY.registerItem("fancy_feather", () -> new Item((new Item.Properties())));
    public static final Holder.Reference<Item> HORN = REGISTRY.registerItem("horn", () -> new Item((new Item.Properties())));
    public static final Holder.Reference<Item> RAINBOW_WOOL = REGISTRY.registerBlockItem(ModBlocks.RAINBOW_WOOL);
    public static final Holder.Reference<Item> RAINBOW_CARPET = REGISTRY.registerBlockItem(ModBlocks.RAINBOW_CARPET);
    public static final Holder.Reference<Item> RAINBOW_BED = REGISTRY.registerBlockItem(ModBlocks.RAINBOW_BED);
    public static final Holder.Reference<Item> BUTTERCUP = REGISTRY.registerBlockItem(ModBlocks.BUTTERCUP);
    public static final Holder.Reference<Item> PINK_DAISY = REGISTRY.registerBlockItem(ModBlocks.PINK_DAISY);
    public static final Holder.Reference<Item> CARVED_MELON = REGISTRY.registerBlockItem(ModBlocks.CARVED_MELON);
    public static final Holder.Reference<Item> MUDDY_PIG_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.MUDDY_PIG, 15771042, 5912611);
    public static final Holder.Reference<Item> WOOLY_COW_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.WOOLY_COW, 13926720, 16634012);
    public static final Holder.Reference<Item> JUMBO_RABBIT_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.JUMBO_RABBIT, 14261130, 15846073);
    public static final Holder.Reference<Item> FANCY_CHICKEN_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.FANCY_CHICKEN, 2504745, 16032275);
    public static final Holder.Reference<Item> RAINBOW_SHEEP_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.RAINBOW_SHEEP, 16777215, 16777215);
    public static final Holder.Reference<Item> JOLLY_LLAMA_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.JOLLY_LLAMA, 6764327, 2446631);
    public static final Holder.Reference<Item> VILER_WITCH_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.VILER_WITCH, 11247501, 1316907);
    public static final Holder.Reference<Item> TROPICAL_SLIME_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.TROPICAL_SLIME, 2514301, 16036882);
    public static final Holder.Reference<Item> MOOBLOOM_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.MOOBLOOM, 16635136, 16644026);
    public static final Holder.Reference<Item> BOULDERING_ZOMBIE_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.BOULDERING_ZOMBIE, 5068634, 5909021);
    public static final Holder.Reference<Item> SKELETON_WOLF_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.SKELETON_WOLF, 13355465, 14954030);
    public static final Holder.Reference<Item> BONE_SPIDER_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.BONE_SPIDER, 3938857, 14084069);
    public static final Holder.Reference<Item> MOOLIP_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.MOOLIP, 16226494, 16644026);
    public static final Holder.Reference<Item> CLUCKSHROOM_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.CLUCKSHROOM, 13835810, 16171930);
    public static final Holder.Reference<Item> LOBBER_ZOMBIE_SPAWN_EGG = REGISTRY.registerSpawnEggItem(ModEntityTypes.LOBBER_ZOMBIE, 9015924, 6323223);
    public static final Holder.Reference<Item> JOURNAL = REGISTRY.registerItem("journal", () -> new JournalItem((new Item.Properties())));

    public static void touch() {

    }
}
