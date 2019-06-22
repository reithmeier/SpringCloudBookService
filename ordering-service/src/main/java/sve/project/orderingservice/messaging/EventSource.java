package sve.project.orderingservice.messaging;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventSource {
    @Output("orderChannel")
    MessageChannel orderEvent();
}
