package ui.pageobjects;

import com.codeborne.selenide.Condition;

public class AddCommentPage extends AddCommentForm{

    public AddCommentForm goToAddComment() {
        dashBoard().shouldBe(Condition.visible).click();
        myTaskButton().shouldBe(Condition.visible).click();
        taskDropDown().shouldBe(Condition.visible).click();
        addCommentDropDown().shouldBe(Condition.visible).click();
        return new AddCommentForm();
    }
}
