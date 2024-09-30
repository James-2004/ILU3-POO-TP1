package cartes;

public class Parade extends Carte {

    public Parade(String nom) {
        super(Type.PARADE, nom);
    }

    @Override
    public String toString() {
        return "Parade: " + nom;
    }
}
