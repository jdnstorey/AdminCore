package me.polo.admincore.admintroll;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static java.lang.Integer.valueOf;

public class Dupe implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("admincore.dupe")){
                if(cmd.getName().equalsIgnoreCase("dupe")){
                    if(args.length != 1){
                        p.sendMessage(ChatColor.RED + "Insufficient Arguments");
                    } else {
                        ItemStack item = p.getItemInHand();
                        ItemMeta itemmeta = item.getItemMeta();
                        item.setItemMeta(itemmeta);

                        for(int i = valueOf(args[0]); i > 0; i--){
                            p.getInventory().addItem(item);
                            i--;
                        }
                    }
                }
            } else {
                p.sendMessage(ChatColor.RED + "Insufficient Permission");
            }
        }
        return false;
    }

}
