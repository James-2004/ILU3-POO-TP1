package cartes;

import java.util.ArrayList;
import java.util.List;

public class JeuDeCartes {
    private List<Configuration> configurations;

    // Constructeur
    public JeuDeCartes() {
        configurations = new ArrayList<>();
    }

    // Ajoute une configuration de carte avec le nombre d'exemplaires
    public void ajouterConfiguration(Carte carte, int nombreExemplaires) {
        configurations.add(new Configuration(carte, nombreExemplaires));
    }

    // Méthode d'affichage du jeu de cartes
    public void affichageJeuDeCartes() {
        System.out.println("JEU :");
        for (Configuration configuration : configurations) {
            System.out.println(configuration.getNombreExemplaires() + " " + configuration.getCarte());
        }
    }
}
