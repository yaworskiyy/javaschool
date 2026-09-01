package hw_20.steps;

import hw_20.Calculator;
import io.qameta.allure.Allure;

public class CalculatorSteps {

    private final Calculator calculator = new Calculator();

    public double add(double a, double b) {
        return Allure.step(String.format("Сложить %s + %s", a, b), () -> {
            double result = calculator.add(a, b);
            attachCalculation(a, "+", b, result);
            return result;
        });
    }

    public double subtract(double a, double b) {
        return Allure.step(String.format("Вычесть %s - %s", a, b), () -> {
            double result = calculator.subtract(a, b);
            attachCalculation(a, "-", b, result);
            return result;
        });
    }

    public double multiply(double a, double b) {
        return Allure.step(String.format("Умножить %s * %s", a, b), () -> {
            double result = calculator.multiply(a, b);
            attachCalculation(a, "*", b, result);
            return result;
        });
    }

    public double divide(double a, double b) {
        return Allure.step(String.format("Разделить %s / %s", a, b), () -> {
            double result = calculator.divide(a, b);
            attachCalculation(a, "/", b, result);
            return result;
        });
    }

    public double power(double base, double exponent) {
        return Allure.step(String.format("Возвести %s в степень %s", base, exponent), () -> {
            double result = calculator.power(base, exponent);
            attachCalculation(base, "^", exponent, result);
            return result;
        });
    }

    public double sqrt(double value) {
        return Allure.step(String.format("Извлечь квадратный корень из %s", value), () -> {
            double result = calculator.sqrt(value);
            Allure.addAttachment("Вычисление",
                    String.format("sqrt(%s) = %s", value, result));
            return result;
        });
    }

    public void verifyResult(double actual, double expected) {
        Allure.step(String.format("Проверить результат: %s == %s", actual, expected), () -> {
            Allure.parameter("actual", String.valueOf(actual));
            Allure.parameter("expected", String.valueOf(expected));
            if (actual != expected) {
                throw new AssertionError(
                        String.format("Ожидалось %s, но получено %s", expected, actual));
            }
        });
    }

    private void attachCalculation(double a, String op, double b, double result) {
        Allure.addAttachment("Вычисление",
                String.format("%s %s %s = %s", a, op, b, result));
    }
}
