import java.util.Scanner;

public class ConversionNumerique {
    public static void main(String[] args) {
        // Demande à l'utilisateur de saisir un nombre entier
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez saisir un nombre entier : ");
        int nombre = scanner.nextInt();

        // Conversion en binaire, octal et hexadécimal
        String binaire = Integer.toBinaryString(nombre); // Conversion en valeur binaire
        String octal = Integer.toOctalString(nombre); // Conversion en valeur octale
        String hexa = Integer.toHexString(nombre); // Conversion en valeur hexadécimale

        // Affichage des résultats
        System.out.println("Valeur en binaire : " + binaire); // Affichage de la valeur binaire
        System.out.println("Valeur en octal : " + octal); // Affichage de la valeur octale
        System.out.println("Valeur en hexadécimal : " + hexa); // Affichage de la valeur hexadécimale
    }
}