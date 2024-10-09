package jeu;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

import java.util.Arrays;
import java.util.List;

public class Jeu {
    private Sabot sabot; // Attribut de type Sabot

    // Constructeur
    public Jeu(JeuDeCartes jeuDeCartes) {
        // a. Récupérer le tableau de cartes de JeuDeCartes et le mélanger
        List<Carte> listeCartes = Arrays.asList(jeuDeCartes.getCartes()); // Transformation en liste
        listeCartes = GestionCartes.melanger(listeCartes); // Appel à la méthode melanger sans accent

        // b. Créer le sabot avec les cartes mélangées, transformées en tableau
        this.sabot = new Sabot(listeCartes.toArray(new Carte[0]));
    }

    // Méthode pour accéder au sabot
    public Sabot getSabot() {
        return sabot;
    }
}
