package jeu;

import java.util.Arrays;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	
	private Sabot<Carte> sabot;
	
	public Jeu() {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> liste = GestionCartes.melanger(Arrays.asList(jeu.donnerCartes()));
		
		Carte[] cartesArray = liste.toArray(jeu.donnerCartes());
		this.sabot = new Sabot<>(cartesArray);
	}
}
