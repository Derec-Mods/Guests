package io.github.derec4.guests.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import io.github.derec4.guests.Guests;

public class GuestBlockListener implements Listener {
    private final Guests plugin;
    public GuestBlockListener(Guests plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("guests.guest") && !plugin.canGuestBreakBlocks()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("guests.guest") && !plugin.canGuestPlaceBlocks()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player != null && player.hasPermission("guests.guest") && !plugin.canGuestInteract()) {
            event.setCancelled(true);
        }
    }
}
