package todoList.domain;

import todoList.exceptions.RequiredDataException;

/**
 * Created by daferpi on 18/04/16.
 */
public class SingleDoneTask implements DoneTask {

    private TodoTask todoTask;

    public SingleDoneTask(TodoTask todoTask) {
        this.todoTask = todoTask;
    }

    @Override
    public TodoTask completeTask() throws RequiredDataException {
        todoTask.setFinished(true);
        return todoTask;
    }
}
