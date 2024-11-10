package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

public class ControlAcheterProduitTest {
    private ControlAcheterProduit controlAcheterProduit;

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

        controlAcheterProduit = new ControlAcheterProduit(new ControlVerifierIdentite(village), new ControlTrouverEtalVendeur(village), village);
    }

    @Test
    public void testVerifieIdentite() {
        assertTrue(controlAcheterProduit.verifierIdentite("Asterix"));
        assertFalse(controlAcheterProduit.verifierIdentite("Idefix"));
    }

    @Test
    public void testRechercherVendeursProduit() {
        String[] nomsVendeurs = controlAcheterProduit.rechercherVendeursProduit("poisson");
        assertEquals(1, nomsVendeurs.length);
        assertEquals("Asterix", nomsVendeurs[0]);
    }

    @Test
    public void testAcheterProduit() {
        assertEquals(5, controlAcheterProduit.acheterProduit("Obelix", 5));
        assertEquals(0, controlAcheterProduit.acheterProduit("Idefix", 5));
    }
}
