package todoList.service;

import com.sun.tools.javac.comp.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import todoList.domain.*;
import todoList.exceptions.InvalidCredentialsException;
import todoList.exceptions.RequiredDataException;
import todoList.exceptions.TodoTaskNotFoundException;

import java.util.List;

/**
 * Created by daferpi on 10/04/16.
 */
@Component("todoTaskService")
@Transactional
public class TodoTaskService {

    private TodoTaskRepository todoTaskRepository;
    private TodoTaskViewRepository todoTaskViewRepository;
    private LoginService loginService;

    @Autowired
    public TodoTaskService(LoginService loginService, TodoTaskRepository todoTaskRepository, TodoTaskViewRepository todoTaskViewRepository) {
        this.loginService = loginService;
        this.todoTaskRepository = todoTaskRepository;
        this.todoTaskViewRepository = todoTaskViewRepository;
    }

    public TodoTask addTodoTask(String userName, String password, String title, String description) throws InvalidCredentialsException, RequiredDataException {
        TodoTaskAdder todoTaskAdder = this.loginService.validateUserCredentials(userName, password);
        TodoTask todoTask = todoTaskAdder.addTask(title, description);
        return todoTaskRepository.save(todoTask);
    }

    public TodoTask completeTask(long taskId, String userName) throws TodoTaskNotFoundException, RequiredDataException {
        DoneTask doneTask = this.todoTaskViewRepository.findByIdUserName(taskId,userName);
        final TodoTask todoTaskComplete = doneTask.completeTask();
        return this.todoTaskRepository.save(todoTaskComplete);
    }

    public List<PendingTodoTask> findPendingTask(String userName) throws RequiredDataException {
        return this.todoTaskViewRepository.findPendingTasks(userName);
    }

    public  List<TodoTask> findDoneTask(String userName) throws RequiredDataException {
        return this.todoTaskViewRepository.findDoneTasks(userName);
    }
}
