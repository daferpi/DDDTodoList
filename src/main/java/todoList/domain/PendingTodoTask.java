package todoList.domain;

import todoList.exceptions.RequiredDataException;
import todoList.exceptions.TodoTaskNotFoundException;

/**
 * Created by daferpi on 10/04/16.
 */
public class PendingTodoTask extends TodoTask {

    public PendingTodoTask(String title, String description, String userName) throws RequiredDataException {
        super(title, description, userName);
        this.finished = false;
    }

    public PendingTodoTask(TodoTask originTask) throws TodoTaskNotFoundException {
        super(originTask);
        this.finished = false;
    }

    public void finishedTask() {
        this.finished = true;
    }
}
