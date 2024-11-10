package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
    private ControlEmmenager controlEmmenager;

    public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
        this.controlEmmenager = controlEmmenager;
    }

    public void emmenager(String nomVisiteur) {
        if(controlEmmenager.isHabitant(nomVisiteur))
            System.out.println("Mais vous êtes déjà un habitant du village !");
        else {
            StringBuilder question = new StringBuilder();
            question.append("Êtes-vous :\n");
            question.append("1 - un druide.\n");
            question.append("2 - un gaulois.");
            int input = -1;
            do {
                input = Clavier.entrerEntier(question.toString());
                switch(input) {
                case 1:
                    emmenagerDruide(nomVisiteur);
                    break;

                case 2:
                    System.out.println("Bienvenue villageois " + nomVisiteur);
                    int force = Clavier.entrerEntier("Quelle est votre force ?");
                    controlEmmenager.ajouterGaulois(nomVisiteur, force);
                    break;

                default:
                    System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
                    break;
                }
            } while (input != 1 && input != 2);
        }
    }

    private void emmenagerDruide(String nomVisiteur) {
        System.out.println("Bienvenue druide " + nomVisiteur);
        int force = Clavier.entrerEntier("Quelle est votre force ?");
        int effetPotionMin;
        int effetPotionMax;
        do {
            effetPotionMin = Clavier.entrerEntier("Quelle est la force de la potion la plus faible que vous produisez ?");
            effetPotionMax = Clavier.entrerEntier("Quelle est la force de la potion la plus forte que vous produisez ?");
            if(effetPotionMax < effetPotionMin)
                System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum !");
        } while(effetPotionMax < effetPotionMin);
        controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
    }
}
