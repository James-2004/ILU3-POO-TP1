package cartes;

public abstract class Carte {
    protected Type type;
    protected String nom;

    public Carte(Type type, String nom) {
        this.type = type;
        this.nom = nom;
    }

    public Type getType() {
        return type;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Carte autreCarte = (Carte) obj;
        return nom.equals(autreCarte.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }

    @Override
    public String toString() {
        return type + ": " + nom;
    }
}
