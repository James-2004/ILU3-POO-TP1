package jeu;

import cartes.Carte;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot implements Iterable<Carte> {
    private Carte[] cartes; // Tableau pour stocker les cartes
    private int nbCartes;   // Nombre actuel de cartes dans le sabot

    // Constructeur
    public Sabot(Carte[] cartes) {
        this.cartes = new Carte[cartes.length];
        System.arraycopy(cartes, 0, this.cartes, 0, cartes.length);
        this.nbCartes = cartes.length; // Initialement, toutes les cartes du jeu sont dans le sabot
    }

    // Vérifie si le sabot est vide
    public boolean estVide() {
        return nbCartes == 0;
    }

    // Ajoute une carte au sabot
    public void ajouterCarte(Carte carte) throws IllegalStateException {
        // Si le tableau de cartes est plein, lever IllegalStateException
        if (nbCartes >= cartes.length) {
            throw new IllegalStateException("Capacité maximale du sabot atteinte.");
        }
        cartes[nbCartes] = carte;
        nbCartes++; // Incrémente le nombre de cartes après ajout
    }

    // Piocher une carte du sabot
    public Carte piocher() throws NoSuchElementException {
        if (estVide()) {
            throw new NoSuchElementException("Le sabot est vide.");
        }
        Carte cartePiochée = cartes[0];
        System.arraycopy(cartes, 1, cartes, 0, nbCartes - 1); // Décale les cartes
        nbCartes--; // Réduit le nombre de cartes
        return cartePiochée;
    }

    @Override
    public Iterator<Carte> iterator() {
        return new Iterator<Carte>() {
            private int index = 0;
            private boolean modifiable = false;

            @Override
            public boolean hasNext() {
                return index < nbCartes;
            }

            @Override
            public Carte next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Le sabot est vide.");
                }
                modifiable = true;
                return cartes[index++];
            }

            @Override
            public void remove() {
                if (!modifiable) {
                    throw new IllegalStateException("Impossible de supprimer avant next().");
                }
                System.arraycopy(cartes, index, cartes, index - 1, nbCartes - index);
                nbCartes--;
                index--;
                modifiable = false;
            }
        };
    }
}
