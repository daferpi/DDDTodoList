package todoList.service;

import org.springframework.data.repository.CrudRepository;
import todoList.domain.TodoTask;

import java.util.List;

/**
 * Created by daferpi on 10/04/16.
 */
public interface TodoTaskRepository extends CrudRepository<TodoTask, Long> {

    List<TodoTask> findByFinished(boolean finished);
}
