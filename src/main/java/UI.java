
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UI {

    public static boolean attack;
    public static int capa = 0;
    public static List<String> logs = new ArrayList<>();

    public Classe categorie;

    public static void update() {

        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }

        switch (LegendOfWar.getGame().getState()) {

            case MENU:
                List<String> menuLine = readFile("res/titre");

                for (int i = 0; i < menuLine.size(); i++)
                    System.out.println(menuLine.get(i));

                break;

            case PLAYING:

                List<String> overlayLines = readFile("res/overlay.txt");
                List<String> menuLinesA = readFile("res/overlay_bottomrightA.txt");
                List<String> menuLinesC = readFile("res/overlay_bottomrightC.txt");
                showPlayer(overlayLines);
                if (LegendOfWar.getGame().getMob() != null) {
                    showMob(overlayLines);
                }
                setStats(overlayLines);
                showLogs(overlayLines);
                if (capa != 0) {
                    showCapa(menuLinesC);
                }
                for (int i = 0; i < overlayLines.size(); i++) {
                    if (i > 22) {
                        System.out.println(
                                overlayLines.get(i) + (attack ? menuLinesA.get(i - 22) : menuLinesC.get(i - 22)));
                    } else {
                        System.out.println(overlayLines.get(i));
                    }
                }
                break;

            case CLASSE:
                showClasse();
                break;

            case GAME_OVER:
                List<String> menuGameOver = readFile("res/GameOver");

                for (int i = 0; i < menuGameOver.size(); i++)
                    System.out.println(menuGameOver.get(i));

                break;

            case END:
                List<String> menuEnd = readFile("res/EcranFin");

                for (int i = 0; i < menuEnd.size(); i++)
                    System.out.println(menuEnd.get(i));

                break;
            default:
                break;
        }

    }

    public static void addLogs(String str) {
        logs.add(str);
        if (logs.size() > 22) {
            logs.remove(0);
        }
    }

    private static void showLogs(List<String> list) {

        if (logs.size() == 0)
            return;

        for (int i = 0; i < logs.size(); i++) {
            String line = list.get(i);
            list.remove(i);
            line = line.substring(0, 120) + logs.get(i);
            list.add(i, line);

        }

    }

    private static void showClasse() {

        List<String> textLines = readFile("res/classchoice.txt");
        List<String> classeLines = readFile("res/classe.txt");
        List<String> arrowLines = readFile("res/arrow.txt");

        for (int i = 0; i < textLines.size(); i++)
            System.out.println(textLines.get(i));

        for (int i = 0; i < classeLines.size(); i++)
            System.out.println(classeLines.get(i));

        switch (LegendOfWar.getGame().getJoueur().getCategorie()) {
            case ASSASSIN:
                String blank = "";
                for (int i = 0; i < 12; i++)
                    blank += " ";
                for (int i = 0; i < arrowLines.size(); i++)
                    System.out.println(blank + arrowLines.get(i));
                break;
            case BARBARE:
                blank = "";
                for (int i = 0; i < 77; i++)
                    blank += " ";
                for (int i = 0; i < arrowLines.size(); i++)
                    System.out.println(blank + arrowLines.get(i));

                break;
            case MAGE:
                blank = "";
                for (int i = 0; i < 137; i++)
                    blank += " ";
                for (int i = 0; i < arrowLines.size(); i++)
                    System.out.println(blank + arrowLines.get(i));
                break;
            default:
                break;
        }

    }

    private static void showMob(List<String> list) {

        List<String> listmage = readFile("res/ascii/" + LegendOfWar.getGame().getMob().getNom());
        for (int i = 2; i < listmage.size() + 2; i++) {
            String line = list.get(i);
            list.remove(i);
            line = line.substring(0, 50) + listmage.get(i - 2) + line.substring(50 + listmage.get(i - 2).length());
            list.add(i, line);
        }
    }

    private static void showCapa(List<String> list) {

        for (int i = 10; i < 19; i++) {
            String line = list.remove(i);
            list.add(i, line.substring(0, 15));
        }

        String line = list.remove(13);
        line = "       " + LegendOfWar.getGame().getJoueur().getCompetences().get(0);
        line += "       " + LegendOfWar.getGame().getJoueur().getCompetences().get(1);
        line += "       " + LegendOfWar.getGame().getJoueur().getCompetences().get(2);

        String underline = list.remove(14);
        int lenght = LegendOfWar.getGame().getJoueur().getCompetences().get(capa - 1).toString().length();
        switch (capa) {
            case 1:
                underline = " ".repeat(7) + ("_".repeat(lenght));
                break;
            case 2:
                underline = " "
                        .repeat(LegendOfWar.getGame().getJoueur().getCompetences().get(0).toString().length() + 14)
                        + ("_".repeat(lenght));
                break;
            case 3:
                underline = " "
                        .repeat(LegendOfWar.getGame().getJoueur().getCompetences().get(0).toString().length()
                                + LegendOfWar.getGame().getJoueur().getCompetences().get(1).toString().length() + 21)
                        + ("_".repeat(lenght));
                break;

            default:
                break;
        }

        list.add(14, underline);
        list.add(13, line);

    }

    private static void showPlayer(List<String> list) {
        List<String> listmage = readFile("res/ascii/" + LegendOfWar.getGame().getJoueur().getCategorie().toString());
        for (int i = 2; i < listmage.size() + 2; i++) {
            String line = list.get(i);
            list.remove(i);
            line = "█ " + listmage.get(i - 2) + line.substring(listmage.get(i - 2).length() + 2);
            list.add(i, line);
        }
    }

    public static String getXPBar(int level, int xp) {
        StringBuilder sb = new StringBuilder();
        int xpLevel = 10;
        for (int i = 0; i < level; i++) {
            xpLevel *= 1.5;
        }
        sb.append(xp + " [");
        int tailleBarre = (int) (((double) xp / xpLevel) * 10);
        for (int i = 0; i < tailleBarre; i++) {
            sb.append("■");
        }
        for (int i = 0; i < 10 - tailleBarre; i++) {
            sb.append(" ");
        }
        sb.append("] " + xpLevel + " (Lvl " + level + ")");
        return sb.toString();
    }

    private static void setStats(List<String> list) {

        Joueur joueur = LegendOfWar.getGame().getJoueur();
        joueur.setCompetences(joueur.getCategorie());
        String line34 = list.get(34);
        list.remove(34);
        line34 = "█   " + joueur.getCategorie().getNom()
                + line34.substring(4 + String.valueOf(joueur.getCategorie().getNom()).length());
        list.add(34, line34);

        String line35 = list.get(35);
        list.remove(35);
        line35 = "█   ❤ : " + joueur.getPv() + line35.substring(8 + String.valueOf(joueur.getPv()).length());
        list.add(35, line35);

        String line36 = list.get(36);
        list.remove(36);
        line36 = "█   ⚔ : " + joueur.getAtk() + line36.substring(8 + String.valueOf(joueur.getAtk()).length());
        list.add(36, line36);

        String line37 = list.get(37);
        list.remove(37);
        line37 = "█   ⛨ : " + joueur.getDef() + line37.substring(8 + String.valueOf(joueur.getDef()).length());
        list.add(37, line37);

        String line38 = list.get(38);
        list.remove(38);
        String xpBar = UI.getXPBar(joueur.getLevel(), joueur.getXp());

        String blank = "█";
        for (int x = 0; x < 35; x++) {
            blank += " ";
        }
        line38 = (blank + xpBar + line38.substring(36 + xpBar.length()));
        list.add(38, line38);

        Mob mob = LegendOfWar.getGame().getMob();

        String line34b = list.get(34);
        list.remove(34);
        String nomMob = "";

        if (mob.isBoss()) {
            nomMob = "\u001B[31m" + mob.getNom() + "\u001B[0m";
        } else {
            nomMob = mob.getNom();
        }
        line34b = line34b.substring(0, 90) + nomMob
                + line34b.substring(90 + String.valueOf(mob.getNom()).length());
        list.add(34, line34b);

        String line35b = list.get(35);
        list.remove(35);
        line35b = line35b.substring(0, 90) + "❤ : " + mob.getPv()
                + line35b.substring(94 + String.valueOf(mob.getPv()).length());
        list.add(35, line35b);

        String line36b = list.get(36);
        list.remove(36);
        line36b = line36b.substring(0, 90) + "⚔ : " + mob.getAtk()
                + line36b.substring(94 + String.valueOf(mob.getAtk()).length());
        list.add(36, line36b);

        String line37b = list.get(37);
        list.remove(37);
        line37b = line37b.substring(0, 90) + "⛨ : " + mob.getDef()
                + line37b.substring(94 + String.valueOf(mob.getDef()).length());
        list.add(37, line37b);

    }

    public static List<String> readFile(String path) {

        List<String> lines = new ArrayList<>();

        try (FileReader fr = new FileReader(path)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Le fichier est introuvable");
        } catch (Exception e) {
            System.out.println("Unknown exception");
        }

        return lines;
    }
}