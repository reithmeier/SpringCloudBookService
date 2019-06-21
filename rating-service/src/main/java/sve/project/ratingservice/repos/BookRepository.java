package sve.project.ratingservice.repos;

import org.springframework.data.repository.CrudRepository;
import sve.project.ratingservice.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
