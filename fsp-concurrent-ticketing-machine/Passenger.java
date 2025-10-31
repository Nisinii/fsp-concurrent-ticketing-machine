// W. A. Nisini Niketha | w1809840 | 20191213

public class Passenger implements Runnable {
    private final TicketMachine w1809840_ticketMachine;
    private final Ticket w1809840_ticket;

    // Parameterized constructor
    public Passenger(TicketMachine w1809840_ticketMachine, Ticket w1809840_ticket) {
        this.w1809840_ticketMachine = w1809840_ticketMachine;
        this.w1809840_ticket = w1809840_ticket;
    }

    // Getters
    public Ticket getW1809840_ticket() {
        return w1809840_ticket;
    }

    // Overriding the run() method from Runnable interface
    @Override
    public void run() {
        // Calling the printTicket() method from TicketMachine class
        w1809840_ticketMachine.printTicket(this.w1809840_ticket);
        try {
            Thread.sleep((int) (Math.random() * 5000)); // Sleep for a random time between 0 and 5 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
