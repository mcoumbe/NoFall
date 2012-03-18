package uk.co.kicraft.nofall;

import java.util.logging.Logger;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class NoFallListener implements Listener {

	private Logger log;
	private NoFall plugin;

	public NoFallListener(NoFall plugin) {
		this.plugin = plugin;
		log = Logger.getAnonymousLogger();
	}

	boolean derp = true;

	@EventHandler
	public void onPlayerDamage(EntityDamageEvent event) {
				
		Entity ee = event.getEntity();
		
		if (ee instanceof Player && plugin.checkPermissions((Player) ee)) {
			Player p = (Player) ee;
			DamageCause type = event.getCause();
			if (type == DamageCause.FALL) {
				log.info(p.getName() + " avoided fall damage");
				event.setCancelled(true);
				return;
			} else {
				log.info(p.getName() + " avoided fall damage");
			}			
		}
	}
}