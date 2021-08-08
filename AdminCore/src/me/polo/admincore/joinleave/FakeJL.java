package me.polo.admincore.joinleave;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeJL implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("admincore.fake")){
                if(cmd.getName().equalsIgnoreCase("fake")){
                    if(args.length != 2){
                        p.sendMessage(ChatColor.RED + "Try /fake <join/leave> <player>");
                    } else {
                        if(args[0].equalsIgnoreCase("join")){
                            String t = args[1].toString();
                            Bukkit.broadcastMessage
                                    (ChatColor.RED + "He" + ChatColor.YELLOW + "llo! " + ChatColor.GREEN + p.getName() + ChatColor.BLUE + " is " + ChatColor.LIGHT_PURPLE + "here! " + ChatColor.DARK_PURPLE + "Say hi!");
                        } else if(args[0].equalsIgnoreCase("leave")){
                            String t = args[1].toString();
                            Bukkit.broadcastMessage
                                    (ChatColor.RED + "Bye " + ChatColor.GRAY + "Bye! " + ChatColor.BLUE + "" + ChatColor.BOLD + p.getName() + ChatColor.GREEN + " left." + ChatColor.GOLD + " They will be missed");
                        } else {
                            p.sendMessage(ChatColor.RED + "Try /fake <join/leave> <player>");
                        }
                    }
                }
            }
        }

        return false;
    }

}
