package todoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import todoList.domain.DoneTodoTask;
import todoList.domain.PendingTodoTask;
import todoList.domain.TodoTask;
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
    public List<PendingTodoTask> findPendingTasks() {
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
    public List<DoneTodoTask> findDoneTasks() {
        List<DoneTodoTask> doneTodoTaskList = new ArrayList<>();
        List<TodoTask> todoTaskList = todoTaskViewRepository.findAll();
        if (todoTaskList != null && todoTaskList.isEmpty() == false) {
            for (TodoTask task : todoTaskList) {
                if (task.isFinished() == true) {
                    try {
                        DoneTodoTask doneTodoTask = new DoneTodoTask(task);
                        doneTodoTaskList.add(doneTodoTask);
                    } catch (TodoTaskNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return doneTodoTaskList;
    }
}
