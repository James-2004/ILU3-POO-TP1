package testsFonctionnels;

import cartes.*;

public class TestMethodeEquals {

    public static void main(String[] args) {
        // a. Tester deux objets de la carte Borne 25KM
        Carte carte1 = new Borne("25KM");
        Carte carte2 = new Borne("25KM");
        System.out.println("Deux cartes de 25KM sont identiques ? " + carte1.equals(carte2));

        // b. Tester deux objets de la carte Feu Rouge
        Carte carte3 = new Attaque("Feu Rouge");
        Carte carte4 = new Attaque("Feu Rouge");
        System.out.println("Deux cartes de Feu Rouge sont identiques ? " + carte3.equals(carte4));

        // c. Tester une carte Feu Rouge et une carte Feu Vert
        Carte carte5 = new Attaque("Feu Rouge");
        Carte carte6 = new Parade("Feu Vert");
        System.out.println("La carte Feu Rouge et la carte Feu Vert sont identiques ? " + carte5.equals(carte6));
    }
}
