package cartes;

public abstract class Probleme extends Carte {
	private Type type;
	
	public Probleme(Type type) {
		super(type.name());
	}
	
	public Type getType() {
		return type;
	}

}
