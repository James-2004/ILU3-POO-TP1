package cartes;

public class FinLimite extends Limite {

	public FinLimite() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Fin Limite Vitesse 50";
	}
	
	@Override
	public boolean equals(Carte c) {
		if(c instanceof FinLimite) return true;
		return false;
	}
}
