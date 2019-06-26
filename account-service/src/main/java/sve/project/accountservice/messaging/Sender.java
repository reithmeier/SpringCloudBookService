package sve.project.accountservice.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import sve.project.accountservice.domain.User;
import sve.project.accountservice.messaging.events.UserEvent;

@EnableBinding(EventSource.class)
public class Sender {

    private final EventSource eventSource;

    public Sender(EventSource eventSource) {
        this.eventSource = eventSource;
    }

    public UserEvent sendCreateUser(User user) {
        UserEvent userEvent = new UserEvent(user, UserEvent.Action.CREATE);
        eventSource.userEvent().send(MessageBuilder.withPayload(userEvent).build());
        System.out.println("Sent " + userEvent);
        return userEvent;
    }

    public UserEvent sendDeleteUser(User user) {
        UserEvent userEvent = new UserEvent(user, UserEvent.Action.DELETE);
        eventSource.userEvent().send(MessageBuilder.withPayload(userEvent).build());
        return userEvent;
    }
}
