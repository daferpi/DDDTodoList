package todoList.infraestructure;

import org.springframework.web.bind.annotation.*;
import todoList.domain.*;
import todoList.exceptions.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public LoginUser loginUser(@RequestParam("userName") String userName, @RequestParam("password") String password) throws InvalidCredentialsException {
        return this.loginService.validateUserCredentials(userName,password);
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.GET)
    public TodoTask addTodoTask(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("title") String title, @RequestParam("description") String description)  {
        return this.todoTaskService.addTodoTask(new UserTodoTaskAdder(userName,password), title,description);
    }

    @RequestMapping(value = "/completeTask/{id}", method = RequestMethod.GET)
    public DoneTodoTask completeTask(@PathVariable Long id) throws TodoTaskNotFoundException {
        return this.todoTaskService.completeTask(id);
    }

    @RequestMapping(value = "/pendingTask", method = RequestMethod.GET)
    public List<PendingTodoTask> pendingTask()  {
        return this.todoTaskService.findPendingTask();
    }

    @RequestMapping(value = "/doneTask", method = RequestMethod.GET)
    public List<DoneTodoTask> doneTask()  {
        return this.todoTaskService.findDoneTask();
    }


    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setTodoTaskService(TodoTaskService todoTaskService) {
        this.todoTaskService = todoTaskService;
    }
}
