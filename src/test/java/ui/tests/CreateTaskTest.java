package ui.tests;

import api.steps.ProjectApiSteps;
import api.steps.TaskApiSteps;
import api.steps.UserApiSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pageobjects.LoginPage;
import ui.pageobjects.NewProjectPage;
import ui.pageobjects.NewTaskPage;

import javax.swing.*;
import java.util.Random;

public class CreateTaskTest extends BaseTest {

    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    TaskApiSteps taskApiSteps = new TaskApiSteps();
    private String projectId;
    private String taskId;
    static Random random = new Random();
    static int randomNumber = random.nextInt(1000);
    private static final String USERNAME = "user" + randomNumber;
    private static final String PASSWORD = "myTestPassword" + randomNumber;
    private final static String PROJECT_NAME = "ProjectName"+ randomNumber;
    private final static String IDENTIFIER = "MYPROJECT" + randomNumber;
    private final static String TITLE_STRING = "NewString" + randomNumber;
    private final static String TASK_TEXT_STRING = "NewTask" + randomNumber;
    private final static int ESTIMATED_STRING = randomNumber;
    private final static int SPENT_STRING = randomNumber;
    private final static int FORM_SCORE_STRING = randomNumber;
    private static JCheckBox TASKCHECK;
    private final static int TASKLIMIT = 2;

    @BeforeMethod
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
        System.out.println(userId);
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD)
                .assertMainSectionIsOpened();
        projectId = projectApiSteps.createProject(PROJECT_NAME);
       System.out.println(projectId);
            new NewProjectPage()
               .goToNewProject()
               .projectForm(PROJECT_NAME, IDENTIFIER, TASKCHECK,TASKLIMIT)
               .assertNewProjectPaigeIsOpened();
    }
    @Test
    public void createTaskTest(){
        new NewTaskPage()
                .goToCreateTask()
                .taskForm(TITLE_STRING, TASK_TEXT_STRING, ESTIMATED_STRING, SPENT_STRING, FORM_SCORE_STRING)
                .assertNewTaskPaigeIsOpened();
        taskId = taskApiSteps.createTask(TITLE_STRING, Integer.parseInt(projectId));
    }
    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {
        taskApiSteps.deleteTask(taskId);
        projectApiSteps.deleteProject(projectId);
        userApiSteps.deleteUser(userId);
    }
}
