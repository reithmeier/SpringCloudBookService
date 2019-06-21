package sve.project.ratingservice.repos;

import org.springframework.data.repository.CrudRepository;
import sve.project.ratingservice.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
