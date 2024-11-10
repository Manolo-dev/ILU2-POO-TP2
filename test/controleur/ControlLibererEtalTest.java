package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

public class ControlLibererEtalTest {
    private ControlLibererEtal controlLibererEtal;

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

        controlLibererEtal = new ControlLibererEtal(new ControlTrouverEtalVendeur(village));
    }

    @Test
    public void testIsVendeur() {
        assertTrue(controlLibererEtal.isVendeur("Obelix"));
        assertTrue(controlLibererEtal.isVendeur("Asterix"));
        assertFalse(controlLibererEtal.isVendeur("Panoramix"));
    }

    @Test
    public void testLibererEtal() {
        String[] donneesVente = controlLibererEtal.libererEtal("Obelix");
        assertEquals("true", donneesVente[0]);
        assertEquals("Obelix", donneesVente[1]);
        assertEquals("fleurs", donneesVente[2]);
        assertEquals("10", donneesVente[3]);
        assertEquals("0", donneesVente[4]);

        donneesVente = controlLibererEtal.libererEtal("Asterix");
        assertEquals("true", donneesVente[0]);
        assertEquals("Asterix", donneesVente[1]);
        assertEquals("poisson", donneesVente[2]);
        assertEquals("5", donneesVente[3]);
        assertEquals("0", donneesVente[4]);

        donneesVente = controlLibererEtal.libererEtal("Panoramix");
        assertEquals("false", donneesVente[0]);
    }
}
