package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainElements {
    public SelenideElement mainSection() {
        return $("#main");
    }
    public SelenideElement loginErrorMessage() {
        return $x("[class=\"alert alert-error\"]");
    }
}