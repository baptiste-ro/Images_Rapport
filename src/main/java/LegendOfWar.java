import java.io.IOException;
import java.util.Scanner;

public class LegendOfWar {

  static Map map = new Map();
  static Case caseActuel;

  static Game game;

  public static void main(String[] args) throws InterruptedException, IOException {

    game = new Game();

    System.out.print("\033[H\033[2J");
    System.out.flush();

    game.initGame();
    Keyboard.initKeyboard();

  }

  public static Game getGame() {
    return game;
  }

}