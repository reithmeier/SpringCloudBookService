package sve.project.ratingservice.messaging.events;

import sve.project.ratingservice.domain.Rating;

import java.util.StringJoiner;

public class RatingEvent {
    public enum Action{
        CREATE("CREATE"),
        DELETE("DELETE");

        private final String action;

        Action(String action) {
            this.action = action;
        }

        public String getAction() {
            return action;
        }
    }

    private Long book;
    private Long user;
    private Integer value;
    private Action action;

    public RatingEvent() {
    }

    public RatingEvent(Rating rating, Action action) {
        this.book = rating.getBook().getId();
        this.user = rating.getUser().getId();
        this.value = rating.getValue();
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
