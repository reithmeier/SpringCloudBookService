package sve.project.analyticsservice.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import sve.project.analyticsservice.domain.OrdersPerDay;

import java.util.List;
import java.util.Optional;

public interface OrdersPerDayRepository extends MongoRepository<OrdersPerDay, Long> {
    List<OrdersPerDay> findAll();

    Optional<OrdersPerDay> findById(Long id);

    OrdersPerDay save(OrdersPerDay entity);

    long count();

    void delete(OrdersPerDay entity);

    boolean existsById(Long id);

}
