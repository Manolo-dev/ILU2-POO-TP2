package villagegaulois;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;

public class VillageTest {
    private Village village;

    @BeforeEach
    public void initialiserSituation() {
        village = new Village("Le village des irréductibles", 10, 5);
        Chef abraracourcix = new Chef("Abraracourcix", 10, village);
        village.setChef(abraracourcix);
    }

    @Test
    void testGetNom() {
        assertEquals("Le village des irréductibles", village.getNom());
    }

    @Test
    void testGetNomFalse() {
        assertNotEquals("Le village des patates", village.getNom());
    }
    
    @Test
    void testTrouverHabitant() {
        Gaulois asterix = new Gaulois("Asterix", 6);
        village.ajouterHabitant(asterix);
        assertEquals(asterix, village.trouverHabitant("Asterix"));
    }

    @Test
    void testTrouverHabitantFalse() {
        Gaulois asterix = new Gaulois("Asterix", 6);
        village.ajouterHabitant(asterix);
        assertNull(village.trouverHabitant("Obelix"));
    }

    @Test
    void testDonnerVillageois() {
        Gaulois asterix = new Gaulois("Asterix", 6);
        Gaulois obelix = new Gaulois("Obelix", 7);
        village.ajouterHabitant(asterix);
        village.ajouterHabitant(obelix);
        String[] villageois = village.donnerVillageois();
        assertEquals("Abraracourcix", villageois[0]);
        assertEquals("Asterix", villageois[1]);
        assertEquals("Obelix", villageois[2]);
    }

    @Test
    void testInstallerVendeur() {
        Gaulois asterix = new Gaulois("Asterix", 6);
        village.ajouterHabitant(asterix);
        assertEquals(0, village.installerVendeur(asterix, "Potion magique", 10));
    }
    
    @Test
    void testInstallerVendeurFalse() {
        Gaulois asterix = new Gaulois("Asterix", 6);
        village.ajouterHabitant(asterix);
        village.installerVendeur(asterix, "Potion magique", 10);
        village.installerVendeur(asterix, "Potion magique", 10);
        village.installerVendeur(asterix, "Potion magique", 10);
        village.installerVendeur(asterix, "Potion magique", 10);
        village.installerVendeur(asterix, "Potion magique", 10);
        assertEquals(-1, village.installerVendeur(asterix, "Potion magique", 10));
    }

    @Test
    void testPartirVendeur() {
        Gaulois asterix = new Gaulois("Asterix", 6);
        village.ajouterHabitant(asterix);
        village.installerVendeur(asterix, "Potion magique", 10);
        village.partirVendeur(asterix);
        assertTrue(village.rechercherEtalVide());
    }

    @Test
    void testPartirVendeurEtalNull() {
        Gaulois asterix = new Gaulois("Asterix", 6);
        village.ajouterHabitant(asterix);
        village.partirVendeur(asterix);
        assertTrue(village.rechercherEtalVide());
    }

    @Test
    void testRechercherEtalVide() {
        assertTrue(village.rechercherEtalVide());
    }

    @Test
    void testRechercherEtalVideFalse() {
        Gaulois asterix = new Gaulois("Asterix", 6);
        village.ajouterHabitant(asterix);
        village.installerVendeur(asterix, "Potion magique", 10);
        village.installerVendeur(asterix, "Potion magique", 10);
        village.installerVendeur(asterix, "Potion magique", 10);
        village.installerVendeur(asterix, "Potion magique", 10);
        village.installerVendeur(asterix, "Potion magique", 10);
        assertFalse(village.rechercherEtalVide());
    }

    @Test
    void testRechercherVendeursProduit() {
        Gaulois asterix = new Gaulois("Asterix", 6);
        Gaulois obelix = new Gaulois("Obelix", 7);
        village.ajouterHabitant(asterix);
        village.installerVendeur(asterix, "Potion magique", 10);
        village.installerVendeur(obelix, "Potion magique", 10);
        Gaulois[] vendeurs = village.rechercherVendeursProduit("Potion magique");
        assertEquals(2, vendeurs.length);
        assertEquals(asterix, vendeurs[0]);
        assertEquals(obelix, vendeurs[1]);
    }

    @Test
    void testRechercherVendeursProduitFalse() {
        Gaulois asterix = new Gaulois("Asterix", 6);
        village.ajouterHabitant(asterix);
        village.installerVendeur(asterix, "Potion magique", 10);
        Gaulois[] vendeurs = village.rechercherVendeursProduit("Patates");
        assertNull(vendeurs);
    }

    @Test
    void testRechercherEtal() {
        Gaulois asterix = new Gaulois("Asterix", 6);
        village.ajouterHabitant(asterix);
        village.installerVendeur(asterix, "Potion magique", 10);
        assertEquals(asterix, village.rechercherEtal(asterix).getVendeur());
    }

    @Test
    void testDonnerEtatMarche() {
        Gaulois asterix = new Gaulois("Asterix", 6);
        Gaulois obelix = new Gaulois("Obelix", 7);
        village.ajouterHabitant(asterix);
        village.ajouterHabitant(obelix);
        village.installerVendeur(asterix, "Potion magique", 10);
        village.installerVendeur(obelix, "Patates", 15);

        String[] expected = {"Asterix", "10", "Potion magique", "Obelix", "15", "Patates"};

        assertArrayEquals(expected, village.donnerEtatMarche());
    }

}
