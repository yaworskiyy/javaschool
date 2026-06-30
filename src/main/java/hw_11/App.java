package hw_11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите количество воды (мл): ");
            int waterInput = scanner.nextInt();
            System.out.println("Вы ввели: " + waterInput + " мл");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: нужно было ввести число");
        }

        try {
            coffeeMachine.makeCoffee(100);
        } catch (NotEnoughWaterException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка кофемашины завершена");
        }

        try {
            coffeeMachine.calculateCups(1000, 0);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: размер чашки не может быть 0");
        }

        String nullCoffeeName = null;
        try {
            coffeeMachine.printCoffeeName(nullCoffeeName);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: название кофе отсутствует");
        }

        scanner.close();
    }
}