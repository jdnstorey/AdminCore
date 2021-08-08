package me.polo.admincore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("help")) {
                if (args.length == 0) {
                    p.sendMessage(" ");
                    p.sendMessage(" ");
                    p.sendMessage(ChatColor.BOLD + "AdminCore Help Menu");
                    p.sendMessage("Type /help <module> for more info");
                    p.sendMessage(" ");
                    p.sendMessage("PrivateMessage");
                    p.sendMessage("Discord");
                    p.sendMessage("Teleports");
                    p.sendMessage("Tracker");
                    p.sendMessage("Warps");
                    p.sendMessage("DeathCounter");
                    p.sendMessage(" ");
                    p.sendMessage(" ");

                } else if(args.length == 1){
                    if(args[0].equalsIgnoreCase("privatemessage")){
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(ChatColor.BOLD + "PrivateMessage Help Menu");
                        p.sendMessage(" ");
                        p.sendMessage("/msg messages another player");
                        p.sendMessage(" ");
                        p.sendMessage(ChatColor.BLUE + "/msg <player> <message>");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                    }
                    if(args[0].equalsIgnoreCase("discord")){
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(ChatColor.BOLD + "Discord Help Menu");
                        p.sendMessage(" ");
                        p.sendMessage("/discord shows the discord link for the server");
                        p.sendMessage(" ");
                        p.sendMessage(ChatColor.BLUE + "/discord");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                    }
                    if(args[0].equalsIgnoreCase("teleports")){
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(ChatColor.BOLD + "Teleports Help Menu");
                        p.sendMessage(" ");
                        p.sendMessage("/spawn teleports you to the server spawn");
                        p.sendMessage("/back teleports you to the location you were in, when performing /spawn");
                        p.sendMessage(" ");
                        p.sendMessage(ChatColor.BLUE + "/spawn");
                        p.sendMessage(ChatColor.BLUE + "/back");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                    }
                    if(args[0].equalsIgnoreCase("tracker")){
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(ChatColor.BOLD + "Tracker Help Menu");
                        p.sendMessage(" ");
                        p.sendMessage("/track sets your compass to follow the player");
                        p.sendMessage(" ");
                        p.sendMessage("Useful for if you are trying to meet up");
                        p.sendMessage(" ");
                        p.sendMessage(ChatColor.BLUE + "/track <player/stop>");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                    }
                    if(args[0].equalsIgnoreCase("warps")){
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(ChatColor.BOLD + "Warps Help Menu");
                        p.sendMessage(" ");
                        p.sendMessage("/warp shows all warps");
                        p.sendMessage(" ");
                        p.sendMessage(ChatColor.BLUE + "/warp <location>");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                    }
                    if(args[0].equalsIgnoreCase("deathcounter")){
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(ChatColor.BOLD + "DeathCounter Help Menu");
                        p.sendMessage(" ");
                        p.sendMessage("/dc <player> shows the player's death count");
                        p.sendMessage(" ");
                        p.sendMessage(ChatColor.BLUE + "/dc <player>");
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Insufficient Arguments");
                }
            }
        }

        return true;
    }

}
