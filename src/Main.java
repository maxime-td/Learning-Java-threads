import java.util.Scanner;


public class Main {

    public static int exitNumber = 1;
    static Scanner scanner;

    static int producersNumber; // Number of producers
    static int consumersNumber; // Number of consumers


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
        for (int i = 0; i < producersNumber; i++) {
            Producteur producteur = new Producteur(stock); // Creation of producer i
            producteur.start(); // Start of producer i
        }
        System.out.println(producersNumber + " producers created.");


        // Consumers creation
        for (int j = 0; j < consumersNumber; j++) {
            Consommateur consommateur = new Consommateur(stock); // Creation of consumer j
            consommateur.start(); // Start of consumer j
        }
        System.out.println(consumersNumber + " consumers created.");


        System.out.println("Enter 0 to exit.");
        exitNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Stopping threads...");
    }



    public static void main(String[] args) {

        // Scanner initialisation
        scanner = new Scanner(System.in);


        try {
            // Parse producers number
            printProducers();
            producersNumber = Integer.parseInt(scanner.nextLine());

            if (producersNumber < 0) { // Invalid number
                System.out.println("Invalid number.");

            } else if (producersNumber == 0) { // Exit number
                System.out.println("Good bye!");

            } else { // Valid number

                try {
                    // Parse consumers number
                    printConsumers();
                    consumersNumber = Integer.parseInt(scanner.nextLine());

                    if (consumersNumber < 0) { // Invalid number
                        System.out.println("Invalid number.");

                    } else if (consumersNumber == 0) { // Exit number
                        System.out.println("Good bye!");

                    } else { // Valid number


                        // Run program
                        run();

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