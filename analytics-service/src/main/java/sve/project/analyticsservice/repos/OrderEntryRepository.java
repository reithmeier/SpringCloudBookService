package sve.project.analyticsservice.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import sve.project.analyticsservice.domain.OrderEntry;

import java.util.List;
import java.util.Optional;

public interface OrderEntryRepository extends MongoRepository<OrderEntry, Long> {
    List<OrderEntry> findAll();

    Optional<OrderEntry> findById(Long id);

    OrderEntry save(OrderEntry entity);

    long count();

    void delete(OrderEntry entity);

    boolean existsById(Long id);

}
