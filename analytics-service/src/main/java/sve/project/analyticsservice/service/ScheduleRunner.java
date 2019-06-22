package sve.project.analyticsservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sve.project.analyticsservice.domain.AnalyticsResult;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduleRunner {

    private static final Logger log = LoggerFactory.getLogger(ScheduleRunner.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private final AnalyticsService analyticsService;
    private final AnalyticsResultService analyticsResultService;

    public ScheduleRunner(AnalyticsService analyticsService, AnalyticsResultService analyticsResultService) {
        this.analyticsService = analyticsService;
        this.analyticsResultService = analyticsResultService;
    }

    @Scheduled(fixedRateString = "${analytics.update.rate}")
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedRateString = "${analytics.update.rate}")
    public void calculateAnalytics(){
        AnalyticsResult result = new AnalyticsResult();

        result.setAvgOrderPerUser(analyticsService.avgOrderPerUser());
        result.setOrdersByRatings(analyticsService.orderByRating());
        result.setOrdersPerDays(analyticsService.ordersPerDay());
        result.setTimestamp(dateFormat.format(new Date()));
        analyticsResultService.saveAnalyticsResult(result);

        log.info("result calculated");
        log.info(result.toString());
    }
}
