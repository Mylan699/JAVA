import java.util.Random;
import java.util.Scanner;

public class JeuDuJustePrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // objet Scanner pour lire les entrée
        Random random = new Random(); // objet Random pour generer un nombre aléatoire

        int nombreAleatoire = random.nextInt(1000) + 1; // Genere un nombre aléatoire entre 1 et 100
        int tentative = 0; // Variable pour compter le nombre de tentative de l'utilisateur
        long debut = System.currentTimeMillis(); // Enregistre le temps

        System.out.println("Le Juste Prix !");
        System.out.println("Un nombre entre 1 et 1000 a été généré.");

        int proposition;
        do {
            System.out.print("Entre ton prix : ");
            proposition = scanner.nextInt(); // Lit la proposition de l'utilisateur
            tentative++; // Incrémente le compteur de tentatives

            if (proposition < nombreAleatoire) {
                System.out.println("C'est + !"); // message proposition est inférieure au nombre
            } else if (proposition > nombreAleatoire) {
                System.out.println("C'est - !"); // message proposition est supérieure au nombre
            } else {
                long fin = System.currentTimeMillis(); // Enregistre le temps
                double temps = (fin - debut) / 1000.0; // Calcule le temps

                System.out.println("Bravo, tu as trouve le juste prix en " + tentative + " tentative(s) !");
                System.out.println("Temps écoulé : " + temps + " secondes.");
            }
        } while (proposition != nombreAleatoire); // Continue la boucle tant que la proposition n'est pas égal au nombre a trouver

        scanner.close(); // libere les ressources
    }
}