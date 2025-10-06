package io.github.derec4.guests.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.entity.Player;

public class GuestChatListener implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("guests.guest")) {
            event.setCancelled(true);
            player.sendMessage("§cChat is disabled for guests. Apply for whitelist to participate.");
        }
    }
}

