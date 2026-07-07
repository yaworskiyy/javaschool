package hw_12;

public class BaggageDropDesk {
    private final String[] availableFlights;

    public BaggageDropDesk(String[] availableFlights) {
        this.availableFlights = availableFlights;
    }

    public BaggageTicket dropBaggage(String passengerName, String flightNumber, int weight)
            throws AirportServiceException {

        // Проверка имени
        if (passengerName == null || passengerName.trim().isEmpty()) {
            throw new InvalidPassengerNameException("Passenger name cannot be null or empty");
        }

        // Проверка веса
        if (weight <= 0) {
            throw new InvalidBaggageWeightException("Baggage weight must be positive");
        }

        // Проверка существования рейса
        boolean flightExists = false;
        for (String f : availableFlights) {
            if (f.equals(flightNumber)) {
                flightExists = true;
                break;
            }
        }
        if (!flightExists) {
            throw new FlightNotFoundException("Flight " + flightNumber + " not found");
        }

        // Проверка перевеса
        if (weight > 23) {
            throw new OverweightBaggageException("Baggage weight exceeds 23 kg: " + weight);
        }

        // Имитация проблемы с печатью бирки
        if ("AE-404".equals(flightNumber)) {
            throw new BaggageTagPrintException("Printer failed for flight " + flightNumber);
        }

        // Все хорошо – выдаем бирку
        BaggageTicket ticket = new BaggageTicket(passengerName, flightNumber, weight);
        System.out.println("Please pay the tax for too correct data: 0 rubles.");
        return ticket;
    }
}