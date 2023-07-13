package api.tests;

import api.models.BoardInfo;
import api.models.Result;
import api.steps.BoardApiSteps;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
public class BoardApiTests {

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "http://localhost/";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .build();
    }
    @Test
    public void checkBoardApi() {
        BoardApiSteps boardApiSteps = new BoardApiSteps();
        Result<List<BoardInfo>> boardInfoResult = boardApiSteps.getBoardForProject(2);
        Assert.assertTrue(boardInfoResult.getResult().size() > 0, "Board request doesn't contain records");
        System.out.println(boardInfoResult.getResult().get(0).getName());
    }
}