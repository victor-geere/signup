package za.co.victorgeere.signon;

public class User {
    public String getUsername() {
        return username;
    }

    private final String username;

    public User(String username) {
        this.username = username;
    }

}
