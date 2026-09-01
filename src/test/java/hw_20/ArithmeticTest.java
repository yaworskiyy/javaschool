package hw_20;

import hw_20.steps.CalculatorSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Epic("Калькулятор")
@Feature("Арифметические операции")
public class ArithmeticTest {

    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Owner("student")
    @Description("Проверяем базовое сложение двух положительных чисел")
    @DisplayName("Сложение двух положительных чисел")
    @Link(name = "Задание 20", url = "https://confluence.moscow.alfaintra.net")
    public void testAddPositiveNumbers() {
        Allure.parameter("a", 2);
        Allure.parameter("b", 3);
        double result = steps.add(2, 3);
        steps.verifyResult(result, 5);
    }

    @Test
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Owner("student")
    @Description("Проверяем сложение с отрицательным числом")
    @DisplayName("Сложение с отрицательным числом")
    public void testAddWithNegativeNumber() {
        Allure.parameter("a", -5);
        Allure.parameter("b", 3);
        double result = steps.add(-5, 3);
        steps.verifyResult(result, -2);
    }

    @Test
    @Story("Вычитание")
    @Severity(SeverityLevel.NORMAL)
    @Owner("student")
    @Description("Проверяем вычитание двух чисел")
    @DisplayName("Вычитание")
    public void testSubtract() {
        Allure.parameter("a", 10);
        Allure.parameter("b", 4);
        double result = steps.subtract(10, 4);
        steps.verifyResult(result, 6);
    }

    @Test
    @Story("Умножение")
    @Severity(SeverityLevel.NORMAL)
    @Owner("student")
    @Description("Проверяем умножение двух чисел")
    @DisplayName("Умножение")
    public void testMultiply() {
        Allure.parameter("a", 7);
        Allure.parameter("b", 8);
        double result = steps.multiply(7, 8);
        steps.verifyResult(result, 56);
    }

    @Test
    @Story("Деление")
    @Severity(SeverityLevel.NORMAL)
    @Owner("student")
    @Description("Проверяем деление двух чисел")
    @DisplayName("Деление")
    public void testDivide() {
        Allure.parameter("a", 15);
        Allure.parameter("b", 3);
        double result = steps.divide(15, 3);
        steps.verifyResult(result, 5);
    }

    @Test
    @Story("Деление")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("student")
    @Description("Проверяем деление на ноль — ожидаем исключение")
    @DisplayName("Деление на ноль")
    @Issue("CALC-001")
    public void testDivideByZero() {
        Allure.parameter("a", 10);
        Allure.parameter("b", 0);
        assertThrows(ArithmeticException.class, () -> steps.divide(10, 0));
    }

    @Test
    @Story("Возведение в степень")
    @Severity(SeverityLevel.NORMAL)
    @Owner("student")
    @Description("Проверяем возведение в степень")
    @DisplayName("Возведение в степень")
    public void testPower() {
        Allure.parameter("base", 2);
        Allure.parameter("exponent", 10);
        double result = steps.power(2, 10);
        steps.verifyResult(result, 1024);
    }

    @Test
    @Story("Квадратный корень")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("student")
    @Description("Проверяем извлечение корня из отрицательного числа — ожидаем исключение")
    @DisplayName("Квадратный корень из отрицательного числа")
    @Issue("CALC-002")
    public void testSqrtOfNegative() {
        Allure.parameter("value", -4);
        assertThrows(ArithmeticException.class, () -> steps.sqrt(-4));
    }
}
