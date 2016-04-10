package todoList.service;

import todoList.domain.LoginUser;
import todoList.exceptions.InvalidCredentialsException;
import org.springframework.stereotype.Component;

/**
 * Created by daferpi on 10/04/16.
 */
public interface LoginService {

    public LoginUser validateUserCredentials(String userName, String password) throws InvalidCredentialsException;
}
