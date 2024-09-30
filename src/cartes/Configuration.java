package cartes;

public class Configuration {
    private Carte carte;
    private int nombreExemplaires;

    public Configuration(Carte carte, int nombreExemplaires) {
        this.carte = carte;
        this.nombreExemplaires = nombreExemplaires;
    }

    public Carte getCarte() {
        return carte;
    }

    public int getNombreExemplaires() {
        return nombreExemplaires;
    }
}
