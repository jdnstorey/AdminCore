package me.polo.admincore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminHelp implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("admincore.adminhelp")) {
                if (cmd.getName().equalsIgnoreCase("adminhelp")) {
                    if (args.length == 0) {
                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        p.sendMessage(ChatColor.BOLD + "AdminCore Help Menu");
                        p.sendMessage("Type /help <module> for more info");
                        p.sendMessage(" ");
                        p.sendMessage("Fly");
                        p.sendMessage("Freeze");
                        p.sendMessage("God");
                        p.sendMessage("Namebomb");
                        p.sendMessage("Vanish");
                        p.sendMessage("Broadcast");
                        p.sendMessage("ClearChat");
                        p.sendMessage("PrivateMessage");
                        p.sendMessage("Discord");
                        p.sendMessage("Teleports");
                        p.sendMessage("Feed");
                        p.sendMessage("Heal");
                        p.sendMessage("Invsee");
                        p.sendMessage("FakeJoinLeave");
                        p.sendMessage("Tracker");
                        p.sendMessage("Warps");
                        p.sendMessage("DeathCounter");
                        p.sendMessage(" ");
                        p.sendMessage(" ");

                    } else if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("fly")) {
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BOLD + "Fly Help Menu");
                            p.sendMessage(" ");
                            p.sendMessage("/fly allows you to fly");
                            p.sendMessage("/flyquery checks if a player is able to fly");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE + "/fly <player>");
                            p.sendMessage(ChatColor.BLUE + "/flyquery <player>");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                        }
                        if (args[0].equalsIgnoreCase("freeze")) {
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BOLD + "Freeze Help Menu");
                            p.sendMessage(" ");
                            p.sendMessage("/freeze allows you to freeze someone");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE + "/freeze <player>");
                            p.sendMessage(ChatColor.BLUE + "/unfreeze <player>");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                        }
                        if (args[0].equalsIgnoreCase("God")) {
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BOLD + "God Help Menu");
                            p.sendMessage(" ");
                            p.sendMessage("/god allows you to set someone into god mode");
                            p.sendMessage("/ungod allows you to set someone out of god mode");
                            p.sendMessage("/godquery is used to find out if someone is in god mode");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE + "/god <player>");
                            p.sendMessage(ChatColor.BLUE + "/ungod <player>");
                            p.sendMessage(ChatColor.BLUE + "/godquery <player>");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                        }
                        if (args[0].equalsIgnoreCase("Namebomb")) {
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BOLD + "Namebomb Help Menu");
                            p.sendMessage(" ");
                            p.sendMessage("/namebomb removes one hp from the player");
                            p.sendMessage("/unnamebomb sets player's health back to 20");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE + "/namebomb (nb) <player>");
                            p.sendMessage(ChatColor.BLUE + "/unnamebomb (unnb) <player>");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                        }
                        if (args[0].equalsIgnoreCase("Vanish")) {
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BOLD + "Vanish Help Menu");
                            p.sendMessage(" ");
                            p.sendMessage("/vanish sets the player into vanish");
                            p.sendMessage("When typed again it takes the player out of vanish");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE + "/vanish <player>");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                        }
                        if (args[0].equalsIgnoreCase("broadcast")) {
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BOLD + "Broadcast Help Menu");
                            p.sendMessage(" ");
                            p.sendMessage("/broadcast broadcasts a message to the server");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE + "/broadcast (bc) <message>");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                        }
                        if (args[0].equalsIgnoreCase("clearchat")) {
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BOLD + "ClearChat Help Menu");
                            p.sendMessage(" ");
                            p.sendMessage("/clearchat clears the chat");
                            p.sendMessage("/clearchat show clears the chat and displays the chat clearer's name");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE + "/clearchat (cc)");
                            p.sendMessage(ChatColor.BLUE + "/clearchat show (cc show)");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                        }
                        if (args[0].equalsIgnoreCase("privatemessage")) {
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
                        if (args[0].equalsIgnoreCase("discord")) {
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
                            p.sendMessage("/rtp <1000,5000,10000> will randomly teleport you around the world");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE + "/spawn");
                            p.sendMessage(ChatColor.BLUE + "/back");
                            p.sendMessage(ChatColor.BLUE + "/rtp");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                        }
                        if (args[0].equalsIgnoreCase("feed")) {
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BOLD + "Feed Help Menu");
                            p.sendMessage(" ");
                            p.sendMessage("/feed sets food level to max");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE + "/feed (f) <player>");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                        }
                        if (args[0].equalsIgnoreCase("heal")) {
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BOLD + "Heal Help Menu");
                            p.sendMessage(" ");
                            p.sendMessage("/heal sets health level to max");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE + "/heal (h) <player>");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                        }
                        if (args[0].equalsIgnoreCase("invsee")) {
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BOLD + "Invsee Help Menu");
                            p.sendMessage(" ");
                            p.sendMessage("/invsee <player> lets you view and edit a player's inventory");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE + "/invsee <player>");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                        }
                        if (args[0].equalsIgnoreCase("fakejoinleave")) {
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BOLD + "FakeJoinLeave Help Menu");
                            p.sendMessage(" ");
                            p.sendMessage("/fake join/leave <player> will show the join or leave message for that player");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE + "/fake <join/leave> <player>");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                        }
                        if (args[0].equalsIgnoreCase("tracker")) {
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
                        if (args[0].equalsIgnoreCase("warps")) {
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
                            p.sendMessage("/dcadd <player> <integer> adds a certain number of deaths to the player");
                            p.sendMessage("/dcdel <player> <integer> removes a certain number of deaths to the player");
                            p.sendMessage(" ");
                            p.sendMessage(ChatColor.BLUE + "/dc <player>");
                            p.sendMessage(ChatColor.BLUE + "/dcadd <player> <integer> ");
                            p.sendMessage(ChatColor.BLUE + "/dcdel <player> <integer> ");
                            p.sendMessage(" ");
                            p.sendMessage(" ");
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "Insufficient Arguments");
                    }
                }
            }
        }

        return true;
    }

}
