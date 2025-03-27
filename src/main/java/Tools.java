
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Tools {
    public static String readFile(String path) throws Exception {
        File fichier = new File(path);
        Scanner sc = new Scanner(fichier);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append(sc.nextLine());
        }
        sc.close();
        return sb.toString();
    }

    public static void writeFile(String path, String content) throws Exception {
        FileWriter fw = new FileWriter(path);
        fw.write(content);
        fw.close();
    }

    public static void printEntity(MobEnum m) {
        try {
            System.out.println(Tools.readFile("res/ascii/" + m.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez votre pseudo : ");
        String name = sc.nextLine();
        sc.close();
        return name;
    }

    public static void savePlayer(Joueur j) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("res/save");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(j);
            System.out.println("Partie sauvegardée");
        } catch (IOException e) {
            System.out.println("Erreur : Impossible de sauvegarder la partie");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erreur non-determiné");
            e.printStackTrace();
        }
    }

    public static Joueur loadPlayer() throws IOException {

        try (FileInputStream fis = new FileInputStream("res/save");
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            Joueur j = (Joueur) ois.readObject();
            System.out.println("Partie chargée");
            return j;
        } catch (IOException e) {
            System.out.println("Erreur : Impossible de charger la partie");
        } catch (Exception e) {
            System.out.println("Erreur non-determiné");
        }
        return null;
    }

    public static void printLeaderboard() {
        try {
            System.out.println(Tools.readFile("res/data/leaderboard.csv"));
        } catch (Exception e) {
            System.out.println("Problème lors de l'affichage du classement");
        }
    }

    public static void writeLeaderboard(String name, int score) {
        try {
            String content = Tools.readFile("res/data/leaderboard.csv");
            content += name + "," + score + "\n";
            Tools.writeFile("res/data/leaderboard.csv", content);
        } catch (Exception e) {
            System.out.println("Problème lors de l'écriture du score dans le classement");
        }
    }

    public static String cleanText(String text) {
        String str = text.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
