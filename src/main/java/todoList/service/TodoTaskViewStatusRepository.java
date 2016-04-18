package todoList.service;

import todoList.domain.DoneTask;
import todoList.domain.PendingTodoTask;
import todoList.domain.TodoTask;
import todoList.exceptions.RequiredDataException;

import java.util.List;

/**
 * Created by daferpi on 10/04/16.
 */
public interface TodoTaskViewStatusRepository {

    public List<PendingTodoTask> findPendingTasks(String userName) throws RequiredDataException;
    public List<TodoTask> findDoneTasks(String userName) throws RequiredDataException;

    DoneTask findByIdUserName(Long id, String userName) throws RequiredDataException;
}
