package cartes;

public enum Type {
	FEU("Feu Rouge", "Feu Vert", "Vehicule Prioritaire"),
	ESSENCE("Panne d'essence", "Citerne d'essence", "Increvable"),
	CREVAISON("Crevaison", "Roue de secours", "Increvable"),
	ACCIDENT("Accident", "Reparation", "As du volant");
	
	private String attaque;
	private String parade;
	private String botte;
	
	Type(String attaque, String parade, String botte){
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	}
	
	public String getAttaque() {
		return attaque;
	}
	
	public String getParade() {
		return parade;
	}
	
	public String getBotte() {
		return botte;
	}
}
