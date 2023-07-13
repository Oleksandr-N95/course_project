package ui.pageobjects;

import com.codeborne.selenide.Condition;
import ui.elements.TaskElements;

public class AddCommentForm extends TaskElements {

    public AddCommentPage addComment(String commentText) {
        addTextArea().shouldBe(Condition.visible).sendKeys(commentText);
        addCommentButton().shouldBe(Condition.visible).click();
        return new AddCommentPage();
    }
    public AddCommentForm assertAddCommentPaigeIsOpened() {
        dashBoard().shouldBe(Condition.visible);
        return new AddCommentForm();
    }
}
