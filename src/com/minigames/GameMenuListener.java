package com.minigames;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GameMenuListener implements Listener {

    private final GameMenuPlugin plugin;

    public GameMenuListener(GameMenuPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(plugin.getGameConfig().getGameMenu().getMenuTitle())) {
            event.setCancelled(true);
            plugin.getGameConfig().getGameMenu().handleClick(event);
        }
    }
}