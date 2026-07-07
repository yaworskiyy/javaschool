package hw_12;

public class BaggageTicket {
    private final String passengerName;
    private final String flightNumber;
    private final int weight;

    public BaggageTicket(String passengerName, String flightNumber, int weight) {
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.weight = weight;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "BaggageTicket{" +
                "passengerName='" + passengerName + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", weight=" + weight +
                '}';
    }
}
