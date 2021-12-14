package com.itayfeder.restored_earth.events;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ShearMelonEventHandler {
    @SubscribeEvent
    public static void blockInteract(PlayerInteractEvent.RightClickBlock event) {
        if (event.getWorld().getBlockState(event.getPos()).is(Blocks.MELON)) {
            PlayerEntity playerEntity = event.getPlayer();
            World world = event.getWorld();
            BlockPos pos = event.getPos();
            ItemStack itemstack = playerEntity.getItemInHand(event.getHand());
            if (itemstack.getItem() == Items.SHEARS) {
                if (!world.isClientSide) {
                    Direction direction = event.getHitVec().getDirection();
                    Direction direction1 = direction.getAxis() == Direction.Axis.Y ? playerEntity.getDirection().getOpposite() : direction;
                    world.playSound((PlayerEntity)null, pos, SoundEvents.PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    world.setBlock(pos, BlockInit.CARVED_MELON.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, direction1), 11);
                    ItemEntity itementity = new ItemEntity(world, (double)pos.getX() + 0.5D + (double)direction1.getStepX() * 0.65D, (double)pos.getY() + 0.1D, (double)pos.getZ() + 0.5D + (double)direction1.getStepZ() * 0.65D, new ItemStack(Items.MELON_SEEDS, 4));
                    itementity.setDeltaMovement(0.05D * (double)direction1.getStepX() + world.random.nextDouble() * 0.02D, 0.05D, 0.05D * (double)direction1.getStepZ() + world.random.nextDouble() * 0.02D);
                    world.addFreshEntity(itementity);
                    itemstack.hurtAndBreak(1, playerEntity, (p_220282_1_) -> {
                        p_220282_1_.broadcastBreakEvent(event.getHand());
                    });
                }
            }
        }
    }
}
