package hw_12;

public class Main {
    public static void main(String[] args) {
        String[] flights = {"SU-123", "TK-777", "KC-909", "AE-404"};
        BaggageDropDesk desk = new BaggageDropDesk(flights);

        // 1. Успешная сдача
        System.out.println("--- Scenario 1: Success ---");
        try {
            BaggageTicket ticket = desk.dropBaggage("Ivan Petrov", "SU-123", 18);
            System.out.println("Ticket issued: " + ticket);
        } catch (FlightNotFoundException e) {
            System.out.println("Flight not found: " + e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println("Overweight: " + e.getMessage());
        } catch (BaggageTagPrintException e) {
            System.out.println("Print error: " + e.getMessage());
        } catch (InvalidPassengerNameException e) {
            System.out.println("Invalid name: " + e.getMessage());
        } catch (InvalidBaggageWeightException e) {
            System.out.println("Invalid weight: " + e.getMessage());
        } catch (AirportServiceException e) {
            System.out.println("Airport service error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

        // 2. Рейс не найден
        System.out.println("\n--- Scenario 2: Flight not found ---");
        try {
            desk.dropBaggage("Ivan Petrov", "XX-999", 18);
        } catch (FlightNotFoundException e) {
            System.out.println("Flight not found: " + e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println("Overweight: " + e.getMessage());
        } catch (BaggageTagPrintException e) {
            System.out.println("Print error: " + e.getMessage());
        } catch (InvalidPassengerNameException e) {
            System.out.println("Invalid name: " + e.getMessage());
        } catch (InvalidBaggageWeightException e) {
            System.out.println("Invalid weight: " + e.getMessage());
        } catch (AirportServiceException e) {
            System.out.println("Airport service error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

        // 3. Перевес
        System.out.println("\n--- Scenario 3: Overweight ---");
        try {
            desk.dropBaggage("Ivan Petrov", "SU-123", 30);
        } catch (FlightNotFoundException e) {
            System.out.println("Flight not found: " + e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println("Overweight: " + e.getMessage());
        } catch (BaggageTagPrintException e) {
            System.out.println("Print error: " + e.getMessage());
        } catch (InvalidPassengerNameException e) {
            System.out.println("Invalid name: " + e.getMessage());
        } catch (InvalidBaggageWeightException e) {
            System.out.println("Invalid weight: " + e.getMessage());
        } catch (AirportServiceException e) {
            System.out.println("Airport service error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

        // 4. Проблема печати
        System.out.println("\n--- Scenario 4: Print failure ---");
        try {
            desk.dropBaggage("Ivan Petrov", "AE-404", 18);
        } catch (FlightNotFoundException e) {
            System.out.println("Flight not found: " + e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println("Overweight: " + e.getMessage());
        } catch (BaggageTagPrintException e) {
            System.out.println("Print error: " + e.getMessage());
        } catch (InvalidPassengerNameException e) {
            System.out.println("Invalid name: " + e.getMessage());
        } catch (InvalidBaggageWeightException e) {
            System.out.println("Invalid weight: " + e.getMessage());
        } catch (AirportServiceException e) {
            System.out.println("Airport service error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

        // 5. Некорректное имя (null)
        System.out.println("\n--- Scenario 5: Invalid name (null) ---");
        try {
            desk.dropBaggage(null, "SU-123", 18);
        } catch (FlightNotFoundException e) {
            System.out.println("Flight not found: " + e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println("Overweight: " + e.getMessage());
        } catch (BaggageTagPrintException e) {
            System.out.println("Print error: " + e.getMessage());
        } catch (InvalidPassengerNameException e) {
            System.out.println("Invalid name: " + e.getMessage());
        } catch (InvalidBaggageWeightException e) {
            System.out.println("Invalid weight: " + e.getMessage());
        } catch (AirportServiceException e) {
            System.out.println("Airport service error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

        // 6. Отрицательный вес
        System.out.println("\n--- Scenario 6: Invalid weight (negative) ---");
        try {
            desk.dropBaggage("Ivan Petrov", "SU-123", -5);
        } catch (FlightNotFoundException e) {
            System.out.println("Flight not found: " + e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println("Overweight: " + e.getMessage());
        } catch (BaggageTagPrintException e) {
            System.out.println("Print error: " + e.getMessage());
        } catch (InvalidPassengerNameException e) {
            System.out.println("Invalid name: " + e.getMessage());
        } catch (InvalidBaggageWeightException e) {
            System.out.println("Invalid weight: " + e.getMessage());
        } catch (AirportServiceException e) {
            System.out.println("Airport service error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }
}