package hw_19.page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SecureAreaPage {

    public void shouldShowSuccessMessage(String message) {
        $("#flash").shouldHave(text(message));
    }

    public void shouldHaveLogoutButton() {
        $("a[href='/logout']").shouldBe(visible);
    }

    public void clickLogout() {
        $("a[href='/logout']").click();
    }
}
