package fr.yanni.rp;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class main extends JavaPlugin {
	
    @Override
    public void onEnable() {
        getLogger().info("RpFramework is now enabled!");
        
        // l'événement
        getServer().getPluginManager().registerEvents(new EventListener(this), this);
        
        // Vérifier la mise à jour au démarrage du serveur
        checkUpdate.checkForUpdate();
        
        // Vérifier la mise à jour toutes les 30 minutes (6000 ticks)
        new BukkitRunnable() {
            @Override
            public void run() {
                checkUpdate.checkForUpdate();
            }
        }.runTaskTimer(this, 0L, 6000L); // Exécuter toutes les 6000 ticks (30 minutes)
    }

    @Override
    public void onDisable() {
        getLogger().info("RpFramework is now disabled!");
    }
}
