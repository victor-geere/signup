package za.co.victorgeere.signon.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private final String username;
    private final String phone;
    private String password;

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder(12).encode(password);
    }

    public User() {
        this.username = "";
        this.phone = "";
        this.password = "";
    }

    public User(String username, String phone, String password) {
        this.username = username;
        this.phone = phone;
        this.password = new BCryptPasswordEncoder(12).encode(password);
    }

    @Override
    public String toString() {
        return String.format(
                "User[username=%s, phone='%s', password='%s']",
                username, phone, password);
    }
}
