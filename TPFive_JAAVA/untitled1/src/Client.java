public class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;

    public Client(String nom, String prenom, String adresse, String codePostal, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public static void main(String[] args) {
        // Création d'un objet client
        Client client = new Client("MAHIEDDINE", "Mylan", "12 rue des Roses", "69000", "Lyon");

        // Affichage des informations du client
        System.out.println("Nom : " + client.getNom());
        System.out.println("Prénom : " + client.getPrenom());
        System.out.println("Adresse : " + client.getAdresse());
        System.out.println("Code postal : " + client.getCodePostal());
        System.out.println("Ville : " + client.getVille());
    }
}