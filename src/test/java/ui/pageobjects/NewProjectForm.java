package ui.pageobjects;

import com.codeborne.selenide.Condition;
import ui.elements.ProjectElements;

import javax.swing.*;

public class NewProjectForm extends ProjectElements {

    public NewProjectPage projectForm(String nameInput, String identifierInput, JCheckBox taskCheck, int taskLimitString){
        nameInput().shouldBe(Condition.visible).sendKeys(nameInput);
        identifierInput().shouldBe(Condition.visible).sendKeys(identifierInput);
        taskCheck().shouldBe(Condition.visible).click();
        taskLimitString().shouldBe(Condition.visible).sendKeys(String.valueOf(taskLimitString));
        saveButton().shouldBe(Condition.visible).click();
        return new NewProjectPage();
    }
    public NewProjectPage assertNewProjectPaigeIsOpened() {
        header().shouldBe(Condition.visible);
        return (NewProjectPage) this;
    }
}
