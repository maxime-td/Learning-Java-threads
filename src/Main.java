public class Main {

    public static void main(String[] args) {
        int nbProducteurs = 50; // Nb de producteurs
        int nbConsommateurs = 2; // Nb de consommateurs

        Stock stock = new Stock(); // Création du stock


        // Création des producteurs
        for (int i = 0; i < nbProducteurs; i++) {
            Producteur producteur = new Producteur(stock); // Création du producteur i
            producteur.start(); // Démarrage du producteur i
        }
        System.out.println(nbProducteurs + " producteurs ont été créés.");


        // Création des consommateurs
        for (int i = 0; i < nbConsommateurs; i++) {

            Consommateur consommateur = new Consommateur(stock); // Création du consommateur i
            consommateur.start(); // Démarrage du consommateur i
        }
        System.out.println(nbConsommateurs + " consommateurs ont été créés.");


    }
}
