package com.itayfeder.restored_earth.items;

import com.itayfeder.restored_earth.client.gui.screen.JournalScreen;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.ReadBookScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SOpenBookWindowPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class JournalItem extends Item {

    public JournalItem(Item.Properties p_i48524_1_) {
        super(p_i48524_1_);
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        if (p_77659_1_.isClientSide()) {
            JournalScreen.open(p_77659_1_);
        }
        else {
            ServerPlayerEntity serverPlayer = p_77659_2_.getServer().getPlayerList().getPlayer(p_77659_2_.getUUID());
            serverPlayer.containerMenu.broadcastChanges();
            serverPlayer.connection.send(new SOpenBookWindowPacket(p_77659_3_));

        }
        return new ActionResult(ActionResultType.PASS, p_77659_2_.getItemInHand(p_77659_3_));
    }
}
