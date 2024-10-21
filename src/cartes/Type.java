package cartes;

public enum Type {
    ATTAQUE("Attaque"),
    PARADE("Parade"),
    BOTTE("Botte"),
    BORNE("Borne"),
    LIMITE("Limite"),
    CREVAISON("Crevaison"),
    ESSENCE("Essence"),
    ACCIDENT("Accident");

    private String description;

    // Constructeur pour l'énumération Type
    Type(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
