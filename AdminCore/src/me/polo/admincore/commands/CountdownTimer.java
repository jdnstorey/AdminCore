package me.polo.admincore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static java.lang.Integer.valueOf;

public class CountdownTimer implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("admincore.countdown")){
                if(cmd.getName().equalsIgnoreCase("countdown")){
                    if(args.length != 1){
                        p.sendMessage(ChatColor.RED + "/countdown <time in minutes>");
                    } else {
                        int full = valueOf(args[0]);
                        int fulltick = valueOf(args[0]) * 1200;
                        for(int i = fulltick; i > 0; i--){
                            Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "Server closing in " + full);
                        }
                    }
                }
            }
        }

        return false;
    }

}
