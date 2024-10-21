package jeu;

import cartes.Borne;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Attaque;
import cartes.Parade;
import java.util.ArrayList;
import java.util.List;

public class ZoneDeJeu {

    private List<Carte> limites;  // Liste des cartes de limites
    private List<Carte> bataille; // Liste des cartes de bataille
    private List<Carte> bornes;   // Liste des cartes de bornes

    // Constructeur
    public ZoneDeJeu() {
        this.limites = new ArrayList<>();
        this.bataille = new ArrayList<>();
        this.bornes = new ArrayList<>();
    }

    // Méthode pour donner la limitation de vitesse en cours
    public int donnerLimitationVitesse() {
        if (limites.isEmpty()) {
            return 200; // Si la pile est vide, la limitation est de 200
        }
        Carte derniereCarte = limites.get(limites.size() - 1);
        if (derniereCarte instanceof FinLimite) {
            return 200; // Si la dernière carte est une FinLimite, la limite est 200
        }
        return 50; // Sinon, la limitation reste à 50
    }

    // Méthode pour calculer le nombre total de km parcourus
    public int donnerKmParcourus() {
        int totalKm = 0;
        for (Carte carte : bornes) {
            if (carte instanceof Borne) {
                // Parse le nom de la borne pour extraire la distance en km
                String nom = carte.getNom();
                int km = Integer.parseInt(nom.replace("KM", ""));
                totalKm += km;
            }
        }
        return totalKm;
    }

    // Méthode pour vérifier si une borne peut avancer (pile de bataille non vide et sommet est feu vert)
    public boolean peutAvancer() {
        if (!bataille.isEmpty()) {
            Carte sommet = bataille.get(bataille.size() - 1); // Vérifie la carte au sommet de la pile
            if (sommet.getNom().equals("Feu Vert")) {
                return true; // On peut avancer si le sommet est Feu Vert
            }
        }
        return false; // Ne peut pas avancer si la pile est vide ou si le sommet n'est pas Feu Vert
    }

    // Méthode pour vérifier si un Feu Vert peut être déposé
    public boolean estDepotFeuVertAutorise() {
        if (bataille.isEmpty()) {
            return true; // Si la pile est vide, le Feu Vert peut être déposé
        }
        Carte sommet = bataille.get(bataille.size() - 1); // Vérifie la carte au sommet
        if (sommet instanceof Attaque && sommet.getNom().equals("Feu Rouge")) {
            return true; // Si la carte au sommet est une attaque Feu Rouge, le Feu Vert peut être déposé
        }
        if (sommet instanceof Parade && !sommet.getNom().equals("Feu Vert")) {
            return true; // Si la carte au sommet est une parade autre que Feu Vert, on peut déposer Feu Vert
        }
        return false; // Sinon, le dépôt n'est pas autorisé
    }

    // 3. Méthode pour vérifier si une borne peut être déposée
    public boolean estDepotBorneAutorise() {
        // Vérifier si la pile de bataille est vide ou si le sommet est un feu vert
        if (peutAvancer()) {
            // Vérifier que la borne ne dépasse pas la vitesse limite
            int limiteVitesse = donnerLimitationVitesse();
            if (limiteVitesse < 1000) {
                return donnerKmParcourus() <= 1000; // La somme des bornes ne dépasse pas 1000
            }
        }
        return false; // Sinon, le dépôt n'est pas autorisé
    }

    // 4. Méthode pour vérifier si une limite peut être déposée
    public boolean estDepotLimiteAutorise(Limite limite) {
        if (limite instanceof FinLimite) {
            // Si la carte est une FinLimite, la pile des limites doit contenir un début de limite
            if (!limites.isEmpty() && limites.get(limites.size() - 1) instanceof Limite) {
                return true;
            }
        } else {
            // Si la carte est un début de limite, la pile doit être vide ou finir par une fin de limite
            return limites.isEmpty() || limites.get(limites.size() - 1) instanceof FinLimite;
        }
        return false;
    }

    // 5. Méthode pour vérifier si une attaque ou parade peut être déposée
    public boolean estDepotBatailleAutorise(Carte batailleCarte) {
        if (batailleCarte instanceof Attaque) {
            // Si c'est une attaque, on peut la déposer si on n'est pas bloqué
            return bataille.isEmpty() || !bataille.get(bataille.size() - 1).getNom().equals("Feu Vert");
        } else if (batailleCarte instanceof Parade) {
            // Si c'est une parade, on peut la déposer selon les règles
            Carte sommet = bataille.isEmpty() ? null : bataille.get(bataille.size() - 1);
            if (bataille.isEmpty() || sommet.getNom().equals("Feu Rouge")) {
                return true; // Si la pile est vide ou si c'est un feu rouge
            }
            if (sommet instanceof Parade && sommet.getNom().equals("Feu Vert")) {
                return true; // Si le sommet est Feu Vert
            }
        }
        return false;
    }

    // Méthode pour vérifier si une carte peut être déposée
    public boolean estDepotAutorise(Carte carte) {
        if (carte instanceof Borne) {
            return estDepotBorneAutorise();
        } else if (carte instanceof Limite) {
            return estDepotLimiteAutorise((Limite) carte);
        } else if (carte instanceof Attaque || carte instanceof Parade) {
            return estDepotBatailleAutorise(carte);
        }
        return false;
    }

    // Méthode pour déposer une carte dans la bonne pile
    public void deposer(Carte c) {
        if (c instanceof Borne) {
            bornes.add(c); // Ajoute aux bornes
        } else if (c instanceof Limite) {
            limites.add(c); // Ajoute aux limites si ce n'est pas une borne
        } else {
            bataille.add(c); // Ajoute aux batailles si c'est une attaque ou parade
        }
    }

    // Méthode pour accéder aux cartes de bataille (pour les tests, par exemple)
    public List<Carte> getBataille() {
        return bataille;
    }

    // Méthode pour accéder aux cartes de bornes (pour les tests, par exemple)
    public List<Carte> getBornes() {
        return bornes;
    }

    // Méthode pour accéder aux cartes de limites (pour les tests, par exemple)
    public List<Carte> getLimites() {
        return limites;
    }
}
