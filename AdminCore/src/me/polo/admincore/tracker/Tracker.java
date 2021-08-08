package me.polo.admincore.tracker;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Tracker implements CommandExecutor {

    private JavaPlugin plugin;
    public Tracker(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("track")) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.RED + "/track <player/stop>");
                } else if (args.length == 1) {
                    if(args[0].equalsIgnoreCase("stop")){
                        Location loc = p.getBedSpawnLocation();
                        assert loc != null;
                        p.setCompassTarget(loc);
                    } else {
                        Player t = Bukkit.getPlayer(args[0]);
                        if (t != null) {
                            new BukkitRunnable() {
                                public void run() {
                                    Location loc = t.getLocation();
                                    p.setCompassTarget(loc);
                                }
                            }.runTaskTimerAsynchronously(plugin, 0L, 1);
                        } else {
                            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Player not found");
                        }
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "/track <player/stop>");
                }
            }
        }
        return false;
    }

}
