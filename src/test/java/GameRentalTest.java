import hw_15.BoardGame;
import hw_15.GameRental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRentalTest {
    private GameRental rental;
    private BoardGame monopoly;
    private BoardGame chess;

    @BeforeEach
    void setUp() {
        rental = new GameRental();
        monopoly = new BoardGame("Monopoly", 8, 5);
        chess = new BoardGame("Chess", 6, 3);
        rental.addGame(monopoly);
        rental.addGame(chess);
    }

    @Test
    void shouldAddGameSuccessfully() {
        BoardGame newGame = new BoardGame("Scrabble", 10, 4);
        rental.addGame(newGame);
        assertEquals(newGame, rental.findGame("Scrabble"));
    }

    @Test
    void shouldThrowWhenAddingNullGame() {
        assertThrows(IllegalArgumentException.class,
                () -> rental.addGame(null));
    }

    @Test
    void shouldThrowWhenAddingDuplicateGameName() {
        BoardGame duplicate = new BoardGame("Monopoly", 8, 6);
        assertThrows(IllegalArgumentException.class,
                () -> rental.addGame(duplicate));
    }

    @Test
    void shouldFindGameByName() {
        assertEquals(monopoly, rental.findGame("Monopoly"));
        assertEquals(chess, rental.findGame("Chess"));
        assertNull(rental.findGame("Unknown"));
    }

    @Test
    void shouldRentGameSuccessfully() {
        assertTrue(rental.rentGame("Monopoly", 10));
        assertTrue(monopoly.isRented());
    }

    @Test
    void shouldNotRentIfAgeTooLow() {
        assertFalse(rental.rentGame("Monopoly", 7));
        assertFalse(monopoly.isRented());
    }

    @Test
    void shouldNotRentIfAlreadyRented() {
        rental.rentGame("Monopoly", 10);
        assertFalse(rental.rentGame("Monopoly", 12));
        assertTrue(monopoly.isRented()); // remains rented
    }

    @Test
    void shouldThrowIfRentingNonexistentGame() {
        assertThrows(IllegalArgumentException.class,
                () -> rental.rentGame("Unknown", 10));
    }

    @Test
    void shouldReturnGameSuccessfully() {
        rental.rentGame("Chess", 10);
        assertTrue(rental.returnGame("Chess"));
        assertFalse(chess.isRented());
    }

    @Test
    void shouldReturnFalseIfGameNotRented() {
        assertFalse(rental.returnGame("Monopoly"));
        assertFalse(monopoly.isRented());
    }

    @Test
    void shouldReturnFalseIfGameNotFound() {
        assertFalse(rental.returnGame("Unknown"));
    }

    @Test
    void shouldResetAllGames() {
        rental.rentGame("Monopoly", 10);
        rental.rentGame("Chess", 10);
        rental.reset();
        assertFalse(monopoly.isRented());
        assertFalse(chess.isRented());
    }
}