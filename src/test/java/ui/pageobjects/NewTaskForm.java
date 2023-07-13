package ui.pageobjects;

import com.codeborne.selenide.Condition;
import ui.elements.TaskElements;

public class NewTaskForm extends TaskElements {

    public NewTaskPage taskForm(String titleString, String taskTextString, int estimatedString, int spentString, int formScoreString){
        titleString().shouldBe(Condition.visible).sendKeys(titleString);
        taskTextString().shouldBe(Condition.visible).sendKeys(taskTextString);
        estimatedString().shouldBe(Condition.visible).sendKeys(String.valueOf(estimatedString));
        spentString().shouldBe(Condition.visible).sendKeys(String.valueOf(spentString));
        formScoreString().shouldBe(Condition.visible).sendKeys(String.valueOf(formScoreString));
        saveButton().shouldBe(Condition.visible).click();
        return new NewTaskPage();
    }
    public NewTaskPage assertNewTaskPaigeIsOpened() {
        header().shouldBe(Condition.visible);
        return (NewTaskPage) this;
    }
}
