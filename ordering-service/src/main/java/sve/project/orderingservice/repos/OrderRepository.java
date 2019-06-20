package sve.project.orderingservice.repos;

import org.springframework.data.repository.CrudRepository;
import sve.project.orderingservice.domain.OrderEntry;

public interface OrderRepository extends CrudRepository<OrderEntry, Long> {

}
