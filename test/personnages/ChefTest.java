package personnages;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

public class ChefTest {
    private Chef chef;
    private Village village;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void initialiserSituation() {
        village = new Village("Le village des irréductibles", 10, 5);
        chef = new Chef("Abraracourcix", 10, village);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testPrendreParole() {
        assertEquals("Le chef Abraracourcix du village Le village des irréductibles : ", chef.prendreParole());
    }

    @Test
    void testParler() {
        chef.parler("Bonjour");
        assertEquals("Le chef Abraracourcix du village Le village des irréductibles : « Bonjour»\n", outContent.toString());
    }
}
