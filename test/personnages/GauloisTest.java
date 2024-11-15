package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GauloisTest {
    private Gaulois gaulois;

    @BeforeEach
    public void initialiserSituation() {
        gaulois = new Gaulois("Astérix", 10);
    }

    @Test
    void testPrendreParole() {
        assertEquals("Le gaulois Astérix : ", gaulois.prendreParole());
    }

    @Test
    void testToString() {
        assertEquals("Gaulois [nom=Astérix, force=10, effetPotion=1]", gaulois.toString());
    }

    @Test
    void testBoirePotion() {
        gaulois.boirePotion(5);
        assertEquals("Gaulois [nom=Astérix, force=10, effetPotion=5]", gaulois.toString());
    }

}
