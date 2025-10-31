// W. A. Nisini Niketha | w1809840 | 20191213

public class TravelInfo {
    private final String w1809840_destination;
    private final String w1809840_departureLocation;
    private final String w1809840_date;
    private final String w1809840_time;

    // Parameterized constructor
    public TravelInfo(String w1809840_destination, String w1809840_departureLocation, String w1809840_date, String w1809840_time) {
        this.w1809840_destination = w1809840_destination;
        this.w1809840_departureLocation = w1809840_departureLocation;
        this.w1809840_date = w1809840_date;
        this.w1809840_time = w1809840_time;
    }

    // Getters
    public String getW1809840_destination() {
        return w1809840_destination;
    }

    public String getW1809840_departureLocation() {
        return w1809840_departureLocation;
    }

    public String getW1809840_date() {
        return w1809840_date;
    }

    public String getW1809840_time() {
        return w1809840_time;
    }

    // toString() method to print the object
    @Override
    public String toString() {
        return "\n\t\tDestination : " + w1809840_destination
                + "\n\t\tDeparture Location : " + w1809840_departureLocation
                + "\n\t\tDate : " + w1809840_date
                + "\n\t\tTime : " + w1809840_time;
    }
}
