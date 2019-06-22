package sve.project.analyticsservice.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import sve.project.analyticsservice.domain.Book;
import sve.project.analyticsservice.domain.OrdersPerDay;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, Long> {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Book save(Book entity);

    long count();

    void delete(Book entity);

    boolean existsById(Long id);

}
