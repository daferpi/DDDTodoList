package todoList.infraestructure;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import todoList.Application;
import todoList.domain.TodoTask;
import todoList.domain.TodoTaskAdder;
import todoList.exceptions.InvalidCredentialsException;
import todoList.exceptions.RequiredDataException;
import todoList.exceptions.TodoTaskNotFoundException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by daferpi on 13/04/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class RestControllerTest {

    @Autowired
    private RestController restControllerSUT;

    private String userName;
    private String password;
    private String title;
    private String description;

    @Before
    public void setUp() {
        userName = "abel";
        password = "test1";
        title = "title";
        description = "description";
    }

    @Test
    public void addTodoTaskOk() throws Exception {

        TodoTask todoTask = restControllerSUT.addTodoTask(userName, password, title, description);

        assertNotNull(todoTask);
        assertThat(todoTask.getTitle(), is(title));
        assertThat(todoTask.getDescription(), is(description));
        assertThat(todoTask.getUserName(), is(userName));
    }

    @Test(expected = InvalidCredentialsException.class)
    public void addTodoTaskInvalidCredentials() throws Exception {
        userName = "user";
        password = "pass";

        restControllerSUT.addTodoTask(userName, password, title, description);
    }

    @Test(expected = InvalidCredentialsException.class)
    public void addTodoTaskUserDataNull() throws Exception {
        userName = null;
        password = null;

        restControllerSUT.addTodoTask(userName, password, title, description);

    }

    @Test(expected = InvalidCredentialsException.class)
    public void addTodoTaskUserNameNull() throws Exception {
        userName = null;

        restControllerSUT.addTodoTask(userName, password, title, description);

    }

    @Test(expected = InvalidCredentialsException.class)
    public void addTodoTaskPasswordNull() throws Exception {
        password = null;

        restControllerSUT.addTodoTask(userName, password, title, description);

    }

    @Test(expected = RequiredDataException.class)
    public void addTodoTaskTaskDataNull() throws Exception {
        title = null;
        description = null;

        restControllerSUT.addTodoTask(userName, password, title, description);

    }

    @Test(expected = RequiredDataException.class)
    public void addTodoTaskTaskTitleNull() throws Exception {
        title = null;

        restControllerSUT.addTodoTask(userName, password, title, description);

    }

    @Test(expected = RequiredDataException.class)
    public void addTodoTaskTaskDescriptionNull() throws Exception {
        description = null;

        restControllerSUT.addTodoTask(userName, password, title, description);

    }

    @Test
    public void loginUserOk() throws Exception {
        TodoTaskAdder todoTaskAdder = restControllerSUT.loginUser(userName, password);

        assertNotNull(todoTaskAdder);
    }

    @Test(expected = InvalidCredentialsException.class)
    public void loginUserUserNameNull() throws Exception {
        userName = null;

        restControllerSUT.loginUser(userName, password);

    }

    @Test(expected = InvalidCredentialsException.class)
    public void loginUserPasswordNull() throws Exception {
        password = null;
        restControllerSUT.loginUser(userName, password);

    }

    @Test(expected = InvalidCredentialsException.class)
    public void loginUserInvalidCredentials() throws Exception {
        userName = "user";
        password = "password";
        restControllerSUT.loginUser(userName, password);

    }

    @Test
    public void completeTaskOk() throws TodoTaskNotFoundException, RequiredDataException {
        TodoTask todoTask = restControllerSUT.completeTask(1L, userName);
        assertNotNull(todoTask);
        assertThat(todoTask.getId(),is(1L));
        assertThat(todoTask.getUserName(),is(userName));
        assertThat(todoTask.isFinished(),is(true));
    }

    @Test(expected = TodoTaskNotFoundException.class)
    public void completeTaskIdNotExist() throws TodoTaskNotFoundException, RequiredDataException {
        TodoTask todoTask = restControllerSUT.completeTask(4L, userName);

    }

    @Test(expected = TodoTaskNotFoundException.class)
    public void completeTaskUserNameNotExist() throws TodoTaskNotFoundException, RequiredDataException {
        TodoTask todoTask = restControllerSUT.completeTask(1L, "Pedro");
    }

    @Test(expected = RequiredDataException.class)
    public void completeTaskIdNull() throws TodoTaskNotFoundException, RequiredDataException {
        TodoTask todoTask = restControllerSUT.completeTask(null, userName);
    }

    @Test(expected = RequiredDataException.class)
    public void completeTaskUserNameNull() throws TodoTaskNotFoundException, RequiredDataException {
        TodoTask todoTask = restControllerSUT.completeTask(1L, null);
    }



}