import java.text.NumberFormat;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Account checking = null;
        Account savings = null;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Scanner sc = new Scanner(System.in);
        boolean session = true;
        int pin = 0;

        while (session) {
            System.out.println("=======================================");
            System.out.println("    MENU DU DISTRIBUTEUR AUTOMATIQUE       ");
            System.out.println("=======================================");
            System.out.println("1. Créer un compte");
            System.out.println("2. Se connecter");
            System.out.println("3. Terminer la session");
            System.out.println("---------------------------------------");
            System.out.print("Entrez votre choix : ");

            int selection = sc.nextInt();

            switch (selection) {

                // case 1 pour créer un compte
                case 1:
                    System.out.println("\n--- Création du compte ---\n");
                    System.out.print("Choisissez un code PIN à 4 chiffres pour votre compte : ");
                    pin = sc.nextInt();

                    checking = new Account();
                    checking.setType("Chèque");
                    checking.setBalance(0.00);
                    checking.setRate(0.00);

                    savings = new Account();
                    savings.setType("Épargne");
                    savings.setBalance(0.00);
                    savings.setRate(2.00);

                    // Demander les informations personnelles jusqu'à ce qu'elles soient saisies
                    boolean infoSaisies = false;

                    while (!infoSaisies) {
                        System.out.print("Entrez votre nom : ");
                        String nom = sc.next();
                        sc.nextLine(); // Consommer la nouvelle ligne en attente

                        System.out.print("Entrez votre prénom : ");
                        String prenom = sc.next();
                        sc.nextLine(); // Consommer la nouvelle ligne en attente

                        System.out.print("Entrez votre adresse : ");
                        String adresse = sc.nextLine().trim(); // Utiliser nextLine() pour capturer l'adresse avec des espaces

                        System.out.print("Entrez votre code postal : ");
                        String codePostal = sc.next();
                        sc.nextLine(); // Consommer la nouvelle ligne en attente

                        System.out.print("Entrez votre ville : ");
                        String ville = sc.next();
                        sc.nextLine(); // Consommer la nouvelle ligne en attente

                        // Vérifier si tous les champs sont remplis
                        if (!nom.isEmpty() && !prenom.isEmpty() && !adresse.isEmpty() && !codePostal.isEmpty() && !ville.isEmpty()) {
                            // Utilisez les informations saisies pour initialiser le compte avec les détails de l'utilisateur
                            checking.setOwnerInfo(nom, prenom, adresse, codePostal, ville);
                            savings.setOwnerInfo(nom, prenom, adresse, codePostal, ville);
                            infoSaisies = true; // Sortir de la boucle lorsque les informations sont saisies
                        } else {
                            System.out.println("\nVeuillez remplir tous les champs obligatoires.\n");
                        }
                    }
                    break;

                case 2:
                    if (checking == null || savings == null) {
                        System.out.println("\nAucun compte n'a été créé. Veuillez créer un compte avant de vous connecter.\n");
                        break;
                    }

                    System.out.println("\n--- Connexion ---\n");
                    System.out.print("Entrez votre code PIN : ");
                    int enteredPin = sc.nextInt();

                    if (enteredPin == pin) {
                        System.out.println("\nConnecté avec succès !\n");
                        showMainMenu(checking, savings, formatter, sc);
                    } else {
                        System.out.println("\nCode PIN incorrect. Veuillez réessayer.\n");
                    }
                    break;

                case 3:
                    session = false;
                    break;

                default:
                    System.out.println("\nChoix invalide. Veuillez sélectionner une option valide.\n");
                    break;
            }
        }

        System.out.println("\nMerci d'avoir utilisé notre distributeur automatique !\n");

    }

    public static void showMainMenu(Account checking, Account savings, NumberFormat formatter, Scanner sc) {
        boolean session = true;

        while (session) {
            System.out.println("=======================================");
            System.out.println("    MENU DU DISTRIBUTEUR AUTOMATIQUE       ");
            System.out.println("=======================================");
            System.out.println("1. Déposer de l'argent");
            System.out.println("2. Retirer de l'argent");
            System.out.println("3. Transférer des fonds du compte chèque au compte épargne");
            System.out.println("4. Transférer des fonds du compte épargne au compte chèque");
            System.out.println("5. Vérifier le solde du compte");
            System.out.println("6. Voir et modifier les informations personnelles");
            System.out.println("7. Terminer la session");
            System.out.println("---------------------------------------");
            System.out.print("Entrez votre choix : ");

            int selection = sc.nextInt();

            switch (selection) {
                case 1:
                    // Gérer le dépôt d'argent
                    System.out.print("Entrez le montant à déposer : ");
                    double depositAmount = sc.nextDouble();
                    checking.deposit(depositAmount);
                    System.out.println("Dépôt effectué avec succès. Le nouveau solde du compte chèque est : " + formatter.format(checking.getBalance()));
                    break;

                case 2:
                    // Gérer le retrait d'argent
                    System.out.print("Entrez le montant à retirer : ");
                    double withdrawAmount = sc.nextDouble();
                    checking.withdraw(withdrawAmount);
                    System.out.println("Retrait effectué avec succès. Le nouveau solde du compte chèque est : " + formatter.format(checking.getBalance()));
                    break;

                case 3:
                    // Transférer des fonds du compte chèque au compte épargne
                    System.out.print("Entrez le montant à transférer du compte chèque au compte épargne : ");
                    double transferAmountToSavings = sc.nextDouble();
                    if (checking.getBalance() >= transferAmountToSavings) {
                        checking.withdraw(transferAmountToSavings);
                        savings.deposit(transferAmountToSavings);
                        System.out.println("Transfert effectué avec succès. Le nouveau solde du compte chèque est : " + formatter.format(checking.getBalance()));
                        System.out.println("Le nouveau solde du compte épargne est : " + formatter.format(savings.getBalance()));
                    } else {
                        System.out.println("Solde insuffisant pour effectuer le transfert.");
                    }
                    break;

                case 4:
                    // Transférer des fonds du compte épargne au compte chèque
                    System.out.print("Entrez le montant à transférer du compte épargne au compte chèque : ");
                    double transferAmountToChecking = sc.nextDouble();
                    if (savings.getBalance() >= transferAmountToChecking) {
                        savings.withdraw(transferAmountToChecking);
                        checking.deposit(transferAmountToChecking);
                        System.out.println("Transfert effectué avec succès. Le nouveau solde du compte épargne est : " + formatter.format(savings.getBalance()));
                        System.out.println("Le nouveau solde du compte chèque est : " + formatter.format(checking.getBalance()));
                    } else {
                        System.out.println("Solde insuffisant pour effectuer le transfert.");
                    }
                    break;

                case 5:
                    // Afficher les soldes des comptes
                    System.out.println("Solde du compte chèque : " + formatter.format(checking.getBalance()));
                    System.out.println("Solde du compte épargne : " + formatter.format(savings.getBalance()));
                    break;

                case 6:
                    showPersonalInfo(checking, savings, sc);
                    break;

                case 7:
                    session = false;
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez sélectionner une option valide.");
                    break;
            }
        }
    }

    public static void showPersonalInfo(Account checking, Account savings, Scanner sc) {
        System.out.println("\nInformations personnelles : ");
        System.out.println("Nom : " + checking.getOwnerInfo().getNom());
        System.out.println("Prénom : " + checking.getOwnerInfo().getPrenom());
        System.out.println("Adresse : " + checking.getOwnerInfo().getAdresse());
        System.out.println("Code postal : " + checking.getOwnerInfo().getCodePostal());
        System.out.println("Ville : " + checking.getOwnerInfo().getVille());

        System.out.print("\nVoulez-vous modifier vos informations personnelles ? (Oui/Non) : ");
        String choix = sc.next();

        if (choix.equalsIgnoreCase("Oui")) {
            System.out.print("Entrez votre nouveau nom : ");
            String nom = sc.next();
            sc.nextLine(); // Consommer la nouvelle ligne en attente

            System.out.print("Entrez votre nouveau prénom : ");
            String prenom = sc.next();
            sc.nextLine(); // Consommer la nouvelle ligne en attente

            System.out.print("Entrez votre nouvelle adresse : ");
            String adresse = sc.nextLine().trim(); // Utiliser nextLine() pour capturer l'adresse avec des espaces

            System.out.print("Entrez votre nouveau code postal : ");
            String codePostal = sc.next();
            sc.nextLine(); // Consommer la nouvelle ligne en attente

            System.out.print("Entrez votre nouvelle ville : ");
            String ville = sc.next();
            sc.nextLine(); // Consommer la nouvelle ligne en attente

            checking.getOwnerInfo().setNom(nom);
            checking.getOwnerInfo().setPrenom(prenom);
            checking.getOwnerInfo().setAdresse(adresse);
            checking.getOwnerInfo().setCodePostal(codePostal);
            checking.getOwnerInfo().setVille(ville);

            savings.getOwnerInfo().setNom(nom);
            savings.getOwnerInfo().setPrenom(prenom);
            savings.getOwnerInfo().setAdresse(adresse);
            savings.getOwnerInfo().setCodePostal(codePostal);
            savings.getOwnerInfo().setVille(ville);

            System.out.println("\nInformations personnelles mises à jour avec succès !\n");
        }
    }
}

