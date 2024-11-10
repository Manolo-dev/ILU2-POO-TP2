package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

public class ControlTrouverEtalVendeurTest {
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

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

        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
    }

    @Test
    public void testTrouverEtalVendeur() {
        assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Asterix"));
        assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Obelix"));
        assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Panoramix"));
    }
}
