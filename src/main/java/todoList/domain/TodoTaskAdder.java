package todoList.domain;

import todoList.exceptions.RequiredDataException;

/**
 * Created by daferpi on 10/04/16.
 */
public interface TodoTaskAdder {

    public TodoTask addTask(String title, String description) throws RequiredDataException;
}
