package za.co.victorgeere.signon.entities;

import javax.persistence.*;

@SqlResultSetMapping(
        name="userSessionMapping",
        classes={
                @ConstructorResult(
                        targetClass=UserSession.class,
                        columns={
                                @ColumnResult(name="USERNAME"),
                                @ColumnResult(name="SESSION_ID")
                        }
                )
        }
)
@NamedNativeQuery(
        name= "UserSession.getUserSessions",
        query = "SELECT u.USERNAME, s.SESSION_ID from USER AS u left outer join SPRING_SESSION AS s on u.username = s.PRINCIPAL_NAME",
        resultSetMapping = "userSessionMapping")
@Entity
public class UserSession {

    @Id
    @Column(name = "SESSION_ID", nullable = false)
    private String sessionId;

    @Column(name = "USERNAME")
    private String username;

    public String getSessionId() {
        return sessionId;
    }

    public String getUsername() {
        return username;
    }

    public UserSession() {

    }

    public UserSession(String username, String sessionId) {
        this.username = username;
        this.sessionId = sessionId;
    }
}
