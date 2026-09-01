package hw_19.page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {

    public void shouldHaveTitleLoginPage() {
        $("h2").shouldHave(text("Login Page"));
    }

    public void shouldHaveElementalSeleniumLink() {
        $$("a").findBy(text("Elemental Selenium")).shouldBe(visible);
    }

    public void enterUsername(String username) {
        $("#username").setValue(username);
    }

    public void enterPassword(String password) {
        $("#password").setValue(password);
    }

    public void clickLogin() {
        $("button[type='submit']").click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void shouldShowError(String message) {
        $("#flash").shouldHave(text(message));
    }
}
