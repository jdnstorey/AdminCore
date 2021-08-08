package me.polo.admincore.events;

import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class CreeperExplosion implements Listener {

    @EventHandler
    public void onExplode(EntityExplodeEvent e){
        if(e.getEntity() instanceof Creeper){
            e.setCancelled(true);
        }
    }

}
