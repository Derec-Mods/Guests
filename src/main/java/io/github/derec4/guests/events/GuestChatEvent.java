package io.github.derec4.guests.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a guest player attempts to send a chat message.
 */
public class GuestChatEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Player player;
    private final String message;
    private boolean cancelled;

    public GuestChatEvent(@NotNull Player player, @NotNull String message) {
        this.player = player;
        this.message = message;
        this.cancelled = false;
    }

    /**
     * Gets the guest player who attempted to chat
     * @return The player
     */
    @NotNull
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the message the guest attempted to send
     * @return The chat message
     */
    @NotNull
    public String getMessage() {
        return message;
    }

    /**
     * Gets whether this event is cancelled.
     * If cancelled, the chat will be allowed to go through.
     * If not cancelled (default), the chat will be blocked.
     * @return true if cancelled (chat allowed)
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Sets whether this event is cancelled.
     * If cancelled, the chat will be allowed to go through.
     * If not cancelled (default), the chat will be blocked.
     * @param cancelled true to allow chat, false to block
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

