package sve.project.analyticsservice.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import sve.project.analyticsservice.domain.Book;
import sve.project.analyticsservice.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User entity);

    long count();

    void delete(User entity);

    boolean existsById(Long id);

}
