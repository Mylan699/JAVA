import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random(); // Crée une instance de la classe Random pour générer des nombres aléatoires
        List<String> tentatives = new ArrayList<>(); // Crée une liste pour stocker les tentatives
        int essais = 0; // Variable pour compter le nombre d'essais
        boolean combinaisonTrouvee = false; // Variable pour indiquer si la combinaison souhaitée a été trouvée

        while (!combinaisonTrouvee) { // Boucle qui continue tant que la combinaison n'a pas été trouvée
            int nombre1 = random.nextInt(1001); // Génère un nombre aléatoire entre 0 et 1000 inclus pour le premier nombre
            int nombre2 = random.nextInt(1001); // Génère un nombre aléatoire entre 0 et 1000 inclus pour le deuxième nombre
            int nombre3 = random.nextInt(1001); // Génère un nombre aléatoire entre 0 et 1000 inclus pour le troisième nombre

            String tentative = nombre1 + ", " + nombre2 + ", " + nombre3; // Crée une chaîne de caractères représentant la tentative actuelle
            tentatives.add(tentative); // Ajoute la tentative à la liste des tentatives

            if (nombre1 % 2 == 0 && nombre2 % 2 == 0 && nombre3 % 2 != 0) {
                // Vérifie si le premier nombre est pair, le deuxième nombre est pair et le troisième nombre est impair
                combinaisonTrouvee = true; // Si la combinaison est satisfaite, met la variable combinaisonTrouvee à true pour sortir de la boucle
            }

            essais++; // Incrémente le nombre d'essais à chaque itération de la boucle
        }

        System.out.println("Combinaison trouvée après " + essais + " essais."); // Affiche le nombre d'essais nécessaires pour trouver la combinaison

        System.out.println("Liste des tentatives :"); // Affiche un message pour indiquer que la liste des tentatives va être affichée
        for (String tentative : tentatives) { // Parcourt la liste des tentatives
            System.out.println(tentative); // Affiche chaque tentative à l'écran
        }
    }
}