class Account {
    String type;
    double balance;
    double rate;
    OwnerInfo ownerInfo;

    void setType(String accType) {
        type = accType;
    }

    void setBalance(double accBal) {
        balance = accBal;
    }

    void setRate(double accRate) {
        rate = accRate;
    }

    void setOwnerInfo(String nom, String prenom, String adresse, String codePostal, String ville) {
        ownerInfo = new OwnerInfo(nom, prenom, adresse, codePostal, ville);
    }

    String getType() {
        return type;
    }

    double getBalance() {
        return balance;
    }

    double getRate() {
        return rate;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Solde insuffisant pour effectuer le retrait.");
        }
    }

    OwnerInfo getOwnerInfo() {
        return ownerInfo;
    }
}

class OwnerInfo {
    String nom;
    String prenom;
    String adresse;
    String codePostal;
    String ville;

    OwnerInfo(String nom, String prenom, String adresse, String codePostal, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    String getNom() {
        return nom;
    }

    void setNom(String nom) {
        this.nom = nom;
    }

    String getPrenom() {
        return prenom;
    }

    void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    String getAdresse() {
        return adresse;
    }

    void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    String getCodePostal() {
        return codePostal;
    }

    void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    String getVille() {
        return ville;
    }

    void setVille(String ville) {
        this.ville = ville;
    }
}