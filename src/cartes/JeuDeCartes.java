package cartes;

public class JeuDeCartes {
    private Configuration[] typesDeCartes;

//    public JeuDeCartes() {
        // Initialisation des cartes et de leurs configurations
//        typesDeCartes = new Configuration[] {
//            new Configuration(new Borne(25), 10),
//            new Configuration(new Borne(50), 10),
//            new Configuration(new Borne(75), 10),
//            new Configuration(new Borne(100), 12),
//            new Configuration(new Borne(200), 4),
//            new Configuration(new FeuVert(), 14),
//            new Configuration(new FeuRouge(), 5),
//            new Configuration(new Limite(), 4), // Ajoute des classes comme Limite
//            new Configuration(new Crevaison(), 3),
//            new Configuration(new PanneEssence(), 3),
//            new Configuration(new Reparation(), 6),
//            new Configuration(new AsDuVolant(), 1),
            // Ajoute toutes les autres cartes ici...
//        };
//    }

    public String affichageJeuDeCartes() {
        StringBuilder affichage = new StringBuilder("JEU :\n");
        for (Configuration config : typesDeCartes) {
            affichage.append(config.getNbExemplaires())
                     .append(" ")
                     .append(config.getCarte().toString())
                     .append("\n");
        }
        return affichage.toString();
    }
}