import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



public class MobTest {
    private Mob mob1 = new Mob(MobEnum.SLIME);

    @Test
    void testMob() {
        assertEquals(MobEnum.SLIME.getATK(), mob1.getAtk());
        assertEquals(MobEnum.SLIME.getDEF(), mob1.getDef());
        assertEquals("SLIME", mob1.getNom());

        

    }
}
