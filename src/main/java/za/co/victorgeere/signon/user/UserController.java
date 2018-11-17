package za.co.victorgeere.signon.user;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class UserController {

    @GetMapping("/user")
    @ResponseBody
    @Bean
    public User getUser() {
        return new User("guest", "000-000-0000", "");
    }
}
