package me.vineer.chestinfo;

import me.vineer.chestinfo.commands.ChestInfoCommand;
import me.vineer.chestinfo.events.GetChestEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Chestinfo extends JavaPlugin {
    private static Plugin plugin;
    public static HashMap<String, Boolean> players = new HashMap<String, Boolean>();
    @Override
    public void onEnable() {
        plugin = this;
        this.getCommand("chestinfo").setExecutor(new ChestInfoCommand());
        getServer().getPluginManager().registerEvents(new GetChestEvent(), this);
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        plugin = null;
        // Plugin shutdown logic
    }

    

    public static Plugin getPlugin() {
        return plugin;
    }
}
