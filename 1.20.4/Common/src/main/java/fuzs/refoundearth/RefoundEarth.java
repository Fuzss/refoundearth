package fuzs.refoundearth;

import fuzs.refoundearth.world.entity.animal.RainbowSheep;
import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.puzzleslib.api.core.v1.context.EntityAttributesCreateContext;
import fuzs.puzzleslib.api.core.v1.context.SpawnPlacementsContext;
import fuzs.puzzleslib.api.event.v1.core.EventResult;
import fuzs.puzzleslib.api.event.v1.core.EventResultHolder;
import fuzs.puzzleslib.api.event.v1.entity.living.LookingAtEndermanCallback;
import fuzs.puzzleslib.api.event.v1.entity.player.PlayerInteractEvents;
import fuzs.refoundearth.init.ModBlocks;
import fuzs.refoundearth.init.ModEntityTypes;
import fuzs.refoundearth.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ComposterBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RefoundEarth implements ModConstructor {
    public static final String MOD_ID = "refoundearth";
    public static final String MOD_NAME = "Refound Earth";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onConstructMod() {
        ModBlocks.touch();
        registerEventHandlers();
    }

    private static void registerEventHandlers() {
        LookingAtEndermanCallback.EVENT.register((EnderMan enderman, Player player) -> {
            if (player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.CARVED_MELON.value())) {
                return EventResult.INTERRUPT;
            } else {
                return EventResult.PASS;
            }
        });
        PlayerInteractEvents.USE_ENTITY.register((Player player, Level level, InteractionHand interactionHand, Entity entity) -> {
            if (entity instanceof RainbowSheep sheep && sheep.isAlive() && !sheep.isSheared()) {
                ItemStack itemInHand = player.getItemInHand(interactionHand);
                if (itemInHand.getItem() instanceof DyeItem dyeItem && sheep.getColor() != dyeItem.getDyeColor()) {
                    return EventResultHolder.interrupt(InteractionResult.PASS);
                }
            }

            return EventResultHolder.pass();
        });
    }

    @Override
    public void onCommonSetup() {
        ComposterBlock.COMPOSTABLES.put(ModItems.CARVED_MELON.value(), 0.65F);
    }

    @Override
    public void onEntityAttributeCreation(EntityAttributesCreateContext context) {
        ModEntityTypes.onEntityAttributeCreation(context);
    }

    @Override
    public void onRegisterSpawnPlacements(SpawnPlacementsContext context) {
        ModEntityTypes.onRegisterSpawnPlacements(context);
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
