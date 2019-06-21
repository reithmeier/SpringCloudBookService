package sve.project.orderingservice.messaging.events;

import sve.project.orderingservice.domain.Book;

import java.util.StringJoiner;

public class BookEvent {
    private Long id;

    private String name;

    private Action action;

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

    public BookEvent() {
    }

    public BookEvent(Long id, String name, Action action) {
        this.id = id;
        this.name = name;
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

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Book toBook(){
        Book book = new Book(id, name, false);
        if (action == Action.DELETE){
            book.setDeleted(true);
        }
        return book;
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
