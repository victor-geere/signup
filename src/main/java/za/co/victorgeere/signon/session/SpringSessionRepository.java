package za.co.victorgeere.signon.session;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import za.co.victorgeere.signon.entities.SpringSession;
import za.co.victorgeere.signon.entities.UserSession;

@RepositoryRestResource(collectionResourceRel = "session", path = "session")
public interface SpringSessionRepository extends CrudRepository<SpringSession, Long> {

    SpringSession findByPrincipalName(@Param("principalname") String principalName);

    // @Query(value = "SELECT u.USERNAME, s.PRIMARY_ID, s.SESSION_ID, s.CREATION_TIME, s.LAST_ACCESS_TIME, s.MAX_INACTIVE_INTERVAL, s.EXPIRY_TIME, s.PRINCIPAL_NAME from USER AS u left outer join SPRING_SESSION AS s on u.username = s.PRINCIPAL_NAME" , nativeQuery = true)
    @Query(value = "SELECT PRIMARY_ID, SESSION_ID, CREATION_TIME, LAST_ACCESS_TIME, MAX_INACTIVE_INTERVAL, EXPIRY_TIME, PRINCIPAL_NAME from SPRING_SESSION" , nativeQuery = true)
    Iterable<SpringSession> findSpringSession();
}
