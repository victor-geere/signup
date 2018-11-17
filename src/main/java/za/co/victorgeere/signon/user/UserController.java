package za.co.victorgeere.signon.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getUser(@RequestParam(value="username", defaultValue="guest") String username) {
        return userRepository.findByUsername(username);
    }

    @PutMapping("/user")
    public User putUser(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }
}
