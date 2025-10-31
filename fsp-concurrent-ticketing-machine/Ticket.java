// W. A. Nisini Niketha | w1809840 | 20191213

public class Ticket {
    private final int w1809840_ticketNumber;
    private final int w1809840_ticketPrice;
    private final PassengerInfo w1809840_passengerInfo;
    private final TravelInfo w1809840_travelInfo;

    // Parameterized constructor
    public Ticket(int w1809840_ticketNumber, int w1809840_ticketPrice, PassengerInfo w1809840_passengerInfo, TravelInfo w1809840_travelInfo) {
        this.w1809840_ticketNumber = w1809840_ticketNumber;
        this.w1809840_ticketPrice = w1809840_ticketPrice;
        this.w1809840_passengerInfo = w1809840_passengerInfo;
        this.w1809840_travelInfo = w1809840_travelInfo;
    }

    // Getters
    public int getW1809840_ticketNumber() {
        return w1809840_ticketNumber;
    }

    public int getW1809840_ticketPrice() {
        return w1809840_ticketPrice;
    }

    public PassengerInfo getW1809840_passengerInfo() {
        return w1809840_passengerInfo;
    }

    public TravelInfo getW1809840_travelInfo() {
        return w1809840_travelInfo;
    }

    // toString() method to print the object
    @Override
    public String toString() {
        return "Ticket Details"
                + "\n\tTicket Number : " + w1809840_ticketNumber
                + "\n\tTicket Price : " + w1809840_ticketPrice
                + "\n\tPassenger Info " + w1809840_passengerInfo
                + "\n\tTravel Info " + w1809840_travelInfo;
    }
}
