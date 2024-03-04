package com.itayfeder.restored_earth.events;

import com.itayfeder.restored_earth.RestoredEarthMod;
import com.itayfeder.restored_earth.entities.MuddyPig;
import com.itayfeder.restored_earth.fluids.MudFluid;
import com.itayfeder.restored_earth.init.EntityInit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RestoredEarthMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EntityTickEventHandler {

    @SubscribeEvent
    public static void livingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntityLiving().getType() == EntityType.PIG) {
            Pig pig = (Pig)event.getEntityLiving();
            if (pig.level.getFluidState(pig.blockPosition()).getType() instanceof MudFluid) {
                CompoundTag tag = new CompoundTag();
                MuddyPig newPig = EntityInit.MUDDY_PIG.create(pig.level);
                pig.save(tag);
                newPig.load(tag);
                pig.remove(Entity.RemovalReason.DISCARDED);
                pig.level.addFreshEntity(newPig);
            }
        }
        if (event.getEntityLiving().getType() == EntityInit.MUDDY_PIG) {
            MuddyPig pig = (MuddyPig)event.getEntityLiving();
            if (pig.level.getFluidState(pig.blockPosition()).getType() instanceof WaterFluid) {
                CompoundTag tag = new CompoundTag();
                Pig newPig = EntityType.PIG.create(pig.level);
                pig.save(tag);
                newPig.load(tag);
                pig.remove(Entity.RemovalReason.DISCARDED);
                pig.level.addFreshEntity(newPig);
            }
        }
    }
}
