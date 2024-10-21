package testsFonctionnels;

import cartes.*;
import jeu.Sabot;
import java.util.NoSuchElementException;

public class TestSabot {

    public static void main(String[] args) {
        // Crée un tableau de cartes pour le sabot (capacité initiale)
        Carte[] cartes = {
            new Borne("25KM"),
            new Borne("50KM"),
            new Borne("75KM"),
            new Parade("Feu Vert"),
            new Attaque("Feu Rouge")
        };

        // Crée le sabot avec les cartes
        Sabot sabot = new Sabot(cartes);

        // ---------------------
        // TEST 1 : Ajout dans un sabot PLEIN
        // ---------------------
        try {
            System.out.println("Test d'ajout dans un sabot plein :");

            // Ajout de cartes au maximum de la capacité
            for (int i = 0; i < cartes.length; i++) {
                System.out.println("Ajout de la carte " + cartes[i].getNom());
            }

            // Tentative d'ajouter une carte après avoir atteint la capacité maximale
            sabot.ajouterCarte(new Botte("AsDuVolant"));
            System.out.println("Ajout de la carte AsDuVolant.");
            
            // Tentative d'ajouter une autre carte alors que le sabot est plein
            sabot.ajouterCarte(new Botte("SuperVolant")); // Cela doit lever une exception

        } catch (IllegalStateException e) {
            System.out.println("Erreur : Capacité maximale du sabot atteinte.");
        }

        // ---------------------
        // TEST 2 : Pioche dans un sabot VIDE
        // ---------------------
        try {
            System.out.println("\nTest de pioche dans un sabot vide :");

            // Piocher toutes les cartes du sabot jusqu'à le vider
            for (int i = 0; i < cartes.length; i++) {
                System.out.println("Je pioche " + sabot.piocher());
            }

            // Tentative de piocher à nouveau dans un sabot vide
            sabot.piocher(); // Cela doit lever une exception NoSuchElementException

        } catch (NoSuchElementException e) {
            System.out.println("Erreur : Le sabot est vide !");
        }
    }
}
