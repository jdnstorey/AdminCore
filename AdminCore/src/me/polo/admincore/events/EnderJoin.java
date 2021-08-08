package me.polo.admincore.events;

import me.polo.admincore.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class EnderJoin implements Listener {

    public Main plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String uuid = p.getUniqueId().toString();

        if (plugin.getConfig().contains(uuid)) {

        } else {
            plugin.getConfig().set("UUID. ", uuid);
            plugin.saveConfig();
            p.getInventory().addItem(new ItemStack(Material.ENDER_CHEST));
        }
    }

}
