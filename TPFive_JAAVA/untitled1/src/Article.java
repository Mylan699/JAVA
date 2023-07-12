public class Article {
    private String reference; // La référence de l'article
    private String designation; // La désignation de l'article
    private double prix; // Le prix de l'article

    // Constructeur de la classe Article
    public Article(String reference, String designation, double prix) {
        this.reference = reference;
        this.designation = designation;
        this.prix = prix;
    }

    // Getter pour la référence de l'article
    public String getReference() {
        return reference;
    }

    // Setter pour la référence de l'article
    public void setReference(String reference) {
        this.reference = reference;
    }

    // Getter pour la désignation de l'article
    public String getDesignation() {
        return designation;
    }

    // Setter pour la désignation de l'article
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    // Getter pour le prix de l'article
    public double getPrix() {
        return prix;
    }

    // Setter pour le prix de l'article
    public void setPrix(double prix) {
        this.prix = prix;
    }

    public static void main(String[] args) {
        // Création d'un objet article avec une référence, une désignation et un prix
        Article article = new Article("REFAC69496", "T-shirt", 19.99);

        // Affichage des informations de l'article
        System.out.println("Référence : " + article.getReference());
        System.out.println("Désignation : " + article.getDesignation());
        System.out.println("Prix : " + article.getPrix());
    }
}