package cartes;

public enum Type {
	FEU("feu", "Feu Rouge", "Feu Vert", "Vehicule Prioritaire"),
	ESSENCE("essence","Panne d'Essence", "Essence", "Canmion Citerne"), 
	CREVAISON("crevaison", "crevaison", "Roue De Secours", "Increvable"),
	ACCIDENT("accident", "Accident", "Reparations", "As Du Volent");
	
	private String type;
	private String attaque;
	private String contre;
	private String botte;
	
	private Type(String type, String attaque, String contre, String botte) {
		this.type = type;
		this.attaque = attaque;
		this.contre = contre;
		this.botte = botte;
	}
	
	public String getNom(String type) {
		return type;
		
	}

	public String getAttaque() {
		return attaque;
	}

	public String getContre() {
		return contre;
	}

	public String getBotte() {
		return botte;
	}
}
