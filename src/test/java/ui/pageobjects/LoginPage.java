package ui.pageobjects;

import ui.elements.LoginElements;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static utils.EnvProperties.BASE_URL;

public class LoginPage extends LoginElements {

    public LoginPage openLoginPage() {
        open(BASE_URL);
        return new LoginPage();
    }

    public MainPage loginByUser(String username, String password) {
        userField().shouldBe(visible).sendKeys(username);
        passwordField().sendKeys(password);
        submitButton().click();
        return new MainPage();
    }
}