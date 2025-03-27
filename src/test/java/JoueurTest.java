import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JoueurTest {

    private Joueur j1;
    private Joueur j2;
    private Joueur j3;

    @BeforeEach
    public void init() {
        j1 = new Joueur();
        j2 = new Joueur("Maxime", 99, 989, 990, null, new Case(Monde.MONDE_0, 0));
        j3 = new Joueur();
        j1.setCategorie(Classe.ASSASSIN);
        j2.setCategorie(Classe.BARBARE);
        j3.setCategorie(Classe.MAGE);
    }

    @Test
    void testXpLow() {
        j3.addXp(10);
        assertEquals(2, j3.getLevel());

        j3.addXp(999999);
        assertEquals(3, j3.getLevel());

        assertEquals(3, j3.getLevel());
        assertEquals(0, j3.getXp());
    }

    @Test
    void textXpHigh() {
        assertEquals(1, j1.getLevel());
        j2.setXp(2);
        assertEquals(2, j2.getXp());
        assertEquals(990, j2.getXpmax());
        j3.addXp(1);

    }

    @Test
    void testClasseStats() {

        assertEquals(j1.getCategorie().getPv(), j1.getPv());
        j1.setPv(75);
        assertEquals(75, j1.getPv());
        assertEquals(j2.getCategorie().getAtk(), j2.getAtk());
        j2.setAtk(3);
        assertEquals(3, j2.getAtk());
        assertEquals(j3.getCategorie().getDef() + 10, j3.getDef());
        j3.setDef(0);
        assertEquals(0, j3.getDef());
        assertEquals(Classe.MAGE, j3.getCategorie());
        assertNull(j3.getInventory());
    }
}
