package ui.pageobjects;

import com.codeborne.selenide.Condition;
import ui.elements.ProjectElements;

import javax.swing.*;

public class ProjectPage extends ProjectElements {

    public ProjectPage createProject(String nameInput, String identifierInput, JCheckBox taskCheck, int taskLimitString){
        createButton().shouldBe(Condition.visible).click();
        newProjectButton().shouldBe(Condition.visible).click();
        nameInput().shouldBe(Condition.visible).sendKeys(nameInput);
        identifierInput().shouldBe(Condition.visible).sendKeys(identifierInput);
        taskCheck().shouldBe(Condition.visible).click();
        taskLimitString().shouldBe(Condition.visible).sendKeys(String.valueOf(taskLimitString));
        saveButton().shouldBe(Condition.visible).click();
        return new ProjectPage();
    }
    public ProjectPage closeProject(){
        closeProjectButton().shouldBe(Condition.visible).click();
        confirmCloseProjectButton().shouldBe(Condition.visible).click();
        return new ProjectPage();
    }
    public ProjectPage assertSummaryPaigeIsOpened() {
        header().shouldBe(Condition.visible);
        return this;
    }
}
