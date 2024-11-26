import java.util.Random;

public class Producteur extends Thread {

    int stockPlein = 0; // 0 = pas plein, 1 = plein
    final Stock stockClasse;

    Random rand = new Random();
    int tempsAleatoire;

    public Producteur(Stock stock) {
        this.stockClasse = stock;
    }

    @Override
    public void run() {
        while (true) {
            if (stockPlein == 0) {
                try {
                    tempsAleatoire = (rand.nextInt(5) + 1) * 1000; // Attente aléatoire entre 1 et 5 secondes
                    Thread.sleep(tempsAleatoire); // Attend 2 secondes
                    PereNoel pereNoel = new PereNoel(); // Créé un père noel
                    stockPlein = stockClasse.ajouter(pereNoel); // L'ajoute au stock

                    if (stockPlein == 0) {
                        System.out.println("Père Noël n°" + pereNoel.numeroDeSerie + " ajouté au stock.");
                        System.out.println("Nombre de pères Noël dans le stock : " + stockClasse.stock.size());
                    } else {
                        System.out.println("Producteur mis en attente...");
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    synchronized (stockClasse) {
                        stockClasse.wait();
                        stockPlein = 0;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}