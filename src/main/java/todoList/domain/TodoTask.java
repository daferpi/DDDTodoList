package todoList.domain;

import todoList.exceptions.RequiredDataException;
import todoList.exceptions.TodoTaskNotFoundException;

import javax.persistence.*;

/**
 * Created by daferpi on 10/04/16.
 */
@Entity
public class TodoTask {

    private static final String TITLE_REQUIRED_ERROR = "Title is required";
    private static final String DESCRIPTION_REQUIRED_ERROR = "Description is required";
    private static final String USERNAME_REQUIRED_ERROR = "Username is required";


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    private String description;

    protected boolean finished;

    private String userName;

    public TodoTask() {
    }

    public TodoTask(String title, String description, String userName) throws RequiredDataException {
        if (title != null) {
            this.title = title;
        } else {
            throw new RequiredDataException(TITLE_REQUIRED_ERROR);
        }

        if (description != null) {
            this.description = description;
        } else {
            throw new RequiredDataException(DESCRIPTION_REQUIRED_ERROR);
        }

        if (userName != null) {
            this.userName = userName;
        } else {
            throw new RequiredDataException(USERNAME_REQUIRED_ERROR);
        }

        this.finished = false;
    }

    protected TodoTask(TodoTask originTask) throws TodoTaskNotFoundException {
        if (originTask != null) {
            this.id = originTask.id;
            this.title = originTask.getTitle();
            this.description = originTask.getDescription();
            this.userName = originTask.getUserName();
            this.finished = originTask.isFinished();
        } else {
            throw new TodoTaskNotFoundException("Todo task not found");
        }

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
