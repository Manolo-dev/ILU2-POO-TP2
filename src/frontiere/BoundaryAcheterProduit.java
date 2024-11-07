package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println(
				  "Je suis désolée "
				+ nomAcheteur
				+ " mais il faut être un habitant de notre village pour commercer ici.");
			return;
		}
		System.out.println("Quel produit voulez-vous acheter ?");
		String nomProduit = scan.next();

		String[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(nomProduit);
		if(vendeurs.length == 0) {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
			return;
		}
		System.out.println("Chez quel commerçant voulez-vous acheter des " + nomProduit + " ?");
		for(int i = 0; i < vendeurs.length; i++) {
			System.out.println(i + " - " + vendeurs[i]);
		}
		int choix = scan.nextInt();
		if(choix < 0 || choix >= vendeurs.length) {
			System.out.println("Choix invalide.");
			return;
		}
		System.out.println("Combien de " + nomProduit + " voulez-vous acheter ?");
		int quantite = scan.nextInt();

		int result = controlAcheterProduit.acheterProduit(nomProduit, vendeurs[choix], quantite);
		if(result == 0) {
			System.out.println(
				  nomAcheteur
				+ " veut acheter "
				+ quantite
				+ " "
				+ nomProduit
				+ ", malheureusement il n'y en a plus !");
			return;
		}
		if(result < quantite) {
			System.out.println(
				  nomAcheteur
				+ " veut acheter "
				+ quantite
				+ " "
				+ nomProduit
				+ ", malheureusement "
				+ vendeurs[choix]
				+ " n’en a plus que "
				+ result
				+ ". "
				+ nomAcheteur
				+ " achète tout le stock de "
				+ vendeurs[choix]);
			return;
		}

		System.out.println(
			  nomAcheteur
			+ " achète "
			+ quantite
			+ " à "
			+ vendeurs[choix]);
	}
}
