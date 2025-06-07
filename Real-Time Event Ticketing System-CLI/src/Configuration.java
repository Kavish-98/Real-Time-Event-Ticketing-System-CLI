import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Scanner;

public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public void setupConfiguration(Scanner scanner) {

        System.out.println("Welcome to the System Configuration Interface\n");

        // Get Total Number of Tickets
        totalTickets = getValidInput(scanner, "Enter the total number of tickets: ");

        // Get Maximum Ticket Capacity
        maxTicketCapacity = getValidInput(scanner, "Enter the maximum ticket capacity: ");

        // Get Ticket Release Rate
        ticketReleaseRate = getValidInput(scanner, "Enter the ticket release rate (tickets per second): ", totalTickets, maxTicketCapacity);

        // Get Customer Retrieval Rate
        customerRetrievalRate = getValidInput(scanner, "Enter the customer retrieval rate (tickets per second): ", totalTickets, maxTicketCapacity);

        System.out.println("\nConfiguration complete! Here are the configured parameters:");
        System.out.println("Total Tickets: " + totalTickets);
        System.out.println("Maximum Ticket Capacity: " + maxTicketCapacity);
        System.out.println("Ticket Release Rate: " + ticketReleaseRate);
        System.out.println("Customer Retrieval Rate: " + customerRetrievalRate);


    }

    private int getValidInput(Scanner scanner, String prompt) {
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine().trim());

                if (input > 0) {
                    return input;
                } else {
                    System.out.println("Error: Please enter a value greater than 0.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid integer.\n");
            }
        }
    }

    private int getValidInput(Scanner scanner, String prompt, int totalTickets, int maxCapacity) {
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine().trim());

                if (input > 0 && input <= totalTickets && input <= maxCapacity) {
                    return input;
                } else {
                    System.out.println("Error: Please enter a value greater than 0 and less than or equal to both total tickets and maximum capacity.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid integer.\n");
            }
        }
    }
    public void saveConfiguration(String fileName) {
        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
            System.out.println("\nConfiguration saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving configuration: " + e.getMessage());
        }
    }
    public static Configuration loadConfiguration(String fileName) {
        try (Reader reader = new FileReader(fileName)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Configuration.class);
        } catch (IOException e) {
            System.out.println("Error loading configuration: " + e.getMessage());
            return null;
        }
    }



    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
    return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
    return customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
    return maxTicketCapacity;
    }
}

