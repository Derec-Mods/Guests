package io.github.derec4.guests.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

import io.github.derec4.guests.Guests;

public class GuestJoinListener implements Listener {
    private final Guests plugin;

    public GuestJoinListener(Guests plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Check if the player is marked as a guest
        if (player.hasPermission("guests.guest")) {
            String message = plugin.getGuestWelcomeMessage();
            player.sendMessage(message);

            // Only force spectator if enabled in config
            if (plugin.isForceSpectator() && player.hasPermission("guests.spectator")) {
                Bukkit.getScheduler().runTaskLater(
                        plugin,
                        () -> player.setGameMode(GameMode.SPECTATOR),
                        1L // 1 tick later to avoid join conflicts
                );
            }
        }
    }
}
