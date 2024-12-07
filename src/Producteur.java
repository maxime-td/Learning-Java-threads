import java.util.Random;

// Producer class
public class Producteur extends Thread {

    // Santas management
    int fullStock = 0; // 0 = not full, 1 = full
    final Stock stockClass;

    // Random management
    Random rand = new Random();
    int randomTime;


    public Producteur(Stock stock) {
        this.stockClass = stock;
    }

    @Override
    public void run() {
        while (Main.exitNumber != 0) {
            if (fullStock == 0) { // If stock is not full

                try {
                    randomTime = (rand.nextInt(5) + 1) * 1000; // Random waiting between 1 and 5 seconds
                    Thread.sleep(randomTime); // Waiting

                    PereNoel pereNoel = new PereNoel(); // Creates the santa
                    fullStock = stockClass.addSantaToStock(pereNoel); // Adds it to the stock

                    if (fullStock == 0) { // If stock is not full => adds the santa
                        System.out.println("Santa n°" + pereNoel.serialNumber + " added to stock.");

                    } else { // Is stock is full => producer waiting
                        System.out.println("Producer waiting...");
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            } else {
                try {
                    synchronized (stockClass) { // End of waiting
                        stockClass.wait();
                        fullStock = 0;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}