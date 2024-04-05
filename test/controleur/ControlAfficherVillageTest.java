package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("Le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void donnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertTrue(controlAfficherVillage.donnerNomsVillageois().length == 1);
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		assertTrue(controlAfficherVillage.donnerNomsVillageois().length == 2);
	}

	@Test
	void donnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals("Le village des irréductibles", controlAfficherVillage.donnerNomVillage());
	}

	@Test
	void donnerNbEtalsTest() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(5, controlAfficherVillage.donnerNbEtals());
	}

}
