package ui.pageobjects;

import com.codeborne.selenide.Condition;

public class NewTaskPage extends NewTaskForm{

    public NewTaskPage goToCreateTask(){
        boardTitle().shouldBe(Condition.visible).click();
        newTaskButton().shouldBe(Condition.visible).click();
        return new NewTaskPage();
    }
}
