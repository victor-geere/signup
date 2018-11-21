package za.co.victorgeere.signon.session;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import za.co.victorgeere.signon.entities.SpringSession;

@RepositoryRestResource(collectionResourceRel = "users", path = "sessions")
public interface SpringSessionRepository extends CrudRepository<SpringSession, Long> {

    SpringSession findByPrincipalName(@Param("principalname") String principalName);
}
