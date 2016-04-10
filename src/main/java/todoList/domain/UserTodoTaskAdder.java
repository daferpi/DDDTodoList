package todoList.domain;

/**
 * Created by daferpi on 10/04/16.
 */
public class UserTodoTaskAdder extends LoginUser implements TodoTaskAdder {


    public UserTodoTaskAdder(String userName, String password) {
        super(userName, password);
    }

    @Override
    public TodoTask addTask(String title, String description) {
        return new TodoTask(title, description, false, getUserName());
    }
}