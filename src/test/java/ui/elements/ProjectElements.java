package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProjectElements {

    public SelenideElement nameInput() {
        return $("#form-name");
    }

    public SelenideElement identifierInput() {
        return $("#form-identifier");
    }

    public SelenideElement taskCheck() {
        return $("[name=\"per_swimlane_task_limits\"]");
    }
    public SelenideElement taskLimitString() {
        return $("[name=\"per_swimlane_task_limits\"]");
    }

    public SelenideElement saveButton() {
        return $("[type=\"submit\"]");
    }
    public SelenideElement createButton() {
        return $("[class=\"fa fa-plus fa-fw\"]");
    }
    public SelenideElement newProjectButton() {
        return $("#dropdown > ul > li:nth-child(1) > a");
    }

    public SelenideElement header() {
        return $("[class=title-container]");
    }
}
