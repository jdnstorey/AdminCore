package me.polo.admincore.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class DragonEgg implements Listener {

    @EventHandler
    public void onTap(PlayerInteractEvent e){
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
            Block block = e.getClickedBlock();
            Material material = block.getType();
            if(material.equals(Material.DRAGON_EGG)){
                e.setCancelled(true);
                e.setUseInteractedBlock(Event.Result.DENY);
                e.getPlayer().sendMessage(ChatColor.RED + "You are not allowed to move a dragon egg");
            }
        } else {
            return;
        }
    }

}
