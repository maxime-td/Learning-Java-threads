public class Main {

    public static void main(String[] args) {

        // Initialisations
        int ProducersNumber = 50; // Number of producers
        int ConsumersNumber = 2; // Number of consumers

        Stock stock = new Stock(); // Stock creation


        // Producers creation
        for (int i = 0; i < ProducersNumber; i++) {
            Producteur producteur = new Producteur(stock); // Creation of producer i
            producteur.start(); // Start of producer i
        }
        System.out.println(ProducersNumber + " producers created.");


        // Consumers creation
        for (int i = 0; i < ConsumersNumber; i++) {

            Consommateur consommateur = new Consommateur(stock); // Creation of consumer i
            consommateur.start(); // Start of consumer i
        }
        System.out.println(ConsumersNumber + " consumers created.");


    }
}
