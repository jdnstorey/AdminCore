package me.polo.admincore.admintroll;

import me.polo.admincore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

public class Vanish implements CommandExecutor, Listener {

    public ArrayList<Player> vanished = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("admincore.vanish")) {
                if (cmd.getName().equalsIgnoreCase("vanish")) {
                    if (args.length == 0) {
                        if (!(vanished.contains(p))) {
                            for (Player everyone : Bukkit.getServer().getOnlinePlayers()) {
                                everyone.hidePlayer(p);
                            }
                            p.sendMessage(ChatColor.GREEN + "You are now vanished!");
                            vanished.add(p);
                        } else {
                            for (Player everyone : Bukkit.getServer().getOnlinePlayers()) {
                                everyone.showPlayer(p);
                            }
                            p.sendMessage(ChatColor.GREEN + "You are now unvanished!");
                            vanished.remove(p);
                        }

                    } else if (args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            if (!(vanished.contains(target))) {
                                for (Player everyone : Bukkit.getServer().getOnlinePlayers()) {
                                    everyone.hidePlayer(target);
                                }
                                target.sendMessage(ChatColor.GREEN + "You are now vanished!");
                                p.sendMessage(ChatColor.GREEN + "Successfully vanished " + target.getName());
                                vanished.add(target);
                            } else {
                                for (Player everyone : Bukkit.getServer().getOnlinePlayers()) {
                                    everyone.showPlayer(target);
                                }
                                target.sendMessage(ChatColor.GREEN + "You are now unvanished!");
                                p.sendMessage(ChatColor.GREEN + "Successfully unvanished " + target.getName());
                                vanished.remove(target);
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Player not found");
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "Insufficient Arguments");
                    }
                }
            }
        }
        return false;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(vanished.contains(p)){
            e.setJoinMessage("");
            p.sendMessage(ChatColor.GREEN + "Friendly Reminder: You're vanished!");
            p.hidePlayer(new Main(), p);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(vanished.contains(p)){
            e.setQuitMessage("");
        }
    }

    //75.127.2.162:25569
}
