package todoList.infraestructure;

import todoList.domain.LoginUser;
import todoList.exceptions.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import todoList.service.LoginService;

/**
 * Created by daferpi on 09/04/16.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/hello")
    public String helloWorld() {
        return "hello World";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public LoginUser loginUser(@RequestParam("userName") String userName, @RequestParam("password") String password) throws InvalidCredentialsException {
        return this.loginService.validateUserCredentials(userName,password);
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
