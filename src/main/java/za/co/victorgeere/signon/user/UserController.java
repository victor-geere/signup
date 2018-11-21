package za.co.victorgeere.signon.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import za.co.victorgeere.signon.entities.User;
import za.co.victorgeere.signon.entities.UserSession;
import za.co.victorgeere.signon.session.SpringSessionRepository;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class UserController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpringSessionRepository springSessionRepository;

    @GetMapping("/users")
    public List<UserSession> getUserSessions() {
        logger.info("GET /users");
        return springSessionRepository.getUserSessions();
    }

    @PutMapping("/users")
    public User putUsers(@RequestBody User user) {
        logger.info("PUT /users");
        userRepository.save(user);
        return user;
    }
}
