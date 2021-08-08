package me.polo.admincore.admintroll;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.HashSet;
import java.util.UUID;

public class Namebomb implements CommandExecutor, Listener {

    static HashSet<UUID> hashset = new HashSet<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("admincore.namebomb")){
                if(cmd.getName().equalsIgnoreCase("namebomb") || cmd.getName().equalsIgnoreCase("nb")){
                    if(args.length == 0){
                        p.sendMessage(ChatColor.RED + "Try /namebomb <player>");
                    } else if(args.length == 1){
                        Player t = Bukkit.getPlayer(args[0]);
                        if(t != null) {
                            if(t.getMaxHealth() == 1){
                                p.sendMessage(ChatColor.BLUE + "Player already only has half a heart");
                                return true;
                            }
                            int i = (int) t.getMaxHealth();
                            i--;
                            t.setMaxHealth(i);
                            hashset.add(t.getUniqueId());
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "Insufficient Arguments");
                    }
                }
                if(cmd.getName().equalsIgnoreCase("unnamebomb") || cmd.getName().equalsIgnoreCase("unnb")){
                    if(args.length == 0){
                        p.sendMessage(ChatColor.RED + "Try /namebomb <player>");
                    } else if(args.length == 1){
                        Player t = Bukkit.getPlayer(args[0]);
                        if(t != null) {
                            t.setMaxHealth(20);
                            t.setHealth(20);
                            hashset.remove(t.getUniqueId());
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "Insufficient Arguments");
                    }
                }
            } else {
                p.sendMessage(ChatColor.RED + "Insufficient Permissions");
            }
        }

        return false;
    }

    @EventHandler public void onPlayerRespawn(PlayerRespawnEvent e){ ;
        Player p = e.getPlayer();
        if(hashset.contains(p.getUniqueId())){
            p.setMaxHealth(20);
            p.setHealth(20);
            hashset.remove(p.getUniqueId());
        }
    }

}
