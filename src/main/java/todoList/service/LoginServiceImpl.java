package todoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import todoList.domain.LoginUser;
import todoList.exceptions.InvalidCredentialsException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by daferpi on 10/04/16.
 */
@Component("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

    final private LoginUserRepository loginUserRepository;

    @Autowired
    public LoginServiceImpl(LoginUserRepository loginUserRepository) {
        this.loginUserRepository = loginUserRepository;
    }

    @Override
    public LoginUser validateUserCredentials(String userName, String password) throws InvalidCredentialsException {
        LoginUser userByUserName = this.loginUserRepository.findUserByUserName(userName);
        if (userByUserName != null && userByUserName.validateCredentials(password)){
            return  userByUserName;
        }
        throw  new InvalidCredentialsException("Invalid Credentials");
    }

    public LoginUserRepository getLoginUserRepository() {
        return loginUserRepository;
    }
}
