package testsFonctionnels;

import cartes.Attaque;
import cartes.Parade;
import cartes.Botte;
import cartes.JeuDeCartes;
import cartes.Borne;

public class TestJeuDeCartes {

    public static void main(String[] args) {
        // Création du jeu de cartes
        JeuDeCartes jeuDeCartes = new JeuDeCartes();

        // Ajout des cartes avec leurs nombres d'exemplaires
        jeuDeCartes.ajouterConfiguration(new Borne("25KM"), 10);
        jeuDeCartes.ajouterConfiguration(new Borne("50KM"), 10);
        jeuDeCartes.ajouterConfiguration(new Borne("75KM"), 10);
        jeuDeCartes.ajouterConfiguration(new Borne("100KM"), 12);
        jeuDeCartes.ajouterConfiguration(new Borne("200KM"), 4);
        jeuDeCartes.ajouterConfiguration(new Parade("Feu Vert"), 14);
        jeuDeCartes.ajouterConfiguration(new Attaque("Feu Rouge"), 5);
        jeuDeCartes.ajouterConfiguration(new Botte("Increvable"), 1);

        // Affichage du jeu de cartes
        jeuDeCartes.affichageJeuDeCartes();
    }
}

