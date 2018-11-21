package za.co.victorgeere.signon.session;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import za.co.victorgeere.signon.entities.UserSession;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "session")
public interface SpringSessionRepository extends CrudRepository<UserSession, Long> {

    List<UserSession> getUserSessions();
}
