package io.github.derec4.guests.listeners;

import io.github.derec4.guests.Guests;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class GuestEntityListener implements Listener {
    private final Guests plugin;

    public GuestEntityListener(Guests plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player) {
            if (player.hasPermission("guests.guest") && !plugin.canGuestDamage()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityPickupItem(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (player.hasPermission("guests.guest") && !plugin.canGuestPickupItems()) {
                event.setCancelled(true);
            }
        }
    }
}

