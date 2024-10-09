package jeu;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

import java.util.Arrays;
import java.util.List;

public class Jeu {
    private Sabot sabot; 

    // Constructeur
    public Jeu(JeuDeCartes jeuDeCartes) {
        // a. Récupérer le tableau de cartes de JeuDeCartes et le mélanger
        List<Carte> listeCartes = Arrays.asList(jeuDeCartes.getCartes()); 
        listeCartes = GestionCartes.melanger(listeCartes); 

        // b. Créer le sabot avec les cartes mélangées, transformées en tableau
        this.sabot = new Sabot(listeCartes.toArray(new Carte[0]));
    }

    // Méthode pour accéder au sabot
    public Sabot getSabot() {
        return sabot;
    }
}
