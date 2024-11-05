package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import cartes.Carte;

public class MainJoueur implements Iterable<Carte> {
	private final List<Carte> main = new ArrayList<>();
	
	public void prendre(Carte carte) {
		main.add(carte);
	}
	
	public void jouer(Carte carte) {
		if (main.contains(carte)) {
			main.remove(carte);
		}
	}
	
	@Override
	public String toString() {
		return this.main.toString();
	}

	@Override
	public Iterator<Carte> iterator() {
		return this.main.iterator();	
	}
}
