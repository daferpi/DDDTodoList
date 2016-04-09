package infraestructure;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by daferpi on 09/04/16.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "hello World";
    }
}
