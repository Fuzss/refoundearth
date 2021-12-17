package com.itayfeder.restored_earth.init;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.entities.projectiles.RottenFleshEntity;
import com.itayfeder.restored_earth.entities.*;
import com.itayfeder.restored_earth.entities.projectiles.MelonSeedEntity;
import com.itayfeder.restored_earth.utils.JournalEntry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityInit {
    public static final EntityType<MuddyPigEntity> MUDDY_PIG = EntityType.Builder.<MuddyPigEntity>of(MuddyPigEntity::new, EntityClassification.CREATURE)
            .sized(0.9F, 0.9F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "muddy_pig").toString());

    public static final EntityType<WoolyCowEntity> WOOLY_COW = EntityType.Builder.<WoolyCowEntity>of(WoolyCowEntity::new, EntityClassification.CREATURE)
            .sized(0.9F, 1.4F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "wooly_cow").toString());

    public static final EntityType<JumboRabbitEntity> JUMBO_RABBIT = EntityType.Builder.<JumboRabbitEntity>of(JumboRabbitEntity::new, EntityClassification.CREATURE)
            .sized(.75F, .75F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "jumbo_rabbit").toString());

    public static final EntityType<FancyChickenEntity> FANCY_CHICKEN = EntityType.Builder.<FancyChickenEntity>of(FancyChickenEntity::new, EntityClassification.CREATURE)
            .sized(0.4F, 0.8F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "fancy_chicken").toString());

    public static final EntityType<RainbowSheepEntity> RAINBOW_SHEEP = EntityType.Builder.<RainbowSheepEntity>of(RainbowSheepEntity::new, EntityClassification.CREATURE)
            .sized(0.9F, 1.2F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "rainbow_sheep").toString());

    public static final EntityType<JollyLlamaEntity> JOLLY_LLAMA = EntityType.Builder.<JollyLlamaEntity>of(JollyLlamaEntity::new, EntityClassification.CREATURE)
            .sized(0.9F, 1.87F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "jolly_llama").toString());

    public static final EntityType<VilerWitchEntity> VILER_WITCH = EntityType.Builder.<VilerWitchEntity>of(VilerWitchEntity::new, EntityClassification.MONSTER)
            .sized(0.6F, 1.95F).clientTrackingRange(8)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "viler_witch").toString());

    public static final EntityType<TropicalSlimeEntity> TROPICAL_SLIME = EntityType.Builder.<TropicalSlimeEntity>of(TropicalSlimeEntity::new, EntityClassification.MONSTER)
            .sized(2.04F, 2.04F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "tropical_slime").toString());

    public static final EntityType<MelonGolemEntity> MELON_GOLEM = EntityType.Builder.<MelonGolemEntity>of(MelonGolemEntity::new, EntityClassification.MISC)
            .sized(0.7F, 1.9F).clientTrackingRange(8)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "melon_golem").toString());

    public static final EntityType<MoobloomEntity> MOOBLOOM = EntityType.Builder.<MoobloomEntity>of(MoobloomEntity::new, EntityClassification.CREATURE)
            .sized(0.9F, 1.4F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "moobloom").toString());

    public static final EntityType<BoulderingZombieEntity> BOULDERING_ZOMBIE = EntityType.Builder.<BoulderingZombieEntity>of(BoulderingZombieEntity::new, EntityClassification.MONSTER)
            .sized(0.6F, 1.95F).clientTrackingRange(8)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "bouldering_zombie").toString());

    public static final EntityType<FurnaceGolemEntity> FURNACE_GOLEM = EntityType.Builder.<FurnaceGolemEntity>of(FurnaceGolemEntity::new, EntityClassification.MISC)
            .sized(1.4F, 2.7F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "furnace_golem").toString());

    public static final EntityType<SkeletonWolfEntity> SKELETON_WOLF = EntityType.Builder.<SkeletonWolfEntity>of(SkeletonWolfEntity::new, EntityClassification.MONSTER)
            .sized(0.6F, 0.85F).clientTrackingRange(8)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "skeleton_wolf").toString());

    public static final EntityType<BoneSpiderEntity> BONE_SPIDER = EntityType.Builder.<BoneSpiderEntity>of(BoneSpiderEntity::new, EntityClassification.MONSTER)
            .sized(1.4F, 0.9F).clientTrackingRange(8)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "bone_spider").toString());

    public static final EntityType<MoolipEntity> MOOLIP = EntityType.Builder.<MoolipEntity>of(MoolipEntity::new, EntityClassification.CREATURE)
            .sized(0.9F, 1.4F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "moolip").toString());

    public static final EntityType<CluckshroomEntity> CLUCKSHROOM = EntityType.Builder.<CluckshroomEntity>of(CluckshroomEntity::new, EntityClassification.CREATURE)
            .sized(0.4F, 0.8F).clientTrackingRange(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "cluckshroom").toString());

    public static final EntityType<LobberZombieEntity> LOBBER_ZOMBIE = EntityType.Builder.<LobberZombieEntity>of(LobberZombieEntity::new, EntityClassification.MONSTER)
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
    public static final EntityType<MelonSeedEntity> MELON_SEED = EntityType.Builder.<MelonSeedEntity>of(MelonSeedEntity::new, EntityClassification.MISC)
            .sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
            .build(new ResourceLocation(RestoredEarthMod.MOD_ID, "melon_seed").toString());

    public static final EntityType<RottenFleshEntity> ROTTEN_FLESH = EntityType.Builder.<RottenFleshEntity>of(RottenFleshEntity::new, EntityClassification.MISC)
            .sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10).setCustomClientFactory(RottenFleshEntity::new)
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
        event.put(MUDDY_PIG, MuddyPigEntity.createAttributes().build());
        event.put(WOOLY_COW, WoolyCowEntity.createAttributes().build());
        event.put(JUMBO_RABBIT, JumboRabbitEntity.createAttributes().build());
        event.put(FANCY_CHICKEN, FancyChickenEntity.createAttributes().build());
        event.put(RAINBOW_SHEEP, RainbowSheepEntity.createAttributes().build());
        event.put(JOLLY_LLAMA, JollyLlamaEntity.createAttributes().build());
        event.put(VILER_WITCH, VilerWitchEntity.createAttributes().build());
        event.put(TROPICAL_SLIME, MonsterEntity.createMonsterAttributes().build());
        event.put(MELON_GOLEM, MelonGolemEntity.createAttributes().build());
        event.put(MOOBLOOM, MoobloomEntity.createAttributes().build());
        event.put(BOULDERING_ZOMBIE, BoulderingZombieEntity.createAttributes().build());
        event.put(FURNACE_GOLEM, FurnaceGolemEntity.createAttributes().build());
        event.put(SKELETON_WOLF, SkeletonWolfEntity.createAttributes().build());
        event.put(BONE_SPIDER, BoneSpiderEntity.createAttributes().build());
        event.put(MOOLIP, MoolipEntity.createAttributes().build());
        event.put(CLUCKSHROOM, CluckshroomEntity.createAttributes().build());
        event.put(LOBBER_ZOMBIE, LobberZombieEntity.createAttributes().build());
    }

    static {
        EntitySpawnPlacementRegistry.register(VILER_WITCH, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(BOULDERING_ZOMBIE,  EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(SKELETON_WOLF, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(BONE_SPIDER, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, BoneSpiderEntity::checkMonsterSpawnRules);
        EntitySpawnPlacementRegistry.register(LOBBER_ZOMBIE,  EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
    }
}
