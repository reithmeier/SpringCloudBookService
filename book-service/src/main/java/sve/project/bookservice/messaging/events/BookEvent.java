package sve.project.bookservice.messaging.events;

import sve.project.bookservice.domain.Book;

import java.util.StringJoiner;

public class BookEvent {

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

    private String name;

    private Action action;


    public BookEvent() {
    }

    public BookEvent(Book book, Action action) {
        this.id = book.getId();
        this.name = book.getName();
        this.action = action;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BookEvent.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("action=" + action)
                .toString();
    }
}
