
public enum Competence {

    /*Explication de chaque stats :
    Healing : nombre de PV rendus/retirés.
    Armor : nombre de points d'armure ajoutés/retirés au lanceur.
    Boost : nombre de points d'attaque retirés/ajoutés au lanceur.
    */

    //Compétences du barbare.
    INTIMIDATION(0, 0, 30),
    SOINS_MINEURS(25, 0, 0),
    TOUT_OU_RIEN(0, -50, 150),

    //Compétences du mage.
    ARMURE_MAGIQUE(0, 35, 0),
    SOINS_MAJEURS(60, 10, 0),
    PLUIE_SANGUINE(-40, 400, 40),


    //Compétence de l'assassin.
    COUVERTURE_DE_SANG(0, 30, 0),
    VAMPIRISME(40, 20, 0),
    EXECUTION(0, -30, 0.3);

    private int healing;
    private int armor;
    private int boost;

    Competence(int healing, int armor, int boost) {
        this.healing = healing;
        this.armor = armor;
        this.boost = boost;
    }

    Competence(int boost, int armor, double execute_rate) {
        this.healing = 0;
        this.armor = armor;
        this.boost = boost;
        if (Math.random() < execute_rate) {
            this.boost = 9999;
        }
    }

    public int getHealing() {
        return this.healing;
    }

    public int getArmor() {
        return this.armor;
    }

    public int getBoost() {
        return this.boost;
    }
}