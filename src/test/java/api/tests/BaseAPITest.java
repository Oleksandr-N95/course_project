package api.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

import static utils.EnvProperties.API_URL;

public class BaseAPITest {

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = API_URL;
    }
}
