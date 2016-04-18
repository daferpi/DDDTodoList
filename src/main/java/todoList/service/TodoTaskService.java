package todoList.service;

import todoList.domain.PendingTodoTask;
import todoList.domain.TodoTask;
import todoList.exceptions.InvalidCredentialsException;
import todoList.exceptions.RequiredDataException;
import todoList.exceptions.TodoTaskNotFoundException;

import java.util.List;

/**
 * Created by daferpi on 18/04/16.
 */
public interface TodoTaskService {

    public TodoTask addTodoTask(String userName, String password, String title, String description) throws InvalidCredentialsException, RequiredDataException;
    public TodoTask completeTask(Long taskId, String userName) throws TodoTaskNotFoundException, RequiredDataException;
    public List<PendingTodoTask> findPendingTask(String userName) throws RequiredDataException;
    public  List<TodoTask> findDoneTask(String userName) throws RequiredDataException;
}
