package sve.project.analyticsservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sve.project.analyticsservice.domain.AnalyticsResult;
import sve.project.analyticsservice.exception.NoEntryException;
import sve.project.analyticsservice.exception.NotFoundException;
import sve.project.analyticsservice.repos.AnalyticsResultRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnalyticsResultService {
    private final AnalyticsResultRepository analyticsResultRepository;


    public AnalyticsResultService(AnalyticsResultRepository analyticsResultRepository) {
        this.analyticsResultRepository = analyticsResultRepository;
    }

    @Transactional
    public Iterable<AnalyticsResult> getAnalyticsResults() {
        return analyticsResultRepository.findAll();
    }

    @Transactional
    public AnalyticsResult getLatestAnalytics() {
        List<AnalyticsResult> analyticsResult = analyticsResultRepository.findAll();
        if (analyticsResult.isEmpty()) {
            throw new NoEntryException(AnalyticsResult.class.getSimpleName());
        }
        AnalyticsResult latest = analyticsResult.get(analyticsResult.size() - 1);
        System.out.println(latest.getTimestamp());
        return latest;
    }

    @Transactional
    public AnalyticsResult saveAnalyticsResult(AnalyticsResult analyticsResult) {
        return analyticsResultRepository.save(analyticsResult);
    }

    @Transactional
    public AnalyticsResult deleteAnalyticsResult(Long id) {
        Optional<AnalyticsResult> analyticsResult = analyticsResultRepository.findById(id);
        if (analyticsResult.isPresent()) {
            analyticsResultRepository.delete(analyticsResult.get());
            return analyticsResult.get();
        }
        throw new NotFoundException(id, AnalyticsResult.class.getSimpleName());
    }
}
