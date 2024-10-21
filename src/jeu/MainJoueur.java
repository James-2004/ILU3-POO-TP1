package jeu;

import cartes.Carte;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainJoueur implements Iterable<Carte> {
    private List<Carte> main; // Liste des cartes dans la main du joueur

    // Constructeur
    public MainJoueur() {
        this.main = new ArrayList<>();
    }

    // Méthode pour ajouter une carte à la main
    public void prendre(Carte carte) {
        main.add(carte);
    }

    // Méthode pour jouer une carte (la retirer de la main)
    public void jouer(Carte carte) {
        assert main.contains(carte) : "La carte doit être présente dans la main";
        main.remove(carte);
    }

    // Méthode toString pour afficher la main du joueur
    @Override
    public String toString() {
        return main.toString();
    }

    // Itérateur pour parcourir les cartes en main
    @Override
    public Iterator<Carte> iterator() {
        return main.iterator();
    }
}
