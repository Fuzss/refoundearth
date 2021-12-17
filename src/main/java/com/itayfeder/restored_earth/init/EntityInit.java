package com.itayfeder.restored_earth.init;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.entities.*;
import com.itayfeder.restored_earth.entities.projectiles.MelonSeed;
import com.itayfeder.restored_earth.entities.projectiles.RottenFlesh;
import com.itayfeder.restored_earth.utils.JournalEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.projectile.LlamaSpit;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityInit {

    public static final EntityType<MuddyPig> MUDDY_PIG = EntityType.Builder.<MuddyPig>of(MuddyPig::new, MobCategory.CREATURE)
            .sized(0.9F, 0.9F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "muddy_pig").toString());

    public static final EntityType<WoolyCow> WOOLY_COW = EntityType.Builder.<WoolyCow>of(WoolyCow::new, MobCategory.CREATURE)
            .sized(0.9F, 1.4F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "wooly_cow").toString());

    public static final EntityType<JumboRabbit> JUMBO_RABBIT = EntityType.Builder.<JumboRabbit>of(JumboRabbit::new, MobCategory.CREATURE)
            .sized(.75F, .75F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "jumbo_rabbit").toString());

    public static final EntityType<FancyChicken> FANCY_CHICKEN = EntityType.Builder.<FancyChicken>of(FancyChicken::new, MobCategory.CREATURE)
            .sized(0.4F, 0.8F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "fancy_chicken").toString());

    public static final EntityType<RainbowSheep> RAINBOW_SHEEP = EntityType.Builder.<RainbowSheep>of(RainbowSheep::new, MobCategory.CREATURE)
            .sized(0.9F, 1.2F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "rainbow_sheep").toString());

    public static final EntityType<JollyLlama> JOLLY_LLAMA = EntityType.Builder.<JollyLlama>of(JollyLlama::new, MobCategory.CREATURE)
            .sized(0.9F, 1.87F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "jolly_llama").toString());

    public static final EntityType<VilerWitch> VILER_WITCH = EntityType.Builder.<VilerWitch>of(VilerWitch::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F).clientTrackingRange(8)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "viler_witch").toString());

    public static final EntityType<TropicalSlime> TROPICAL_SLIME = EntityType.Builder.<TropicalSlime>of(TropicalSlime::new, MobCategory.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "tropical_slime").toString());

    public static final EntityType<MelonGolem> MELON_GOLEM = EntityType.Builder.<MelonGolem>of(MelonGolem::new, MobCategory.MISC).immuneTo(Blocks.POWDER_SNOW)
            .sized(0.7F, 1.9F).clientTrackingRange(8)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "melon_golem").toString());

    public static final EntityType<Moobloom> MOOBLOOM = EntityType.Builder.<Moobloom>of(Moobloom::new, MobCategory.CREATURE)
            .sized(0.9F, 1.4F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "moobloom").toString());

    public static final EntityType<BoulderingZombie> BOULDERING_ZOMBIE = EntityType.Builder.<BoulderingZombie>of(BoulderingZombie::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F).clientTrackingRange(8)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "bouldering_zombie").toString());

    public static final EntityType<FurnaceGolem> FURNACE_GOLEM = EntityType.Builder.<FurnaceGolem>of(FurnaceGolem::new, MobCategory.MISC)
            .sized(1.4F, 2.7F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "furnace_golem").toString());

    public static final EntityType<SkeletonWolf> SKELETON_WOLF = EntityType.Builder.<SkeletonWolf>of(SkeletonWolf::new, MobCategory.MONSTER)
            .sized(0.6F, 0.85F).clientTrackingRange(8)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "skeleton_wolf").toString());

    public static final EntityType<BoneSpider> BONE_SPIDER = EntityType.Builder.<BoneSpider>of(BoneSpider::new, MobCategory.MONSTER)
            .sized(1.4F, 0.9F).clientTrackingRange(8)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "bone_spider").toString());

    public static final EntityType<Moolip> MOOLIP = EntityType.Builder.<Moolip>of(Moolip::new, MobCategory.CREATURE)
            .sized(0.9F, 1.4F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "moolip").toString());

    public static final EntityType<Cluckshroom> CLUCKSHROOM = EntityType.Builder.<Cluckshroom>of(Cluckshroom::new, MobCategory.CREATURE)
            .sized(0.4F, 0.8F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "cluckshroom").toString());

    public static final EntityType<LobberZombie> LOBBER_ZOMBIE = EntityType.Builder.<LobberZombie>of(LobberZombie::new, MobCategory.MONSTER)
            .sized(0.6F, 1.95F).clientTrackingRange(8)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "lobber_zombie").toString());

    public static final JournalEntry[] JOURNAL_ENTRIES = {
            new JournalEntry(MUDDY_PIG, 30, EntityType.PIG, ItemInit.MUDDY_PIG_SPAWN_EGG),
            new JournalEntry(WOOLY_COW, 28, EntityType.COW, ItemInit.WOOLY_COW_SPAWN_EGG),
            new JournalEntry(JUMBO_RABBIT, 30, EntityType.RABBIT, ItemInit.JUMBO_RABBIT_SPAWN_EGG),
            new JournalEntry(FANCY_CHICKEN, 36, EntityType.CHICKEN, ItemInit.FANCY_CHICKEN_SPAWN_EGG),
            new JournalEntry(RAINBOW_SHEEP, 30, EntityType.SHEEP, ItemInit.RAINBOW_SHEEP_SPAWN_EGG),
            new JournalEntry(JOLLY_LLAMA, 20, EntityType.LLAMA, ItemInit.JOLLY_LLAMA_SPAWN_EGG),
            new JournalEntry(VILER_WITCH, 20, EntityType.WITCH, ItemInit.VILER_WITCH_SPAWN_EGG),
            new JournalEntry(TROPICAL_SLIME, 30, EntityType.SLIME, ItemInit.TROPICAL_SLIME_SPAWN_EGG),
            new JournalEntry(MELON_GOLEM, 24, EntityType.SNOW_GOLEM, Items.SNOWBALL),
            new JournalEntry(MOOBLOOM, 28, EntityType.COW, ItemInit.MOOBLOOM_SPAWN_EGG),
            new JournalEntry(BOULDERING_ZOMBIE, 24, EntityType.ZOMBIE, ItemInit.BOULDERING_ZOMBIE_SPAWN_EGG),
            new JournalEntry(FURNACE_GOLEM, 20, EntityType.IRON_GOLEM, Items.BLAST_FURNACE),
            new JournalEntry(SKELETON_WOLF, 36, EntityType.WOLF, ItemInit.SKELETON_WOLF_SPAWN_EGG),
            new JournalEntry(BONE_SPIDER, 24, EntityType.SPIDER, ItemInit.BONE_SPIDER_SPAWN_EGG),
            new JournalEntry(MOOLIP, 28, EntityType.COW, ItemInit.MOOLIP_SPAWN_EGG),
            new JournalEntry(CLUCKSHROOM, 36, EntityType.CHICKEN, ItemInit.CLUCKSHROOM_SPAWN_EGG),
            new JournalEntry(LOBBER_ZOMBIE, 24, EntityType.ZOMBIE, ItemInit.LOBBER_ZOMBIE_SPAWN_EGG)
    };

    //PROJECTILES
    public static final EntityType<MelonSeed> MELON_SEED = EntityType.Builder.<MelonSeed>of(MelonSeed::new, MobCategory.MISC)
            .sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "melon_seed").toString());

    public static final EntityType<RottenFlesh> ROTTEN_FLESH = EntityType.Builder.<RottenFlesh>of(RottenFlesh::new, MobCategory.MISC)
            .sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10).setCustomClientFactory(RottenFlesh::new)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "rotten_flesh").toString());

    @SubscribeEvent
    public static void registerEntity(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().register(MUDDY_PIG.setRegistryName("muddy_pig"));
        event.getRegistry().register(WOOLY_COW.setRegistryName("wooly_cow"));
        event.getRegistry().register(JUMBO_RABBIT.setRegistryName("jumbo_rabbit"));
        event.getRegistry().register(FANCY_CHICKEN.setRegistryName("fancy_chicken"));
        event.getRegistry().register(RAINBOW_SHEEP.setRegistryName("rainbow_sheep"));
        event.getRegistry().register(JOLLY_LLAMA.setRegistryName("jolly_llama"));
        event.getRegistry().register(VILER_WITCH.setRegistryName("viler_witch"));
        event.getRegistry().register(TROPICAL_SLIME.setRegistryName("tropical_slime"));
        event.getRegistry().register(MELON_GOLEM.setRegistryName("melon_golem"));
        event.getRegistry().register(MOOBLOOM.setRegistryName("moobloom"));
        event.getRegistry().register(BOULDERING_ZOMBIE.setRegistryName("bouldering_zombie"));
        event.getRegistry().register(FURNACE_GOLEM.setRegistryName("furnace_golem"));
        event.getRegistry().register(SKELETON_WOLF.setRegistryName("skeleton_wolf"));
        event.getRegistry().register(BONE_SPIDER.setRegistryName("bone_spider"));
        event.getRegistry().register(MOOLIP.setRegistryName("moolip"));
        event.getRegistry().register(CLUCKSHROOM.setRegistryName("cluckshroom"));
        event.getRegistry().register(LOBBER_ZOMBIE.setRegistryName("lobber_zombie"));

        event.getRegistry().register(MELON_SEED.setRegistryName("melon_seed"));
        event.getRegistry().register(ROTTEN_FLESH.setRegistryName("rotten_flesh"));
    }

    @SubscribeEvent
    public static void registerEntityAttribute(EntityAttributeCreationEvent event) {
        event.put(MUDDY_PIG, MuddyPig.createAttributes().build());
        event.put(WOOLY_COW, WoolyCow.createAttributes().build());
        event.put(JUMBO_RABBIT, JumboRabbit.createAttributes().build());
        event.put(FANCY_CHICKEN, FancyChicken.createAttributes().build());
        event.put(RAINBOW_SHEEP, RainbowSheep.createAttributes().build());
        event.put(JOLLY_LLAMA, JollyLlama.createAttributes().build());
        event.put(VILER_WITCH, VilerWitch.createAttributes().build());
        event.put(TROPICAL_SLIME, Monster.createMonsterAttributes().build());
        event.put(MELON_GOLEM, MelonGolem.createAttributes().build());
        event.put(MOOBLOOM, Moobloom.createAttributes().build());
        event.put(BOULDERING_ZOMBIE, BoulderingZombie.createAttributes().build());
        event.put(FURNACE_GOLEM, FurnaceGolem.createAttributes().build());
        event.put(SKELETON_WOLF, SkeletonWolf.createAttributes().build());
        event.put(BONE_SPIDER, BoneSpider.createAttributes().build());
        event.put(MOOLIP, Moolip.createAttributes().build());
        event.put(CLUCKSHROOM, Cluckshroom.createAttributes().build());
        event.put(LOBBER_ZOMBIE, LobberZombie.createAttributes().build());
    }

    static {
        SpawnPlacements.register(VILER_WITCH, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(BOULDERING_ZOMBIE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(SKELETON_WOLF, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(BONE_SPIDER, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(LOBBER_ZOMBIE, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
    }
}
