package sve.project.accountservice.messaging.events;

import sve.project.accountservice.domain.User;

import java.util.StringJoiner;

public class UserEvent {
    private Long id;

    private String name;

    private Action action;

    public enum Action {
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

    public UserEvent() {
    }

    public UserEvent(User user, Action action) {
        this.id = user.getId();
        this.name = user.getName();
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

    @Override
    public String toString() {
        return new StringJoiner(", ", UserEvent.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("action=" + action)
                .toString();
    }
}
