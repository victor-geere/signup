package za.co.victorgeere.signon.authentication;

import org.springframework.web.bind.annotation.*;
import za.co.victorgeere.signon.entities.Token;
import za.co.victorgeere.signon.user.User;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public Token postLogin(@RequestBody User user) {
        return new Token("", "");
    }
}
