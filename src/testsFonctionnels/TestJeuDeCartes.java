package testsFonctionnels;

import cartes.*;
import java.util.HashMap;
import java.util.Map;

public class TestJeuDeCartes {

    public static void main(String[] args) {
        // Tests de la méthode equals
        // a. Tester deux objets de la carte Borne 25KM
        Carte carte1 = new Borne("25KM");
        Carte carte2 = new Borne("25KM");
        System.out.println("Deux cartes de 25KM sont identiques ? " + carte1.equals(carte2));

        // b. Tester deux objets de la carte Feu Rouge
        Carte carte3 = new Attaque("Feu Rouge");
        Carte carte4 = new Attaque("Feu Rouge");
        System.out.println("Deux cartes de Feu Rouge sont identiques ? " + carte3.equals(carte4));

        // c. Tester une carte Feu Rouge et une carte Feu Vert
        Carte carte5 = new Attaque("Feu Rouge");
        Carte carte6 = new Parade("Feu Vert");
        System.out.println("La carte Feu Rouge et la carte Feu Vert sont identiques ? " + carte5.equals(carte6));

        // Tests de la méthode checkCount
        System.out.println("\nTests de la méthode checkCount()");

        // Test 1 : Vérification avec une configuration correcte
        Carte[] cartes1 = {
            new Borne("25KM"),
            new Borne("50KM"),
            new Borne("25KM"),
            new Parade("Feu Vert"),
            new Attaque("Feu Rouge")
        };
        Map<String, Integer> configuration1 = new HashMap<>();
        configuration1.put("25KM", 2);
        configuration1.put("50KM", 1);
        configuration1.put("Feu Vert", 1);
        configuration1.put("Feu Rouge", 1);
        JeuDeCartes jeuDeCartes1 = new JeuDeCartes(cartes1, configuration1);
        System.out.println("Test 1 : Le nombre d'occurrences est correct ? " + jeuDeCartes1.checkCount());

        // Test 2 : Vérification avec une configuration incorrecte
        Carte[] cartes2 = {
            new Borne("25KM"),
            new Borne("50KM"),
            new Parade("Feu Vert"),
            new Attaque("Feu Rouge")
        };
        Map<String, Integer> configuration2 = new HashMap<>();
        configuration2.put("25KM", 2); // Mauvais nombre (il n'y a qu'une carte "25KM")
        configuration2.put("50KM", 1);
        configuration2.put("Feu Vert", 1);
        configuration2.put("Feu Rouge", 1);
        JeuDeCartes jeuDeCartes2 = new JeuDeCartes(cartes2, configuration2);
        System.out.println("Test 2 : Le nombre d'occurrences est correct ? " + jeuDeCartes2.checkCount());

        // Test 3 : Vérification avec une carte manquante dans la configuration
        Map<String, Integer> configuration3 = new HashMap<>();
        configuration3.put("25KM", 2);
        configuration3.put("50KM", 1);
        // "Feu Vert" n'est pas dans la configuration
        configuration3.put("Feu Rouge", 1);
        JeuDeCartes jeuDeCartes3 = new JeuDeCartes(cartes1, configuration3);
        System.out.println("Test 3 : Le nombre d'occurrences est correct ? " + jeuDeCartes3.checkCount());
    }
}
