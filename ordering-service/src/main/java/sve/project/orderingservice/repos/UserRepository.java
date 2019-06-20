package sve.project.orderingservice.repos;

import org.springframework.data.repository.CrudRepository;
import sve.project.orderingservice.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
