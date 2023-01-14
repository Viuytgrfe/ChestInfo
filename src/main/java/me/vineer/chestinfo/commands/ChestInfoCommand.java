package me.vineer.chestinfo.commands;

import me.vineer.chestinfo.Chestinfo;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChestInfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(command.getName().equals("chestinfo")) {
            if(!player.isOp()) {
                player.sendMessage(ChatColor.YELLOW + "[CI] " + ChatColor.RED + "У тебя нет прав на использование этой команды!");
                return true;
            }
            if(args.length == 0) {
                player.sendMessage(ChatColor.YELLOW + "[CI] " + ChatColor.RED + "слишком мало аргументов!");
                return true;
            }
            boolean is_info;
            is_info = args[0].equalsIgnoreCase("enable");
            Chestinfo.players.put(player.getName(), is_info);
            if(is_info)player.sendMessage(ChatColor.YELLOW + "[CI] " + ChatColor.GREEN + "Chest Info is enabled!");
            else player.sendMessage(ChatColor.YELLOW + "[CI] " + ChatColor.GREEN + "Chest Info is disabled!");
        }
        return true;
    }
}
