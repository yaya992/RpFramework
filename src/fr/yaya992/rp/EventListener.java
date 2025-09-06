package fr.yaya992.rp;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {
	
	private final main plugin;

    public EventListener(main plugin) {
        this.plugin = plugin;
    }
    
    
    // Quant Un Joueurs Rejoindre
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        
        // Vérifier si le joueur est OP avant d'envoyer un message
        if (player.isOp()) {
        	for (Player player1 : Bukkit.getOnlinePlayers()) {
                if (player1.isOp()) {
                	String latestVersion = checkUpdate.checkForUpdate();
                    String currentVersion = plugin.getDescription().getVersion(); // Version actuelle du plugin

                    // Si une mise à jour est disponible (version GitHub différente de la version actuelle)
                    if (latestVersion != null && !latestVersion.equals(currentVersion)) {
                        // Envoyer un message aux joueurs OP
                        player1.sendMessage("§c[Mise à jour] : Une nouvelle version stable du plugin est disponible !");
                        player1.sendMessage("§6Téléchargez la nouvelle version sur GitHub : https://github.com/yaya992/RpFramework/releases");
                    }
                }
            }
        }
    }
}
