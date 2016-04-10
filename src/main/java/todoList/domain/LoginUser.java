package todoList.domain;

import javax.persistence.*;

/**
 * Created by daferpi on 10/04/16.
 */
@Entity
public class LoginUser implements User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public LoginUser() {
    }

    @Override
    public String toString() {
        return getId()+", "+getUserName();
    }

    public boolean validateCredentials(String password) {
        boolean isValidUser = false;
        if (password != null && password.equals(this.getPassword())){
            isValidUser = true;
        }
        return  isValidUser;
    }


}
