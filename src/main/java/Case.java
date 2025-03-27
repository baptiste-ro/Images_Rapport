

import java.io.Serializable;
import java.util.ArrayList;

public class Case implements Serializable {
    private Monde monde;
    private int numCase;
    private ArrayList<Mob> mobs;


    public Case(Monde monde, int numCase) {
        this.monde = monde;
        this.numCase = numCase;
        this.mobs = new ArrayList<Mob>();
        for (MobEnum mob:MobEnum.values()) {
            if(mob.getMonde() == this.monde) {
                this.mobs.add(new Mob(mob));
            }
        }
    }

    public String toString(){
        return "Monde : " + this.monde + "   Niveau : " + this.numCase;
    }

    public void setMobs() {
        
    }

    public Monde getMonde() {
        return this.monde;
    }

    public int getNumCase() {
        return this.numCase;
    }

    public Mob mobEncountered() {
        if (this.numCase == this.monde.getNbCases()-1){
            /*if(this.monde == Monde.MONDE_4) {
                return this.mobs.get(0);
            } else {*/
                return this.mobs.get(2);
            //}
        }
        if(Math.random()<0.5) {
            return this.mobs.get(0);
        } else {
            return this.mobs.get(1);
        }
    }
}

