package utils;

import cartes.Carte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GestionCartes {

    // a. Méthode extraire (version travaillant directement sur la liste)
    public static Carte extraire(List<Carte> liste) {
        if (liste.isEmpty()) {
            throw new IllegalArgumentException("La liste ne doit pas être vide.");
        }
        int index = (int) (Math.random() * liste.size());
        return liste.remove(index);
    }

    // a. Méthode extraire (version utilisant un ListIterator)
    public static Carte extraireAvecIterator(List<Carte> liste) {
        if (liste.isEmpty()) {
            throw new IllegalArgumentException("La liste ne doit pas être vide.");
        }
        int index = (int) (Math.random() * liste.size());
        ListIterator<Carte> iterator = liste.listIterator();
        Carte carteExtraite = null;
        for (int i = 0; i <= index; i++) {
            carteExtraite = iterator.next();
        }
        iterator.remove();
        return carteExtraite;
    }

    // b. Méthode mélanger
    public static List<Carte> melanger(List<Carte> liste) {
        List<Carte> copie = new ArrayList<>(liste);
        Collections.shuffle(copie);
        liste.clear(); // Vider la liste d'origine
        return copie; // Retourner la liste mélangée
    }

    // c. Méthode verifierMelange
    public static boolean verifierMelange(List<Carte> listeOriginale, List<Carte> listeMelangee) {
        if (listeOriginale.size() != listeMelangee.size()) {
            return false; // Les listes doivent avoir la même taille
        }
        for (Carte carte : listeOriginale) {
            int occurrencesOriginale = Collections.frequency(listeOriginale, carte);
            int occurrencesMelangee = Collections.frequency(listeMelangee, carte);
            if (occurrencesOriginale != occurrencesMelangee) {
                return false; // Le nombre d'occurrences doit être le même
            }
        }
        return true;
    }

    // d. Méthode rassembler
    public static List<Carte> rassembler(List<Carte> liste) {
        List<Carte> copie = new ArrayList<>(liste);
        copie.sort((c1, c2) -> c1.getNom().compareTo(c2.getNom()));
        return copie;
    }

    // e. Méthode verifierRassemblement
    public static boolean verifierRassemblement(List<Carte> liste) {
        if (liste.isEmpty()) {
            return true; // Une liste vide est considérée comme correctement rassemblée
        }

        ListIterator<Carte> it1 = liste.listIterator();
        Carte derniereCarte = it1.next();

        while (it1.hasNext()) {
            Carte carteActuelle = it1.next();
            if (!carteActuelle.getNom().equals(derniereCarte.getNom())) {
                // Vérifier s'il y a une autre occurrence de derniereCarte plus loin dans la liste
                ListIterator<Carte> it2 = liste.listIterator(it1.nextIndex());
                while (it2.hasNext()) {
                    if (it2.next().getNom().equals(derniereCarte.getNom())) {
                        return false; // Une autre occurrence est trouvée plus loin
                    }
                }
            }
            derniereCarte = carteActuelle;
        }
        return true;
    }
}
