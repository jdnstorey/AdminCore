package me.polo.admincore.commands;

import me.polo.admincore.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class Spawn implements CommandExecutor, Listener {

    public Main plugin = Main.getPlugin(Main.class);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(sender instanceof Player) {
            Player p = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("spawn")) {
                Location playerloc = p.getLocation();
                plugin.getConfig().set(p.getName() + ".X", playerloc.getX());
                plugin.getConfig().set(p.getName() + ".Y", playerloc.getY());
                plugin.getConfig().set(p.getName() + ".Z", playerloc.getZ());
                plugin.getConfig().set(p.getName() + ".World", playerloc.getWorld().getName());
                plugin.getConfig().set(p.getName() + ".Pitch", playerloc.getPitch());
                plugin.getConfig().set(p.getName() + ".Yaw", playerloc.getYaw());
                plugin.saveConfig();

                Location loc = p.getWorld().getSpawnLocation();
                p.teleport(loc);
            }
        }

        return false;
    }

    @EventHandler
    public void onHurt(EntityDamageEvent e){
        Player p = (Player) e.getEntity();
    }

}
