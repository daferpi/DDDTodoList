package todoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todoList.domain.LoginUser;

import javax.annotation.PostConstruct;

/**
 * Created by daferpi on 10/04/16.
 */
@Service
public class DatabaseLoader {

    private final LoginUserRepository loginUserRepository;

    @Autowired
    public DatabaseLoader(LoginUserRepository loginUserRepository) {
        this.loginUserRepository = loginUserRepository;
    }

    @PostConstruct
    void init() {
        this.loginUserRepository.save(new LoginUser("abel","test1"));
        this.loginUserRepository.save(new LoginUser("kevin","test2"));
    }

}
