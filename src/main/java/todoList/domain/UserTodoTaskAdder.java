package todoList.domain;

import todoList.exceptions.RequiredDataException;

/**
 * Created by daferpi on 10/04/16.
 */
public class UserTodoTaskAdder extends LoginUser implements TodoTaskAdder {


    public UserTodoTaskAdder(String userName, String password) {
        super(userName, password);
    }

    @Override
    public TodoTask addTask(String title, String description) throws RequiredDataException {
        return new TodoTask(title, description, getUserName());
    }
}
