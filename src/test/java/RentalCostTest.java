import hw_15.BoardGame;
import hw_15.GameRental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalCostTest {
    private GameRental rental;

    @BeforeEach
    void setUp() {
        rental = new GameRental();
        rental.addGame(new BoardGame("Monopoly", 8, 5));
        rental.addGame(new BoardGame("Chess", 6, 3));
    }

    @Test
    void shouldCalculateCorrectCost() {
        assertEquals(15, rental.calculateCost("Monopoly", 3));
        assertEquals(6, rental.calculateCost("Chess", 2));
    }

    @Test
    void shouldThrowWhenDaysNonPositive() {
        assertThrows(IllegalArgumentException.class,
                () -> rental.calculateCost("Monopoly", 0));
        assertThrows(IllegalArgumentException.class,
                () -> rental.calculateCost("Monopoly", -1));
    }

    @Test
    void shouldThrowWhenGameNotFound() {
        assertThrows(IllegalArgumentException.class,
                () -> rental.calculateCost("Unknown", 2));
    }
}