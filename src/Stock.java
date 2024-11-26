import java.util.ArrayList;

public class Stock {
    int stockMax = 100;
    ArrayList<PereNoel> stock = new ArrayList<>();

    public Stock() {}

    public synchronized int ajouter(PereNoel pereNoel) {
        int codeRetour = 1;

        if (stock.size() < stockMax) {
            stock.add(pereNoel);
            notify();
            codeRetour = 0;
        }

        return codeRetour;
    }

    public synchronized int retirer(int nombre) {
        int codeRetour = 1;

        if (stock.size() >= nombre) {
            for (int i = 0; i < nombre; i++) {
                System.out.println("Père Noël n°" + stock.get(stock.size() - 1).numeroDeSerie + " acheté.");
                stock.remove(stock.size() - 1);
                System.out.println("Nombre de pères Noël dans le stock : " + stock.size());
            }
            notify();
            codeRetour = 0;
        }

        return codeRetour;
    }
}
