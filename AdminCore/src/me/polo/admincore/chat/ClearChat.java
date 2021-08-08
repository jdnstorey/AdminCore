package me.polo.admincore.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("clearchat")) {

                if (p.hasPermission("admincore.clearchat")) {
                    if(args.length == 0){
                        for (int i = 100; i > 0; i--){
                            Bukkit.broadcastMessage(" ");
                        }
                    } else  if (args.length == 1){
                        if(args[0].equalsIgnoreCase("show")) {
                            for (int i = 100; i > 0; i--) {
                                Bukkit.broadcastMessage(" ");
                                if (i == 1) {
                                    Bukkit.broadcastMessage(ChatColor.GOLD + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                                    Bukkit.broadcastMessage(ChatColor.GOLD + "Chat cleared by " + p.getName());
                                    Bukkit.broadcastMessage(ChatColor.GOLD + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                                }
                            }
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "Insufficient Arguments!");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Insufficient Permission");
                }
            }
        }
        return false;
    }

}
