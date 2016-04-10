package todoList.domain;

import javax.persistence.*;

/**
 * Created by daferpi on 10/04/16.
 */
@Entity
public class TodoTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private boolean finished;

    private String userName;

    public TodoTask() {
    }

    public TodoTask(String title, String description, boolean finished, String userName) {
        this.title = title;
        this.description = description;
        this.finished = finished;
        this.userName = userName;
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
