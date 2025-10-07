package io.github.derec4.guests;

import io.github.derec4.guests.listeners.GuestChatListener;
import io.github.derec4.guests.listeners.GuestJoinListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Guests extends JavaPlugin {
    private String discordInviteUrl;
    private String guestWelcomeMessage;
    private String guestChatDenyMessage;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        discordInviteUrl = config.getString("discordInviteUrl", "https://discord.gg/example");
        guestWelcomeMessage = config.getString("guestWelcomeMessage", "§eWelcome! You are a guest.");
        guestChatDenyMessage = config.getString("guestChatDenyMessage", "§cYou are a guest.");

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new GuestJoinListener(this), this);
        pm.registerEvents(new GuestChatListener(this), this);
    }

    public String getDiscordInviteUrl() {
        return discordInviteUrl;
    }

    public String getGuestWelcomeMessage() {
        return guestWelcomeMessage;
    }

    public String getGuestChatDenyMessage() {
        return guestChatDenyMessage;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
