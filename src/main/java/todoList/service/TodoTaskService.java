package todoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import todoList.domain.TodoTask;
import todoList.domain.TodoTaskAdder;

/**
 * Created by daferpi on 10/04/16.
 */
@Component("todoTaskService")
@Transactional
public class TodoTaskService {

    private TodoTaskRepository todoTaskRepository;

    @Autowired
    public TodoTaskService(TodoTaskRepository todoTaskRepository) {
        this.todoTaskRepository = todoTaskRepository;
    }

    public TodoTask addTodoTask(TodoTaskAdder taskAdder, String title, String description) {
        TodoTask todoTask = taskAdder.addTask(title, description);
        return todoTaskRepository.save(todoTask);
    }
}
