// W. A. Nisini Niketha | w1809840 | 20191213

public class TicketTonerTechnician implements Runnable{

    private final TicketMachine w1809840_ticketMachine;
    private final String w1809840_tonerTechnicianName;

    // Parameterized constructor
    public TicketTonerTechnician(TicketMachine w1809840_ticketMachine, String w1809840_tonerTechnicianName) {
        this.w1809840_ticketMachine = w1809840_ticketMachine;
        this.w1809840_tonerTechnicianName = w1809840_tonerTechnicianName;
    }

    // Getters
    public String getW1809840_tonerTechnicianName() {
        return w1809840_tonerTechnicianName;
    }

    // Overriding the run() method from Runnable interface
    @Override
    public void run() {
        // Calling the replaceTonerCartridge() method from TicketMachine class
         // Attempt to replace toner for 3 times
        for (int i = 0; i < Constants.NUMBER_OF_ATTEMPTS; i++) {

            // If the toner level is less than the minimum toner level, then replace the toner
            if(w1809840_ticketMachine.getTonerLevel() < Constants.MINIMUM_TONER_LEVEL){
                w1809840_ticketMachine.replaceTonerCartridge();
            }

            try {
                Thread.sleep((int) (Math.random() * 5000)); // Sleep for a random time between 0 and 5 seconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
