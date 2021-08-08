package me.polo.admincore.healfeed;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("feed") || cmd.getName().equalsIgnoreCase("f")) {
                if (p.hasPermission("admincore.feed")) {
                    if (args.length == 0) {
                        p.setFoodLevel(20);
                        p.setSaturation(20);
                        p.sendMessage(ChatColor.GREEN + "You have been fed!");
                    } else if (args.length == 1) {
                        Player t = Bukkit.getPlayer(args[0]);
                        if (t != null) {
                            t.setFoodLevel(20);
                            t.setSaturation(20);
                            p.sendMessage(ChatColor.GREEN + "You fed " + t.getName());
                            t.sendMessage(ChatColor.GREEN + "You've been fed by an admin");
                        } else {
                            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Player not found");
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "Insufficient Arguments!");
                    }
                }
            }
        }

        return false;
    }

}
