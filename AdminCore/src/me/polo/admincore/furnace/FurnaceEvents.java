package me.polo.admincore.furnace;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class FurnaceEvents implements Listener {

    ItemStack iron = new ItemStack(Material.IRON_INGOT);
    ItemStack opiron = new ItemStack(Material.IRON_INGOT, 3);
    ItemStack gold = new ItemStack(Material.GOLD_INGOT);
    ItemStack opgold = new ItemStack(Material.GOLD_INGOT, 3);

    int oprandom = (int) (Math.random() * (50) + 30);
    int random = (int) (Math.random() * (5) + 3);

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block block = e.getBlock();
        Location loc = block.getLocation();

        if(block.getType().equals(Material.IRON_ORE)) {
            e.setDropItems(false);

            if(p.isOp()) {
                e.setExpToDrop(oprandom);
                loc.getWorld().dropItem(loc, opiron);
            } else {
                e.setExpToDrop(random);
                loc.getWorld().dropItem(loc, iron);
            }

        } else if (block.getType().equals(Material.GOLD_ORE)){
            e.setDropItems(false);

            if(p.isOp()) {
                e.setExpToDrop(oprandom);
                loc.getWorld().dropItem(loc, opgold);
            } else {
                e.setExpToDrop(random);
                loc.getWorld().dropItem(loc, gold);
            }

        } else {
            return;
        }
    }
}
