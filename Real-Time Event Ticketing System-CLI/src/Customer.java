public class Customer implements Runnable {
    private final int retrievalRate;
    private final TicketPool ticketPool;
    private volatile boolean running = true;

    public Customer(int retrievalRate, TicketPool ticketPool) {
        this.retrievalRate = retrievalRate;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        while (running) {
            try {
                ticketPool.removeTicket();
                Thread.sleep(1000 / retrievalRate);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop() {
        running = false;
    }
}
