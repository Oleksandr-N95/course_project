package ui.tests;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static utils.EnvProperties.API_URL;
import static utils.EnvProperties.BASE_URL;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = BASE_URL;
        RestAssured.baseURI = API_URL;
//        Configuration.headless = true;
    }

    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        closeWebDriver();
    }
}
