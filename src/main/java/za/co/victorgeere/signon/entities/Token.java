package za.co.victorgeere.signon.entities;

public class Token {
    private final String id;
    private final String token;

    public String getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public Token(String id, String token) {
        this.id = id;
        this.token = token;
    }
}
