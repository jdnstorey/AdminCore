package me.polo.admincore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Discord implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(sender instanceof Player){
            Player p = (Player) sender;

            if(cmd.getName().equalsIgnoreCase("discord")){
                p.sendMessage("https://discord.gg/hgjmu3CBgW");
            }

        }
        return false;
    }

}
