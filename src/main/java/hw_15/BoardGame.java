package hw_15;

public class BoardGame {
    private final String name;
    private final int minAge;
    private final int pricePerDay;
    private boolean isRented;

    public BoardGame(String name, int minAge, int pricePerDay) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (minAge < 0) {
            throw new IllegalArgumentException("Minimum age cannot be negative");
        }
        if (pricePerDay <= 0) {
            throw new IllegalArgumentException("Price per day must be positive");
        }
        this.name = name;
        this.minAge = minAge;
        this.pricePerDay = pricePerDay;
        this.isRented = false;
    }

    public String getName() {
        return name;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean canBeRentedBy(int age) {
        return age >= minAge;
    }
}