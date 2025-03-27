

import java.io.Serializable;
import java.util.Random;

public class Mob extends Entity implements EntityInterface, Serializable {
    MobEnum type;
    CompetenceMob competence;

    public Mob(MobEnum type) {
        this.type = type;
        this.nom = type.toString();
        this.pv = type.getPV();
        this.atk = type.getATK();
        this.def = type.getDEF();
        this.competence = type.getCompetence();
    }

    public String toString(){
        return this.nom + "|pv: " + this.pv + "|atk: " + this.atk + "|def: " + this.def + "|";
    }

    public MobEnum getType() {
        return type;
    }

    public void setType(MobEnum type) {
        this.type = type;
    }

    public int getPv() {
        return this.pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getAtk() {
        return this.atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return this.def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public String getNom() {
        return this.nom;
    }

    public CompetenceMob getCompetenceMob() {
        return this.competence;
    }

    public boolean isBoss() {
        return type.isBoss();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Item dropMob(){
        Random random = new Random();
        double rdm = random.nextDouble();
        if (rdm > 0.8){
            return type.getLOOT1();
        } else if (rdm > 0.6){
            return type.getLOOT2();
        }
        return null;
    }
}
