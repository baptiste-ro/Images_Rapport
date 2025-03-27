import java.io.Serializable;

public class CompetenceMob implements Serializable {
    private String name;            //Nom de la compétence.
    private int damage;             //Nombre des dégâts infligés par la compétence.
    private int bonusAttack;        //Nombre de points d'attaque ajoutés au mob.
    private int dropAttack;         //Nombre de points d'attaque retirés au joueur.
    private int bonusArmor;         //Nombre de points d'armure ajoutés au mob.
    private int dropArmor;          //Nombre de points d'armure retirés au joueur.
    private int healing;            //Nombre de points de vie rendus au mob.
    private double proba;           //Probabilité que la compétence soit activée.

    public CompetenceMob(String name, int damage, int bonusAttack, int bonusArmor, int dropAttack, int dropArmor, int healing, double proba) {
        this.name = name;
        this.damage = damage;
        this.bonusAttack = bonusAttack;
        this.bonusArmor = bonusArmor;
        this.dropAttack = dropAttack;
        this.dropArmor = dropArmor;
        this.healing = healing;
        this.proba = proba;
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getBonusAttack() {
        return this.bonusAttack;
    }

    public int getBonusArmor() {
        return this.bonusArmor;
    }

    public int getDropAttack() {
        return this.dropAttack;
    }

    public int getDropArmor() {
        return this.dropArmor;
    }

    public int getHealing() {
        return this.healing;
    }

    public double getProba() {
        return this.proba;
    }
}