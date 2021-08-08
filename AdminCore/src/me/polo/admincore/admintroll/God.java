package me.polo.admincore.admintroll;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;

public class God implements CommandExecutor {

    static HashSet<Player> gods = new HashSet<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("admincore.god")){

                if(cmd.getName().equalsIgnoreCase("god")){
                    if(args.length == 0){
                        p.setInvulnerable(true);
                        p.sendMessage(ChatColor.GREEN + "You're now in god mode");
                        gods.add(p);
                    } else if(args.length == 1){
                        Player t = Bukkit.getPlayer(args[0]);

                        if(t != null) {
                            t.setInvulnerable(true);
                            t.sendMessage(ChatColor.GREEN + "Set to god mode");
                            p.sendMessage(ChatColor.GREEN + t.getName() + " set to god mode");
                            gods.add(t);
                        }
                    }
                }

                if(cmd.getName().equalsIgnoreCase("ungod")){
                    if(args.length == 0){
                        p.setInvulnerable(false);
                        p.sendMessage(ChatColor.GREEN + "You're now in normal mode");
                        gods.remove(p);
                    } else if(args.length == 1){
                        Player t = Bukkit.getPlayer(args[0]);
                        if(t != null){
                            t.setInvulnerable(false);
                            t.sendMessage(ChatColor.GREEN + "Set back to normal mode");
                            p.sendMessage(ChatColor.GREEN + t.getName() + " set back to normal");
                            gods.remove(t);
                        }
                    }
                }

                if(cmd.getName().equalsIgnoreCase("godquery")){
                    Player t = Bukkit.getPlayer(args[0]);
                    if(gods.contains(t)){
                        p.sendMessage(ChatColor.LIGHT_PURPLE + t.getName() + " is in god mode");
                    }
                    if(!(gods.contains(t))){
                        p.sendMessage(ChatColor.LIGHT_PURPLE + t.getName() + " isnt in god mode");
                    }
                }
            }
        }

        return false;
    }

}
