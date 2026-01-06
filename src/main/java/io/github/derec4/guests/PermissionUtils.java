package io.github.derec4.guests;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.HashMap;
import java.util.UUID;

public class PermissionUtils {

    private static final HashMap<UUID, PermissionAttachment> attachments = new HashMap<>();

    private static PermissionAttachment getAttachment(Player player) {
        return attachments.computeIfAbsent(player.getUniqueId(),
                uuid -> player.addAttachment(Bukkit.getPluginManager().getPlugin("Guests")));
    }

    public static void addPermission(Player player, String permission) {
        PermissionAttachment attachment = getAttachment(player);
        attachment.setPermission(permission, true);
    }

    public static void removePermission(Player player, String permission) {
        PermissionAttachment attachment = attachments.get(player.getUniqueId());
        if (attachment != null) {
            attachment.unsetPermission(permission);
        }
    }
}

