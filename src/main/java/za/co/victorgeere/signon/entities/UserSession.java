package za.co.victorgeere.signon.entities;

import javax.persistence.*;

@SqlResultSetMapping(
        name="userSessionMapping",
        classes={
                @ConstructorResult(
                        targetClass=UserSession.class,
                        columns={
                                @ColumnResult(name="SESSION_ID"),
                                @ColumnResult(name="PHONE"),
                                @ColumnResult(name="USERNAME")
                        }
                )
        }
)
@NamedNativeQuery(
        name= "UserSession.getUserSessions",
        query = "SELECT u.USERNAME, u.PHONE, s.SESSION_ID from USER AS u left outer join SPRING_SESSION AS s on u.username = s.PRINCIPAL_NAME",
        resultSetMapping = "userSessionMapping")
@Entity
public class UserSession {

    @Id
    @Column(name = "SESSION_ID", nullable = false)
    private String sessionId;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "USERNAME")
    private String username;

    public String getSessionId() {
        return sessionId;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public UserSession() {

    }

    public UserSession(String sessionId, String phone, String username) {
        this.username = username;
        this.phone = phone;
        this.sessionId = sessionId;
    }
}
