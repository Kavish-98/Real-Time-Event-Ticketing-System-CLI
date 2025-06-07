import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Configuration config = new Configuration();
        config.saveConfiguration("config.json");

        // Load and display the saved configuration
        Configuration loadedConfig = Configuration.loadConfiguration("config.json");
        if (loadedConfig != null) {
            System.out.println("\nLoaded Configuration");
            System.out.println(loadedConfig);

            // Step 1: System Configuration
            System.out.println("Welcome to the Real-Time Ticketing System!");
            config.setupConfiguration(scanner);

            // Create the TicketPool
            TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());

            // Step 2: Start Ticket Handling
            System.out.println("Type 'start' to begin or 'exit' to stop the application.");
            while (true) {
                String command = scanner.nextLine().trim().toLowerCase();
                if (command.equals("start")) {
                    System.out.println("Starting the ticket system...");
                    Vendor vendor = new Vendor(config.getTicketReleaseRate(), ticketPool, config.getTotalTickets());
                    Customer customer = new Customer(config.getCustomerRetrievalRate(), ticketPool);

                    Thread vendorThread = new Thread(vendor);
                    Thread customerThread = new Thread(customer);

                    vendorThread.start();
                    customerThread.start();

                    System.out.println("Type 'stop' to terminate the system.");
                    String stopCommand = scanner.nextLine().trim().toLowerCase();
                    if (stopCommand.equals("stop")) {
                        vendor.stop();
                        customer.stop();
                        try {
                            vendorThread.join();
                            customerThread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                } else if (command.equals("exit")) {
                    System.out.println("Exiting the system...");
                    break;
                } else {
                    System.out.println("Invalid command. Please type 'start' or 'exit'.");
                }
            }
            scanner.close();
            System.out.println("System terminated.");
        }
    }
}



