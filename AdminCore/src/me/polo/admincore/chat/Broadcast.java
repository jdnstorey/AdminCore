package me.polo.admincore.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player){
            Player p = (Player) sender;
                if(p.hasPermission("admincore.broadcast")){
                    if(cmd.getName().equalsIgnoreCase("broadcast") || cmd.getName().equalsIgnoreCase("bc")) {
                        if (args.length == 0) {
                            p.sendMessage(ChatColor.BLUE + "Try /broadcast <message>");
                        } else if (args.length > 0) {
                            StringBuilder s = new StringBuilder();
                            for (int i = 0; i < args.length; i++) {
                                s.append(args[i] + " ");
                            }

                            Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "[BROADCAST] " + ChatColor.RED + s.toString());
                        }
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Insufficient Permission");
                }
        }

        return false;
    }

}
