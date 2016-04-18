package todoList.infraestructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import todoList.domain.PendingTodoTask;
import todoList.domain.TodoTask;
import todoList.domain.TodoTaskAdder;
import todoList.exceptions.InvalidCredentialsException;
import todoList.exceptions.RequiredDataException;
import todoList.exceptions.TodoTaskNotFoundException;
import todoList.service.LoginService;
import todoList.service.TodoTaskService;

import java.util.List;

/**
 * Created by daferpi on 09/04/16.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private TodoTaskService todoTaskService;

    @RequestMapping("/hello")
    public String helloWorld() {
        return "hello World";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public TodoTaskAdder loginUser(@RequestParam("userName") String userName, @RequestParam("password") String password) throws InvalidCredentialsException {
        return this.loginService.validateUserCredentials(userName,password);
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public TodoTask addTodoTask(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("title") String title, @RequestParam("description") String description) throws InvalidCredentialsException, RequiredDataException {
        return this.todoTaskService.addTodoTask(userName,password, title,description);
    }

    @RequestMapping(value = "/completeTask/{id}", method = RequestMethod.POST)
    public TodoTask completeTask(@PathVariable Long id, @RequestParam("userName") String userName) throws TodoTaskNotFoundException, RequiredDataException {
        return this.todoTaskService.completeTask(id, userName);
    }

    @RequestMapping(value = "/pendingTask", method = RequestMethod.GET)
    public List<PendingTodoTask> pendingTask(@RequestParam("userName") String userName) throws RequiredDataException {
        return this.todoTaskService.findPendingTask(userName);
    }

    @RequestMapping(value = "/doneTask", method = RequestMethod.GET)
    public List<TodoTask> doneTask(@RequestParam("userName") String userName) throws RequiredDataException {
        return this.todoTaskService.findDoneTask(userName);
    }


    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setTodoTaskService(TodoTaskService todoTaskService) {
        this.todoTaskService = todoTaskService;
    }
}
