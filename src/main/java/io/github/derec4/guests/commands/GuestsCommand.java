package io.github.derec4.guests.commands;

import io.github.derec4.guests.Guests;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Command manager for /guests command
 */
public class GuestsCommand implements CommandExecutor, TabCompleter {
    private final Guests plugin;

    public GuestsCommand(Guests plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Component.text("=== Guests Plugin ===").color(NamedTextColor.GREEN));
            sender.sendMessage(Component.text("/guests reload - Reload the config").color(NamedTextColor.GRAY));
            sender.sendMessage(Component.text("Version: " + plugin.getDescription().getVersion()).color(NamedTextColor.GRAY));
            return true;
        }

        String subcommand = args[0].toLowerCase();

        switch (subcommand) {
            case "reload":
                return handleReload(sender);
            default:
                sender.sendMessage(Component.text("Unknown subcommand. Use /guests for help.").color(NamedTextColor.RED));
                return true;
        }
    }

    private boolean handleReload(@NotNull CommandSender sender) {
        if (!sender.hasPermission("guests.reload")) {
            sender.sendMessage(Component.text("You don't have permission to reload the config!").color(NamedTextColor.RED));
            return true;
        }

        try {
            plugin.reloadPluginConfig();
            sender.sendMessage(Component.text("Successfully reloaded Guests config!").color(NamedTextColor.GREEN));
        } catch (Exception e) {
            sender.sendMessage(Component.text("Failed to reload config: " + e.getMessage()).color(NamedTextColor.RED));
            plugin.getLogger().severe("Failed to reload configuration: " + e.getMessage());
        }

        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            if (sender.hasPermission("guests.reload")) {
                completions.add("reload");
            }
        }

        return completions;
    }
}

