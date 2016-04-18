package todoList.domain;

import todoList.exceptions.RequiredDataException;
import todoList.exceptions.TodoTaskNotFoundException;

/**
 * Created by daferpi on 10/04/16.
 */
public interface DoneTask {

    public TodoTask completeTask() throws RequiredDataException;

}
