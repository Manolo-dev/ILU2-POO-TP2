package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

public class ControlAfficherMarcheTest {
    private ControlAfficherMarche controlAfficherMarche;

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

        controlAfficherMarche = new ControlAfficherMarche(village);
    }

    @Test
    public void testDonnerInfosMarche() {
        String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
        String[] infosMarcheAttendues = new String[] {
            "Obelix", "10", "fleurs", "Asterix", "5", "poisson"
        };
        assertArrayEquals(infosMarcheAttendues, infosMarche);
    }
}
