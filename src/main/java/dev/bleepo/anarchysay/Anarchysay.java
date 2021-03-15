package dev.bleepo.anarchysay;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Anarchysay extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(ChatColor.DARK_GREEN + "AnarchySay by Bleepo has been loaded and enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.DARK_GREEN + "AnarchySay by Bleepo has been unloaded and disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("say")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("server.say")) {
                    String prefix = getConfig().getString("prefix");
                    StringBuilder str = new StringBuilder();
                    for (String arg : args) {
                        str.append(arg).append(" ");
                    }
                    String msg = str.toString();
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix != null ? prefix : "".replace("{message}", msg)));
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "You do not have permission todo that!");
                }
            } else {
                String prefix = getConfig().getString("prefix");
                StringBuilder str = new StringBuilder();
                for (String arg : args) {
                    str.append(arg).append(" ");
                }
                String msg = str.toString();
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix != null ? prefix : "".replace("{message}", msg)));
            }
        }
        return true;
    }
}
