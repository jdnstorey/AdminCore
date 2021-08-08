package me.polo.admincore.healfeed;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player) {
            Player p = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("heal") || cmd.getName().equalsIgnoreCase("h")) {
                if (p.hasPermission("admincore.heal")) {
                    if (args.length == 0) {
                        p.setHealth(20);
                        p.sendMessage(ChatColor.GREEN + "You have been healed!");
                    } else if (args.length == 1) {
                        Player t = Bukkit.getPlayer(args[0]);
                        if (t != null) {
                            t.setHealth(20);
                            p.sendMessage(ChatColor.GREEN + "You healed " + t.getName());
                            t.sendMessage(ChatColor.GREEN + "You've been healed by an admin");
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
