import java.util.Random;

public class Consommateur extends Thread {

    Random rand = new Random();
    int nombreAleatoire;

    int stockVide = 0; // 0 = pas vide, 1 = vide
    final Stock stockClasse;


    public Consommateur(Stock stock) {
        this.stockClasse = stock;
    }

    @Override
    public void run() {
        while (true) {

            nombreAleatoire = rand.nextInt(5) + 1; // Nombre aléatoire entre 1 et 5

            if (stockVide == 0) {
                try {

                    Thread.sleep(1000); // Attend 1 seconde
                    stockVide = stockClasse.retirer(nombreAleatoire); // Retire x pères noel

                    if (stockVide == 0) {
                        System.out.println(nombreAleatoire + " père(s) Noël retiré(s) du stock.");
                        System.out.println("Nombre de pères Noël dans le stock : " + stockClasse.stock.size());
                    } else {
                        System.out.println("Consommateur mis en attente...");
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    synchronized (stockClasse) {
                        stockClasse.wait();
                        stockVide = 0;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
