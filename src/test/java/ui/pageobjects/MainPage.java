package ui.pageobjects;

import com.codeborne.selenide.Condition;
import ui.elements.MainElements;

import static com.codeborne.selenide.Selenide.open;

public class MainPage extends MainElements {

    public MainPage openLoginPage() {
        open("http://localhost/login/");
        return new MainPage();
    }

    public MainPage assertMainSectionIsOpened() {
        mainSection().shouldBe(Condition.visible);
        return this;
    }
}