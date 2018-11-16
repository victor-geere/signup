package za.co.victorgeere.signon;

public class User {
    private final String username;
    private final String phone;
    private final String password;

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public User(String username, String phone, String password) {
        this.username = username;
        this.phone = phone;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[username=%s, phone='%s', password='%s']",
                username, phone, password);
    }
}
