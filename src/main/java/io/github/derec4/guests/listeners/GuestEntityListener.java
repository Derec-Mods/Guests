package io.github.derec4.guests.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class GuestEntityListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player) {
            // If player is a guest and doesn't have the damage permission, cancel the event
            if (player.hasPermission("guests.guest") && !player.hasPermission("guests.damage")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityPickupItem(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player player) {
            // If player is a guest and doesn't have the pickup items permission, cancel the event
            if (player.hasPermission("guests.guest") && !player.hasPermission("guests.pickupitems")) {
                event.setCancelled(true);
            }
        }
    }
}

