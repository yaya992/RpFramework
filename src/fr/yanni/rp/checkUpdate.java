package fr.yanni.rp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class checkUpdate {
	private static final String GITHUB_API_URL = "https://api.github.com/repos/yaya992/RpFramework/releases/latest";
	
	// Vérife Update
	public static String checkForUpdate() {
        try {
            // Créer une connexion HTTP à l'API GitHub
            HttpURLConnection connection = (HttpURLConnection) new URL(GITHUB_API_URL).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            // Lire la réponse
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            // Récupérer les informations JSON
            String responseBody = response.toString();

            // Extraire la version de la release
            String version = responseBody.split("\"tag_name\":\"")[1].split("\"")[0]; // Extraire la version

            // Vérifier si c'est une pré-release
            boolean isPrerelease = responseBody.contains("\"prerelease\":true");

            // Si c'est une pré-release, ne pas retourner la version
            if (isPrerelease) {
                return null;
            }

            return version;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
