package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
	}
	
	@Override
	public String toString() {
		return this.type.getContre();
	}
	
	@Override
	public boolean equals(Carte carte) {
		if(carte instanceof Parade par) {
			return type.equals(par.getType());
		}
		return false;
	}
}
