package io.github.derec4.guests.listeners;

import io.github.derec4.guests.Guests;
import io.github.derec4.guests.events.GuestChatEvent;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GuestChatListener implements Listener {
    private final Guests plugin;

    public GuestChatListener(Guests plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(AsyncChatEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("guests.guest") && !plugin.canGuestChat()) {
            String messageContent = PlainTextComponentSerializer.plainText().serialize(event.message());
            String message = plugin.getGuestChatDenyMessage();

            GuestChatEvent guestChatEvent = new GuestChatEvent(player, messageContent);
            Bukkit.getScheduler().runTask(plugin, () -> Bukkit.getPluginManager().callEvent(guestChatEvent));
            event.setCancelled(true);
            player.sendMessage(message);
        }
    }
}
