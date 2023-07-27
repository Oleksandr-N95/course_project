package api.steps;

import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.tasks.CreateComment;
import api.models.args.tasks.CreateTask;
import api.models.args.tasks.OperationsTasks;
import api.models.args.tasks.TaskId;
import io.restassured.response.Response;

import static api.methods.Tasks.*;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class TaskApiSteps extends BaseApiSteps{
    public String createTask(String title, int projectId) {
        CreateTask args = new CreateTask().builder()
                .title(title)
                .project_id(projectId)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(CREATE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }

    public String openTask(int taskId) {
        OperationsTasks args = new OperationsTasks().builder()
                .task_id(taskId)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(OPEN_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }

    public String getTask(int taskId) {
        OperationsTasks args = new OperationsTasks().builder()
                .task_id(taskId)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(GET_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }

    public String closeTask(int taskId) {
        OperationsTasks args = new OperationsTasks().builder()
                .task_id(taskId)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(CLOSE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
    public boolean deleteTask(String taskId) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new TaskId(Integer.valueOf(taskId)))
                .method(DELETE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }
    public String createComment(String userId, String taskId, String content) {
        CreateComment args = new CreateComment().builder()
                .user_id(Integer.valueOf(userId))
                .task_id(Integer.valueOf(taskId))
                .content(content)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(CREATE_COMMENT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }
}
