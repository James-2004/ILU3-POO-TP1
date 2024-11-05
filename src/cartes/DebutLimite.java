package cartes;

public class DebutLimite extends Limite {

	public DebutLimite() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Limite Vitesse 50";
	}
	
	@Override
	public boolean equals(Carte carte) {
		if (carte instanceof DebutLimite) return true;
		return false;
	}
}
