package cartes;

public class Borne extends Carte {

	private int km;
	
	public Borne(int kms) {
		this.km = kms;
	}
	
	public int getKm() {
		return km;
	}

	@Override
	public String toString() {
		return km +" kms";
	}
	
	@Override
	public boolean equals(Carte carte) {
		if(carte instanceof Borne b) {
			return km == b.getKm();
		}
		
		return false;
	}

}
