package todoList.service;

import todoList.domain.LoginUser;
import todoList.domain.TodoTaskAdder;
import todoList.exceptions.InvalidCredentialsException;

/**
 * Created by daferpi on 10/04/16.
 */
public interface LoginService {

    public TodoTaskAdder validateUserCredentials(String userName, String password) throws InvalidCredentialsException;
}
