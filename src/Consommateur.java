import java.util.Random;

// Consumer class
public class Consommateur extends Thread {

    // Random management
    Random rand = new Random();
    int randomNumber; // Random number of santas consumed
    int randomTime; // Random time between consummations

    // Stock management
    int emptyStock = 0; // 0 = not empty, 1 = empty
    final Stock stockClass; // Stock pointer


    public Consommateur(Stock stock) {
        this.stockClass = stock; // Connect to the stock
    }

    @Override
    public void run() {
        while (Main.exitNumber != 0) {

            randomNumber = rand.nextInt(5) + 1; // Random number between 1 and 5 for the number of santas consumed

            if (emptyStock == 0) { // If stock is not empty

                try {
                    randomTime = (rand.nextInt(5) + 1) * 1000; // Random waiting between 1 and 5 seconds.
                    Thread.sleep(randomTime); // Waiting

                    emptyStock = stockClass.consumeSantaFromStock(randomNumber); // Consumes X santas

                    if (emptyStock == 0) { // Si stock pas vide => affichage
                        System.out.println(randomNumber + " santa(s) consumed.");

                    } else { // If stock is empty => waiting
                        System.out.println("Consumer waiting...");
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            } else {
                try {
                    synchronized (stockClass) { // End of waiting
                        stockClass.wait();
                        emptyStock = 0;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
