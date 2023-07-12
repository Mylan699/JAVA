import java.util.Date;

public class Commande {
    private int numero; // Le numéro de la commande
    private Date date; // La date de la commande
    private Client client; // Le client qui passe la commande
    private Article[] articles; // Le tableau des articles commandés
    private int[] quantites; // Le tableau des quantités commandées pour chaque article

    public Commande(int numero, Date date, Client client, Article[] articles, int[] quantites) {
        this.numero = numero;
        this.date = date;
        this.client = client;
        this.articles = articles;
        this.quantites = quantites;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Article[] getArticles() {
        return articles;
    }

    public void setArticles(Article[] articles) {
        this.articles = articles;
    }

    public int[] getQuantites() {
        return quantites;
    }

    public void setQuantites(int[] quantites) {
        this.quantites = quantites;
    }

    public double getMontantTotal() {
        double montantTotal = 0;

        for (int i = 0; i < articles.length; i++) {
            montantTotal += articles[i].getPrix() * quantites[i];
        }

        return montantTotal;
    }

    public static void main(String[] args) {
        // Création d'un client
        Client client = new Client("MAHIEDDINE", "Mylan", "12 rue des Roses", "69000", "Lyon");

        // Création des articles
        Article article1 = new Article("REF123", "T-shirt", 19.99);
        Article article2 = new Article("REF456", "Pantalon", 29.99);

        // Création du tableau des articles et des quantités
        Article[] articles = {article1, article2};
        int[] quantites = {2, 3};

        // Création d'une date
        Date date = new Date();

        // Création de la commande
        Commande commande = new Commande(1, date, client, articles, quantites);

        // Affichage des informations de la commande
        System.out.println("Numéro de commande : " + commande.getNumero());
        System.out.println("Date de commande : " + commande.getDate());
        System.out.println("Client : " + commande.getClient().getNom() + " " + commande.getClient().getPrenom());
        System.out.println("Adresse : " + commande.getClient().getAdresse() + ", " + commande.getClient().getCodePostal() + " " + commande.getClient().getVille());
        System.out.println("Articles commandés :");

        for (int i = 0; i < commande.getArticles().length; i++) {
            System.out.println("Article : " + commande.getArticles()[i].getDesignation());
            System.out.println("Quantité : " + commande.getQuantites()[i]);
        }

        System.out.println("Montant total de la commande : " + commande.getMontantTotal() + " euros");
    }
}