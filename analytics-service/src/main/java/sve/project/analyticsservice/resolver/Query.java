package sve.project.analyticsservice.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import sve.project.analyticsservice.domain.OrderByRating;
import sve.project.analyticsservice.domain.OrdersPerDay;
import sve.project.analyticsservice.service.AnalyticsResultService;

@Component
public class Query implements GraphQLQueryResolver {
    private final AnalyticsResultService analyticsResultService;

    public Query(AnalyticsResultService analyticsResultService) {
        this.analyticsResultService = analyticsResultService;
    }

    //orderByRating: [OrderByRating]
    public Iterable<OrderByRating> orderByRating() {
        return analyticsResultService.getLatestAnalytics().getOrdersByRatings();
    }

    //avgOrderPerUser: Float
    public Float avgOrderPerUser() {
        return analyticsResultService.getLatestAnalytics().getAvgOrderPerUser();
    }

    //ordersPerDay: [OrdersPerDay]
    public Iterable<OrdersPerDay> ordersPerDay() {
        return analyticsResultService.getLatestAnalytics().getOrdersPerDays();
    }

}

