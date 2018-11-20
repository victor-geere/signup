package za.co.victorgeere.signon.authentication;

import org.springframework.web.bind.annotation.*;
import za.co.victorgeere.signon.entities.User;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public void postLogin(@RequestBody User user) {

    }

    @PostMapping("/logout/{id}")
    public void postLogout(HttpSession session, @PathVariable String id) {
        session.invalidate();
    }
}
