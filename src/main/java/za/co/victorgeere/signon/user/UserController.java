package za.co.victorgeere.signon.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import za.co.victorgeere.signon.entities.SpringSession;
import za.co.victorgeere.signon.entities.User;
import za.co.victorgeere.signon.entities.UserSession;
import za.co.victorgeere.signon.session.SpringSessionRepository;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class UserController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpringSessionRepository springSessionRepository;

    @GetMapping("/sessions")
    public Iterable<SpringSession> getSessions() {
        logger.info("GET /sessions");
        return springSessionRepository.findSpringSession();
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        logger.info("GET /users");
        return userRepository.findAll();
    }

    @PutMapping("/users")
    public User putUsers(@RequestBody User user) {
        logger.info("PUT /user");
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }
}
