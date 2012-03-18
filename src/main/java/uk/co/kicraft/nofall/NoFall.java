package uk.co.kicraft.nofall;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Hello world!
 * 
 */
public class NoFall extends JavaPlugin {

	private static NoFall instance;

	public static NoFall getInstance() {
		return instance;
	}

	public String version = "0.1";

//	private void setupPermissions() {
//		log.info("Setup Permissions");
//		Plugin test = this.getServer().getPluginManager()
//				.getPlugin("Permissions");
//		if (test != null) {
//			this.permissions = (Permission) test;
//			log.info("[NoFall] Permissions system detected!");
//		} else {
//			log.info("[NoFall] Permission system not detected, defaulting to OP");
//		}
//	}

	public boolean checkPermissions(Player player) {
		return player.hasPermission("nofall.nofalldamage");
	}

	boolean derp = true;

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		return false;
	}

	private static final Logger log = Logger.getLogger("Minecraft");

	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
//		setupPermissions();
		pm.registerEvents(new NoFallListener(this), this);
		this.version = this.getDescription().getVersion();
		log.info("[NoFall] " + version + " has been enabled!");
	}

	public void onDisable() {
		log.info("[NoFall] Version " + version + " has been disabled!");
	}

}
