package ui.pageobjects;

import com.codeborne.selenide.Condition;

public class CloseTaskPage extends CloseTaskForm{

    public CloseTaskForm goToCloseTask() {
        dashBoard().shouldBe(Condition.visible).click();
        myTaskButton().shouldBe(Condition.visible).click();
        taskDropDown().shouldBe(Condition.visible).click();
        closeTaskDropDown().shouldBe(Condition.visible).click();
        return new CloseTaskForm();
    }
}
