package sve.project.bookservice.repos;

import org.springframework.data.repository.CrudRepository;
import sve.project.bookservice.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
