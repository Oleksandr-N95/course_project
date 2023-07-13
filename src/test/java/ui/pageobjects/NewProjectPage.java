package ui.pageobjects;

import com.codeborne.selenide.Condition;

public class NewProjectPage extends NewProjectForm {

    public NewProjectPage goToNewProject() {
        createButton().shouldBe(Condition.visible).click();
        newProjectButton().shouldBe(Condition.visible).click();
        return new NewProjectPage();
    }
}
