package sve.project.bookservice.repos;

import org.springframework.data.repository.CrudRepository;
import sve.project.bookservice.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
