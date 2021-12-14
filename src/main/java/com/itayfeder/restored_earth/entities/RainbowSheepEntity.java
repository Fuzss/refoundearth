package com.itayfeder.restored_earth.entities;

import com.itayfeder.restored_earth.init.BlockInit;
import com.itayfeder.restored_earth.init.EntityInit;
import com.itayfeder.restored_earth.utils.ModLootTables;
import net.minecraft.client.audio.SoundSource;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class RainbowSheepEntity extends SheepEntity  {
    public RainbowSheepEntity(EntityType<? extends SheepEntity> p_i50245_1_, World p_i50245_2_) {
        super(p_i50245_1_, p_i50245_2_);
    }

    @Override
    public RainbowSheepEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return EntityInit.RAINBOW_SHEEP.create(p_241840_1_);
    }

    @Override
    public void shear(SoundCategory p_230263_1_) {
        this.level.playSound((PlayerEntity) null, this, SoundEvents.SHEEP_SHEAR, p_230263_1_, 1.0F, 1.0F);
        this.setSheared(true);
        int i = 1 + this.random.nextInt(3);

        for(int j = 0; j < i; ++j) {
            ItemEntity itementity = this.spawnAtLocation(BlockInit.RAINBOW_WOOL, 1);
            if (itementity != null) {
                itementity.setDeltaMovement(itementity.getDeltaMovement().add((double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1F), (double)(this.random.nextFloat() * 0.05F), (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1F)));
            }
        }
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nullable PlayerEntity player, @Nonnull ItemStack item, World world, BlockPos pos, int fortune) {
        world.playSound(null, this, SoundEvents.SHEEP_SHEAR, player == null ? SoundCategory.BLOCKS : SoundCategory.PLAYERS, 1.0F, 1.0F);
        if (!world.isClientSide) {
            this.setSheared(true);
            int i = 1 + this.random.nextInt(3);

            java.util.List<ItemStack> items = new java.util.ArrayList<>();
            for (int j = 0; j < i; ++j) {
                items.add(new ItemStack(BlockInit.RAINBOW_WOOL));
            }
            return items;
        }
        return java.util.Collections.emptyList();
    }

    @Override
    public ResourceLocation getDefaultLootTable() {
        if (this.isSheared()) {
            return EntityType.SHEEP.getDefaultLootTable();
        } else {
            return ModLootTables.SHEEP_RAINBOW;
        }
    }
}
