package cartes;

public class Borne extends Carte {
    public Borne(String nom) {
        super(Type.BORNE, nom); // Ici, tu passes un Type BORNE en plus du nom
    }

    @Override
    public String toString() {
        return nom;
    }
}

