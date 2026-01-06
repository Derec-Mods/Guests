package io.github.derec4.guests.listeners;

import io.github.derec4.guests.GuestListManager;
import io.github.derec4.guests.Guests;
import io.github.derec4.guests.PermissionUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class WhitelistGuestListener implements Listener {
    private final Guests plugin;
    private final GuestListManager guestListManager;

    public WhitelistGuestListener(Guests plugin, GuestListManager guestListManager) {
        this.plugin = plugin;
        this.guestListManager = guestListManager;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoinWhitelistCheck(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!Bukkit.hasWhitelist()) {
            return;
        }

        boolean isWhitelisted = player.isWhitelisted();

        if (!isWhitelisted) {
            guestListManager.addGuest(player.getUniqueId());

            if (!player.hasPermission("guests.guest")) {
                PermissionUtils.addPermission(player, "guests.guest");
            }

            if (plugin.isForceSpectator() && !player.hasPermission("guests.spectator")) {
                PermissionUtils.addPermission(player, "guests.spectator");
            }
        } else {
            if (guestListManager.isGuest(player.getUniqueId())) {
                guestListManager.removeGuest(player.getUniqueId());
                PermissionUtils.removePermission(player, "guests.guest");
                PermissionUtils.removePermission(player, "guests.spectator");
            }
        }
    }
}

