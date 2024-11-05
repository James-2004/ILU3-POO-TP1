package cartes;

public interface Cartes {
	static Carte PRIORITAIRE = new Botte(Type.FEU);
	static Carte FEU_VERT = new Parade(Type.FEU);
	static Carte FEU_ROUGE = new Attaque(Type.FEU);
}
