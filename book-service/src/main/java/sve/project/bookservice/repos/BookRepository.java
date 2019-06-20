package sve.project.bookservice.repos;

import org.springframework.data.repository.CrudRepository;
import sve.project.bookservice.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
  /*  List<Book> findAll();

    Optional<Book> findById(String isbn);

    Book save(Book entity);

    long count();

    void delete(Book entity);

    boolean existsById(String isbn);
*/
}
