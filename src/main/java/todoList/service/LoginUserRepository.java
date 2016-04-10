package todoList.service;

import org.springframework.data.repository.CrudRepository;
import todoList.domain.LoginUser;

import javax.annotation.PostConstruct;

/**
 * Created by daferpi on 10/04/16.
 */
public interface LoginUserRepository extends CrudRepository<LoginUser, Long> {

    LoginUser findUserByUserName(String userName);

}
