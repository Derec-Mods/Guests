package io.github.derec4.guests.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

public class GuestJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Check if the player is marked as a guest
        if (player.hasPermission("guests.guest")) {

            // If guest has spectator node, force them into spectator
            if (player.hasPermission("guests.spectator")) {
                Bukkit.getScheduler().runTaskLater(
                        Bukkit.getPluginManager().getPlugin("Guests"),
                        () -> player.setGameMode(GameMode.SPECTATOR),
                        1L // 1 tick later to avoid join conflicts
                );
            }
        }
    }
}

