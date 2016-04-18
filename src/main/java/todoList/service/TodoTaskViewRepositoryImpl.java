package todoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import todoList.domain.DoneTask;
import todoList.domain.PendingTodoTask;
import todoList.domain.SingleDoneTask;
import todoList.domain.TodoTask;
import todoList.exceptions.RequiredDataException;
import todoList.exceptions.TodoTaskNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daferpi on 10/04/16.
 */
public class TodoTaskViewRepositoryImpl implements TodoTaskViewStatusRepository {

    @Autowired
    private TodoTaskViewRepository todoTaskViewRepository;

    @Override
    public List<PendingTodoTask> findPendingTasks(String userName) throws RequiredDataException {

        if (userName == null || userName.trim().length() < 1) {
            throw  new RequiredDataException("User name is required");
        }

        List<PendingTodoTask> pendingTodoTaskList = new ArrayList<>();
        List<TodoTask> todoTaskList = todoTaskViewRepository.findAll();
        if (todoTaskList != null && todoTaskList.isEmpty() == false) {
            for (TodoTask task : todoTaskList) {
                if (task.isFinished() == false) {
                    try {
                        PendingTodoTask pendingTodoTask = new PendingTodoTask(task);
                        pendingTodoTaskList.add(pendingTodoTask);
                    } catch (TodoTaskNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return pendingTodoTaskList;
    }

    @Override
    public List<TodoTask> findDoneTasks(String userName) throws RequiredDataException {
        if (userName == null || userName.trim().length() < 1) {
            throw  new RequiredDataException("User name is required");
        }
        List<TodoTask> doneTodoTaskList = new ArrayList<>();
        List<TodoTask> todoTaskList = todoTaskViewRepository.findAll();
        if (todoTaskList != null && todoTaskList.isEmpty() == false) {
            for (TodoTask task : todoTaskList) {
                if (task.isFinished() == true && userName.equals(task.getUserName())) {
                    doneTodoTaskList.add(task);
                }
            }
        }
        return doneTodoTaskList;
    }

    @Override
    public DoneTask findByIdUserName(Long id, String userName) throws TodoTaskNotFoundException, RequiredDataException {

        if (id == null) {
            throw  new RequiredDataException("Todo task id is required");
        }

        if (userName == null || userName.trim().length() < 1) {
            throw  new RequiredDataException("User name is required");
        }

        List<TodoTask> todoTaskList = todoTaskViewRepository.findAll();
        for (TodoTask todoTask : todoTaskList) {
            if (userName.equals(todoTask.getUserName()) && id == todoTask.getId()) {
                return new SingleDoneTask(todoTask);
            }
        }

        throw  new TodoTaskNotFoundException("Todo task not found");
    }


}
