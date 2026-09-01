package hw_19;

import hw_19.page.HomePage;
import hw_19.page.LoginPage;
import hw_19.page.SecureAreaPage;
import org.junit.jupiter.api.Test;

public class Act2_LoginFormPageObjectTest {

    private final HomePage home = new HomePage();
    private final LoginPage login = new LoginPage();

    @Test
    void loginWithValidCredentials() {
        home.openPage();
        home.clickFormAuthentication();

        login.shouldHaveTitleLoginPage();
        login.login("tomsmith", "SuperSecretPassword!");

        SecureAreaPage secureArea = new SecureAreaPage();
        secureArea.shouldShowSuccessMessage("You logged into a secure area!");
        secureArea.shouldHaveLogoutButton();
        secureArea.clickLogout();

        login.shouldHaveTitleLoginPage();
    }

    @Test
    void loginWithInvalidCredentials() {
        home.openPage();
        home.clickFormAuthentication();

        login.shouldHaveElementalSeleniumLink();
        login.login("admin", "1234");

        login.shouldShowError("Your username is invalid!");
    }
}
