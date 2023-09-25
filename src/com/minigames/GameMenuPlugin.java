package com.minigames;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GameMenuPlugin extends JavaPlugin {

    private GameConfig gameConfig;

    @Override
    public void onEnable() {
        gameConfig = new GameConfig(this);

        this.getCommand("gamemenu").setExecutor(new GameMenuCommandExecutor(this));
        this.getCommand("start").setExecutor(new GameMenuCommandExecutor(this));

        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new GameMenuListener(this), this);
    }

    @Override
    public void onDisable() {
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }
}