package com.itayfeder.restored_earth.items;

import com.itayfeder.restored_earth.client.gui.screen.JournalScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.protocol.game.ClientboundOpenBookPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class JournalItem extends Item {

    public JournalItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
        if (p_41432_.isClientSide()) {
            JournalScreen.open(p_41432_);
        }
        else {
            ServerPlayer serverPlayer = p_41432_.getServer().getPlayerList().getPlayer(p_41433_.getUUID());
            serverPlayer.containerMenu.broadcastChanges();
            serverPlayer.connection.send(new ClientboundOpenBookPacket(p_41434_));

        }
        return InteractionResultHolder.pass(p_41433_.getItemInHand(p_41434_));
    }
}
