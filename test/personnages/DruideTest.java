package personnages;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DruideTest {
    private Druide druide;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void initialiserSituation() {
        druide = new Druide("Panoramix", 4, 3, 4);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testPreparerPotionEtBouster() {
        druide.preparerPotion();
        Gaulois gaulois = new Gaulois("Astérix", 10);
        druide.booster(gaulois);
        assertEquals("Gaulois [nom=Astérix, force=10, effetPotion=3]", gaulois.toString());
    }

    @Test
    void testBooster() {
        druide.preparerPotion();
        Gaulois gaulois = new Gaulois("Obélix", 10);
        druide.booster(gaulois);
        assertEquals("Gaulois [nom=Obélix, force=10, effetPotion=1]", gaulois.toString());
    }

    @Test
    void testBooster2() {
        String expected = "Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force ";
        druide.preparerPotion();
        assertEquals(expected, outContent.toString().substring(24, expected.length()+24));
    }

    @Test
    void testBooster3() {
        Druide druide2 = new Druide("Panoramix", 4, 8, 9);
        outContent.reset();
        String expected2 = "J'ai préparé une super potion de force ";
        druide2.preparerPotion();
        assertEquals(expected2, outContent.toString().substring(24, expected2.length()+24));
    }

    @Test
    void testPrendreParole() {
        assertEquals("Le druide Panoramix : ", druide.prendreParole());
    }

}
