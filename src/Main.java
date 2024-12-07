import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    static int exitNumber = 1;
    static Scanner scanner;

    static int ProducersNumber; // Number of producers
    private static List<Producteur> producers = new ArrayList<>(); // List of producers

    static int ConsumersNumber; // Number of consumers
    private static List<Consommateur> consumers = new ArrayList<>(); // List of consumers


    public Main() {}


    private static void printProducers() {
        System.out.println("\nHow many producers do you want? Enter 0 to exit.");
        System.out.print("Number of producers: ");
    }

    private static void printConsumers() {
        System.out.println("\nHow many consumers do you want? Enter 0 to exit.");
        System.out.print("Number of consumers: ");
    }


    private static void run() {

        // Initialisation
        Stock stock = new Stock(); // Stock creation

        // Producers creation
        for (int i = 0; i < ProducersNumber; i++) {
            Producteur producteur = new Producteur(stock); // Creation of producer i
            producteur.start(); // Start of producer i
            producers.add(producteur);
        }
        System.out.println(ProducersNumber + " producers created.");


        // Consumers creation
        for (int j = 0; j < ConsumersNumber; j++) {

            Consommateur consommateur = new Consommateur(stock); // Creation of consumer j
            consommateur.start(); // Start of consumer j
            consumers.add(consommateur);
        }
        System.out.println(ConsumersNumber + " consumers created.");


        System.out.println("Enter 0 to exit.");

    }



    public static void main(String[] args) {

        // Initialisations
        scanner = new Scanner(System.in);

        Stock stock = new Stock(); // Stock creation


        try {
            // Parse producers number
            printProducers();
            ProducersNumber = Integer.parseInt(scanner.nextLine());
            System.out.println(ProducersNumber);

            if (ProducersNumber < 0) { // Invalid number
                System.out.println("Invalid number.");

            } else if (ProducersNumber == 0) { // Exit number
                System.out.println("Good bye!");

            } else { // Valid number

                try {
                    // Parse consumers number
                    printConsumers();
                    ConsumersNumber = Integer.parseInt(scanner.nextLine());
                    System.out.println(ConsumersNumber);

                    if (ConsumersNumber < 0) { // Invalid number
                        System.out.println("Invalid number.");

                    } else if (ConsumersNumber == 0) { // Exit number
                        System.out.println("Good bye!");

                    } else { // Valid number


                        // Run program
                        while (exitNumber != 0) {
                            run();
                        }
                    }

                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);

        } finally {
            scanner.close(); // Closes the scanner
        }
    }
}