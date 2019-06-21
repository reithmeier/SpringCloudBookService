package sve.project.accountservice.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import sve.project.accountservice.domain.User;
import sve.project.accountservice.messaging.events.UserEvent;

@EnableBinding(UserEventSource.class)
public class Sender {

    private final UserEventSource userEventSource;

    public Sender(UserEventSource userEventSource) {
        this.userEventSource = userEventSource;
    }

    public UserEvent sendCreateUser(User user) {
        UserEvent userEvent = new UserEvent(user, UserEvent.Action.CREATE);
        userEventSource.userEvent().send(MessageBuilder.withPayload(userEvent).build());
        userEventSource.userRating().send(MessageBuilder.withPayload(userEvent).build());
        System.out.println("Sent " + userEvent);
        return userEvent;
    }

    public UserEvent sendDeleteUser(User user) {
        UserEvent userEvent = new UserEvent(user, UserEvent.Action.DELETE);
        userEventSource.userEvent().send(MessageBuilder.withPayload(userEvent).build());
        userEventSource.userRating().send(MessageBuilder.withPayload(userEvent).build());
        return userEvent;
    }
}
