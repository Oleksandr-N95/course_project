package ui.pageobjects;

import com.codeborne.selenide.Condition;
import ui.elements.MainElements;

import static com.codeborne.selenide.Selenide.open;
import static utils.EnvProperties.BASE_URL;

public class MainPage extends MainElements {

    public MainPage openLoginPage() {
        open(BASE_URL);
        return new MainPage();
    }

    public MainPage assertMainSectionIsOpened() {
        mainSection().shouldBe(Condition.visible);
        return this;
    }
    public MainPage assertLoginErrorMessage() {
        loginErrorMessage().shouldBe(Condition.visible);
        return this;
    }
}