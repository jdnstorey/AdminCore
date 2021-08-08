package me.polo.admincore.commands;

import me.polo.admincore.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Back implements CommandExecutor {

    public Main plugin = Main.getPlugin(Main.class);

    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (cmd.getName().equalsIgnoreCase("back")) {
                World world = Bukkit.getServer().getWorld(plugin.getConfig().getString(p.getName() + ".World"));
                double x = plugin.getConfig().getDouble(p.getName() + ".X");
                double y = plugin.getConfig().getDouble(p.getName() + ".Y");
                double z = plugin.getConfig().getDouble(p.getName() + ".Z");
                float yaw = plugin.getConfig().getInt(p.getName() + ".Yaw");
                float pitch = plugin.getConfig().getInt(p.getName() + ".Pitch");

                Location oldloc = new Location(world, x, y, z, yaw, pitch);
                p.teleport(oldloc);
            }
        }
        return false;
    }
}
