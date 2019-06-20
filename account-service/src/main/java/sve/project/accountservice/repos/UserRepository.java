package sve.project.accountservice.repos;

import org.springframework.data.repository.CrudRepository;
import sve.project.accountservice.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
