package sve.project.analyticsservice.domain;

import java.util.StringJoiner;

public class OrdersPerDay {
    private Integer orders;
    private String day;

    public OrdersPerDay() {
    }

    public OrdersPerDay(Integer orders, String day) {
        this.orders = orders;
        this.day = day;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrdersPerDay.class.getSimpleName() + "[", "]")
                .add("orders=" + orders)
                .add("day='" + day + "'")
                .toString();
    }
}
