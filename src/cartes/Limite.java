package cartes;

public class Limite extends Carte {

    // Constructeur pour la classe Limite
    public Limite(String nom) {
        super(Type.LIMITE, nom); // On passe le type LIMITE et le nom de la carte
    }

    @Override
    public String toString() {
        return nom;
    }
}
