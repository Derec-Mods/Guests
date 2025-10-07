package io.github.derec4.guests.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GuestChatListener implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncChatEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("guests.guest")) {
            event.setCancelled(true);
            player.sendMessage("§cYou are a guest. Drop your username on the Discord to play!");
        }
    }
}

