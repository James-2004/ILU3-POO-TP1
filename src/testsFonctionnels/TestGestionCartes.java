package testsFonctionnels;

import cartes.*;
import utils.GestionCartes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGestionCartes {

    public static void main(String[] args) {
        // Création d'une liste de cartes pour les tests
        List<Carte> listeCartes = new ArrayList<>(Arrays.asList(
            new Borne("25KM"),
            new Borne("50KM"),
            new Borne("25KM"),
            new Parade("Feu Vert"),
            new Attaque("Feu Rouge")
        ));

        // a. Test de la méthode extraire
        System.out.println("Test de la méthode extraire");
        Carte carteExtraite = GestionCartes.extraire(listeCartes);
        System.out.println("Carte extraite : " + carteExtraite);
        System.out.println("Liste après extraction : " + listeCartes);

        // a. Test de la méthode extraireAvecIterator
        System.out.println("\nTest de la méthode extraireAvecIterator");
        carteExtraite = GestionCartes.extraireAvecIterator(listeCartes);
        System.out.println("Carte extraite avec iterator : " + carteExtraite);
        System.out.println("Liste après extraction avec iterator : " + listeCartes);

        // b. Test de la méthode melanger
        List<Carte> listeMelangee = GestionCartes.melanger(new ArrayList<>(listeCartes));
        System.out.println("\nTest de la méthode melanger");
        System.out.println("Liste mélangée : " + listeMelangee);

        // c. Test de la méthode verifierMelange
        boolean estCorrectementMelangee = GestionCartes.verifierMelange(listeCartes, listeMelangee);
        System.out.println("\nTest de la méthode verifierMelange");
        System.out.println("La liste est correctement mélangée ? " + estCorrectementMelangee);

        // d. Test de la méthode rassembler
        List<Carte> listeRassemblee = GestionCartes.rassembler(listeCartes);
        System.out.println("\nTest de la méthode rassembler");
        System.out.println("Liste rassemblée : " + listeRassemblee);

        // e. Test de la méthode verifierRassemblement
        boolean estCorrectementRassemblee = GestionCartes.verifierRassemblement(listeRassemblee);
        System.out.println("\nTest de la méthode verifierRassemblement");
        System.out.println("La liste est correctement rassemblée ? " + estCorrectementRassemblee);
    }
}
