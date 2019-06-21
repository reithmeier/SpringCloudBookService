package sve.project.ratingservice.repos;

import org.springframework.data.repository.CrudRepository;
import sve.project.ratingservice.domain.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long> {

}
