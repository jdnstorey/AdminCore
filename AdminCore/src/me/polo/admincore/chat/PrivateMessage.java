package me.polo.admincore.chat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

import static org.bukkit.Bukkit.getPlayer;

public class PrivateMessage implements CommandExecutor {

    public HashMap<Player, Player> players = new HashMap<>();
    public Player msgreciever;
    public Player msgsender;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if (sender instanceof Player) {
            if(cmd.getName().equalsIgnoreCase("msg")) {
                msgsender = (Player) sender;

                if(args.length > 1){
                    msgreciever = getPlayer(args[0]);
                    if (msgreciever != null) {
                        String message= "";

                        for(int i = 1; i < args.length; i++) {
                            message += " " + args[i];
                        }

                        msgsender.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "[SENT MSG] " + ChatColor.RED + "" + msgsender.getName() + " --> " + msgreciever.getName() + ChatColor.BOLD + " >" + ChatColor.RESET + message);
                        msgreciever.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "[INCOMING MSG] " + ChatColor.RED + "" + msgsender.getName() + ChatColor.BOLD + " >" + ChatColor.RESET + message);

                        players.put(msgreciever, msgreciever);
                    } else {
                        sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Player is offline");
                    }
                } else {
                    msgsender.sendMessage(ChatColor.RED + "Insufficient Arguments");
                }
            }
        }

        return false;
    }

}
