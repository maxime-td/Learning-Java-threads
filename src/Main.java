import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int nbProducteurs = 50;
        int nbConsommateurs = 2;

        Stock stock = new Stock();


        // Création des producteurs
        for (int i = 0; i < nbProducteurs; i++) {
            Producteur producteur = new Producteur(stock);
            producteur.start();
        }
        System.out.println(nbProducteurs + " producteurs ont été créés.");

        // Création des consommateurs
        for (int i = 0; i < nbConsommateurs; i++) {

            Consommateur consommateur = new Consommateur(stock);
            consommateur.start();
        }
        System.out.println(nbConsommateurs + " consommateurs ont été créés.");


    }
}
