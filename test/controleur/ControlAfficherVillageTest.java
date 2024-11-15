package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;
import personnages.Druide;

class ControlAfficherVillageTest {
    private ControlAfficherVillage controlAfficherVillage;
    
    @BeforeEach
    public void initialiserSituation() {
        Village village    = new Village("Le village des irréductibles", 10, 5);
        
        Chef abraracourcix = new Chef("Abraracourcix", 10, village);
        Gaulois asterix    = new Gaulois("Asterix", 6);
        Gaulois obelix     = new Gaulois("Obelix", 12);
        Druide panoramix   = new Druide("Panoramix", 4, 1, 10);

        village.ajouterHabitant(asterix);
        village.ajouterHabitant(obelix);
        village.setChef(abraracourcix);
        village.ajouterHabitant(panoramix);

        village.installerVendeur(obelix, "fleurs", 10);
        village.installerVendeur(asterix, "poisson", 5);

        controlAfficherVillage = new ControlAfficherVillage(village);
    }

    @Test
    void testDonnerNomsVillageois() {
        String[] nomsVillageois = controlAfficherVillage.donnerNomsVillageois();
        String[] expected = {"Abraracourcix", "Asterix", "Obelix", "le druide Panoramix"};
        assertArrayEquals(expected, nomsVillageois);
    }

    @Test
    void testDonnerNomVillage() {
        String nomVillage = controlAfficherVillage.donnerNomVillage();
        assertEquals("Le village des irréductibles", nomVillage);
    }

    @Test
    void testDonnerNbEtals() {
        int nbEtals = controlAfficherVillage.donnerNbEtals();
        assertEquals(5, nbEtals);
    }
}
