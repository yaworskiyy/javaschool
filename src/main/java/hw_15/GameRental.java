package hw_15;

import java.util.HashMap;
import java.util.Map;

public class GameRental {
    private final Map<String, BoardGame> catalog = new HashMap<>();

    public void addGame(BoardGame game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        String key = game.getName().toLowerCase();
        if (catalog.containsKey(key)) {
            throw new IllegalArgumentException("Game with this name already exists");
        }
        catalog.put(key, game);
    }

    public BoardGame findGame(String name) {
        if (name == null) return null;
        return catalog.get(name.toLowerCase());
    }

    public boolean rentGame(String name, int customerAge) {
        BoardGame game = findGame(name);
        if (game == null) {
            throw new IllegalArgumentException("Game not found");
        }
        if (!game.canBeRentedBy(customerAge)) {
            return false;
        }
        if (game.isRented()) {
            return false;
        }
        game.setRented(true);
        return true;
    }

    public boolean returnGame(String name) {
        BoardGame game = findGame(name);
        if (game == null) {
            return false;
        }
        if (!game.isRented()) {
            return false;
        }
        game.setRented(false);
        return true;
    }

    public int calculateCost(String name, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be positive");
        }
        BoardGame game = findGame(name);
        if (game == null) {
            throw new IllegalArgumentException("Game not found");
        }
        return game.getPricePerDay() * days;
    }

    public void reset() {
        for (BoardGame game : catalog.values()) {
            game.setRented(false);
        }
    }
}