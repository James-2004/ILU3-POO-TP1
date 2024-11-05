package jeu;

import cartes.Carte;

public class Joueur {
	private String name;
	private ZoneDeJeu zone;
	private MainJoueur main;
	
	public Joueur(String name, ZoneDeJeu zone) {
		this.name = name;
		this.zone = zone;
		this.main = new MainJoueur();
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public String getName() {
		return this.name;
	}

	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot<Carte> sabot) {
		if (sabot.estVide()) {
			return null;
		}
		Carte carte = sabot.piocher();
		this.donner(carte);
		return carte;
	}	
	
	public int donnerKmParcourus() {
		return this.zone.donnerKmParcourus();
	}
	
	@Override
	public boolean equals(Object autreJoueur) {
		if (autreJoueur instanceof Joueur joueur) {
			return this.name.equals(joueur.getName());
		}
		return false;
	}
}
