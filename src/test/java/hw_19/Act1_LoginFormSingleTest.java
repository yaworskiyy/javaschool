package hw_19;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class Act1_LoginFormSingleTest {

    @Test
    void loginWithValidCredentials() {
        open("https://the-internet.herokuapp.com/");
        $$("a").findBy(Condition.text("Form Authentication")).click();

        $("h2").shouldHave(Condition.text("Login Page"));

        $("#username").setValue("tomsmith");
        $("#password").setValue("SuperSecretPassword!");
        $("button[type='submit']").click();

        $("#flash").shouldHave(Condition.text("You logged into a secure area!"));

        $("a[href='/logout']").shouldBe(Condition.visible);
        $("a[href='/logout']").click();

        $("h2").shouldHave(Condition.text("Login Page"));
    }

    @Test
    void loginWithInvalidCredentials() {
        open("https://the-internet.herokuapp.com/");
        $$("a").findBy(Condition.text("Form Authentication")).click();

        $$("a").findBy(Condition.text("Elemental Selenium")).shouldBe(Condition.visible);

        $("#username").setValue("admin");
        $("#password").setValue("1234");
        $("button[type='submit']").click();

        $("#flash").shouldHave(Condition.text("Your username is invalid!"));
    }
}
