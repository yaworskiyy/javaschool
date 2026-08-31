import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class BookingSteps {

    // Блок 1, 2, 4 — DataTable
    @Given("в ресторане есть столики:")
    public void вРесторанеЕстьСтолики(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        System.out.println("Добавляем столики:");
        for (Map<String, String> row : rows) {
            System.out.println("  номер: " + row.get("номер") + ", вместимость: " + row.get("вместимость"));
        }
        // Заглушка: throw new PendingException();
    }

    @Given("все столики свободны")
    public void всеСтоликиСвободны() {
        System.out.println("Все столики свободны");
    }

    @Given("столик номер {int} занят")
    public void столикНомерЗанят(int номер) {
        System.out.println("Столик " + номер + " занят");
    }

    @When("гость забронировал столик на {int} человек")
    public void гостьЗабронировалСтоликНаЧеловек(int количество) {
        System.out.println("Бронируем столик на " + количество + " человек");
    }

    @Then("бронирование подтверждено")
    public void бронированиеПодтверждено() {
        System.out.println("Бронирование подтверждено");
    }

    @Then("бронирование отклонено с сообщением {string}")
    public void бронированиеОтклоненоССообщением(String сообщение) {
        System.out.println("Бронирование отклонено: " + сообщение);
    }

    @Given("гость забронировал столик на {int} человека")
    public void гостьЗабронировалСтоликНаЧеловека(int количество) {
        System.out.println("Бронируем столик на " + количество + " человек (для отмены)");
    }

    @When("гость отменяет бронирование")
    public void гостьОтменяетБронирование() {
        System.out.println("Отмена бронирования");
    }

    @Then("бронирование отменено")
    public void бронированиеОтменено() {
        System.out.println("Бронирование отменено");
    }

    @Then("столик номер {int} свободен")
    public void столикНомерСвободен(int номер) {
        System.out.println("Столик " + номер + " свободен");
    }

    // Блок 3 — Scenario Outline
    @Then("результат бронирования: {word}")
    public void результатБронирования(String результат) {
        System.out.println("Результат бронирования: " + результат);
    }

    // Блок 5 — Doc String
    @When("гость оставляет пожелание к брони:")
    public void гостьОставляетПожеланиеКБрони(String пожелание) {
        System.out.println("Пожелание клиента:\n" + пожелание);
    }

    // Блок 8* — регулярное выражение для увеличения/уменьшения
    @When("^гость (увеличивает|уменьшает) бронь на (\\d+) человек(?:а)?$")
    public void гостьИзменяетБронь(String действие, int количество) {
        System.out.println("Гость " + действие + " бронь на " + количество + " человек");
    }

    // Дополнительные шаги для блока 8
    @Then("количество гостей в брони равно {int}")
    public void checkGuestCountInBooking(int количество) {
        System.out.println("Количество гостей в брони: " + количество);
    }
}
