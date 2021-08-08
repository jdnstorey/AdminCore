package me.polo.admincore.admintroll;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.UUID;

public class Fly implements CommandExecutor, Listener {

    static ArrayList<UUID> flying = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(sender instanceof Player){
            Player p = (Player) sender;
            UUID puuid = p.getUniqueId();
            if(p.hasPermission("admincore.fly")){
                if(cmd.getName().equalsIgnoreCase("fly")){
                    if(args.length == 0){
                        if(!(flying.contains(puuid))) {
                            p.setAllowFlight(true);
                            p.sendMessage(ChatColor.GREEN + "Flight Enabled!");
                            flying.add(puuid);
                        } else {
                            p.setAllowFlight(false);
                            p.sendMessage(ChatColor.RED + "Flight Disabled!");
                            flying.remove(puuid);
                        }

                    } else if(args.length == 1){
                        Player t = Bukkit.getPlayer(args[0]);
                        UUID tuuid = t.getUniqueId();
                        if(t != null){
                            if(!(flying.contains(tuuid))) {
                                t.setAllowFlight(true);
                                t.sendMessage(ChatColor.GREEN + "Flight Enabled!");
                                p.sendMessage(ChatColor.GREEN + "Flight enabled for " + t.getName());
                                flying.add(tuuid);
                            } else {
                                t.setAllowFlight(false);
                                t.sendMessage(ChatColor.RED + "Flight Disabled!");
                                p.sendMessage(ChatColor.RED + "Flight disabled for " + t.getName());
                                flying.remove(tuuid);
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "Player not found");
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "Insufficient Arguments");
                    }
                }
                if(cmd.getName().equalsIgnoreCase("flyquery")){
                    Player t = Bukkit.getPlayer(args[0]);
                    if(flying.contains(t.getUniqueId())){
                        p.sendMessage(ChatColor.LIGHT_PURPLE + t.getName() + " is able to fly");
                    } else if(!(flying.contains(t.getUniqueId()))){
                        p.sendMessage(ChatColor.LIGHT_PURPLE + t.getName() + " isn't able to fly");
                    }
                }
            } else {
                p.sendMessage(ChatColor.RED+ "Insufficient Permission");
            }
        }

        return false;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        UUID puuid = p.getUniqueId();
        if(flying.contains(puuid)){
            p.setAllowFlight(false);
            flying.remove(puuid);
        }
    }

}
