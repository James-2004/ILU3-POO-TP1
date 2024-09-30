package cartes;

public class Botte extends Carte {

    public Botte(String nom) {
        super(Type.BOTTE, nom);
    }

    @Override
    public String toString() {
        return "Botte: " + nom;
    }
}

