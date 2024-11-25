import java.util.ArrayList;

public class Stock {
    int stockMax = 100;
    ArrayList<PereNoel> stock = new ArrayList<>();

    public Stock() {}

    public int ajouter(PereNoel pereNoel) {
        int codeRetour = 1;

        if (stock.size() < stockMax) {
            stock.add(pereNoel);
            codeRetour = 0;
        }

        return codeRetour;
    }

    public int retirer(int nombre) {
        int codeRetour = 1;

        if (stock.size() >= nombre) {
            for (int i = 0; i < nombre; i++) {
                stock.remove(stock.size() - 1);
            }
            codeRetour = 0;
        }

        return codeRetour;
    }
}
