package cartes;

public class Attaque extends Carte {

    public Attaque(String nom) {
        super(Type.ATTAQUE, nom);
    }

    @Override
    public String toString() {
        return "Attaque: " + nom;
    }
}