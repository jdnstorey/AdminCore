package me.polo.admincore.admintroll;

import me.polo.admincore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBanned implements CommandExecutor {

    public Main plugin = Main.getPlugin(Main.class);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        if (p.hasPermission("commandbanned.add")){
            if(cmd.getName().equalsIgnoreCase("cmdban")){
                if(args.length != 2){
                    p.sendMessage(ChatColor.RED + "Insufficient Arguments");
                } else {
                    Player banned = Bukkit.getPlayer(args[0]);
                    String command = args[1];
                    if(command.equalsIgnoreCase("Spawn")){
                        plugin.getConfig().set("CommandBanned.Spawn.", banned.getName());
                    }
                }
            }
        }

        return false;
    }
}
