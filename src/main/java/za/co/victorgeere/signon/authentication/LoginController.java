package za.co.victorgeere.signon.authentication;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public void postLogin() {

    }

    @PostMapping("/logout")
    public void postLogout(HttpSession session) {
        session.invalidate();
    }
}
