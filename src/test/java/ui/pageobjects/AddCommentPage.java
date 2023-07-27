package ui.pageobjects;

import com.codeborne.selenide.Condition;
import ui.elements.TaskElements;

public class AddCommentPage extends TaskElements {

    public AddCommentPage goToAddComment(String commentText) {
        dashBoard().shouldBe(Condition.visible).click();
        myTaskButton().shouldBe(Condition.visible).click();
        taskDropDown().shouldBe(Condition.visible).click();
        addCommentDropDown().shouldBe(Condition.visible).click();
        addTextArea().shouldBe(Condition.visible).sendKeys(commentText);
        addCommentButton().shouldBe(Condition.visible).click();
        return new AddCommentPage();
    }
    public AddCommentPage assertTaskDashboardIsOpened() {
        dashBoard().shouldBe(Condition.visible);
        return new AddCommentPage();
    }
}
