package fuzs.refoundearth.init;

import com.itayfeder.restored_earth.entities.*;
import com.itayfeder.restored_earth.entities.projectiles.MelonSeed;
import com.itayfeder.restored_earth.entities.projectiles.RottenFlesh;
import fuzs.puzzleslib.api.core.v1.context.EntityAttributesCreateContext;
import fuzs.puzzleslib.api.core.v1.context.SpawnPlacementsContext;
import fuzs.puzzleslib.api.init.v3.registry.RegistryManager;
import fuzs.refoundearth.RefoundEarth;
import fuzs.refoundearth.world.entity.animal.EarthChicken;
import fuzs.refoundearth.world.entity.animal.EarthRabbit;
import fuzs.refoundearth.world.entity.animal.FurnaceGolem;
import fuzs.refoundearth.world.entity.animal.RainbowSheep;
import fuzs.refoundearth.world.entity.monster.*;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;

public class ModEntityTypes {
    static final RegistryManager REGISTRY = RegistryManager.from(RefoundEarth.MOD_ID);
    public static final Holder.Reference<EntityType<MuddyPig>> MUDDY_PIG = REGISTRY.registerEntityType("muddy_pig",
            () -> EntityType.Builder.<MuddyPig>of(MuddyPig::new, MobCategory.CREATURE)
                    .sized(0.9F, 0.9F)
                    .clientTrackingRange(10)
    );
    public static final Holder.Reference<EntityType<WoolyCow>> WOOLY_COW = REGISTRY.registerEntityType("wooly_cow",
            () -> EntityType.Builder.<WoolyCow>of(WoolyCow::new, MobCategory.CREATURE)
                    .sized(0.9F, 1.4F)
                    .clientTrackingRange(10)
    );
    public static final Holder.Reference<EntityType<EarthRabbit>> JUMBO_RABBIT = REGISTRY.registerEntityType(
            "jumbo_rabbit",
            () -> EntityType.Builder.<EarthRabbit>of(EarthRabbit::new, MobCategory.CREATURE)
                    .sized(.75F, .75F)
                    .clientTrackingRange(10)
    );
    public static final Holder.Reference<EntityType<EarthChicken>> FANCY_CHICKEN = REGISTRY.registerEntityType(
            "fancy_chicken",
            () -> EntityType.Builder.<EarthChicken>of(EarthChicken::new, MobCategory.CREATURE)
                    .sized(0.4F, 0.8F)
                    .clientTrackingRange(10)
    );
    public static final Holder.Reference<EntityType<RainbowSheep>> RAINBOW_SHEEP = REGISTRY.registerEntityType(
            "rainbow_sheep",
            () -> EntityType.Builder.<RainbowSheep>of(RainbowSheep::new, MobCategory.CREATURE)
                    .sized(0.9F, 1.2F)
                    .clientTrackingRange(10)
    );
    public static final Holder.Reference<EntityType<Llama>> JOLLY_LLAMA = REGISTRY.registerEntityType("jolly_llama",
            () -> EntityType.Builder.<Llama>of(Llama::new, MobCategory.CREATURE)
                    .sized(0.9F, 1.87F)
                    .clientTrackingRange(10)
    );
    public static final Holder.Reference<EntityType<VilerWitch>> VILER_WITCH = REGISTRY.registerEntityType("viler_witch",
            () -> EntityType.Builder.<VilerWitch>of(VilerWitch::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(8)
    );
    public static final Holder.Reference<EntityType<TropicalSlime>> TROPICAL_SLIME = REGISTRY.registerEntityType(
            "tropical_slime",
            () -> EntityType.Builder.<TropicalSlime>of(TropicalSlime::new, MobCategory.MONSTER)
                    .sized(2.04F, 2.04F)
                    .clientTrackingRange(10)
    );
    public static final Holder.Reference<EntityType<MelonGolem>> MELON_GOLEM = REGISTRY.registerEntityType("melon_golem",
            () -> EntityType.Builder.<MelonGolem>of(MelonGolem::new, MobCategory.MISC)
                    .immuneTo(Blocks.POWDER_SNOW)
                    .sized(0.7F, 1.9F)
                    .clientTrackingRange(8)
    );
    public static final Holder.Reference<EntityType<Moobloom>> MOOBLOOM = REGISTRY.registerEntityType("moobloom",
            () -> EntityType.Builder.<Moobloom>of(Moobloom::new, MobCategory.CREATURE)
                    .sized(0.9F, 1.4F)
                    .clientTrackingRange(10)
    );
    public static final Holder.Reference<EntityType<BoulderingZombie>> BOULDERING_ZOMBIE = REGISTRY.registerEntityType(
            "bouldering_zombie",
            () -> EntityType.Builder.<BoulderingZombie>of(BoulderingZombie::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(8)
    );
    public static final Holder.Reference<EntityType<FurnaceGolem>> FURNACE_GOLEM = REGISTRY.registerEntityType(
            "furnace_golem",
            () -> EntityType.Builder.<FurnaceGolem>of(FurnaceGolem::new, MobCategory.MISC)
                    .sized(1.4F, 2.7F)
                    .clientTrackingRange(10)
    );
    public static final Holder.Reference<EntityType<SkeletonWolf>> SKELETON_WOLF = REGISTRY.registerEntityType(
            "skeleton_wolf",
            () -> EntityType.Builder.<SkeletonWolf>of(SkeletonWolf::new, MobCategory.MONSTER)
                    .sized(0.6F, 0.85F)
                    .clientTrackingRange(8)
    );
    public static final Holder.Reference<EntityType<BoneSpider>> BONE_SPIDER = REGISTRY.registerEntityType("bone_spider",
            () -> EntityType.Builder.<BoneSpider>of(BoneSpider::new, MobCategory.MONSTER)
                    .sized(1.4F, 0.9F)
                    .clientTrackingRange(8)
    );
    public static final Holder.Reference<EntityType<Moolip>> MOOLIP = REGISTRY.registerEntityType("moolip",
            () -> EntityType.Builder.<Moolip>of(Moolip::new, MobCategory.CREATURE)
                    .sized(0.9F, 1.4F)
                    .clientTrackingRange(10)
    );
    public static final Holder.Reference<EntityType<Cluckshroom>> CLUCKSHROOM = REGISTRY.registerEntityType(
            "cluckshroom",
            () -> EntityType.Builder.<Cluckshroom>of(Cluckshroom::new, MobCategory.CREATURE)
                    .sized(0.4F, 0.8F)
                    .clientTrackingRange(10)
    );
    public static final Holder.Reference<EntityType<LobberZombie>> LOBBER_ZOMBIE = REGISTRY.registerEntityType(
            "lobber_zombie",
            () -> EntityType.Builder.<LobberZombie>of(LobberZombie::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(8)
    );
    public static final Holder.Reference<EntityType<MelonSeed>> MELON_SEED = REGISTRY.registerEntityType("melon_seed",
            () -> EntityType.Builder.<MelonSeed>of(MelonSeed::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
    );
    public static final Holder.Reference<EntityType<RottenFlesh>> ROTTEN_FLESH = REGISTRY.registerEntityType(
            "rotten_flesh",
            () -> EntityType.Builder.<RottenFlesh>of(RottenFlesh::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
    );

    public static void onEntityAttributeCreation(EntityAttributesCreateContext context) {
        context.registerEntityAttributes(MUDDY_PIG.value(), MuddyPig.createAttributes());
        context.registerEntityAttributes(WOOLY_COW.value(), WoolyCow.createAttributes());
        context.registerEntityAttributes(JUMBO_RABBIT.value(), EarthRabbit.createAttributes());
        context.registerEntityAttributes(FANCY_CHICKEN.value(), EarthChicken.createAttributes());
        context.registerEntityAttributes(RAINBOW_SHEEP.value(), RainbowSheep.createAttributes());
        context.registerEntityAttributes(JOLLY_LLAMA.value(), Llama.createAttributes());
        context.registerEntityAttributes(VILER_WITCH.value(), VilerWitch.createAttributes());
        context.registerEntityAttributes(TROPICAL_SLIME.value(), Monster.createMonsterAttributes());
        context.registerEntityAttributes(MELON_GOLEM.value(), MelonGolem.createAttributes());
        context.registerEntityAttributes(MOOBLOOM.value(), Moobloom.createAttributes());
        context.registerEntityAttributes(BOULDERING_ZOMBIE.value(), BoulderingZombie.createAttributes());
        context.registerEntityAttributes(FURNACE_GOLEM.value(), FurnaceGolem.createAttributes());
        context.registerEntityAttributes(SKELETON_WOLF.value(), SkeletonWolf.createAttributes());
        context.registerEntityAttributes(BONE_SPIDER.value(), BoneSpider.createAttributes());
        context.registerEntityAttributes(MOOLIP.value(), Moolip.createAttributes());
        context.registerEntityAttributes(CLUCKSHROOM.value(), Cluckshroom.createAttributes());
        context.registerEntityAttributes(LOBBER_ZOMBIE.value(), LobberZombie.createAttributes());
    }

    public static void onRegisterSpawnPlacements(SpawnPlacementsContext context) {
        context.registerSpawnPlacement(VILER_WITCH.value(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules
        );
        context.registerSpawnPlacement(BOULDERING_ZOMBIE.value(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules
        );
        context.registerSpawnPlacement(SKELETON_WOLF.value(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                SkeletonWolf::checkMonsterSpawnRules
        );
        context.registerSpawnPlacement(BONE_SPIDER.value(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules
        );
        context.registerSpawnPlacement(LOBBER_ZOMBIE.value(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules
        );
    }
}
