package sve.project.analyticsservice.domain;


import java.util.StringJoiner;

public class OrderByRating {
    private Integer rating;
    private Integer orders;

    public OrderByRating() {
    }

    public OrderByRating(Integer rating, Integer orders) {
        this.rating = rating;
        this.orders = orders;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderByRating.class.getSimpleName() + "[", "]")
                .add("rating=" + rating)
                .add("orders=" + orders)
                .toString();
    }
}
