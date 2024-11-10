package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

public class ControlVerifierIdentiteTest {
    private ControlVerifierIdentite controlVerifierIdentite;

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

        controlVerifierIdentite = new ControlVerifierIdentite(village);
    }

    @Test
    public void testVerifieIdentite() {
        assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"));
        assertTrue(controlVerifierIdentite.verifierIdentite("Obelix"));
        assertFalse(controlVerifierIdentite.verifierIdentite("Panoramix"));
    }

    @Test
    public void testVerifieIdentiteChef() {
        assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"));
    }

    @Test
    public void testVerifieIdentiteInconnu() {
        assertFalse(controlVerifierIdentite.verifierIdentite("Inconnu"));
    }
}
