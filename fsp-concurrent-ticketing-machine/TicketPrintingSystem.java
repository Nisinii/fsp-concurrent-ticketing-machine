// W. A. Nisini Niketha | w1809840 | 20191213

public class TicketPrintingSystem {
    public static void main(String[] args){

        // Creating the PassengerInfo objects
        PassengerInfo w1809840_passengerInfo1 = new PassengerInfo("Rachel Green", "+61248393943", "rachel@gmail.com");
        PassengerInfo w1809840_passengerInfo2 = new PassengerInfo("Sofia Dunphy", "+61473729492", "sofia@gmail.com");
        PassengerInfo w1809840_passengerInfo3 = new PassengerInfo("Mike Ross", "+61978472932", "mike@gmail.com");
        PassengerInfo w1809840_passengerInfo4 = new PassengerInfo("Jerry Tyson", "+61385749384", "jerry@gmail.com");

        // Creating the TravelInfo objects
        TravelInfo w1809840_travelInfo1 = new TravelInfo("Sydney", "Perth", "2024-01-10", "11.00 AM");
        TravelInfo w1809840_travelInfo2 = new TravelInfo("Sydney", "Melbourne", "2024-01-12", "08.00 AM");
        TravelInfo w1809840_travelInfo3 = new TravelInfo("Perth", "Adelaide", "2024-01-08", "04.00 PM");
        TravelInfo w1809840_travelInfo4 = new TravelInfo("Melbourne", "Adelaide", "2024-01-15", "06.00 PM");

        // Creating the Ticket objects
        Ticket w1809840_ticket1 = new Ticket(1, 1000, w1809840_passengerInfo1, w1809840_travelInfo1);
        Ticket w1809840_ticket2 = new Ticket(2, 1500, w1809840_passengerInfo2, w1809840_travelInfo2);
        Ticket w1809840_ticket3 = new Ticket(3, 2000, w1809840_passengerInfo3, w1809840_travelInfo3);
        Ticket w1809840_ticket4 = new Ticket(4, 1800, w1809840_passengerInfo4, w1809840_travelInfo4);

        // Creating the TicketMachine object
        TicketMachine w1809840_ticketMachine = new TicketMachine(Constants.MINIMUM_PAPER_LEVEL, Constants.MINIMUM_TONER_LEVEL);

        // Creating the Passenger objects
        Passenger w1809840_passenger1 = new Passenger(w1809840_ticketMachine, w1809840_ticket1);
        Passenger w1809840_passenger2 = new Passenger(w1809840_ticketMachine, w1809840_ticket2);
        Passenger w1809840_passenger3 = new Passenger(w1809840_ticketMachine, w1809840_ticket3);
        Passenger w1809840_passenger4 = new Passenger(w1809840_ticketMachine, w1809840_ticket4);

        // Creating the Technician objects
        TicketTonerTechnician w1809840_ticketTonerTechnician = new TicketTonerTechnician(w1809840_ticketMachine, "Toner Technician");
        TicketPaperTechnician w1809840_ticketPaperTechnician = new TicketPaperTechnician(w1809840_ticketMachine, "Paper Technician");

        //Creating thread groups
        ThreadGroup w1809840_passengerThreadGroup = new ThreadGroup("Passenger Thread Group");
        ThreadGroup w1809840_technicianThreadGroup = new ThreadGroup("Technician Thread Group");

        w1809840_passengerThreadGroup.setMaxPriority(Thread.MAX_PRIORITY);
        w1809840_technicianThreadGroup.setMaxPriority(Thread.NORM_PRIORITY);

        //Creating the passenger threads
        Thread w1809840_passengerThread1 = new Thread(w1809840_passengerThreadGroup, w1809840_passenger1, w1809840_passenger1.getW1809840_ticket().getW1809840_passengerInfo().getW1809840_passengerName());
        Thread w1809840_passengerThread2 = new Thread(w1809840_passengerThreadGroup, w1809840_passenger2, w1809840_passenger2.getW1809840_ticket().getW1809840_passengerInfo().getW1809840_passengerName());
        Thread w1809840_passengerThread3 = new Thread(w1809840_passengerThreadGroup, w1809840_passenger3, w1809840_passenger3.getW1809840_ticket().getW1809840_passengerInfo().getW1809840_passengerName());
        Thread w1809840_passengerThread4 = new Thread(w1809840_passengerThreadGroup, w1809840_passenger4, w1809840_passenger4.getW1809840_ticket().getW1809840_passengerInfo().getW1809840_passengerName());

        //Creating the technician threads
        Thread w1809840_tonerTechnicianThread = new Thread(w1809840_technicianThreadGroup, w1809840_ticketTonerTechnician, w1809840_ticketTonerTechnician.getW1809840_tonerTechnicianName());
        Thread w1809840_paperTechnicianThread = new Thread(w1809840_technicianThreadGroup, w1809840_ticketPaperTechnician, w1809840_ticketPaperTechnician.getW1809840_paperTechnicianName());

        //Starting the threads
        w1809840_passengerThread1.start();
        w1809840_passengerThread2.start();
        w1809840_passengerThread3.start();
        w1809840_passengerThread4.start();

        w1809840_tonerTechnicianThread.start();
        w1809840_paperTechnicianThread.start();

        try {
            // Waiting for all threads to complete execution
            w1809840_passengerThread1.join();
            w1809840_passengerThread2.join();
            w1809840_passengerThread3.join();
            w1809840_passengerThread4.join();

            w1809840_paperTechnicianThread.join();
            w1809840_tonerTechnicianThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing final Ticket Machine status
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("Final Ticket Machine Status");
        System.out.println("Paper Level : " + w1809840_ticketMachine.getPaperLevel());
        System.out.println("Toner Level : " + w1809840_ticketMachine.getTonerLevel());
        System.out.println("---------------------------------------------------------------\n");
    }
}