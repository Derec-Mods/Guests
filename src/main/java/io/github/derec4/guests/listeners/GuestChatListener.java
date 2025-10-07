package io.github.derec4.guests.listeners;

import io.github.derec4.guests.Guests;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GuestChatListener implements Listener {
    private final Guests plugin;

    public GuestChatListener(Guests plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(AsyncChatEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("guests.guest") && !plugin.canGuestChat()) {
            event.setCancelled(true);
            String message = plugin.getGuestChatDenyMessage();
            player.sendMessage(message);
        }
    }
}
