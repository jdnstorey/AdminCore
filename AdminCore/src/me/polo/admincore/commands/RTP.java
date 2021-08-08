package me.polo.admincore.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RTP implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("rtp")){
                if(args.length != 1){
                    p.sendMessage(ChatColor.RED + "Try /rtp <1000,5000,10000>");
                } else {
                    if(args[0].equalsIgnoreCase("1000")){
                        World world = p.getWorld();
                        double x = Math.random() * (1000) + 0;
                        double y = Math.random() * (1000) + 0;
                        double z = Math.random() * (1000) + 0;
                        Location loc = new Location(world, x, y, z);
                        p.teleport(loc);
                    }
                    if(args[0].equalsIgnoreCase("5000")){
                        World world = p.getWorld();
                        double x = Math.random() * (5000) + 0;
                        double y = Math.random() * (5000) + 0;
                        double z = Math.random() * (5000) + 0;
                        Location loc = new Location(world, x, y, z);
                        p.teleport(loc);
                    }if(args[0].equalsIgnoreCase("10000")){
                        World world = p.getWorld();
                        double x = Math.random() * (10000) + 0;
                        double y = Math.random() * (10000) + 0;
                        double z = Math.random() * (10000) + 0;
                        Location loc = new Location(world, x, y, z);
                        p.teleport(loc);
                    }

                }
            }
        }

        return false;
    }

}
