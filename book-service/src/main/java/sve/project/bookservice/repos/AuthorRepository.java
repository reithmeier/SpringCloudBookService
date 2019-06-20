package sve.project.bookservice.repos;

import org.springframework.data.repository.CrudRepository;
import sve.project.bookservice.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
