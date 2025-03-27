
public enum Drop {
    SLIME("Gelée Résistante", 3, 10, "Peau Slime", 2, 5),
    ORC("Bracelet Orc", 2, 10, "Anneau De Force", 1, 10),
    SLIMEGEANT("Essence De Force", 1, 20, "Couronne De Slime", 3, 10),
    SERPENT("Ecaille Mineur", 2, 10, "Poison Du Serpent", 5, 10),
    DIO("Anneau De Vitalité", 3, 20, "Cape De Vampire", 4, 20),
    KRAKEN("Fragment De Tentacule", 5, 15, "Force De Kraken", 1, 30),
    DRAGON("Griffe De Dragon", 1, 25, "Ecaille De Dragon", 2, 20),
    AMOGUS("Casque De Survie", 4, 10, "Gants D'Imposteur", 1, 20),
    SHREK("Chaussure De Shrek", 4, 10, "Epée de Shrek", 1, 40),
    DEMON("Gant Du Démon", 1, 40, "Corne Du Démon", 5, 10),
    SQUELETTE("Epée En Os", 1, 35, "Bouclier Du Squelette", 2, 50),
    FOURMI("Coeur De La Fourmi Reine", 3, 1000, "Oeuf De La Fourmi Reine", 2, 100);

    private final String item1;
    private final int stat1; // 1 = Atk, 2 = Def, 3 = PV, 4 = Esquive, 5 = Coup critique
    private final int bonus1;
    private final String item2; // 1 = Atk, 2 = Def, 3 = PV, 4 = Esquive, 5 = Coup critique
    private final int stat2;
    private final int bonus2;

    Drop(String item1, int stat1, int bonus1, String item2, int stat2, int bonus2) {
        this.item1 = item1;
        this.stat1 = stat1;
        this.bonus1 = bonus1;
        this.item2 = item2;
        this.stat2 = stat2;
        this.bonus2 = bonus2;
    }

    public String getItem1() {
        return item1;
    }

    public int getStat1() {
        return stat1;
    }

    public int getBonus1() {
        return bonus1;
    }

    public String getItem2() {
        return item2;
    }

    public int getStat2() {
        return stat2;
    }

    public int getBonus2() {
        return bonus2;
    }

}