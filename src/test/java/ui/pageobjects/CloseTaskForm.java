package ui.pageobjects;

import com.codeborne.selenide.Condition;
import ui.elements.TaskElements;

public class CloseTaskForm extends TaskElements {
    public CloseTaskPage closeProjectTask() {
        closeTaskButton().shouldBe(Condition.visible).click();
        return new CloseTaskPage();
    }
    public CloseTaskForm assertCloseTaskPaigeIsOpened() {
        dashBoard().shouldBe(Condition.visible);
        return new CloseTaskForm();
    }
}
