package sve.project.analyticsservice.messaging.events;

import sve.project.analyticsservice.domain.OrderEntry;

import java.util.StringJoiner;

public class OrderEvent {

    private Long id;

    private Long book;

    private Long user;

    private String date;

    private Action action;

    public OrderEvent() {
    }

    public OrderEvent(Long id, Long book, Long user, String date, Action action) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.date = date;
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public OrderEntry toOrderEntry(){
        return new OrderEntry(id, book, user, date);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderEvent.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("book=" + book)
                .add("user=" + user)
                .add("date='" + date + "'")
                .add("action=" + action)
                .toString();
    }
}
