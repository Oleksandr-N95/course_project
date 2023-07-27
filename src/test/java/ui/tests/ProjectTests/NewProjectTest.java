package ui.tests.ProjectTests;

import api.steps.UserApiSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pageobjects.LoginPage;
import ui.pageobjects.ProjectPage;
import ui.tests.BaseTest;

import javax.swing.*;
import java.util.Random;

public class NewProjectTest extends BaseTest {
    static Random random = new Random();
    static int randomNumber = random.nextInt(1000);
    private static final String USERNAME = "user"+ randomNumber;
    private static final String PASSWORD = "myTestPassword"+ randomNumber;

    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;
    private final static String PROJECTNAME = "ProjectName"+ randomNumber;
    private final static String IDENTIFIER = "MYPROJECT" + randomNumber;
    private static JCheckBox TASKCHECK;
    private final static int TASKLIMIT = 2;

    @BeforeMethod
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD)
                .assertMainSectionIsOpened();
    }
    @Test
    public void newProjectTest () {
         new ProjectPage()
                 .createProject(PROJECTNAME, IDENTIFIER, TASKCHECK,TASKLIMIT)
                 .assertSummaryPaigeIsOpened();
    }
    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {
        userApiSteps.deleteUser(userId);
    }
}
