import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Tableau contenant les adresses e-mail
        String[] adressesEmail = {
                "jpp@sfr.fr",
                "tom@gmail.com",
                "fred@sfr.fr",
                "victor@sfr.fr",
                "chris@sfr.fr",
                "robert@orange.fr",
                "paul@sfr.fr",
                "lise@gmail.com",
                "thierry@isitech.fr",
                "marie@isitech.fr"
        };

        // Appel de la fonction calculerPourcentagesFournisseursMail avec le tableau d'adresses e-mail en paramètre
        calculerPourcentagesFournisseursMail(adressesEmail);
    }

    public static void calculerPourcentagesFournisseursMail(String[] adressesEmail) {
        // Nombre total d'adresses e-mail
        int totalAdresses = adressesEmail.length;

        // Tableau pour compter les adresses de chaque fournisseur
        int[] fournisseurCompteurs = new int[adressesEmail.length];

        // Parcourir le tableau d'adresses e-mail
        for (String adresse : adressesEmail) {
            // Extraire le fournisseur de l'adresse e-mail
            String fournisseur = adresse.substring(adresse.indexOf('@') + 1);

            // Rechercher l'index du fournisseur dans le tableau fournisseurCompteurs
            int index = -1;
            for (int i = 0; i < fournisseurCompteurs.length; i++) {
                if (fournisseur.equals(adressesEmail[i].substring(adressesEmail[i].indexOf('@') + 1))) {
                    index = i;
                    break;
                }
            }

            // Incrémenter le compteur approprié
            if (index != -1) {
                fournisseurCompteurs[index]++;
            } else {
                // Si le fournisseur n'existe pas dans le tableau, ajouter un nouvel élément
                fournisseurCompteurs = Arrays.copyOf(fournisseurCompteurs, fournisseurCompteurs.length + 1);
                fournisseurCompteurs[fournisseurCompteurs.length - 1] = 1;
            }
        }

        // Afficher les pourcentages des fournisseurs de services mail
        System.out.println("Pourcentage de fournisseurs de services mail :");

        // Calculer et afficher le pourcentage de chaque fournisseur
        for (int i = 0; i < fournisseurCompteurs.length; i++) {
            // Extraire le fournisseur du tableau d'adresses e-mail
            String fournisseur = adressesEmail[i].substring(adressesEmail[i].indexOf('@') + 1);

            // Calculer le pourcentage
            double pourcentage = (double) fournisseurCompteurs[i] / totalAdresses * 100;

            // Afficher le pourcentage du fournisseur
            System.out.println("- " + fournisseur + " : " + pourcentage + "%");
        }
    }
}