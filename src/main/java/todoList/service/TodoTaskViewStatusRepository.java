package todoList.service;

import todoList.domain.DoneTodoTask;
import todoList.domain.PendingTodoTask;

import java.util.List;

/**
 * Created by daferpi on 10/04/16.
 */
public interface TodoTaskViewStatusRepository {

    public List<PendingTodoTask> findPendingTasks();
    public List<DoneTodoTask> findDoneTasks();
}
