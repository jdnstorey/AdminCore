package me.polo.admincore.inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Invsee implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("admincore.invsee")){
                if(cmd.getName().equalsIgnoreCase("invsee")){
                    if(args.length != 1){
                        p.sendMessage(ChatColor.RED + "Insufficent Arguments");
                    } else {
                        Player t = Bukkit.getPlayer(args[0]);
                        if(t != null){
                            Inventory inv = t.getInventory();
                            p.openInventory(inv);
                        } else {
                            p.sendMessage(ChatColor.RED + "Player not found");
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
