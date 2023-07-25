package ui.tests.LoginTests;

import api.steps.UserApiSteps;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pageobjects.LoginPage;
import ui.tests.BaseTest;

import java.util.Random;

public class LoginNegativeUsernameTest extends BaseTest {

    private final static Faker faker = new Faker();
    static Random random = new Random();
    static int randomNumber = random.nextInt(1000);
    private static final String USERNAME = "user" + randomNumber;
    private static final String PASSWORD = "myTestPassword" + randomNumber;
    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;

    @BeforeMethod
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
    }

    @Test
    public void loginByNewUser() {
        new LoginPage()
                .openLoginPage()
                .loginByUser(faker.name().username(), PASSWORD)
                .assertMainSectionIsOpened();
    }

    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {
        userApiSteps.deleteUser(userId);
    }
}

