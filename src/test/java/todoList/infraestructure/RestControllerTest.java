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
import todoList.exceptions.InvalidCredentialsException;
import todoList.exceptions.RequiredDataException;
import todoList.service.LoginService;
import todoList.service.TodoTaskService;

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


    @Before
    public void setUp() {
    }

    @Test
    public void addTodoTaskOk() throws Exception {
        String userName = "abel";
        String password = "test1";
        String title = "title";
        String description = "description";

        TodoTask todoTask = restControllerSUT.addTodoTask(userName, password, title, description);

        assertNotNull(todoTask);
        assertThat(todoTask.getTitle(), is(title));
        assertThat(todoTask.getDescription(), is(description));
        assertThat(todoTask.getUserName(), is(userName));
    }

    @Test(expected = InvalidCredentialsException.class)
    public void addTodoTaskInvalidCredentials() throws Exception {
        String userName = "user";
        String password = "pass";
        String title = "title";
        String description = "description";

        restControllerSUT.addTodoTask(userName, password, title, description);
    }

    @Test(expected = InvalidCredentialsException.class)
    public void addTodoTaskUserDataNull() throws Exception {
        String userName = null;
        String password = null;
        String title = "title";
        String description = "description";

        restControllerSUT.addTodoTask(userName, password, title, description);

    }

    @Test(expected = InvalidCredentialsException.class)
    public void addTodoTaskUserNameNull() throws Exception {
        String userName = null;
        String password = "test1";
        String title = "title";
        String description = "description";

        restControllerSUT.addTodoTask(userName, password, title, description);

    }

    @Test(expected = InvalidCredentialsException.class)
    public void addTodoTaskPasswordNull() throws Exception {
        String userName = "abel";
        String password = null;
        String title = "title";
        String description = "description";

        restControllerSUT.addTodoTask(userName, password, title, description);

    }

    @Test(expected = RequiredDataException.class)
    public void addTodoTaskTaskDataNull() throws Exception {
        String userName = "abel";
        String password = "test1";
        String title = null;
        String description = null;

        restControllerSUT.addTodoTask(userName, password, title, description);

    }

    @Test(expected = RequiredDataException.class)
    public void addTodoTaskTaskTitleNull() throws Exception {
        String userName = "abel";
        String password = "test1";
        String title = null;
        String description = "description";

        restControllerSUT.addTodoTask(userName, password, title, description);

    }

    @Test(expected = RequiredDataException.class)
    public void addTodoTaskTaskDescriptionNull() throws Exception {
        String userName = "abel";
        String password = "test1";
        String title = "test";
        String description = null;

        restControllerSUT.addTodoTask(userName, password, title, description);

    }
}