import java.util.ArrayList;

public class Stock {

    // Gestion du stock
    int stockMax = 100;
    ArrayList<PereNoel> stock = new ArrayList<>();


    public Stock() {}

    // Méthode pour ajouter un pn au stock
    public synchronized int ajouter(PereNoel pereNoel) {
        int codeRetour = 1; // 1 = stock plein

        if (stock.size() < stockMax) { // Si stock pas plein
            stock.add(pereNoel); // Ajoute le pn
            notify(); // Notifie les consommateurs
            codeRetour = 0; // 0 = stock pas plein
        }

        return codeRetour;
    }


    // Méthode pour retirer X pn du stock
    public synchronized int retirer(int nombre) {
        int codeRetour = 1; // 1 = stock vide

        if (stock.size() >= nombre) { // Si stock pas vide
            for (int i = 0; i < nombre; i++) { // Retire X pn
                System.out.println("Père Noël n°" + stock.get(stock.size() - 1).numeroDeSerie + " acheté.");
                stock.remove(stock.size() - 1);

                System.out.println("Nombre de pères Noël dans le stock : " + stock.size());
            }
            notify(); // Notifie les producteurs
            codeRetour = 0; // 0 = stock pas vide
        }

        return codeRetour;
    }
}
