package me.polo.admincore.joinleave;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JLEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        e.setJoinMessage("");
        Bukkit.broadcastMessage
                (ChatColor.RED + "He" + ChatColor.YELLOW + "llo! " + ChatColor.GREEN + p.getName() + ChatColor.BLUE + " is " + ChatColor.LIGHT_PURPLE + "here! " + ChatColor.DARK_PURPLE + "Say hi!");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();

        e.setQuitMessage("");
        Bukkit.broadcastMessage
                (ChatColor.RED + "Bye " + ChatColor.GRAY + "Bye! " + ChatColor.BLUE + "" + ChatColor.BOLD + p.getName() + ChatColor.GREEN + " left." + ChatColor.GOLD + " They will be missed");
    }

}
