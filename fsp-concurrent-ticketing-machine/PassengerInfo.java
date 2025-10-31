// W. A. Nisini Niketha | w1809840 | 20191213

public class PassengerInfo {
    private final String w1809840_passengerName;
    private String w1809840_phoneNumber;
    private String w1809840_emailAddress;

    // Parameterized constructor
    public PassengerInfo(String w1809840_passengerName, String w1809840_phoneNumber, String w1809840_emailAddress) {
        this.w1809840_passengerName = w1809840_passengerName;
        this.w1809840_phoneNumber = w1809840_phoneNumber;
        this.w1809840_emailAddress = w1809840_emailAddress;
    }

    // Getters and setters
    public String getW1809840_passengerName() {
        return w1809840_passengerName;
    }

    public String getW1809840_phoneNumber() {
        return w1809840_phoneNumber;
    }

    public void setW1809840_phoneNumber(String w1809840_phoneNumber) {
        this.w1809840_phoneNumber = w1809840_phoneNumber;
    }

    public String getW1809840_emailAddress() {
        return w1809840_emailAddress;
    }

    public void setW1809840_emailAddress(String w1809840_emailAddress) {
        this.w1809840_emailAddress = w1809840_emailAddress;
    }

    // toString() method to print the object
    @Override
    public String toString() {
        return "\n\t\tUserID : " + w1809840_passengerName
                + "\n\t\tPhone Number : " + w1809840_phoneNumber
                + "\n\t\tEmail Address : " + w1809840_emailAddress;
    }
}
