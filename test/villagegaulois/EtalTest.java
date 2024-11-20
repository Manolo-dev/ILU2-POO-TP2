package villagegaulois;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;

public class EtalTest {
    private Etal etal;
    private Gaulois vendeur;

    @BeforeEach
    public void initialiserSituation() {
        etal = new Etal();
        vendeur = new Gaulois("Astérix", 4);
    }

    @Test
    void testIsEtalOccupeFalse() {
        assertFalse(etal.isEtalOccupe());
    }

    @Test
    void testIsEtalOccupeTrue() {
        etal.occuperEtal(vendeur, "Potion magique", 10);
        assertTrue(etal.isEtalOccupe());
    }

    @Test
    void testGetVendeur() {
        etal.occuperEtal(vendeur, "Potion magique", 10);
        assertEquals(vendeur, etal.getVendeur());
    }

    @Test
    void testGetQuantite() {
        etal.occuperEtal(vendeur, "Potion magique", 10);
        assertEquals(10, etal.getQuantite());
    }

    @Test
    void testGetProduit() {
        etal.occuperEtal(vendeur, "Potion magique", 10);
        assertEquals("Potion magique", etal.getProduit());
    }

    @Test
    void testOccuperEtal() {
        etal.occuperEtal(vendeur, "Potion magique", 10);
        assertTrue(etal.isEtalOccupe());
    }

    @Test
    void testContientProduitTrue() {
        etal.occuperEtal(vendeur, "Potion magique", 10);
        assertTrue(etal.contientProduit("Potion magique"));
    }

    @Test
    void testContientProduitFalse() {
        etal.occuperEtal(vendeur, "Potion magique", 10);
        assertFalse(etal.contientProduit("Potion"));
    }

    @Test
    void testAcheterProduit() {
        etal.occuperEtal(vendeur, "Potion magique", 10);
        assertEquals(5, etal.acheterProduit(5));
    }

    @Test
    void testAcheterProduitZero() {
        etal.occuperEtal(vendeur, "Potion magique", 10);
        assertEquals(0, etal.acheterProduit(0));
    }

    @Test
    void testAcheterProduitMax() {
        etal.occuperEtal(vendeur, "Potion magique", 10);
        assertEquals(10, etal.acheterProduit(15));
    }

    @Test
    void testAcheterProduitEtalNonOccupe() {
        assertEquals(0, etal.acheterProduit(5));
    }

    @Test
    void testLibererEtal() {
        etal.occuperEtal(vendeur, "Potion magique", 10);
        etal.libererEtal();
        assertFalse(etal.isEtalOccupe());
    }

    @Test
    void testLibererEtalNonOccupe() {
        etal.libererEtal();
        assertFalse(etal.isEtalOccupe());
    }

    @Test
    void testEtatEtal() {
        etal.occuperEtal(vendeur, "Potion magique", 10);
        String[] donneesVente = etal.etatEtal();
        assertEquals("true", donneesVente[0]);
        assertEquals("Astérix", donneesVente[1]);
        assertEquals("Potion magique", donneesVente[2]);
        assertEquals("10", donneesVente[3]);
        assertEquals("0", donneesVente[4]);
    }

    @Test
    void testEtatEtalNonOccupe() {
        String[] donneesVente = etal.etatEtal();
        assertEquals("false", donneesVente[0]);
    }
}
