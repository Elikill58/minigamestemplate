package com.minigames;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {

    private final GameMenuPlugin plugin;
    private Location spawnLocation;
    private List<Location> teleportLocations;
    private Location deathLocation;
    private int minPlayers;
    private String gameName;

    public GameLogic(GameMenuPlugin plugin) {
        this.plugin = plugin;
        spawnLocation = null;
        teleportLocations = new ArrayList<>();
        deathLocation = null;
        minPlayers = 1;
        gameName = "Jeu";
    }

    public void setSpawnLocation(Location location) {
        spawnLocation = location;
    }

    public void addTeleportLocation(Location location) {
        teleportLocations.add(location);
    }

    public void setDeathLocation(Location location) {
        deathLocation = location;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void startGame() {
        if (Bukkit.getOnlinePlayers().size() >= minPlayers) {
            Bukkit.broadcastMessage(ChatColor.GREEN + "Le jeu commence dans 15 secondes.");
            // ...
        } else {
            Bukkit.broadcastMessage(ChatColor.RED + "Il doit y avoir au moins " + minPlayers + " joueurs pour démarrer le jeu.");
        }
    }
}
