package me.polo.admincore.events;

import me.polo.admincore.Main;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class SinglePlayerSleep implements Listener, CommandExecutor {

    private ArrayList<Player> sleeping = new ArrayList<>();

    private Main plugin;
    public SinglePlayerSleep(Main plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, this.plugin);
        Bukkit.getPluginCommand("sleeping").setExecutor(this);
        Bukkit.getPluginCommand("runtimequery").setExecutor(this);
    }

    @EventHandler
    public void onSleep(PlayerBedEnterEvent e){
        Player p = e.getPlayer();

        if(e.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {
            for (int i = 0; i < 100; i++) {
                long time = p.getWorld().getTime();

                if (time > 12000 && time < 24000) {
                    if (i == 1) {
                        plugin.getServer().getConsoleSender().sendMessage(p.getName() + " is trying to sleep");
                        sleeping.add(p);
                        getServer().getConsoleSender().sendMessage("SLEEPING PLAYERS: " + sleeping.get(0).getName());
                    }
                    p.getWorld().setTime(time + 1000);
                }
            }
        }
    }

    @EventHandler
    public void onWake(PlayerBedLeaveEvent f){
        Player p = f.getPlayer();
        if(sleeping.contains(p)){
            if(Bukkit.getOnlinePlayers().size() > 1) {
                Bukkit.broadcastMessage("Night was skipped because " + ChatColor.GOLD + p.getName() + ChatColor.RESET +
                        " slept.");
            }
            sleeping.remove(p);
        } else {
            return;
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender.hasPermission("admincore.sleeping")){
            if(cmd.getName().equalsIgnoreCase("sleeping")) {
                if(args.length != 1) {
                    sender.sendMessage(sleeping.toString());
                } else {
                    if (args[0].equalsIgnoreCase("clear")) {
                        for (Player t : Bukkit.getOnlinePlayers()) {
                            sleeping.clear();
                        }
                        sender.sendMessage("Cleared the list of sleeping players");
                    }
                }
            }
            if(cmd.getName().equalsIgnoreCase("runtimequery")) {
                if (args[0].equalsIgnoreCase("gettime")) {
                    BukkitTask rn = new BukkitRunnable() {
                        Player p = (Player) sender;

                        public void run() {
                            for (int i = 0; i < 10; i++) {
                                getServer().getConsoleSender().sendMessage(String.valueOf(p.getWorld().getTime()));

                                for (Player ops : getServer().getOnlinePlayers()) {
                                    if (ops.isOp()) {
                                        ops.sendMessage(String.valueOf(p.getWorld().getTime()));
                                    }
                                }
                            }
                        }
                    }.runTaskLater(plugin, 50);
                } else if(args[0].equalsIgnoreCase("getfull")){
                    BukkitTask rn = new BukkitRunnable() {
                        Player p = (Player) sender;

                        public void run() {
                            for (int i = 0; i < 10; i++) {
                                getServer().getConsoleSender().sendMessage(String.valueOf(p.getWorld().getFullTime()));

                                for (Player ops : getServer().getOnlinePlayers()) {
                                    if (ops.isOp()) {
                                        ops.sendMessage(String.valueOf(p.getWorld().getFullTime()));
                                    }
                                }
                            }
                        }
                    }.runTaskLater(plugin, 50);
                }
            }
        }
        return false;
    }

}
