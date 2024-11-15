package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonnageTest {
    private Personnage personnage;

    @BeforeEach
    public void initialiserSituation() {
        personnage = new Personnage("Astérix", 10);
    }

    @Test
    void testGetForce() {
        assertEquals(10, personnage.getForce());
    }

    @Test
    void testGetNom() {
        assertEquals("Astérix", personnage.getNom());
    }

    @Test
    void testToString() {
        assertEquals("[nom=Astérix, force=10]", personnage.toString());
    }

    @Test
    void testParler() {
        personnage.parler("Bonjour !");
    }

    @Test
    void testPrendreParole() {
        assertEquals("Astérix : ", personnage.prendreParole());
    }

}
