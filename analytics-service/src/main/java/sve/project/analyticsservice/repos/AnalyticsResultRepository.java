package sve.project.analyticsservice.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import sve.project.analyticsservice.domain.AnalyticsResult;

import java.util.List;
import java.util.Optional;

public interface AnalyticsResultRepository extends MongoRepository<AnalyticsResult, Long> {
    List<AnalyticsResult> findAll();

    Optional<AnalyticsResult> findById(Long id);

    AnalyticsResult save(AnalyticsResult entity);

    long count();

    void delete(AnalyticsResult entity);

    boolean existsById(Long id);

}
