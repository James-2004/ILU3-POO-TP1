package cartes;

public class JeuDeCartes {
	private static int nbConf = 19;
	
	private Configuration[] configurationCartes = new Configuration[nbConf];
	
	public JeuDeCartes() {
		insererCartes();
	}
	
	
	public int getNbConf() {
		return nbConf;
	}
	
	
	public String affichageJeuDeCartes() {
		StringBuilder afficheJeu = new StringBuilder();
		
		for(int i = 0; i < 19; i++) {
			afficheJeu.append(configurationCartes[i].getNbExemplaires() + " " + configurationCartes[i].getCarte() +
					"\n");
		}
		
		return afficheJeu.toString();
	}
	
	public Carte[] donnerCartes() {
		Carte[] pioche = new Carte[106];
		int nbCartes = 0;
		
		for (Configuration jeu : configurationCartes) {
			for (int i = 0; i < jeu.getNbExemplaires(); i++) {
				pioche[nbCartes] = jeu.getCarte();
				nbCartes ++;
			}
		}
		
		return pioche;
	}
	
	public void insererCartes() {
		configurationCartes[0] = new Configuration(new Borne(25), 10);
		configurationCartes[1] = new Configuration(new Borne(50), 10);
		configurationCartes[2] = new Configuration(new Borne(75), 10);
		configurationCartes[3] = new Configuration(new Borne(100), 12);
		configurationCartes[4] = new Configuration(new Borne(200), 4);
		
		configurationCartes[5] = new Configuration(new Parade(Type.FEU), 14);
		configurationCartes[6] = new Configuration(new FinLimite(), 6);
		configurationCartes[7] = new Configuration(new Parade(Type.ESSENCE), 6);
		configurationCartes[8] = new Configuration(new Parade(Type.CREVAISON), 6);
		configurationCartes[9] = new Configuration(new Parade(Type.ACCIDENT), 6);
		
		configurationCartes[10] = new Configuration(new Attaque(Type.FEU), 5);
		configurationCartes[11] = new Configuration(new DebutLimite(), 4);
		configurationCartes[12] = new Configuration(new Attaque(Type.ESSENCE), 3);
		configurationCartes[13] = new Configuration(new Attaque(Type.CREVAISON), 3);
		configurationCartes[14] = new Configuration(new Attaque(Type.ACCIDENT), 3);
		
		configurationCartes[15] = new Configuration(new Botte(Type.FEU), 1);
		configurationCartes[16] = new Configuration(new Botte(Type.ESSENCE), 1);
		configurationCartes[17] = new Configuration(new Botte(Type.CREVAISON), 1);
		configurationCartes[18] = new Configuration(new Botte(Type.ACCIDENT), 1);
	}

	private int count(Carte[] s, Configuration c) {
		int i = 0;
		for (Carte carte : s) {
			if(carte.equals(c.getCarte())) {
				i ++;
			}
		}
		
		return i;
	}
	
	public boolean checkCount() {
		Carte[] sabot = donnerCartes();
		int sum;
		
		for(Configuration c : configurationCartes) {
			sum = count(sabot, c);
			if (sum != c.getNbExemplaires()) {
				return false;
			}
		}
		return true;
	}
	
	// CLASSE INTERNE //
	private static class Configuration{
		private Carte carte;
		private int nbExemplaires;
		
		public Configuration(Carte carte, int exemplaires) {
			this.carte = carte;
			this.nbExemplaires = exemplaires;
		}

		public Carte getCarte() {
			return carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}
	}
}
