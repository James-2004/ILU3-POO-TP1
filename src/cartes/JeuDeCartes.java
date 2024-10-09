package cartes;

import java.util.HashMap;
import java.util.Map;

public class JeuDeCartes {
    private Carte[] cartes; // Tableau de cartes
    private Map<String, Integer> configuration; // Configuration souhaitée du nombre de cartes

    // Constructeur qui prend en paramètre le tableau de cartes et la configuration
    public JeuDeCartes(Carte[] cartes, Map<String, Integer> configuration) {
        this.cartes = cartes;
        this.configuration = configuration;
    }

    // Méthode pour obtenir le tableau de cartes
    public Carte[] getCartes() {
        return cartes;
    }

    public boolean checkCount() {
        // Créer un Map pour compter les occurrences des cartes
        Map<String, Integer> compteur = new HashMap<>();
        for (Carte carte : cartes) {
            String nomCarte = carte.getNom();
            compteur.put(nomCarte, compteur.getOrDefault(nomCarte, 0) + 1);
        }

        // Vérifier que chaque carte dans la configuration est présente avec le bon nombre d'occurrences
        for (Map.Entry<String, Integer> entry : configuration.entrySet()) {
            String nomCarte = entry.getKey();
            int nombreAttendu = entry.getValue();
            int nombreActuel = compteur.getOrDefault(nomCarte, 0);

            if (nombreActuel != nombreAttendu) {
                return false; // Les comptes ne correspondent pas
            }
        }

        // Vérifier qu'il n'y a pas de cartes supplémentaires dans le tableau
        for (String nomCarte : compteur.keySet()) {
            if (!configuration.containsKey(nomCarte)) {
                return false; // Une carte est présente dans le tableau mais pas dans la configuration
            }
        }

        return true; // Tout est correct
    }
}
