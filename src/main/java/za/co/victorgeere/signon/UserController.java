package za.co.victorgeere.signon;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @GetMapping("/users")
    @ResponseBody
    @Bean
    public List<User> getUser(UserRepository repository) {

        return repository.findByUsername("guest");

//        return new User("guest", "000-000-0000", "");
    }
}
