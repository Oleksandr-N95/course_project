package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TaskElements {

    public SelenideElement boardTitle() {
        return $("[class=\"dropdown-component\"]");
    }

    public SelenideElement newTaskButton() {
        return $("#dropdown > ul > li:nth-child(1) > a");
    }
    public SelenideElement titleString() {
        return $("[id=\"form-title\"]");
    }
    public SelenideElement taskTextString() {
        return $("[name=\"description\"]");
    }

    public SelenideElement estimatedString() {
        return $("[id=\"form-time_estimated\"]");
    }
    public SelenideElement spentString() {
        return $("[id=\"form-time_spent\"]");
    }
    public SelenideElement formScoreString() {
        return $("[id=\"form-score\"]");
    }

    public SelenideElement saveButton() {
        return $("[class=\"btn btn-blue\"]");
    }
    public SelenideElement header() {
        return $("[class=title-container]");
    }
    public SelenideElement dashBoard() {
        return $("[title=\"Dashboard\"]");
    }
    public SelenideElement myTaskButton() {
        return $("#dashboard > div.sidebar > ul > li:nth-child(3) > a");
    }
    public SelenideElement taskDropDown() {
        return $("#dashboard > div.sidebar-content > div.table-list > div.table-list-row.color-yellow > div:nth-child(1) > div > a");
    }
    public SelenideElement closeTaskDropDown() {
        return $("#dropdown > ul > li:nth-child(14) > a > i");
    }
    public SelenideElement closeTaskButton() {
        return $("[id=\"modal-confirm-button\"]");
    }
    public SelenideElement addCommentDropDown() {
        return $("#dropdown > ul > li:nth-child(6) > a");
    }
    public SelenideElement addTextArea() {
        return $("[name=\"comment\"]");
    }
    public SelenideElement addCommentButton() {
        return $("[type=\"submit\"]");
    }
}
