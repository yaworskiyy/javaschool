import hw_15.BoardGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BoardGameTest {
    private BoardGame game;

    @BeforeEach
    void setUp() {
        game = new BoardGame("Monopoly", 8, 5);
    }

    @Test
    void shouldCreateGameWithValidParameters() {
        assertEquals("Monopoly", game.getName());
        assertEquals(8, game.getMinAge());
        assertEquals(5, game.getPricePerDay());
        assertFalse(game.isRented());
    }

    @Test
    void shouldThrowWhenNameIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame(null, 8, 5));
    }

    @Test
    void shouldThrowWhenNameIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame("", 8, 5));
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame("   ", 8, 5));
    }

    @Test
    void shouldThrowWhenMinAgeNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame("Chess", -1, 5));
    }

    @Test
    void shouldThrowWhenPriceNonPositive() {
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame("Chess", 8, 0));
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame("Chess", 8, -5));
    }

    @ParameterizedTest
    @CsvSource({
            "5, false",
            "8, true",
            "10, true"
    })
    void testCanBeRentedBy(int customerAge, boolean expected) {
        assertEquals(expected, game.canBeRentedBy(customerAge));
    }

    @ParameterizedTest
    @MethodSource("invalidGameDataProvider")
    void shouldThrowOnInvalidCreation(String name, int minAge, int price) {
        assertThrows(IllegalArgumentException.class,
                () -> new BoardGame(name, minAge, price));
    }

    static Stream<Object[]> invalidGameDataProvider() {
        return Stream.of(
                new Object[]{null, 8, 5},
                new Object[]{"", 8, 5},
                new Object[]{"   ", 8, 5},
                new Object[]{"Chess", -1, 5},
                new Object[]{"Chess", 8, 0},
                new Object[]{"Chess", 8, -3}
        );
    }
}