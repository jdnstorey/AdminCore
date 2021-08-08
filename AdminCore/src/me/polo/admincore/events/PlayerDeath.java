package me.polo.admincore.events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity().getPlayer();
        double xLoc = p.getLocation().getBlockX();
        double yLoc = p.getLocation().getBlockY();
        double zLoc = p.getLocation().getBlockZ();
        Bukkit.broadcastMessage(ChatColor.YELLOW + p.getName() + " didnt want to live here any more");
        p.sendMessage(ChatColor.GREEN + "You died at X:" + xLoc + " Y:" + yLoc + " Z:" + zLoc);
        e.setDeathMessage("");
    }

}
