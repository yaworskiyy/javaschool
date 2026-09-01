package hw_19.page;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    public static final String URL = "https://the-internet.herokuapp.com/";

    public void openPage() {
        open(URL);
    }

    public void clickFormAuthentication() {
        $$("a").findBy(text("Form Authentication")).click();
    }
}
