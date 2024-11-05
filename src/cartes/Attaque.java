package cartes;

public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return this.type.getAttaque();
	}
	
	@Override
	public boolean equals(Carte carte) {
		if(carte instanceof Attaque att) {
			return type.equals(att.getType());
		}
		return false;
	}
}