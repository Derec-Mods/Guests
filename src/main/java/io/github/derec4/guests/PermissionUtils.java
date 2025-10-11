package io.github.derec4.guests;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.HashMap;
import java.util.UUID;

public class PermissionUtils {

    private final HashMap<UUID, PermissionAttachment> attachments = new HashMap<>();

    /**
     * Check if a player is currently a guest
     */
    public boolean isGuest(Player player) {
        return player.hasPermission("guests.guest");
    }

    /**
     * Utility: gets or creates a PermissionAttachment for a player
     */
    private PermissionAttachment getAttachment(Player player) {
        return attachments.computeIfAbsent(player.getUniqueId(),
                uuid -> player.addAttachment(Bukkit.getPluginManager().getPlugin("Guests")));
    }
}

