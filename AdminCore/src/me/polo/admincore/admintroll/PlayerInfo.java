package me.polo.admincore.admintroll;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerInfo implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("admincore.playerinfo")){
                if(cmd.getName().equalsIgnoreCase("playerinfo")){
                    if(args.length != 1){
                        p.sendMessage(ChatColor.RED + "Insufficient Arguments");
                    } else {
                        Player t = Bukkit.getPlayer(args[0]);
                        if(t != null){
                            Location loc = t.getLocation();
                            World world = loc.getWorld();
                            double x = Math.floor(loc.getX() * 10) / 10;
                            double y = Math.floor(loc.getY() * 10) / 10;
                            double z = Math.floor(loc.getZ() * 10) / 10;
                            int health = (int) t.getHealth();
                            int food = t.getFoodLevel();
                            boolean fly = t.getAllowFlight();
                            boolean god = t.isInvulnerable();
                            boolean op = t.isOp();

                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Info for " + t.getName());
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.LIGHT_PURPLE + "World: " + ChatColor.GOLD + "" + world.getName());
                            p.sendMessage(ChatColor.LIGHT_PURPLE + "X: " + ChatColor.GOLD + "" + x);
                            p.sendMessage(ChatColor.LIGHT_PURPLE + "Y: " + ChatColor.GOLD + "" + y);
                            p.sendMessage(ChatColor.LIGHT_PURPLE + "Z: " + ChatColor.GOLD + "" + z);
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.LIGHT_PURPLE + "Health: " + ChatColor.GOLD + "" + health);
                            p.sendMessage(ChatColor.LIGHT_PURPLE + "Food: " + ChatColor.GOLD + "" + food);
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.LIGHT_PURPLE + "Can fly: " + ChatColor.GOLD + "" + fly);
                            p.sendMessage(ChatColor.LIGHT_PURPLE + "Is god: " + ChatColor.GOLD + "" + god);
                            p.sendMessage(ChatColor.LIGHT_PURPLE + "Is op: " + ChatColor.GOLD + "" + op);
                            p.sendMessage(" ");

                        } else {
                            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Player not found");
                        }
                    }
                }
            }
        }

        return false;
    }

}
