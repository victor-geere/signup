package za.co.victorgeere.signon.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class UserController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public User getUser(@RequestParam(value="username", defaultValue="guest") String username) {
        logger.info("GET /user");
        return userRepository.findByUsername(username);
    }

    @PutMapping("/user")
    public User putUser(@RequestBody User user) {
        logger.info("PUT /user");
        userRepository.save(user);
        return user;
    }
}
