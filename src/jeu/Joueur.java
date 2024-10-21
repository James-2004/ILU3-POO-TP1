package jeu;

import cartes.Carte;
import cartes.Borne;
import cartes.Attaque;
import cartes.Parade;
import jeu.Sabot;
import java.util.NoSuchElementException;

public class Joueur {
    private String nom;
    private ZoneDeJeu zoneDeJeu; // Zone de jeu du joueur
    private MainJoueur main; // Main du joueur (cartes)

    // Constructeur
    public Joueur(String nom) {
        this.nom = nom;
        this.zoneDeJeu = new ZoneDeJeu(); // Initialise la zone de jeu
        this.main = new MainJoueur(); // Initialise la main du joueur
    }

    // Getter pour le nom du joueur
    public String getNom() {
        return nom;
    }

    // Getter pour la zone de jeu du joueur
    public ZoneDeJeu getZoneDeJeu() {
        return zoneDeJeu;
    }

    // Getter pour la main du joueur
    public MainJoueur getMain() {
        return main;
    }

    // Méthode pour donner une carte au joueur (l'ajouter à sa main)
    public void donner(Carte carte) {
        main.prendre(carte); // Ajoute la carte à la main du joueur
    }

    // Méthode pour prendre une carte du sabot
    public Carte prendreCarte(Sabot sabot) {
        try {
            Carte carte = sabot.piocher(); // Pioche la première carte du sabot
            main.prendre(carte); // Ajoute la carte à la main du joueur
            return carte; // Retourne la carte piochée
        } catch (NoSuchElementException e) {
            return null; // Retourne null si le sabot est vide
        }
    }

    // Méthode pour déposer une carte dans la zone de jeu du joueur
    public void deposer(Carte c) {
        if (zoneDeJeu.estDepotAutorise(c)) { // Vérifie si la carte peut être déposée
            main.jouer(c); // Retirer la carte de la main du joueur
            zoneDeJeu.deposer(c); // Déposer la carte dans la zone de jeu
        } else {
            System.out.println("Dépôt non autorisé pour la carte : " + c);
        }
    }

    // Méthode pour vérifier si une carte peut être déposée
    public boolean estDepotAutorise(Carte carte) {
        return zoneDeJeu.estDepotAutorise(carte);
    }

    // Deux joueurs sont identiques s’ils ont le même nom
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Joueur)) return false;
        Joueur joueur = (Joueur) o;
        return nom.equals(joueur.nom);
    }

    // Méthode toString qui renvoie le nom du joueur
    @Override
    public String toString() {
        return nom;
    }
}
