package sve.project.bookservice.messaging;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventSource {
    @Output("bookChannel")
    MessageChannel bookEvent();
}
