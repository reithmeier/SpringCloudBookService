package sve.project.analyticsservice.domain;

import java.util.List;
import java.util.StringJoiner;

public class AnalyticsResult {
    private List<OrderByRating> ordersByRatings;
    private List<OrdersPerDay> ordersPerDays;
    private Float avgOrderPerUser;
    private String timestamp;

    public AnalyticsResult() {
    }

    public AnalyticsResult(List<OrderByRating> ordersByRatings, List<OrdersPerDay> ordersPerDays, Float avgOrderPerUser, String timestamp) {
        this.ordersByRatings = ordersByRatings;
        this.ordersPerDays = ordersPerDays;
        this.avgOrderPerUser = avgOrderPerUser;
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<OrderByRating> getOrdersByRatings() {
        return ordersByRatings;
    }

    public void setOrdersByRatings(List<OrderByRating> ordersByRatings) {
        this.ordersByRatings = ordersByRatings;
    }

    public List<OrdersPerDay> getOrdersPerDays() {
        return ordersPerDays;
    }

    public void setOrdersPerDays(List<OrdersPerDay> ordersPerDays) {
        this.ordersPerDays = ordersPerDays;
    }

    public Float getAvgOrderPerUser() {
        return avgOrderPerUser;
    }

    public void setAvgOrderPerUser(Float avgOrderPerUser) {
        this.avgOrderPerUser = avgOrderPerUser;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AnalyticsResult.class.getSimpleName() + "[", "]")
                .add("ordersByRatings=" + ordersByRatings)
                .add("ordersPerDays=" + ordersPerDays)
                .add("avgOrderPerUser=" + avgOrderPerUser)
                .add("timestamp=" + timestamp)
                .toString();
    }
}
