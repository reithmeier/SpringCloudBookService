package sve.project.analyticsservice.domain;

import java.util.StringJoiner;

public class Book {
    private Long id;

    private Integer ratingSum;

    private Integer ratingCount;

    private Integer orderSum;

    public Book() {
    }

    public Book(Long id, Integer ratingSum, Integer ratingCount, Integer orderSum) {
        this.id = id;
        this.ratingSum = ratingSum;
        this.ratingCount = ratingCount;
        this.orderSum = orderSum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRatingSum() {
        return ratingSum;
    }

    public void setRatingSum(Integer ratingSum) {
        this.ratingSum = ratingSum;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Integer getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(Integer orderSum) {
        this.orderSum = orderSum;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("ratingSum=" + ratingSum)
                .add("ratingCount=" + ratingCount)
                .add("orderSum=" + orderSum)
                .toString();
    }
}
