package sve.project.orderingservice.repos;

import org.springframework.data.repository.CrudRepository;
import sve.project.orderingservice.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
