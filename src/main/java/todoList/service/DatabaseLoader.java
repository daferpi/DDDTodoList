package todoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todoList.domain.LoginUser;
import todoList.domain.TodoTask;
import todoList.exceptions.RequiredDataException;

import javax.annotation.PostConstruct;

/**
 * Created by daferpi on 10/04/16.
 */
@Service
public class DatabaseLoader {

    private final LoginUserRepository loginUserRepository;
    private final TodoTaskRepository todoTaskRepository;

    @Autowired
    public DatabaseLoader(LoginUserRepository loginUserRepository, TodoTaskRepository todoTaskRepository) {
        this.loginUserRepository = loginUserRepository;
        this.todoTaskRepository = todoTaskRepository;
    }

    @PostConstruct
    void init() throws RequiredDataException {
        this.loginUserRepository.save(new LoginUser("abel","test1"));
        this.loginUserRepository.save(new LoginUser("kevin","test2"));

        this.todoTaskRepository.save(new TodoTask("title1", "description1", "abel"));
        this.todoTaskRepository.save(new TodoTask("title2", "description2", "kevin"));
    }

}
