package api.tests.ProjectApiTests;

import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import api.tests.BaseAPITest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateProjectApiTest extends BaseAPITest {
    static Random random = new Random();
    static int randomNumber = random.nextInt(1000);
    private static final String USERNAME = "user"+ randomNumber;
    private static final String PASSWORD = "myTestPassword"+ randomNumber;

    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    private String projectId;
    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;
    private final static String PROJECTNAME = "ProjectName"+ randomNumber;

    @BeforeMethod
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
    }
    @Test
    public void createProjectTest () {
        projectId = projectApiSteps.createProject(PROJECTNAME);
        Assert.assertNotNull(projectId, "The Project was not created");
    }
    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {
        projectApiSteps.deleteProject(projectId);
        userApiSteps.deleteUser(userId);
    }
}
