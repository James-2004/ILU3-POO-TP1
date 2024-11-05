package cartes;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return this.type.getBotte();
	}

	
	@Override
	public boolean equals(Carte carte) {
		if (carte instanceof Botte b) {
			return type.equals(b.getType());
		}
		return false;
	}
	
}
