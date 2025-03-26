package fr.yanni.rp;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
    @Override
    public void onEnable() {
        getLogger().info("RpFramework is now enabled!");
        
        getServer().getPluginManager().registerEvents(new EventListener(this), this);
        
    }

    @Override
    public void onDisable() {
        getLogger().info("RpFramework is now disabled!");
    }
}
