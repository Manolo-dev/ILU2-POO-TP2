package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

public class ControlPrendreEtalTest {
    private ControlPrendreEtal controlPrendreEtal;

    @BeforeEach
    public void initialiserSituation() {
        Village village    = new Village("Le village des irréductibles", 10, 5);
        
        Chef abraracourcix = new Chef("Abraracourcix", 10, village);
        Gaulois asterix    = new Gaulois("Asterix", 6);
        Gaulois obelix     = new Gaulois("Obelix", 12);
        Gaulois panoramix  = new Gaulois("Panoramix", 8);

        village.ajouterHabitant(asterix);
        village.ajouterHabitant(obelix);
        village.setChef(abraracourcix);

        village.installerVendeur(obelix, "fleurs", 10);
        village.installerVendeur(asterix, "poisson", 5);
        village.installerVendeur(panoramix, "potion", 5);

        controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
    }


    @Test
    public void testResteEtals() {
        assertTrue(controlPrendreEtal.resteEtals());
    }

    @Test
    public void testPrendreEtal() {
        assertEquals(3, controlPrendreEtal.prendreEtal("Asterix", "poisson", 5));
        assertEquals(4, controlPrendreEtal.prendreEtal("Obelix", "fleurs", 10));
    }

    @Test
    public void testVerifieIdentite() {
        assertTrue(controlPrendreEtal.verifierIdentite("Asterix"));
        assertTrue(controlPrendreEtal.verifierIdentite("Obelix"));
        assertFalse(controlPrendreEtal.verifierIdentite("Panoramix"));
    }

    @Test
    public void testRestEtalFalse() {
        controlPrendreEtal.prendreEtal("Asterix", "poisson", 5);
        controlPrendreEtal.prendreEtal("Obelix", "fleurs", 10);
        controlPrendreEtal.prendreEtal("Obelix", "fleurs", 10);
        assertFalse(controlPrendreEtal.resteEtals());
    }

    @Test
    public void testPrendreEtalFalse() {
        controlPrendreEtal.prendreEtal("Asterix", "poisson", 5);
        controlPrendreEtal.prendreEtal("Obelix", "fleurs", 10);
        assertEquals(-1, controlPrendreEtal.prendreEtal("Obelix", "fleurs", 10));
    }

    @Test
    public void testPrendreEtalWithWrongName() {
        assertEquals(-1, controlPrendreEtal.prendreEtal("Assurancetourix", "poisson", 5));
    }
}
