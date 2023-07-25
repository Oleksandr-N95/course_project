package ui.pageobjects;

import com.codeborne.selenide.Condition;
import ui.elements.TaskElements;

public class TaskPage extends TaskElements {

    public TaskPage createTask(String titleString, String taskTextString, int estimatedString, int spentString, int formScoreString){
        boardTitle().shouldBe(Condition.visible).click();
        newTaskButton().shouldBe(Condition.visible).click();
        titleString().shouldBe(Condition.visible).sendKeys(titleString);
        taskTextString().shouldBe(Condition.visible).sendKeys(taskTextString);
        estimatedString().shouldBe(Condition.visible).sendKeys(String.valueOf(estimatedString));
        spentString().shouldBe(Condition.visible).sendKeys(String.valueOf(spentString));
        formScoreString().shouldBe(Condition.visible).sendKeys(String.valueOf(formScoreString));
        saveButton().shouldBe(Condition.visible).click();
        return new TaskPage();
    }
    public TaskPage assertNewTaskPaigeIsOpened() {
        header().shouldBe(Condition.visible);
        return (TaskPage) this;
    }
    public TaskPage closeTask() {
        dashBoard().shouldBe(Condition.visible).click();
        myTaskButton().shouldBe(Condition.visible).click();
        taskDropDown().shouldBe(Condition.visible).click();
        closeTaskDropDown().shouldBe(Condition.visible).click();
        closeTaskButton().shouldBe(Condition.visible).click();
        return new TaskPage();
    }
    public TaskPage assertCloseTaskPaige() {
        dashBoard().shouldBe(Condition.visible);
        return new TaskPage();
    }
}
