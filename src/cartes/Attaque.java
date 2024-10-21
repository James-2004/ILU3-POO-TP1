package cartes;

public class Attaque extends Carte {
    // Constructeur pour les tests existants
    public Attaque(String nom) {
        super(Type.ATTAQUE, nom);
    }
    
    // Nouveau constructeur pour la partie 3
    public Attaque(Type type) {
        super(type, type.getDescription()); // Utilise la description du type
    }

    @Override
    public String toString() {
        return "Attaque: " + getNom();
    }
}