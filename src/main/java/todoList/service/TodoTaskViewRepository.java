package todoList.service;

import org.springframework.data.jpa.repository.JpaRepository;
import todoList.domain.TodoTask;

/**
 * Created by daferpi on 10/04/16.
 */
public interface TodoTaskViewRepository extends JpaRepository<TodoTask, Long>, TodoTaskViewStatusRepository {
}
