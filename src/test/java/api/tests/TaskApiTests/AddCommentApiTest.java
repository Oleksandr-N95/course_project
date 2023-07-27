package api.tests.TaskApiTests;

import api.steps.ProjectApiSteps;
import api.steps.TaskApiSteps;
import api.steps.UserApiSteps;
import api.tests.BaseAPITest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddCommentApiTest extends BaseAPITest {
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
    private final static String TITLE_STRING = "NewString" + randomNumber;
    private final static String CONTENT = "NewComment" + randomNumber;
    private String commentId;

    @BeforeMethod
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
        projectId = projectApiSteps.createProject(PROJECT_NAME);
        taskId = taskApiSteps.createTask(TITLE_STRING, Integer.parseInt(projectId));
    }
    @Test
    public void addCommentTest(){
        commentId = taskApiSteps.createComment(userId, taskId, CONTENT);
        Assert.assertNotNull(commentId, "The comment was not created");
    }
    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {
        taskApiSteps.deleteTask(taskId);
        projectApiSteps.deleteProject(projectId);
        userApiSteps.deleteUser(userId);
    }
}
