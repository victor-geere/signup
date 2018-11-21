package za.co.victorgeere.signon.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import za.co.victorgeere.signon.entities.User;

@RepositoryRestResource(collectionResourceRel = "usersx", path = "usersx")
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(@Param("username") String username);
}
