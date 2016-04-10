package todoList.infraestructure;

import org.springframework.web.bind.annotation.*;
import todoList.domain.LoginUser;
import todoList.domain.TodoTask;
import todoList.domain.UserTodoTaskAdder;
import todoList.exceptions.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import todoList.service.LoginService;
import todoList.service.TodoTaskService;

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


    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setTodoTaskService(TodoTaskService todoTaskService) {
        this.todoTaskService = todoTaskService;
    }
}
