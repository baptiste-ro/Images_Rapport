
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Game {

    GameState state = GameState.MENU;

    Map map;
    Case caseActuel;
    Joueur joueur;
    Mob mob;
    Turn turn;
    boolean cheatCodeImmortel = false;
    boolean cheatCodeOneShot = false;
    boolean resume = false;

    public Game() {
        this.joueur = new Joueur();
    }

    public void initGame() {

        for (int i = 0; i < 30; i++) {
            UI.addLogs("               ");
        }

        setState(GameState.MENU);
        UI.update();
        map = new Map();
        if (resume) {
            this.caseActuel = map.getCase(joueur.getPosition().getNumCase(), joueur.getPosition().getMonde());
        } else {
            this.caseActuel = map.getFirstCase();
        }
    }

    public void startGame() {
        setState(GameState.PLAYING);

        System.out.println("start");
        newMob();
    }

    public void leaveGame() {
        System.out.println("Fin de la partie.");
        System.exit(0);
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Mob getMob() {
        return mob;
    }

    public void newMob() {
        mob = this.caseActuel.mobEncountered();
        UI.update();
        turn = new Turn(joueur, mob);
    }

    public void attackPlayer() {

        int dmg = turn.damageSimpleAttaque(joueur, mob);

        UI.addLogs(joueur.getCategorie().getNom() + " inflige " + dmg + " dégats ");

        mob.setPv(mob.getPv() - dmg);
        if (mob.getPv() <= 0) { // MORT DU MOB

            UI.addLogs("");
            UI.addLogs(joueur.getCategorie().getNom() + " a tué " + mob.getNom() + " ☠");
            UI.addLogs("");
            Item item = mob.dropMob();
            if (item != null) {
                UI.addLogs(mob.getNom() + " drop " + item.name());
                UI.addLogs("");
                joueur.setAtk(joueur.getAtk() + item.getAtk());
                joueur.setDef(joueur.getDef() + item.getDef());
                joueur.setPv(joueur.getPv() + item.getPv());
                joueur.setDef(joueur.getAtk() + item.getCrit());
                joueur.setAtk(joueur.getAtk() + item.getEsq());
            }

            this.caseActuel = this.map.getRight(this.caseActuel);
            if (this.caseActuel == null) {
                this.setState(GameState.END);
                UI.update();
                System.exit(0);
            }
            if (!cheatCodeImmortel && !cheatCodeOneShot) {
                joueur.resetBuff();
            }
            joueur.addXp(mob.getType().getXP());
            newMob();

        } else {
            UI.update();
            this.attackMob();
        }
    }

    public void cheatAttackPlayer() {
        cheatCodeOneShot = true;
        joueur.setAtk(999999);
    }

    public void cheatCapacityPlayer() {
        cheatCodeImmortel = true;
        joueur.setDef(999999);
        joueur.setPv(999999);
    }

    public String propositions(ArrayList<Competence> li) {
        String retour = "[ ";
        for (int i = 0; i < li.size(); i++) {
            retour += Tools.cleanText(li.get(i).toString()) + " (" + (i + 1) + "), ";
        }
        return retour.substring(0, retour.length() - 2) + " ]";
    }

    public int ask() {
        Scanner scanner = new Scanner(System.in);
        int retour = 0;
        while (retour < 1 || retour > 3) {
            System.out.print("Entrez le numéro correspondant à la compétences que vous voulez utiliser : ");
            retour = scanner.nextInt();
        }
        scanner.close();
        return retour;
    }

    public void capacityPlayer(Competence competence) {
        Turn t = new Turn(joueur, mob);

        t.applyEffect(joueur, competence);
        UI.addLogs(joueur.getCategorie().getNom() + " utilise " + competence.toString());
        this.attackMob();
    }

    public void attackMob() {
        if (Math.random() < mob.getCompetenceMob().getProba()) {
            turn.applyMobCompetence(joueur, mob, mob.getCompetenceMob());
        } else {
            int degat = turn.damageSimpleAttaque(mob, joueur);
            UI.addLogs(this.mob.nom + " inflige " + degat + " dégats");
            joueur.setPv(joueur.getPv() - degat);
        }
        if (joueur.getPv() <= 0) {
            this.setState(GameState.GAME_OVER);
        }
    }

}
