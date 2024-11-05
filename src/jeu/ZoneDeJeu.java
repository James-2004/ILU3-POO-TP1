package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.Cartes;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;

public class ZoneDeJeu {

	private final List<Limite> pileLimite = new ArrayList<>();
	private final List<Bataille> pileBataille = new ArrayList<>();
	private final List<Borne> bornes = new ArrayList<>();
	
	public int donnerLimitationVitesse() {
		if (pileLimite.isEmpty() || pileLimite.get(0) instanceof FinLimite) {
			return 200;
		}
		return 50;
	}
	
	public int donnerKmParcourus() {
		int totalKm = 0;
		for (Borne borne : bornes) {
			totalKm += borne.getKm();
		}
		return totalKm;
	}
	
	public void deposer(Carte carte) {
		if (carte instanceof Bataille bataille) {
			pileBataille.add(0, bataille);
		} else if (carte instanceof Borne borne)  {
			bornes.add(0, borne);
		} else {
			pileLimite.add(0, (Limite) carte);
		}
	}
	
	public boolean peutAvancer() {
		return !pileBataille.isEmpty() && pileBataille.get(0).equals(Cartes.FEU_VERT);
	}
	
	private boolean estDepotFeuVertAutorise() {
		return pileBataille.isEmpty() || pileBataille.get(0).equals(Cartes.FEU_ROUGE) || pileBataille.get(0) instanceof Parade;
	}
	
	private boolean estDepotBorneAutorise(Borne borne) {
		return peutAvancer() && (borne.getKm() <= donnerLimitationVitesse()) && (donnerKmParcourus() + borne.getKm() <= 1000);
	}  
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		return limite instanceof DebutLimite ? pileLimite.isEmpty() || !pileLimite.get(0).equals(limite) : !pileLimite.get(0).equals(limite);
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if (bataille instanceof Attaque) {
			return peutAvancer();
		}
		if (bataille.equals(Cartes.FEU_VERT)) {
			return estDepotFeuVertAutorise() || (pileBataille instanceof Parade);
		}
		return !pileBataille.isEmpty() && (bataille.getType() == pileBataille.get(0).getType());
	}
	
	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Borne borne) {
			return estDepotBorneAutorise(borne);
		} else if (carte instanceof Bataille bataille) {
			return estDepotBatailleAutorise(bataille);
		} else if (carte instanceof Parade) {
			return estDepotFeuVertAutorise();
		} else {
			return estDepotLimiteAutorise((Limite) carte);
		}
	}
}
