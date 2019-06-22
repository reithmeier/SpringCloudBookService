package sve.project.analyticsservice.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import sve.project.analyticsservice.domain.OrderByRating;

import java.util.List;
import java.util.Optional;

public interface OrderByRatingRepository extends MongoRepository<OrderByRating, Long> {
    List<OrderByRating> findAll();

    Optional<OrderByRating> findById(Long id);

    OrderByRating save(OrderByRating entity);

    long count();

    void delete(OrderByRating entity);

    boolean existsById(Long id);

}
