public class Producteur extends Thread {
    int stockPlein = 0;

    public Producteur() {};

    public void run(Stock stockClasse) {
        while (true) {
            if (stockPlein == 0) {
                try {

                    Thread.sleep(2000); // Attend 2 secondes
                    PereNoel pereNoel = new PereNoel(); // Créé un père noel
                    stockPlein = stockClasse.ajouter(pereNoel); // L'ajoute au stock

                    if (stockPlein == 0) {
                        System.out.println("Père Noël n°" + pereNoel.numeroDeSerie + " ajouté au stock.\n");
                    } else {
                        System.out.println("Producteur mis en attente...\n");
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                Thread.wait();
                stockPlein = 0;
            }
        }
    }
}