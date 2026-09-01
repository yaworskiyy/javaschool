package hw_19.steps;

import hw_19.page.HomePage;
import hw_19.page.LoginPage;
import hw_19.page.SecureAreaPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    private final HomePage home = new HomePage();
    private final LoginPage login = new LoginPage();
    private final SecureAreaPage secureArea = new SecureAreaPage();

    @Given("I open the internet home page")
    public void iOpenTheInternetHomePage() {
        home.openPage();
    }

    @And("I click on Form Authentication link")
    public void iClickOnFormAuthenticationLink() {
        home.clickFormAuthentication();
    }

    @Then("page title should contain Login Page")
    public void pageTitleShouldContainLoginPage() {
        login.shouldHaveTitleLoginPage();
    }

    @And("there should be an Elemental Selenium link")
    public void thereShouldBeAnElementalSeleniumLink() {
        login.shouldHaveElementalSeleniumLink();
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        login.enterUsername(username);
    }

    @When("I enter password {string}")
    public void iEnterPassword(String password) {
        login.enterPassword(password);
    }

    @And("I click Login button")
    public void iClickLoginButton() {
        login.clickLogin();
    }

    @Then("success message should contain {string}")
    public void successMessageShouldContain(String message) {
        secureArea.shouldShowSuccessMessage(message);
    }

    @And("there should be a Logout button")
    public void thereShouldBeALogoutButton() {
        secureArea.shouldHaveLogoutButton();
    }

    @When("I click Logout button")
    public void iClickLogoutButton() {
        secureArea.clickLogout();
    }

    @Then("error message should contain {string}")
    public void errorMessageShouldContain(String message) {
        login.shouldShowError(message);
    }
}
