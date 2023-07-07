package com.minigames;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class GameConfig {

    private final GameMenuPlugin plugin;
    private final GameMenu gameMenu;
    private final GameLogic gameLogic;
    private File configFile;
    private FileConfiguration config;

    public GameConfig(GameMenuPlugin plugin) {
        this.plugin = plugin;
        configFile = new File(plugin.getDataFolder(), "config.yml");
        config = YamlConfiguration.loadConfiguration(configFile);

        gameMenu = new GameMenu(plugin);
        gameLogic = new GameLogic(plugin);
    }

    public void openGameMenu(Player player) {
        player.openInventory(gameMenu.createGameMenu(player));
    }

    public GameMenu getGameMenu() {
        return gameMenu;
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
