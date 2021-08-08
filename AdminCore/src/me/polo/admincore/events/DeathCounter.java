package me.polo.admincore.events;

import me.polo.admincore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;
import java.util.Objects;

public class DeathCounter implements CommandExecutor, Listener {

    public Main plugin = Main.getPlugin(Main.class);
    public ArrayList<Player> players = new ArrayList<>();
    public ArrayList<Integer> counter = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if (sender instanceof Player){
            Player p = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("deathcounter") || cmd.getName().equalsIgnoreCase("dc")){

                //      /dc
                if(args.length == 0){

                    //plugin.getConfig().get("Deaths.");
                    p.sendMessage("-=-=-=-=-=-=-=-");
                    p.sendMessage("Server Death Counter");
                    for(int b = 0; b < Bukkit.getOnlinePlayers().size(); b++) {
                        Player player = Bukkit.getPlayer(Objects.requireNonNull(plugin.getConfig().getString("Deaths.", String.valueOf(b))));
                        if(player != null) {
                            int deaths = plugin.config.getInt("Deaths." + player.getName());
                            players.add(player);
                            counter.add(deaths);
                        }

                        p.sendMessage(ChatColor.RED + "" + players.get(b) + ChatColor.AQUA + ": " + ChatColor.WHITE + "" + counter.get(b) + " deaths");
                    }
                    p.sendMessage("-=-=-=-=-=-=-=-");
                }
                //      /dc Bob
                else if(args.length == 1){
                    Player t = Bukkit.getPlayer(args[0]);
                    String tname = t.getName();
                    p.sendMessage("-=-=-=-=-=-=-=-");
                    p.sendMessage(ChatColor.RED + "Deaths Counter for " + args[0]);
                    int deaths = plugin.getConfig().getInt("Deaths." + tname);
                    p.sendMessage(ChatColor.BLUE + "" + deaths + " deaths");
                    p.sendMessage("-=-=-=-=-=-=-=-");
                } else {
                    p.sendMessage(ChatColor.RED + "Try /dc <player>");
                }
            }
            if(cmd.getName().equalsIgnoreCase("dcadd") || cmd.getName().equalsIgnoreCase("deathcounteradd")){
                if(args.length == 2){
                    if(p.hasPermission("admincore.deathcounteradd")){
                            Player player = Bukkit.getPlayer(args[0]);
                            if(player != null) {
                                String name = player.getName();
                                int x = Integer.parseInt(args[1]);
                                int deaths = plugin.getConfig().getInt("Deaths." + name);
                                plugin.getConfig().set("Deaths." + name, deaths + x);
                                p.sendMessage(ChatColor.GREEN + "Successfully added " + x + " deaths to " + name);
                            }
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Try /dcadd <player> <number>");
                }
            }
            if(cmd.getName().equalsIgnoreCase("dcdel") || cmd.getName().equalsIgnoreCase("deathcounterdelete")){
                if(args.length == 2){
                    if(p.hasPermission("admincore.deathcounterdelete")){
                        Player player = Bukkit.getPlayer(args[0]);
                        if(player != null) {
                            String name = player.getName();
                            Bukkit.getConsoleSender().sendMessage("1");
                            int x = Integer.parseInt(args[1]);
                            int deaths = plugin.getConfig().getInt("Deaths." + name);
                            if(deaths < x){
                                p.sendMessage(ChatColor.RED + "They do not have that many deaths.");
                            } else {
                                Bukkit.getConsoleSender().sendMessage("2");
                                plugin.getConfig().set("Deaths." + name, deaths - x);
                                p.sendMessage(ChatColor.GREEN + "Successfully removed " + x + " deaths from " + name);
                            }
                            Bukkit.getConsoleSender().sendMessage("3");
                        }
                        Bukkit.getConsoleSender().sendMessage("4");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Try /dcdel <player> <number>");
                }
            }
        }

        return false;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        String name = p.getName();
        if(plugin.getConfig().getInt("Deaths." + name) == 0){
            plugin.getConfig().set("Deaths." + name, 1);
        } else {
            int deaths = plugin.getConfig().getInt("Deaths." + name);
            plugin.getConfig().set("Deaths." + name, deaths + 1);
        }
        plugin.saveConfig();
    }

}
