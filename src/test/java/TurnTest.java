
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TurnTest {
    private Joueur player = new Joueur();
    private Mob mob = new Mob(MobEnum.DRAGON);
    private Turn turn = new Turn(player, mob);

    @BeforeEach
    void before(){
        player.setCategorie(Classe.ASSASSIN);
    }

    @Test
    void testTurn() {
        player.getCategorie().setCritRate(0);
        assertEquals(26,turn.damageSimpleAttaque(player, mob));
        
    }
}
