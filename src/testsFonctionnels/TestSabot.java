package testsFonctionnels;

import cartes.*;
import jeu.Sabot;
import java.util.Iterator;
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

        try {
            // Étape a : Pioche une carte avant d'entrer dans la boucle
            Carte carte = sabot.piocher();
            System.out.println("Je pioche " + carte);

            // Étape b : Utilisation de l'itérateur et remove pour piocher et supprimer les cartes
            Iterator<Carte> it = sabot.iterator();
            int iteration = 0; // Compteur d'itérations pour ajouter AsDuVolant après 2 piocheurs
            while (it.hasNext()) {
                carte = it.next();
                System.out.println("Je pioche " + carte);
                it.remove(); // Supprime la carte après l'avoir piochée

                // Étape c : Tentative d'ajouter une carte dans la boucle pour provoquer une exception
                if (iteration == 2) { // On insère AsDuVolant à la 3e itération
                    sabot.ajouterCarte(new Botte("AsDuVolant"));
                    System.out.println("Ajout de la carte AsDuVolant dans la boucle.");
                }
                iteration++;
            }

        } catch (IllegalStateException e) {
            System.out.println("Erreur : Capacité maximale du sabot atteinte.");
        } catch (NoSuchElementException e) {
            System.out.println("Le sabot est vide !");
        }

        // Tentative de piocher après que le sabot soit vide, ce qui devrait lever une exception
        try {
            Carte carte = sabot.piocher(); // Ce piocheur doit lever une exception
            System.out.println("Je pioche " + carte);
        } catch (NoSuchElementException e) {
            System.out.println("Erreur : Le sabot est vide !");
        }
    }
}
