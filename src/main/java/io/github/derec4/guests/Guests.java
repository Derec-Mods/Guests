package io.github.derec4.guests;

import io.github.derec4.guests.commands.GuestsCommand;
import io.github.derec4.guests.listeners.GuestBlockListener;
import io.github.derec4.guests.listeners.GuestChatListener;
import io.github.derec4.guests.listeners.GuestEntityListener;
import io.github.derec4.guests.listeners.GuestJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Guests extends JavaPlugin {
    private String discordInviteUrl;
    private String guestWelcomeMessage;
    private String guestChatDenyMessage;
    private String titleMain;
    private String titleSub;
    private boolean forceSpectator;
    private boolean allowGuestBreakBlocks;
    private boolean allowGuestPlaceBlocks;
    private boolean allowGuestInteract;
    private boolean allowGuestChat;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        discordInviteUrl = config.getString("discordInviteUrl", "https://discord.gg/48H6shbH4t");
        guestWelcomeMessage = config.getString("guestWelcomeMessage", "§eWelcome! You are a guest.");
        guestChatDenyMessage = config.getString("guestChatDenyMessage", "§cYou are a guest.");
        titleMain = config.getString("titleMain", "Welcome to our world!");
        titleSub = config.getString("titleSub", "If you want to play, join the Discord");
        forceSpectator = config.getBoolean("forceSpectator", true);
        allowGuestBreakBlocks = config.getBoolean("allowGuestBreakBlocks", false);
        allowGuestPlaceBlocks = config.getBoolean("allowGuestPlaceBlocks", false);
        allowGuestInteract = config.getBoolean("allowGuestInteract", false);
        allowGuestChat = config.getBoolean("allowGuestChat", false);

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new GuestJoinListener(this), this);
        pm.registerEvents(new GuestChatListener(this), this);
        pm.registerEvents(new GuestBlockListener(this), this);
        pm.registerEvents(new GuestEntityListener(), this);

        GuestsCommand guestsCommand = new GuestsCommand(this);
        getCommand("guests").setExecutor(guestsCommand);
        getCommand("guests").setTabCompleter(guestsCommand);

        Bukkit.getLogger().info("");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "  |_______|                             " +
                "  ");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "  | Derex |     Guests v" + getDescription().getVersion());
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "  |_______|     Running on " + Bukkit.getName() + " - " + Bukkit.getVersion());
        Bukkit.getLogger().info("");
    }

    public String getGuestWelcomeMessage() {
        return guestWelcomeMessage;
    }

    public String getGuestChatDenyMessage() {
        return guestChatDenyMessage;
    }

    public boolean isForceSpectator() {
        return forceSpectator;
    }

    public boolean canGuestBreakBlocks() {
        return allowGuestBreakBlocks;
    }

    public boolean canGuestPlaceBlocks() {
        return allowGuestPlaceBlocks;
    }

    public boolean canGuestInteract() {
        return allowGuestInteract;
    }

    public boolean canGuestChat() {
        return allowGuestChat;
    }


    public String getTitleMain() {
        return titleMain;
    }

    public String getTitleSub() {
        return titleSub;
    }

    public void reloadPluginConfig() {
        reloadConfig();
        FileConfiguration config = getConfig();

        discordInviteUrl = config.getString("discordInviteUrl", "https://discord.gg/48H6shbH4t");
        guestWelcomeMessage = config.getString("guestWelcomeMessage", "§eWelcome! You are a guest.");
        guestChatDenyMessage = config.getString("guestChatDenyMessage", "§cYou are a guest.");
        titleMain = config.getString("titleMain", "Welcome to our world!");
        titleSub = config.getString("titleSub", "If you want to play, join the Discord");
        forceSpectator = config.getBoolean("forceSpectator", true);
        allowGuestBreakBlocks = config.getBoolean("allowGuestBreakBlocks", false);
        allowGuestPlaceBlocks = config.getBoolean("allowGuestPlaceBlocks", false);
        allowGuestInteract = config.getBoolean("allowGuestInteract", false);
        allowGuestChat = config.getBoolean("allowGuestChat", false);

        Bukkit.getLogger().info("[Guests] Configuration reloaded successfully!");
    }

    @Override
    public void onDisable() {
    }
}
