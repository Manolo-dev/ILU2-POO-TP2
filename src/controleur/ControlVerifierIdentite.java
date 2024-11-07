package controleur;

import villagegaulois.Village;
import java.util.Objects;

public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return Objects.nonNull(village.trouverHabitant(nomVendeur));
	}
}
