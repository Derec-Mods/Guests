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
     * Assign guest permissions to a player (default state)
     */
    public void makeGuest(Player player) {
        PermissionAttachment attachment = getAttachment(player);

        attachment.setPermission("guests.guest", true);
        attachment.setPermission("guests.spectator", true);
        attachment.setPermission("guests.muted", true);
        attachment.setPermission("guests.limited", true);

        // Revoke member permissions if any
        attachment.unsetPermission("guests.member");

        player.recalculatePermissions();
    }

    /**
     * Promote player from guest to full member
     */
    public void promoteToMember(Player player) {
        PermissionAttachment attachment = getAttachment(player);

        // Remove all guest-related permissions
        attachment.unsetPermission("guests.guest");
        attachment.unsetPermission("guests.spectator");
        attachment.unsetPermission("guests.muted");
        attachment.unsetPermission("guests.limited");

        // Give full member node
        attachment.setPermission("guests.member", true);

        player.recalculatePermissions();
    }

    /**
     * Utility: gets or creates a PermissionAttachment for a player
     */
    private PermissionAttachment getAttachment(Player player) {
        return attachments.computeIfAbsent(player.getUniqueId(),
                uuid -> player.addAttachment(Bukkit.getPluginManager().getPlugin("Guests")));
    }
}

