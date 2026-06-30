package hw_11;

public class CoffeeMachine {

    public void makeCoffee(int waterAmount) {
        if (waterAmount <= 200) {
            throw new NotEnoughWaterException(
                    "Недостаточно воды для приготовления кофе. " +
                            "Требуется больше 200 мл, текущее количество: " + waterAmount + " мл"
            );
        }
        System.out.println("Кофе приготовлен!");
    }

    public int calculateCups(int waterAmount, int cupSize) {
        return waterAmount / cupSize;
    }

    public void printCoffeeName(String coffeeName) {
        System.out.println(coffeeName.toUpperCase());
    }
}