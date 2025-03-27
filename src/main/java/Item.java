
public enum Item implements EntityInterface {

    GeleeResistante(10, 0, 0, 0, 0),
    PeauSlime(0, 0, 5, 0, 0),
    BraceletOrc(0, 0, 10, 0, 0),
    AnneauDeForce(0, 10, 0, 0, 0),
    EssenceDeForce(0, 20, 0, 0, 0),
    CouronneDeSlime(20, 0, 0, 0, 0),
    EcailleMineur(0, 0, 10, 0, 0),
    PoisonDuSerpent(0, 0, 0, 0, 10),
    AnneauDeVitalite(20, 0, 0, 0, 0),
    ZaWarudo(0, 0, 0, 20, 0),
    FragmentDeTentacule(0, 0, 0, 0, 15),
    ForceDeKraken(0, 30, 0, 0, 0),
    GriffeDeDragon(0, 25, 0, 0, 0),
    EcailleDeDragon(0, 0, 20, 0, 0),
    CasqueDeSurvie(0, 0, 0, 10, 0),
    GantsImposteur(0, 20, 0, 0, 0),
    ChaussureDeShrek(0, 0, 0, 10, 0),
    MuscleDeShrek(0, 40, 0, 0, 0),
    GantDuDemon(0, 40, 0, 0, 0),
    CorneDuDemon(0, 0, 0, 0, 10),
    EpeeEnOs(0, 35, 0, 0, 0),
    BouclierDuSquelette(0, 0, 50, 0, 0),
    L(1, 1, 1, 1, 1),
    D(1, 1, 1, 1, 1);

    int PV;
    int ATK;
    int DEF;
    int ESQ;
    int CRIT;
    String name;

    Item(int PV, int ATK, int DEF, int ESQ, int CRIT) {
        this.PV = PV;
        this.ATK = ATK;
        this.DEF = DEF;
        this.ESQ = ESQ;
        this.CRIT = CRIT;
    }

    @Override
    public int getPv() {
        return this.PV;
    }

    @Override
    public void setPv(int pv) {
        this.PV = pv;
    }

    @Override
    public int getAtk() {
        return this.ATK;
    }

    @Override
    public void setAtk(int atk) {
        this.ATK = atk;
    }

    @Override
    public int getDef() {
        return this.DEF;
    }

    @Override
    public void setDef(int def) {
        this.DEF = def;
    }

    @Override
    public String getNom() {
        return this.name;
    }

    @Override
    public void setNom(String nom) {
        this.name = nom;
    }

    public int getEsq() {
        return this.ESQ;
    }

    public void setEsq(int ESQ) {
        this.ESQ = ESQ;
    }

    public int getCrit() {
        return this.CRIT;
    }

    public void setCrit(int CRIT) {
        this.CRIT = CRIT;
    }

}
