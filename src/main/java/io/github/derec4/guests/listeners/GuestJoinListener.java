package io.github.derec4.guests.listeners;

import io.github.derec4.guests.Guests;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

import java.time.Duration;

import static net.kyori.adventure.title.Title.title;

public class GuestJoinListener implements Listener {
    private final Guests plugin;

    public GuestJoinListener(Guests plugin) {
        this.plugin = plugin;
    }

    /**
     * On player spawn, handle the guest mode stuff and title
     *
     * @param event
     */
    @EventHandler
    public void onPlayerSpawn(PlayerSpawnLocationEvent event) {
        Player player = event.getPlayer();

        // Check if the player is marked as a guest
        if (player.hasPermission("guests.guest")) {
            // Schedule the message and title to show after spawn
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                String message = plugin.getGuestWelcomeMessage();
                player.sendMessage(Component.text(message).color(NamedTextColor.GREEN));

                // Display title to the guest
                Component titleMain = Component.text("Welcome to our world!").color(NamedTextColor.GREEN);
                Component titleSub =
                        Component.text("If you want to play, join the Discord").color(NamedTextColor.GREEN);

                Title.Times times = Title.Times.times(
                        Duration.ofMillis(500),  // fadeIn (10 ticks = 500ms)
                        Duration.ofMillis(7000), // stay (70 ticks = 3500ms)
                        Duration.ofMillis(1000)  // fadeOut (20 ticks = 1000ms)
                );

                player.showTitle(title(titleMain, titleSub, times));
            }, 5L); // 5 ticks delay to ensure player is fully spawned idk if this will work actually

            // Only force spectator if enabled in config and delay a lil
            if (plugin.isForceSpectator() && player.hasPermission("guests.spectator")) {
                Bukkit.getScheduler().runTaskLater(
                        plugin,
                        () -> player.setGameMode(GameMode.SPECTATOR),
                        10L
                );
            }
        }
    }
}
