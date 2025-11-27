package io.github.derec4.guests.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a guest player is about to be set to spectator mode.
 */
public class GuestSpectatorEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private boolean cancelled;

    public GuestSpectatorEvent(@NotNull Player player) {
        this.player = player;
        this.cancelled = false;
    }

    /**
     * Gets the guest player who is being set to spectator
     * @return The player
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets whether this event is cancelled.
     * If cancelled, the player will not be set to spectator mode.
     * @return true if cancelled
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Sets whether this event is cancelled.
     * If cancelled, the player will not be set to spectator mode.
     * @param cancelled true to cancel
     */
    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
