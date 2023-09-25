package com.minigames;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameMenuCommandExecutor implements CommandExecutor {

    private final GameMenuPlugin plugin;

    public GameMenuCommandExecutor(GameMenuPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("gamemenu") && sender instanceof Player) {
            Player player = (Player) sender;
            plugin.getGameConfig().openGameMenu(player);
        } else if (command.getName().equalsIgnoreCase("start") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                plugin.getGameConfig().getGameLogic().startGame();
            } else {
                player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission d'utiliser cette commande.");
            }
        }

        return true;
    }
}
