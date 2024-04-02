package fuzs.refoundearth.world.level.block;

import com.mojang.serialization.MapCodec;
import fuzs.refoundearth.init.ModBlocks;
import fuzs.refoundearth.init.ModEntityTypes;
import fuzs.refoundearth.world.entity.animal.MelonGolem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.EquipableCarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

public class CarvedMelonBlock extends EquipableCarvedPumpkinBlock {
    public static final MapCodec<EquipableCarvedPumpkinBlock> CODEC = simpleCodec(CarvedMelonBlock::new);
    @Nullable
    private BlockPattern melonGolemBase;
    @Nullable
    private BlockPattern melonGolemFull;

    public CarvedMelonBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
        DispenserBlock.registerBehavior(this, new OptionalDispenseItemBehavior() {
            @Override
            protected ItemStack execute(BlockSource blockSource, ItemStack item) {
                Level level = blockSource.level();
                BlockPos blockPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
                if (level.isEmptyBlock(blockPos) && CarvedMelonBlock.this.canSpawnGolem(level, blockPos)) {
                    if (!level.isClientSide) {
                        level.setBlock(blockPos, CarvedMelonBlock.this.defaultBlockState(), 3);
                        level.gameEvent(null, GameEvent.BLOCK_PLACE, blockPos);
                    }

                    item.shrink(1);
                    this.setSuccess(true);
                } else {
                    this.setSuccess(ArmorItem.dispenseArmor(blockSource, item));
                }

                return item;
            }
        });
    }

    @Override
    public MapCodec<EquipableCarvedPumpkinBlock> codec() {
        return CODEC;
    }

    @Override
    public boolean canSpawnGolem(LevelReader level, BlockPos pos) {
        return this.getOrCreateMelonGolemBase().find(level, pos) != null;
    }

    @Override
    protected void trySpawnGolem(Level level, BlockPos pos) {
        BlockPattern.BlockPatternMatch blockPatternMatch = this.getOrCreateMelonGolemFull().find(level, pos);
        if (blockPatternMatch != null) {
            MelonGolem melonGolem = ModEntityTypes.MELON_GOLEM.value().create(level);
            if (melonGolem != null) {
                spawnGolemInWorld(level, blockPatternMatch, melonGolem, blockPatternMatch.getBlock(0, 2, 0).getPos());
            }
        }
    }

    private BlockPattern getOrCreateMelonGolemBase() {
        if (this.melonGolemBase == null) {
            this.melonGolemBase = BlockPatternBuilder.start().aisle(" ", "#", "#").where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.SNOW_BLOCK))).build();
        }

        return this.melonGolemBase;
    }

    private BlockPattern getOrCreateMelonGolemFull() {
        if (this.melonGolemFull == null) {
            this.melonGolemFull = BlockPatternBuilder.start().aisle("^", "#", "#").where('^', BlockInWorld.hasState(BlockStatePredicate.forBlock(ModBlocks.CARVED_MELON.value()))).where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.SNOW_BLOCK))).build();
        }

        return this.melonGolemFull;
    }
}