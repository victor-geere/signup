package za.co.victorgeere.signon.entities;

import javax.persistence.*;

@Entity
@Table(name = "USER_INFO_TEST")
public class SpringSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRIMARY_ID", nullable = false)
    private String primaryId;

    @Column(name = "SESSION_ID", nullable = false)
    private String sessionId;

    @Column(name = "CREATION_TIME", nullable = false)
    private long creationTime;

    @Column(name = "LAST_ACCESS_TIME", nullable = false)
    private long lastAccessTime;

    @Column(name = "MAX_INACTIVE_INTERVAL", nullable = false)
    private long maxInactiveInterval;

    @Column(name = "EXPIRY_TIME", nullable = false)
    private long expiryTime;

    @Column(name = "PRINCIPAL_NAME")
    private String principalName;

    public String getPrimaryId() {
        return primaryId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getLastAccessTime() {
        return lastAccessTime;
    }

    public long getMaxInactiveInterval() {
        return maxInactiveInterval;
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public SpringSession() {

    }
}
