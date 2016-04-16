package todoList.domain;

import todoList.exceptions.RequiredDataException;
import todoList.exceptions.TodoTaskNotFoundException;

/**
 * Created by daferpi on 10/04/16.
 */
public class DoneTodoTask extends TodoTask {

    public DoneTodoTask(String title, String description, String userName) throws RequiredDataException {
        super(title, description, userName);
        this.finished = true;
    }

    public DoneTodoTask(TodoTask originTask) throws TodoTaskNotFoundException {
        super(originTask);
        this.finished = true;
    }

}
