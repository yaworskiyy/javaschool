Feature: Login Form on the-internet
  As a user I want to authenticate on the login form
  So that I can verify the herokuapp application

  Scenario: Login with valid credentials
    Given I open the internet home page
    And I click on Form Authentication link
    Then page title should contain Login Page
    When I enter username "tomsmith"
    And I enter password "SuperSecretPassword!"
    And I click Login button
    Then success message should contain "You logged into a secure area!"
    And there should be a Logout button
    When I click Logout button
    Then page title should contain Login Page

  Scenario: Login with invalid credentials
    Given I open the internet home page
    And I click on Form Authentication link
    Then page title should contain Login Page
    And there should be an Elemental Selenium link
    When I enter username "admin"
    And I enter password "1234"
    And I click Login button
    Then error message should contain "Your username is invalid!"
