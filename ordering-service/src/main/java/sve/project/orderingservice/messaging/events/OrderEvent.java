package sve.project.orderingservice.messaging.events;

import sve.project.orderingservice.domain.OrderEntry;

import java.util.StringJoiner;

public class OrderEvent {
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

    private Long id;

    private Long book;

    private Long user;

    private String date;

    private Action action;

    public OrderEvent() {
    }

    public OrderEvent(OrderEntry orderEntry, Action action){
        this.id = orderEntry.getId();
        this.book = orderEntry.getBook().getId();
        this.user = orderEntry.getUser().getId();
        this.date = orderEntry.getDate();
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
