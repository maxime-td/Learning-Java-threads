import java.util.ArrayList;

// Stock class
public class Stock {

    // Stock management
    int stockMax = 100; // Maximum possible of santas in the stock
    ArrayList<PereNoel> stock = new ArrayList<>();


    public Stock() {}

    // Method to add a santa to the stock
    public synchronized int addSantaToStock(PereNoel pereNoel) {
        int returnCode = 1; // 1 = stock is full

        if (stock.size() < stockMax) { // If stock is not full
            stock.add(pereNoel); // Adds the santa
            notifyAll(); // Notifies the consumers
            returnCode = 0; // 0 = stock is not full
        }

        return returnCode;
    }


    // Method to consume X santas from the stock
    public synchronized int consumeSantaFromStock(int nombre) {
        int returnCode = 1; // 1 = stock is empty

        if (stock.size() >= nombre) { // If stock is not empty
            for (int i = 0; i < nombre; i++) { // Consumes X santas
                System.out.println("Santa n°" + stock.get(stock.size() - 1).serialNumber + " consumed.");
                stock.remove(stock.size() - 1); // Removes the santa
            }
            notifyAll(); // Notifies the producers
            returnCode = 0; // 0 = stock is not empty
        }

        return returnCode;
    }
}
