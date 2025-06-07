import java.math.BigDecimal;

public class Vendor implements Runnable {
    private final int totalTickets; // Tickets willing to sell
    private final int ticketReleaseRate; // Frequency of releasing
    private final TicketPool ticketPool; // Shared resource between Vendors and Customers

    private volatile boolean running = true;

    public Vendor(int releaseRate, TicketPool ticketPool, int totalTickets) {
        this.ticketReleaseRate = releaseRate;
        this.ticketPool = ticketPool;
        this.totalTickets = totalTickets;
    }

    @Override
    public void run() {
        for (int i = 1; i <= totalTickets && running; i++) {
            try {
                Ticket ticket = new Ticket(i,"Simple Event",new BigDecimal(1000),"Lotus Tower","2024-12-31");
                ticketPool.addTicket(ticket);
                Thread.sleep(1000 / ticketReleaseRate);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop() {
        running = false;
    }
}

