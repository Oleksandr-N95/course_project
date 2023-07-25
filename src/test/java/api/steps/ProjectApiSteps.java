package api.steps;

import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.projects.CreateProject;
import api.models.args.projects.ProjectId;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

import static api.methods.Projects.*;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class ProjectApiSteps extends BaseApiSteps{
    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "http://localhost/dashboard";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .build();
    }
    public String createProject(String name) {
        CreateProject args = new CreateProject().builder()
                .name(name)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(CREATE_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
    public String disableProject(int projectId){

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new ProjectId(Integer.valueOf(projectId)))
                .method(DISABLE_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
    public boolean deleteProject(String projectId) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new ProjectId(Integer.valueOf(projectId)))
                .method(DELETE_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }
}
