package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

public class ControlEmmenagerTest {
    private ControlEmmenager controlEmmenager;

    @BeforeEach
    public void initialiserSituation() {
        Village village    = new Village("Le village des irréductibles", 10, 5);
        
        Chef abraracourcix = new Chef("Abraracourcix", 10, village);
        Gaulois asterix    = new Gaulois("Asterix", 6);
        Gaulois obelix     = new Gaulois("Obelix", 12);

        village.ajouterHabitant(asterix);
        village.ajouterHabitant(obelix);
        village.setChef(abraracourcix);

        village.installerVendeur(obelix, "fleurs", 10);
        village.installerVendeur(asterix, "poisson", 5);

        controlEmmenager = new ControlEmmenager(village);
    }

    @Test
    public void testIsHabitant() {
        assertTrue(controlEmmenager.isHabitant("Abraracourcix"));
        assertTrue(controlEmmenager.isHabitant("Asterix"));
        assertTrue(controlEmmenager.isHabitant("Obelix"));
        assertFalse(controlEmmenager.isHabitant("Panoramix"));
    }

    @Test
    public void testAjouterDruide() {
        controlEmmenager.ajouterDruide("Panoramix", 8, 2, 5);
        assertTrue(controlEmmenager.isHabitant("Panoramix"));
    }

    @Test
    public void testAjouterGaulois() {
        controlEmmenager.ajouterGaulois("Panoramix", 8);
        assertTrue(controlEmmenager.isHabitant("Panoramix"));
    }
}
