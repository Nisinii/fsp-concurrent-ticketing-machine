// W. A. Nisini Niketha | w1809840 | 20191213

public class TicketPaperTechnician implements Runnable{

    private final TicketMachine w1809840_ticketMachine;
    private final String w1809840_paperTechnicianName;

    // Parameterized constructor
    public TicketPaperTechnician(TicketMachine w1809840_ticketMachine, String w1809840_paperTechnicianName) {
        this.w1809840_ticketMachine = w1809840_ticketMachine;
        this.w1809840_paperTechnicianName = w1809840_paperTechnicianName;
    }

    // Getters
    public String getW1809840_paperTechnicianName() {
        return w1809840_paperTechnicianName;
    }

    // Overriding the run() method from Runnable interface
    @Override
    public void run() {
        // Calling the refillTicketPaper() method from TicketMachine class
        // Attempt to refill paper for 3 times
        for (int i = 0; i < Constants.NUMBER_OF_ATTEMPTS; i++) {

            // If the paper level is less than the minimum paper level, then refill the paper
            if(w1809840_ticketMachine.getPaperLevel() < Constants.MINIMUM_PAPER_LEVEL){
                w1809840_ticketMachine.refillTicketPaper();
            }

            try {
                Thread.sleep((int) (Math.random() * 5000)); // Sleep for a random time between 0 and 5 seconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
