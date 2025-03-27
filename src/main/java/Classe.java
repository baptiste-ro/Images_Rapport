
public enum Classe {
    ASSASSIN(100, 40, 15, 40, "l'assassin", 0.5, 1.5),
    BARBARE(200, 70, 30, 20, "le barbare", 0.1, 1.5),
    MAGE(150, 110, 10, 20, "le grand mage", 0, 1.5);

    public int pv;
    public int atk;
    public int def;
    public int esquive;
    public String nom;
    public double critRate;
    public double critDamage;

    Classe(int pv, int atk, int def, int esquive, String nom, double critRate, double critDamage) {
        this.pv = pv;
        this.atk = atk;
        this.def = def;
        this.esquive = esquive;
        this.nom = nom;
        this.critRate = critRate;
        this.critDamage = critDamage;
    }

    public int getPv() {
        return pv;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getEsquive() {
        return this.esquive;
    }

    public String getNom() {
        return nom;
    }

    public double getCritRate() {
        return this.critRate;
    }

    public double getCritDamage() {
        return this.critDamage;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setEsquive(int esquive) {
        this.esquive = esquive;
    }

    public void setCritRate(double critRate) {
        this.critRate = critRate;
    }

    public void setCritDamage(double critDamage) {
        this.critDamage = critDamage;
    }

}
