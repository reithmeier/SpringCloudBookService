package sve.project.analyticsservice.messaging.events;

import java.util.StringJoiner;

public class RatingEvent {
    private Long book;
    private Long user;
    private Integer value;
    private Action action;

    public RatingEvent() {
    }

    public RatingEvent(Long book, Long user, Integer value, Action action) {
        this.book = book;
        this.user = user;
        this.value = value;
        this.action = action;
    }

    public Long getBook() {
        return book;
    }

    public void setBook(Long book) {
        this.book = book;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RatingEvent.class.getSimpleName() + "[", "]")
                .add("book=" + book)
                .add("user=" + user)
                .add("value=" + value)
                .add("action=" + action)
                .toString();
    }
}
