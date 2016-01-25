package org.learncraft;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.learncraft.gui.StudentMainMenuFrame;

/**
 * Represents a internal event listener for listening to events.
 *
 * @since 1.0-SNAPSHOT
 * @author Open-source contributors to LearnCraft
 */
public class InternalListener implements Listener {
    @EventHandler
    public void onLoginEvent(PlayerLoginEvent e) {
        if(e.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            e.disallow(PlayerLoginEvent.Result.KICK_FULL, ChatColor.RED + "The LearnCraft session is full, ask your teacher to expand the server slots via server.properties to allow more students.");
            return;
        }
        if(!e.getPlayer().isWhitelisted()){
            e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, ChatColor.RED + "Your teacher hasn't put you inside of the LearnCraft session. Ask your teacher to put you inside of the student whitelist inside of the student menu in the control panel.");
            return;
        }
        e.allow();
    }
    @EventHandler
    public void onChatEvent(PlayerChatEvent e) {
        if(!StudentMainMenuFrame.isChatEnabled || !e.getPlayer().isOp()) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "The teacher has disabled student chat. Please stop attempting to chat.");
            return;
        }
        if(e.getPlayer().isOp()) {
            e.setMessage(ChatColor.GREEN + "[TEACHER] " + e.getMessage());
            return;
        }
    }
}
