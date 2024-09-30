package cartes;

public abstract class Carte {
    protected Type type;
    protected String nom;

    public Carte(Type type, String nom) {
        this.type = type;
        this.nom = nom;
    }

    public abstract String toString();
}


