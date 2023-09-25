package com.minigames;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GameMenu {

    private final GameMenuPlugin plugin;
    private final String menuTitle = ChatColor.DARK_GREEN + "Game Menu";

    public GameMenu(GameMenuPlugin plugin) {
        this.plugin = plugin;
    }

    public Inventory createGameMenu(Player player) {
        Inventory gameMenu = Bukkit.createInventory(player, 9, menuTitle);

        ItemStack spawnItem = new ItemStack(Material.BEACON);
        ItemMeta spawnItemMeta = spawnItem.getItemMeta();
        spawnItemMeta.setDisplayName(ChatColor.GREEN + "Définir le point d'apparition du spawn");
        spawnItem.setItemMeta(spawnItemMeta);
        gameMenu.setItem(0, spawnItem);


        ItemStack finishItem = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta finishItemMeta = finishItem.getItemMeta();
        finishItemMeta.setDisplayName(ChatColor.GOLD + "Terminer la configuration");
        finishItem.setItemMeta(finishItemMeta);
        gameMenu.setItem(8, finishItem);

        return gameMenu;
    }

    public void handleClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getCurrentItem();

        if (item == null || !item.hasItemMeta()) {
            return;
        }

        String itemName = item.getItemMeta().getDisplayName();

        if (itemName.equals(ChatColor.GREEN + "Définir le point d'apparition du spawn")) {
            plugin.getGameConfig().getGameLogic().setSpawnLocation(player.getLocation());
            player.sendMessage(ChatColor.GREEN + "Point d'apparition du spawn défini!");
        }


        if (itemName.equals(ChatColor.GOLD + "Terminer la configuration")) {
            plugin.getGameConfig().saveConfig();
            player.sendMessage(ChatColor.GREEN + "Configuration enregistrée!");
            player.closeInventory();
        }
    }

    public String getMenuTitle() {
        return menuTitle;
    }
}