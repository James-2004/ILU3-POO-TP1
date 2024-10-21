package cartes;

public class Parade extends Carte {
    // Constructeur pour les tests existants
    public Parade(String nom) {
        super(Type.PARADE, nom);
    }

    // Nouveau constructeur pour la partie 3
    public Parade(Type type) {
        super(type, type.getDescription());
    }

    @Override
    public String toString() {
        return "Parade: " + getNom();
    }
}