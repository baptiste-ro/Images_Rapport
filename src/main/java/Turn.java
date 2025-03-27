public class Turn {
    private Joueur player;
    private Mob mob;


    public Turn(Joueur player, Mob mob) {
        this.player = player;
        this.mob = mob;
    }

    public Joueur getJoueur() {
        return this.player;
    }

    public Mob getMob() {
        return this.mob;
    }

    public int damageSimpleAttaque(Joueur attaquant, Mob defenseur) {
        if(Math.random()<attaquant.getCategorie().getCritRate()) {
            return (int)(attaquant.getAtk()*attaquant.getCategorie().getCritDamage()*(1-((double)defenseur.getDef()/(defenseur.getDef()+100))));
        } else {
            return (int)(attaquant.getAtk()*(1-((double)defenseur.getDef()/(defenseur.getDef()+100))));
        }
    }

    public int damageSimpleAttaque(Mob attaquant, Joueur defenseur) {
        if(Math.random()<0.25) {
            return (int)(attaquant.getAtk()*1.5*(1-((double)defenseur.getDef()/(defenseur.getDef()+100))));
        } else {
            return (int)(attaquant.getAtk()*(1-((double)defenseur.getDef()/(defenseur.getDef()+100))));
        }
    }


    public int damageSimpleAttaque(EntityInterface attaquant, EntityInterface defenseur) {
        if(Math.random()<0.25) {
            return (int)(attaquant.getAtk()*1.5*((double)defenseur.getDef()/(defenseur.getDef()+100)));
        } else {
            return (int)(attaquant.getAtk()*((double)defenseur.getDef()/(defenseur.getDef()+100)));
        }
    }




    public void applyEffect(Joueur player, Competence c) {
        player.setPv(player.getPv()+c.getHealing());
        // System.out.println(c.getHealing());
        player.setDef(player.getDef()+c.getArmor());
        // System.out.println(c.getArmor());
        player.setAtk(player.getAtk()+c.getBoost());
        // System.out.println(c.getBoost());
    }

    public void applyMobCompetence(Joueur player, Mob mob, CompetenceMob c) {
        player.setPv(player.getPv()-c.getDamage());
        player.setDef(player.getDef()-c.getDropArmor());
        player.setAtk(player.getAtk()-c.getDropAttack());
        mob.setPv(mob.getPv()+c.getHealing());
        mob.setDef(mob.getDef()+c.getBonusArmor());
        mob.setAtk(mob.getAtk()+c.getBonusAttack());
        mobCapacityMessage(mob, c);
    }

    public void mobCapacityMessage(Mob mob, CompetenceMob c) {
        String message = mob.getNom() + " utilise la compétence : " + c.getName() + ".";
        String message2 = mob.getNom();
        if(c.getDamage()>0) {
            message2 += " inflige " + c.getDamage() + " dégâts,";
        }
        if(c.getBonusArmor()>0) {
            message2 += " augmente son armure de " + c.getBonusArmor() + " points,";
        }
        if(c.getBonusAttack()>0) {
            message2 += " augmente son attaque de " + c.getBonusAttack() + " points,";
        }
        if(c.getDropArmor()>0) {
            message2 += " baisse votre armure de " + c.getDropArmor() + " points,";
        }
        if(c.getDropAttack()>0) {
            message2 += " baisse votre attaque de " + c.getDropAttack() + " points,";
        }
        if(c.getHealing()>0) {
            message2 += " se soigne de " + c.getHealing() + " PV.";
        }
        message2 = message2.substring(0, message2.length()-1) + '.';
        UI.addLogs(message);
        UI.addLogs(message2);
    }
}